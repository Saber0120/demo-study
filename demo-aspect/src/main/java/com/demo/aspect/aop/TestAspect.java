package com.demo.aspect.aop;

import com.demo.aspect.anno.SysLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * 执行顺序：环绕通知（前）-前置通知-被代理方法-环绕通知（后）-最终通知-后置通知（或异常通知）。
 * Created by sheng on 2018/9/3.
 */
@Aspect
@Component
public class TestAspect {

    /**
     * 拦截有指定注解的方法或者拦截指定报名下的所有方法
     */
//    private final String POINT_CUT = "@annotation(com.demo.aspect.anno.SysLog)";
    private final String POINT_CUT = "execution(* com.demo.aspect.controller.*.*(..))";

    @Pointcut(POINT_CUT)
    private void pointCut() {
    }

    // 或者 @Before(value = POINT_CUT)
    @Before("pointCut()")
    public void beforePointCut(JoinPoint joinPoint) {
        System.out.println("beforePointCut begin---");
        // 从RequestContextHolder获取RequestAttributes对象
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        // requestAttributes获取HttpServletRequest和HttpSession信息
        HttpServletRequest httpServletRequest = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        HttpSession httpSession = (HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);
        String age = httpServletRequest.getParameter("age");
        System.out.println("age = " + age);

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("被代理的方法是：" + name);

        Method method = signature.getMethod();
//        SysLog annotation = AnnotationUtils.findAnnotation(method, SysLog.class);
        SysLog sysLog = method.getAnnotation(SysLog.class);
        System.out.println("syslog.value = " + sysLog.value());
        System.out.println("beforePointCut end---");
    }

    @AfterReturning(value = "pointCut()", returning = "keys")
    public void doAfterReturning(JoinPoint joinPoint, Object keys) {
        System.out.println("第一个后置通知");
    }

    @AfterReturning(value = "pointCut()", returning = "keys", argNames = "keys")
    public void doAfterReturning2(String keys) {
        System.out.println("第二个后置通知");
    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        if (exception instanceof NullPointerException) {
            System.out.println("空指针异常");
        } else {
            System.out.println("其他异常");
        }
    }

    @After(value = "pointCut()")
    public void doAfter() {
        System.out.println("最终通知");
    }

    @Around(value = "pointCut()")
    public Object doAround(ProceedingJoinPoint joinPoint) {
        System.out.println("环绕通知方法名 " + joinPoint.getSignature().getName());
        try {
            System.out.println("执行前");
            Object obj = joinPoint.proceed();
            System.out.println("执行后");
            return obj;
        } catch (Throwable throwable) {
            // 这里要这么写才会走@AfterThrowing
            throw new RuntimeException(throwable);
        }
    }
}
