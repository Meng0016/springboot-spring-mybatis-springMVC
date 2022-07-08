package com.ydlclass;

import java.beans.PropertyEditorSupport;

public class EmployeeEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Employee employee=new Employee();
        employee.setName(text);
        employee.setSalary(10000F);
        super.setValue(employee);
    }
}
