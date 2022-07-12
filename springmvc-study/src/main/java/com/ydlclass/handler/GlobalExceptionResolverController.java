package com.ydlclass.handler;

import com.ydlclass.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
@Slf4j
public class GlobalExceptionResolverController{
    @ExceptionHandler(ArithmeticException.class)
    public String processArithmeticException(ArithmeticException ex){
        log.error("数学异常",ex);
        return "error";
    }

    /*@ExceptionHandler(BusinessException.class)
    public String processBusinessExceptionException(BusinessException ex){
        log.error("异常",ex);
        return "error";
    }*/
}


