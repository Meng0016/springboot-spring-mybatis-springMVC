package com.ydlclass;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class EmployeeValidate implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Employee.class == clazz;
    }

    @Override
    public void validate(Object target, Errors errors) {

        Employee employee=(Employee) target;
        if (employee.getSalary()<2000){
            errors.rejectValue("salary","10001","员工薪资最低2000，而您的是"+employee.getSalary());
        }
    }
}
