package com.ydlclass;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.ObjectError;

import java.util.List;

public class TestTools {
    private static final Logger logger=LoggerFactory.getLogger(TestTools.class);

    @Test
    public void testBeanWrapper(){
        Company company=new Company();
        Employee employee=new Employee();
        //将实例进行包装
        BeanWrapper beanWrapper=new BeanWrapperImpl(company);
        beanWrapper.setPropertyValue("name","元动力");
        beanWrapper.setPropertyValue("managingDirector",employee);
        beanWrapper.setPropertyValue("managingDirector.name","楠哥");
        beanWrapper.setPropertyValue("managingDirector.salary","10000");

        System.out.println(beanWrapper.getWrappedInstance());
    }
    @Test
    public void testPropertyEditor(){
        ApplicationContext context=new ClassPathXmlApplicationContext("ioc.xml");
        Company bean = context.getBean(Company.class);
        logger.info("{}",bean);
    }
    @Test
    public void testConvertor(){
        ApplicationContext context=new ClassPathXmlApplicationContext("ioc.xml");
        Employee bean = context.getBean(Employee.class);
        logger.info("{}",bean);
    }
    @Test
    public void testDataBinder(){
        Employee employee=new Employee();
        employee.setSalary(1500);
        DataBinder dataBinder=new DataBinder(employee);
        dataBinder.addValidators(new EmployeeValidate());
        dataBinder.validate();

        BindingResult bindingResult=dataBinder.getBindingResult();
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        for (ObjectError error:allErrors){
            System.out.println(error);
        }
    }
    @Test
    public void testel(){
        ExpressionParser parser=new SpelExpressionParser();
        Expression expression=parser.parseExpression("'6666'");
        System.out.println(expression.getValue());

        Expression expression2=parser.parseExpression("'66666'.bytes.length");
        System.out.println(expression2.getValue());

        Expression expression3=parser.parseExpression("new String('hello world').toUpperCase()");
        System.out.println(expression3.getValue());

        Employee employee=new Employee();
        employee.setName("lucy");
        expression=parser.parseExpression("name");
        String name=(String) expression.getValue(employee);
        System.out.println(name);



    }
    @Test
    public void testValue(){
        ApplicationContext context=new ClassPathXmlApplicationContext("ioc.xml");
        Employee bean = context.getBean(Employee.class);
        logger.info("{}",bean);
    }
}
