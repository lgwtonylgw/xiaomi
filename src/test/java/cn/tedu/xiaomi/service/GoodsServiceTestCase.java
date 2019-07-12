package cn.tedu.xiaomi.service;

import cn.tedu.xiaomi.entity.Goods;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created on 2019/6/9 12:47
 *
 * @author Tony
 * @projectName xiaomi
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsServiceTestCase {
    @Autowired
    private IGoodsService goodsService;
    @Test
    public  void hot(){
        Integer x=1;
        List<Goods> list=goodsService.getHotList(x);
        System.out.println(list);
        Goods good=goodsService.getById(10000003L);
        System.out.println(good);
    }

}
