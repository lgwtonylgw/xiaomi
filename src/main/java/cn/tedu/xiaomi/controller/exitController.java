package cn.tedu.xiaomi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created on 2019/6/24 20:37
 *
 * @author Tony
 * @projectName xiaomi
 */
@Controller
@RequestMapping("user")
public class exitController {
    @RequestMapping("exit")
    public String exitDo(HttpSession session){
        session.invalidate();
        System.out.println("hahahahah");
        return "redirect:/index.html";
    }
}
