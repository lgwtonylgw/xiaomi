package cn.tedu.xiaomi.service.impl;

import cn.tedu.xiaomi.entity.Cart;
import cn.tedu.xiaomi.mapper.CartMapper;
import cn.tedu.xiaomi.service.ICartService;
import cn.tedu.xiaomi.service.ex.AccessDeniedException;
import cn.tedu.xiaomi.service.ex.CartNotFoundException;
import cn.tedu.xiaomi.service.ex.InsertException;
import cn.tedu.xiaomi.service.ex.UpdateException;
import cn.tedu.xiaomi.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created on 2019/6/10 13:23
 *
 * @author Tony
 * @projectName xiaomi
 */
@Service
public class CartService implements ICartService {
    @Autowired
    private CartMapper mapper;

    @Override
    public void addTocart(Cart cart, String username) throws UpdateException, UpdateException {
        Integer uid=cart.getUid();
        Long gid=cart.getGid();
        Cart result=findByUidAndGid(uid,gid);
        Date now=new Date();
        if(result==null){
            cart.setCreatedTime(now);
            cart.setCreatedUser(username);
            cart.setModifiedTime(now);
            cart.setModifiedUser(username);
            insert(cart);
        }else{
            Integer num= result.getNum();
            System.out.println(num);
            Integer cid=result.getCid();
            System.out.println(cart);
            Integer n=cart.getNum();
            Integer newNum=n+num;
            updateNum(cid,newNum,username,now);
        }

    }

    @Override
    public List<CartVO> getByUid(Integer uid) {
        return findByUid(uid);
    }



    @Override
    public Integer addNum(Integer cid, Integer uid, String username)
            throws UpdateException, CartNotFoundException, AccessDeniedException {
        Cart result=findByCid(cid);
        if(result==null){
            throw  new CartNotFoundException("增加商品数量失败，尝试访问的购物车数据不存在！");
        }
        if(uid!=result.getUid()){
            throw new AccessDeniedException("增加商品数量失败，尝试访问的购物车数据归属错误");
        }
        Integer newNum=result.getNum()+1;
        Date now=new Date();
        updateNum(cid,newNum,username,now);
        return  newNum;
    }

    @Override
    public List<CartVO> getByCids(Integer[] cids ) {
        return findByCids(cids);
    }



    //---------------------------------------------私有方法

    private List<CartVO> findByCids(Integer[] cids) {
        return mapper.findByCids(cids);
    }

    private Cart findByCid(Integer cid) {
        return mapper.findByCid(cid);
    }

    private List<CartVO> findByUid(Integer uid) {
        return mapper.findByUid(uid);
    }
    private void insert(Cart cart) {
        Integer rows=mapper.insert(cart);
        if(rows!=1){
            throw new InsertException("将商品添加到购物车失败，插入数据时出现未知错误！");
        }
    }
    private void updateNum(Integer cid, Integer num, String modifiedUser, Date modifiedTime) {
        Integer rows=mapper.updateNum(cid,num,modifiedUser,modifiedTime);
        if(rows!=1){
            throw new UpdateException("将商品添加到购物车失败，更新数据时发生未知错误！");
        }
    }

    private Cart findByUidAndGid(Integer uid, Long gid) {
        return mapper.findByUidAndGid(uid,gid);
    }
}
