package com.teluguskillhub.app.service;

import com.teluguskillhub.app.playload.EmployeeDto;

public interface EmployeeService {

    public EmployeeDto saveEmployee (EmployeeDto employeeDto);

    public EmployeeDto getEmployeeById (long empId);
}
