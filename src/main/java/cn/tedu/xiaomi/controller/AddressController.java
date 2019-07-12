package cn.tedu.xiaomi.controller;

import cn.tedu.xiaomi.entity.Address;
import cn.tedu.xiaomi.service.IAddressService;
import cn.tedu.xiaomi.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created on 2019/6/9 17:06
 *
 * @author Tony
 * @projectName xiaomi
 */
@RestController
@RequestMapping("addresses")
public class AddressController extends BaseController {
    @Autowired
    private IAddressService addressService;
    @RequestMapping("addnew")
    public ResponseResult<Void> addnew(Address address,HttpSession session){
        Integer uid=getUidFromSession(session);
        String username=getUsernameFromSession(session);
        address.setUid(uid);
        addressService.addnew(address,username);
        return new ResponseResult<>(SUCCESS);
    }
    @GetMapping("/")
    public ResponseResult<List<Address>> getByUid(HttpSession session){
        Integer uid=getUidFromSession(session);
        System.out.println("查询地址");
        List<Address> data=addressService.getByUid(uid);
        return  new ResponseResult<>(SUCCESS,data);
    }
    @RequestMapping("{aid}/delete")
    public ResponseResult<Void> delete(@PathVariable("aid") Integer aid,HttpSession session){
        Integer uid=getUidFromSession(session);
        String username=getUsernameFromSession(session);
        addressService.delete(aid,uid,username);
        return new ResponseResult<>(SUCCESS);
    }
    @RequestMapping("{aid}/set_default")
    public ResponseResult<Void> setDefault(@PathVariable("aid") Integer aid ,HttpSession session){
        Integer uid=getUidFromSession(session);
        String username=getUsernameFromSession(session);
        addressService.setDefault(aid,uid,username);
        return new ResponseResult<>(SUCCESS);
    }
}
