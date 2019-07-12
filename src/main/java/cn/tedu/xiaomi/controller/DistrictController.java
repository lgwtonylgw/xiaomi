package cn.tedu.xiaomi.controller;

import cn.tedu.xiaomi.entity.District;
import cn.tedu.xiaomi.service.IDistrictService;
import cn.tedu.xiaomi.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created on 2019/6/10 9:42
 *
 * @author Tony
 * @projectName xiaomi
 */
@RestController
@RequestMapping("districts")
public class DistrictController extends BaseController {
    @Autowired
    private IDistrictService districtService;
    @RequestMapping("/")
    public ResponseResult<List<District>> getByParent(@RequestParam("parent") String parent){
        List<District> districts =districtService.getByParent(parent);
        return  new ResponseResult<>(SUCCESS,districts);
    }
}
