package com.ydlclass.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyAop {

    private void beforeAdvice(JoinPoint jp) throws InvocationTargetException, IllegalAccessException {

        System.out.println("this is before advice");
    }


    private void afterReturningAdvice(){

        System.out.println("this is afterReturningAdvice");
    }
    private void afterAdvice(){

        System.out.println("this is afterAdvice");
    }
    private void afterThrowingAdvice(ArithmeticException ex){

        System.out.println("this is afterThrowingAdvice");
        System.out.println("---------------"+ex);
    }



    private Object aroundAdvice(ProceedingJoinPoint pjp,Integer money) throws Throwable {
        System.out.println("this is aroundAdvice1");
        System.out.println(money);
        //相当于调用方法
        Object proceed = pjp.proceed();
        System.out.println("this is aroundAdvice2");
        return proceed;
    }

}
