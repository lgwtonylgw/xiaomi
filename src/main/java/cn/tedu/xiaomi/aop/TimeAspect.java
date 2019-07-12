package cn.tedu.xiaomi.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created on 2019/6/24 19:57
 *
 * @author Tony
 * @projectName xiaomi
 */
@Aspect
@Component
public class TimeAspect {
    @Around("execution(* cn.tedu.xiaomi.service.impl.*.*(..))")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable{
        long start=System.currentTimeMillis();
        Object result=pjp.proceed();
        long end=System.currentTimeMillis();
        System.err.println("耗时："+(end-start));
        return result;
    }
}
