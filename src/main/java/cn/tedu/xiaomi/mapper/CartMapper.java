package cn.tedu.xiaomi.mapper;

import cn.tedu.xiaomi.entity.Cart;
import cn.tedu.xiaomi.vo.CartVO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created on 2019/6/10 13:25
 *
 * @author Tony
 * @projectName xiaomi
 */
public interface CartMapper {

    Cart findByUidAndGid(@Param("uid") Integer uid,
                         @Param("gid") Long gid);

    Integer updateNum(@Param("cid") Integer cid,
                      @Param("num") Integer num,
                      @Param("modifiedUser") String modifiedUser,
                      @Param("modifiedTime") Date modifiedTime);

    Integer insert(Cart cart);

    List<CartVO> findByUid(Integer uid);

    Cart findByCid(Integer cid);

    List<CartVO> findByCids(Integer[] cids);
}
