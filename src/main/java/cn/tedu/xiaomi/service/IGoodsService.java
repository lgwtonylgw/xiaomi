package cn.tedu.xiaomi.service;

import cn.tedu.xiaomi.entity.Goods;

import java.util.List;

/**
 * Created on 2019/6/9 12:15
 *
 * @author Tony
 * @projectName xiaomi
 */
public interface IGoodsService {
    List<Goods> getHotList(Integer x);
    Goods getById(Long id);
}
