package cn.tedu.xiaomi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class XiaomiApplicationTests {

    @Test
    public void contextLoads() {
    }
    @Autowired
    private JavaMailSender mailSender;

    @Test
    public void sendSimpleMail() throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("1323795603@qq.com");
        message.setTo("1323795603@qq.com");
        message.setSubject("主题：简单邮件");
        message.setText("测试邮件内容");

        mailSender.send(message);
    }
    @Test
    public void test2() throws Exception {
        MimeMessage mimeMailMessage=mailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(mimeMailMessage,true);
        helper.setFrom("1323795603@qq.com");
        helper.setTo("lgwtonylgw@163.com");
        helper.setSubject("主题：简单邮件");
        helper.setText("<h1 style='color:red;'>测试邮件内容<h1><input type='button' value='罗卓辉'>",true);
        helper.addAttachment("1.jpg",new File("C:\\Users\\admin\\Desktop\\1.jpg"));
        helper.addAttachment("2.jpg",new File("C:\\Users\\admin\\Desktop\\2.jpg"));
        mailSender.send(mimeMailMessage);
    }
}
