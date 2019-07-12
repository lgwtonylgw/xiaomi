package cn.tedu.xiaomi.mapper;

import cn.tedu.xiaomi.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created on 2019/6/2 22:24
 *
 * @author Tony
 * @projectName xiaomi
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTestCase {
    @Autowired
    private UserMapper mapper;
    @Test
    public  void reg(){
        User u=new User();
        u.setUsername("tony");
        u.setPhone("123456");
        u.setPhone("13888888888");
        u.setEmail("1323795603@qq.com");
        mapper.insert(u);
    }
}
