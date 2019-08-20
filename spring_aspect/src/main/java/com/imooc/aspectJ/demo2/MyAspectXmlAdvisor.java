package com.imooc.aspectJ.demo2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspectXmlAdvisor {

    // 前置通知
    public void before(JoinPoint joinPoint) {
        System.out.println("通过Xml方式配置的前置增强===================" + joinPoint);
    }

    // 后置通知
    public void afterReturning(Object result) {
        System.out.println("通过Xml方式配置的后置通知===================" + result);
    }

    // 环绕通知
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("通过Xml方式配置的环绕前通知===================");
        Object obj = proceedingJoinPoint.proceed();
        System.out.println("通过Xml方式配置的环绕后通知===================");
        return obj;
    }

    // 异常通知
    public void afterThrowing(Throwable e) {
        System.out.println("通过Xml方式配置的异常通知=====================" + e.getMessage());
    }

    // 最终通知
    public void after() {
        System.out.println("通过Xml方式配置最终通知=======================");
    }
}
