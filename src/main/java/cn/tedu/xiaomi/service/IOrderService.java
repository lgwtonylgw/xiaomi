package cn.tedu.xiaomi.service;

import cn.tedu.xiaomi.entity.Order;
import cn.tedu.xiaomi.service.ex.AccessDeniedException;
import cn.tedu.xiaomi.service.ex.AddressNotFoundException;
import cn.tedu.xiaomi.service.ex.InsertException;
import cn.tedu.xiaomi.vo.OrderVO;

import java.util.List;

/**
 * Created on 2019/6/11 19:58
 *
 * @author Tony
 * @projectName xiaomi
 */
public interface IOrderService {

    Integer create(Integer aid, Integer[] cids, Integer uid, String username) throws AccessDeniedException
            , InsertException, AddressNotFoundException;

    Order getByOid(Integer oid);

    void handlePay(Integer oid);

    List<OrderVO> getByUid(Integer uid);
}
