package com.example.springbootdemo.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.security.auth.message.AuthException;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 环绕增强实现全局日志
 */
@Controller
@Aspect
@Slf4j
@EnableAspectJAutoProxy
public class AspectController {
    /**
     * 指定切点
     */
    @Pointcut("execution(* com.example.springbootdemo..*.*(..))")
    public void aspectController(){
    }

    @Around(value = "aspectController()")
    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        //防止非http请求的方法，如：schedule
        if (ra == null || sra == null) {
            return pjp.proceed();
        }


//        log.info("URL : " + request.getRequestURL().toString());
//        log.info("HTTP_METHOD : " + request.getMethod());
//        log.info("IP : " + request.getRemoteAddr());
//        log.info("CLASS_METHOD : " + pjp.getSignature().getDeclaringTypeName() + "." + pjp.getSignature().getName());
//        log.info("REQUEST ARGS : " + JSON.toJSONString(pjp.getArgs()));
//        log.info(String.format("start to:[%s],request method:[%s] request param:%s",request.getRequestURL().toString(),request.getMethod(),JSON.toJSONString(pjp.getArgs())));

        long startTime = System.currentTimeMillis();
        try {
            Object response = pjp.proceed();
            // 打印返回结果
            long endTime = System.currentTimeMillis();
//            log.info(String.format("start to:[%s],request method:[%s] request param:%s,response:[%s]",request.getRequestURL().toString(),request.getMethod(),JSON.toJSONString(pjp.getArgs()),JSON.toJSONString(response)));

            log.info("SPEND TIME : {}ms", (endTime - startTime));
            return response;
        } catch (AuthException e) {
            log.info("RESPONSE ERROR:{}", e.getMessage());
            throw e;
        } catch (MethodArgumentNotValidException e) {
            log.info("RESPONSE ERROR:{}", e.getMessage());
            throw e;
        } catch (Throwable e) {
            log.error("RESPONSE ERROR:{}", Arrays.toString(e.getStackTrace()));
            throw e;
        } finally {
            long endTime = System.currentTimeMillis();
            log.error("SPEND TIME : {}ms", (endTime - startTime));
        }
    }

}
