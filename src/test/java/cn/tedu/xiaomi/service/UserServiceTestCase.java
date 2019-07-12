package cn.tedu.xiaomi.service;

import cn.tedu.xiaomi.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created on 2019/6/2 22:28
 *
 * @author Tony
 * @projectName xiaomi
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTestCase {
    @Autowired
    private IUserService userService;
    @Test
    public void reg(){
        User u=new User();
        u.setUsername("jerry");
        u.setPassword("123456");
        u.setPhone("13888888888");
        u.setEmail("1323795603@qq.com");
        userService.reg(u);
    }
    @Test
    public  void login(){
        String username="lgwtonylgw";
        String password="123456";
        User u=userService.login(username,password);
        System.out.println(u);
    }
    @Test
    public void changeGrxx(){
        String username="lgwtonylgw";
        String nickname="刘国文";
        String birth="1994年5月24日";
        String gender="男";
        userService.changeGrxx(username,nickname,birth,gender);
    }
    @Test
    public void findUserByUsername(){
        String username="lgwtonylgw";
        User u=userService.findUserByUsername(username);
        System.out.println(u);
    }
}
