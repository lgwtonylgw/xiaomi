package cn.tedu.xiaomi.controller;

import cn.tedu.xiaomi.entity.Goods;
import cn.tedu.xiaomi.service.IGoodsService;
import cn.tedu.xiaomi.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created on 2019/6/8 17:16
 *
 * @author Tony
 * @projectName xiaomi
 */
@RestController
@RequestMapping("goods")
public class GoodsController extends BaseController {
    @Autowired
    private IGoodsService goodsService;
    @RequestMapping("hot/{x}")
    public ResponseResult<List<Goods>> getHotList(@PathVariable("x") Integer x){
        List<Goods> list=goodsService.getHotList(x);
        return  new ResponseResult<>(SUCCESS,list);
    }
    @RequestMapping("{id}/details")
    public ResponseResult<Goods> getById(@PathVariable("id") Long id){
        Goods good=goodsService.getById(id);
        return new ResponseResult<>(SUCCESS,good);
    }

}
