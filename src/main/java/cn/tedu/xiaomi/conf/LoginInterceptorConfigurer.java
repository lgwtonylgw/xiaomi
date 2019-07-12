package cn.tedu.xiaomi.conf;

import cn.tedu.xiaomi.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2019/6/24 20:07
 *
 * @author Tony
 * @projectName xiaomi
 */
@Configuration
public class LoginInterceptorConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        HandlerInterceptor interceptor=new LoginInterceptor();
        List<String> patterns=new ArrayList<>();
        patterns.add("/bootstrap/**");
        patterns.add("/bootstrap3/**");
        patterns.add("/cropper/**");
        patterns.add("/css/**");
        patterns.add("/image/**");
        patterns.add("/images/**");
        patterns.add("/imgs/**");
        patterns.add("/jq/**");
        patterns.add("/jquery/**");
        patterns.add("/js/**");
        patterns.add("/sitelogo/**");
        patterns.add("/web/hotgoods.html");
        patterns.add("/web/login.html");
        patterns.add("/web/product.html");
        patterns.add("/web/reg.html");
        patterns.add("/index.html");
        patterns.add("/user/reg");
        patterns.add("/user/email");
        patterns.add("/user/check");
        patterns.add("/user/login");
        patterns.add("/user/info");
        patterns.add("/goods/**");
        patterns.add("/districts/**");
        registry.addInterceptor(interceptor).addPathPatterns("/**").excludePathPatterns(patterns);
    }
}
