package com.imooc.aspectJ.demo1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class MyAspectAnnoAdvisor {

    // 可以在方法中传入JoingPoint对象，用来获得切点信息
//    @Before(value="execution(* com.imooc.aspectJ.demo1.ProductDao.save(..))")
//    public void beforeAdvisor(JoinPoint joinPoint) {
//        System.out.println("前置通知==============" + joinPoint);
//    }

    // 在每个通知内定义切点，会造成工作量大，不易维护，对于重复的切点可以使用@Pointcut进行定义
    @Before(value="myPointcut1() || myPointcut2()")
    public void beforeAdvisor(JoinPoint joinPoint) {
        System.out.println("前置通知==============" + joinPoint);
    }

    @AfterReturning(value="execution(* com.imooc.aspectJ.demo1.ProductDao.update(..))", returning = "result")
    public void afterAdvisor(Object result) {
        System.out.println("后置通知==============" + result);
    }

    // 可以不调用ProceedingJoinPoint方法，从而实现对目标方法的拦截
    @Around(value="execution(* com.imooc.aspectJ.demo1.ProductDao.delete(..))")
    public Object aroundAdvisor(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前通知=============");
        // 执行目标方法
        Object obj = joinPoint.proceed();
        System.out.println("环绕后通知=============");
        return obj;
    }

    @AfterThrowing(value="execution(* com.imooc.aspectJ.demo1.ProductDao.findOne(..))", throwing = "e")
    public void throwableAdvisor(Throwable e) {
        System.out.println("异常通知抛出============" + e);
    }

    @After(value="execution(* com.imooc.aspectJ.demo1.ProductDao.findAll(..))")
    public void finallyAdvisor() {
        System.out.println("最终通知================");
    }

    @Pointcut(value="execution(* com.imooc.aspectJ.demo1.ProductDao.save(..))")
    private void myPointcut1() {}

    @Pointcut(value="execution(* com.imooc.aspectJ.demo1.ProductDao.update(..))")
    private void myPointcut2() {}
}
