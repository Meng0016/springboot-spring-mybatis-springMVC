package com.ydlclass.aspectj;

import com.ydlclass.service.IActivity;
import com.ydlclass.service.impl.Activity;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Component
@Aspect
public class MyAspectj {

    @DeclareParents(value = "com.ydlclass.service.impl.OrderService",defaultImpl = Activity.class)
    public static IActivity activity;

    @Pointcut("execution(public * com.ydlclass..*(..))")
    private void beforePointcut(){
    }
    @Before("beforePointcut()")
    private void beforeAdvice(JoinPoint jp) throws InvocationTargetException, IllegalAccessException {
        MethodSignature signature=(MethodSignature) jp.getSignature();
        //能拿到方法，能不能拿到方法的注解
        Method method=signature.getMethod();
        //调用方法的过程
        method.invoke(jp.getTarget(),jp.getArgs());

        System.out.println("this is before advice");
    }

    @AfterReturning("execution(public * com.ydlclass..order(..))")
    private void afterReturningAdvice(){

        System.out.println("this is afterReturningAdvice");
    }
    @After("execution(public * com.ydlclass..order(..))")
    private void afterAdvice(){

        System.out.println("this is afterAdvice");
    }
    @AfterThrowing(value = "execution(public * com.ydlclass..order(..))",throwing = "ex")
    private void afterThrowingAdvice(ArithmeticException ex){

        System.out.println("this is afterThrowingAdvice");
        System.out.println("---------------"+ex);
    }


    /*@Around("execution(public * com.ydlclass..order(..))")
    private Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("this is aroundAdvice1");

        //相当于调用方法
        Object proceed = pjp.proceed();
        System.out.println("this is aroundAdvice2");
        return proceed;
    }*/

    @Before("execution(* com.ydlclass.service.impl.OrderService.*(..)) && args(money,..)")
    public void validateAccount(Integer money){

        System.out.println("before---------"+money);
    }
}
//能够将一个类定义成一个切面
