package cn.tedu.xiaomi.service.impl;

import cn.tedu.xiaomi.entity.Address;
import cn.tedu.xiaomi.entity.Order;
import cn.tedu.xiaomi.entity.OrderItem;
import cn.tedu.xiaomi.mapper.OrderMapper;
import cn.tedu.xiaomi.service.IAddressService;
import cn.tedu.xiaomi.service.ICartService;
import cn.tedu.xiaomi.service.IOrderService;
import cn.tedu.xiaomi.service.ex.AccessDeniedException;
import cn.tedu.xiaomi.service.ex.AddressNotFoundException;
import cn.tedu.xiaomi.service.ex.InsertException;
import cn.tedu.xiaomi.service.ex.UpdateException;
import cn.tedu.xiaomi.vo.CartVO;
import cn.tedu.xiaomi.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created on 2019/6/11 20:01
 *
 * @author Tony
 * @projectName xiaomi
 */
@Service
public class OrderService implements IOrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private IAddressService addressService;
    @Autowired
    private ICartService cartService;

    @Override
    @Transactional
    public Integer create(Integer aid, Integer[] cids, Integer uid, String username)
            throws AccessDeniedException, InsertException, AddressNotFoundException {
        Address address=addressService.getByAid(aid);
        if(address==null){
            throw  new AddressNotFoundException("创建订单失败，所选的收货地址不存在");
        }
        if(uid!=address.getUid()){
            throw new AccessDeniedException("创建订单失败，选的收货地址数据归属错误！");
        }
        List<CartVO> carts=cartService.getByCids(cids);
        Long totalPrice=0L;
        for (CartVO cart: carts) {
            totalPrice+=cart.getNum()*cart.getPrice();
        }
        Date now=new Date();
        Order o=new Order();
        o.setUid(uid);
        o.setRecvName(address.getName());
        o.setRecvPhone(address.getPhone());
        o.setRecvAddress(address.getDistrict()+address.getAddress());
        o.setTotalPrice(totalPrice);
        o.setStatus(0);
        o.setOrderTime(now);
        o.setPayTime(null);
        o.setCreatedUser(username);
        o.setCreatedTime(now);
        o.setModifiedUser(username);
        o.setModifiedTime(now);
        insertOrder(o);
        for(CartVO cart:carts){
            OrderItem i=new OrderItem();
            //mapper踩坑记录
            //mapper接口返回值依然是成功插入的记录数，但不同的是主键值已经赋值到领域模型实体的id中了
            i.setOid(o.getOid());
            i.setGid(cart.getGid());
            i.setGoodsImage(cart.getImage());
            i.setGoodsNum(cart.getNum());
            i.setGoodsTitle(cart.getTitle());
            i.setGoodsPrice(cart.getPrice());
            i.setCreatedTime(now);
            i.setCreatedUser(username);
            i.setModifiedTime(now);
            i.setModifiedUser(username);
            insertOrderItem(i);
        }
        return o.getOid();
    }

    @Override
    public Order getByOid(Integer oid) {
        return findByOid(oid);
    }

    @Override
    public void handlePay(Integer oid) {
        Date now=new Date();
        payOrder(oid,now);
    }

    @Override
    public List<OrderVO> getByUid(Integer uid) {
        return findByUid(uid);
    }



    //-------------------------------------------------------私有方法单独放
    private List<OrderVO> findByUid(Integer uid) {
        System.out.println(uid);
        return orderMapper.findByUid(uid);
    }

    private void payOrder(Integer oid, Date now) {
        Integer rows=orderMapper.payOrder(oid,now);
        if(rows!=1){
            throw new UpdateException(("付款时发生未知错误！"));
        }
    }

    private Order findByOid(Integer oid) {
        return orderMapper.findOrderByOid(oid);
    }


    private void insertOrder(Order o) {
       Integer rows= orderMapper.insertOrder(o);
       if(rows!=1){
           throw new InsertException("创建订单失败，插入订单数据时出现未知错误");
       }
    }

    private void insertOrderItem(OrderItem i) {
       Integer rows= orderMapper.insertOrderItem(i);
       if(rows!=1){
           throw new InsertException("创建订单失败，插入订单数据时出现未知错误");
       }
    }
}
