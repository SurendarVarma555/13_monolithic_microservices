package com.teluguskillhub.app.service;

import com.teluguskillhub.app.entity.Employee;
import com.teluguskillhub.app.playload.EmployeeDto;

public interface EmployeeService {

    public EmployeeDto saveEmployee (Employee employee);

    public EmployeeDto getEmployeeById (long empId);
}
