package cn.tedu.xiaomi.service.impl;

import cn.tedu.xiaomi.entity.Goods;
import cn.tedu.xiaomi.mapper.GoodsMapper;
import cn.tedu.xiaomi.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2019/6/9 12:21
 *
 * @author Tony
 * @projectName xiaomi
 */
@Service
public class GoodsServiceImpl implements IGoodsService {
    @Autowired
    private GoodsMapper mapper;
    @Override
    public List<Goods> getHotList(Integer x) {
        return findHotList(x);
    }

    @Override
    public Goods getById(Long id) {
        return findById(id);
    }
    private List<Goods> findHotList(Integer x){
        return mapper.findHotList(x);
    }
    private Goods findById(Long id){
        return mapper.findById(id);
    }
}
