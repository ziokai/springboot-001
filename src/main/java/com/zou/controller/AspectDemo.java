package com.zou.controller;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author 你好
 */
@Component
@Aspect//增强注解
public class  AspectDemo{

    /**
     * 声明切入点
     */
    @Pointcut("@annotation(com.zou.common.NeedAuth)")
    public void aspectPoint() {

    }

    /**
     * @Pointcut("@annotation(com.zou.controller.HelloController.hello())")
     */
    @Before("aspectPoint()")
    public void before(){
        System.out.println("======前置======");
    }

    @AfterReturning(value="execution(* com.zou.controller.HelloController.hello(..))")
    public  void AfterReturning(){
        System.out.println("========后置=======");
    }

    @After("aspectPoint()")
    public  void after(){
        System.out.println("========最终=======");
    }

    @AfterThrowing(value = "execution(* com.zou.controller.HelloController.hello(..))")
    public  void AfterThrowing(){
        System.out.println("========异常=======");
    }

    @Around(value = "execution(* com.zou.controller.HelloController.hello(..))")
        public void around(ProceedingJoinPoint pj) throws
        Throwable {
            System.out.println("环绕之前.........");
            //被增强的方法执行
            pj.proceed();
            System.out.println("环绕之后.........");
        }
    }