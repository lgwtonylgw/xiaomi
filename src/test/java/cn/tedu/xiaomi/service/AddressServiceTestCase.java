package cn.tedu.xiaomi.service;

import cn.tedu.xiaomi.entity.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created on 2019/6/9 20:34
 *
 * @author Tony
 * @projectName xiaomi
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressServiceTestCase {
    @Autowired
    IAddressService service;
    @Test
    public void findByUid(){
        Integer uid=2;
        List<Address> data=service.getByUid(2);
        System.out.println(data);
    }
}
