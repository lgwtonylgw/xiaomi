package cn.tedu.xiaomi.mapper;

import cn.tedu.xiaomi.entity.Order;
import cn.tedu.xiaomi.entity.OrderItem;
import cn.tedu.xiaomi.vo.OrderVO;

import java.util.Date;
import java.util.List;

/**
 * Created on 2019/6/11 20:03
 *
 * @author Tony
 * @projectName xiaomi
 */
public interface OrderMapper {

    Integer  insertOrder(Order order);

    Integer insertOrderItem(OrderItem i);


    Order findOrderByOid(Integer oid);

    Integer payOrder(Integer oid, Date now);

    List<OrderVO> findByUid(Integer uid);
}
