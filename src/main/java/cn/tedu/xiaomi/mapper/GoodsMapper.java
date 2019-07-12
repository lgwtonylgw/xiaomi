package cn.tedu.xiaomi.mapper;

import cn.tedu.xiaomi.entity.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created on 2019/6/9 12:35
 *
 * @author Tony
 * @projectName xiaomi
 */
public interface GoodsMapper {
    List<Goods> findHotList(@Param(value = "x") Integer x);
    Goods findById(Long id);
}
