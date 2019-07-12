package cn.tedu.xiaomi.controller;

import cn.tedu.xiaomi.entity.Order;
import cn.tedu.xiaomi.service.IOrderService;
import cn.tedu.xiaomi.util.ResponseResult;
import cn.tedu.xiaomi.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created on 2019/6/11 19:53
 *
 * @author Tony
 * @projectName xiaomi
 */

@RestController
@RequestMapping("orders")
public class OrderController extends BaseController{
    @Autowired
    private IOrderService orderService;
    @RequestMapping("create")
    public ResponseResult<Integer> create(Integer aid, Integer[] cids, HttpSession session){
        Integer uid=getUidFromSession(session);
        String username=getUsernameFromSession(session);
        Integer oid=orderService.create(aid,cids,uid,username);
        return new ResponseResult<>(SUCCESS,oid);
    }
    @RequestMapping("{oid}/details")
    public ResponseResult<Order> getByOid(@PathVariable("oid") Integer oid){
        Order data=orderService.getByOid(oid);
        System.out.println(data);
        return new ResponseResult<>(SUCCESS,data);
    }
    @RequestMapping("pay")
    public ResponseResult<Void> handlePay(Integer oid){
        orderService.handlePay(oid);
        return  new ResponseResult<>(SUCCESS);
    }
    @GetMapping("/")
    public ResponseResult<List<OrderVO>> getByUid(HttpSession session){
        Integer uid=getUidFromSession(session);
        List<OrderVO> data=orderService.getByUid(uid);
        System.out.println(data);
        return new ResponseResult<>(SUCCESS,data);
    }
}
