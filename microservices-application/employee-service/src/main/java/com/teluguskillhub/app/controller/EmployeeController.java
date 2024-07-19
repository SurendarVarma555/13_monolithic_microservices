package com.teluguskillhub.app.controller;

import com.teluguskillhub.app.entity.Employee;
import com.teluguskillhub.app.playload.EmployeeDto;
import com.teluguskillhub.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee (@RequestBody Employee employee){
        EmployeeDto employeeDto = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(employeeDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployee (@PathVariable("id") long empId){
        EmployeeDto employeeById = employeeService.getEmployeeById(empId);
        return new ResponseEntity<>(employeeById, HttpStatus.OK);
    }
}
