package com.zgxh.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author Yu Yang
 * @create 2020-06-10 23:42
 */

@Aspect
@Component
// @Order(1) // 多切面时可以通过@Order注解来指定切面的执行顺序
public class AOPEmbed {

    @Before("execution(public int com.zgxh.service.impl.MyCalculator.*(int, int))")
    public static void logStart(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs(); // 拿到方法参数
        Signature signature = joinPoint.getSignature(); // 拿到方法签名
        System.out.println(signature.getName() + " method start..." + " args: " + Arrays.asList(args));
    }

    @AfterReturning(value = "execution(public int com.zgxh.service.impl.MyCalculator.*(int, int))", returning = "result")
    public static void logReturn(int result) { // 接收的变量需要声明用途
        System.out.println("method return... result:" + result);
    }

    @AfterThrowing(value = "execution(public int com.zgxh.service.impl.MyCalculator.*(int, int))", throwing = "exception")
    public static void logException(Exception exception) { // 获取异常信息，需要通过throwing告诉spring哪个参数接收异常信息
        System.out.println("method exception... " + exception);
    }

    @After("execution(public int com.zgxh.service.impl.MyCalculator.*(int, int))")
    public static void logEnd() {
        System.out.println("method end...");
    }

    /**
     * 环绕通知是【优先】于普通通知执行的。
     */
    @Around("execution(public int com.zgxh.service.impl.MyCalculator.*(int, int))")
    public Object logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();
        String methodName = proceedingJoinPoint.getSignature().getName();
        Object proceed = null;
        try {
            System.out.println("[Around] 前置通知...");
            proceed = proceedingJoinPoint.proceed(args); // 实质是反射调用
            System.out.println("[Around] 返回通知... result:" + proceed);
        } catch (Exception e) {
            System.out.println("[Around] 异常通知... exception:" + e);
        } finally {
            System.out.println("[Around] 后置通知...");
        }

        return proceed; // 返回反射调用后的返回值
    }
}
