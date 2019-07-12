package cn.tedu.xiaomi.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created on 2019/6/24 20:04
 *
 * @author Tony
 * @projectName xiaomi
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session=request.getSession();
        Object uid=session.getAttribute("id");
        if(uid==null){
            response.sendRedirect("/web/login.html");
            return  false;
        }
        return true;
    }
}
