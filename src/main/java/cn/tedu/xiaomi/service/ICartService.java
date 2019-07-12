package cn.tedu.xiaomi.service;

import cn.tedu.xiaomi.entity.Cart;
import cn.tedu.xiaomi.service.ex.AccessDeniedException;
import cn.tedu.xiaomi.service.ex.CartNotFoundException;
import cn.tedu.xiaomi.service.ex.UpdateException;
import cn.tedu.xiaomi.vo.CartVO;

import java.util.List;

/**
 * Created on 2019/6/10 13:20
 *
 * @author Tony
 * @projectName xiaomi
 */
public interface ICartService {

    void addTocart(Cart cart, String username) throws UpdateException, UpdateException;

    List<CartVO> getByUid(Integer uid);

    Integer addNum(Integer cid, Integer uid, String username) throws
            UpdateException, CartNotFoundException, AccessDeniedException;

    List<CartVO> getByCids(Integer[] cids) ;
}
