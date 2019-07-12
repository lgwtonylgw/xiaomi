package cn.tedu.xiaomi.controller;

import cn.tedu.xiaomi.entity.Cart;
import cn.tedu.xiaomi.service.ICartService;
import cn.tedu.xiaomi.util.ResponseResult;
import cn.tedu.xiaomi.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created on 2019/6/10 11:44
 *
 * @author Tony
 * @projectName xiaomi
 */
@RestController
@RequestMapping("carts")
public class CartController extends BaseController {
    @Autowired
    private ICartService cartService;
    @RequestMapping("add_to_cart")
    public ResponseResult<Void> addToCart(Cart cart, HttpSession session){
        Integer uid=getUidFromSession(session);
        String username=getUsernameFromSession(session);
        cart.setUid(uid);
        cartService.addTocart(cart,username);
        return new ResponseResult<>(SUCCESS);
    }
    @RequestMapping("/")
    public ResponseResult<List<CartVO>> getByUid(HttpSession session){
        Integer uid=getUidFromSession(session);
        List<CartVO> data=cartService.getByUid(uid);
        return new ResponseResult<>(SUCCESS,data);
    }
    @RequestMapping("{cid}/add_num")
    public ResponseResult<Integer> addNum(@PathVariable("cid") Integer cid,HttpSession session){
        Integer uid=getUidFromSession(session);
        String username=getUsernameFromSession(session);
        Integer num=cartService.addNum(cid,uid,username);
        return new ResponseResult<>(SUCCESS,num);
    }
    @RequestMapping("get_by_cids")
    public ResponseResult<List<CartVO>> getByCids(Integer[] cids){
        List<CartVO> data=cartService.getByCids(cids);
        return new ResponseResult<>(SUCCESS,data);
    }
}
