package com.teluguskillhub.app.service.impl;

import com.teluguskillhub.app.entity.Employee;
import com.teluguskillhub.app.entity.Project;
import com.teluguskillhub.app.playload.EmployeeDto;
import com.teluguskillhub.app.repository.EmployeeRepo;
import com.teluguskillhub.app.repository.ProjectRepo;
import com.teluguskillhub.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ProjectRepo projectRepo;

    @Override
    public EmployeeDto saveEmployee (Employee employee){

        Employee savedEmployee = employeeRepo.save(employee);
        Project project = projectRepo.findByProjectCode(savedEmployee.getEmployeeAssignedProject());

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setEmpId(savedEmployee.getEmpId());
        employeeDto.setEmpName(savedEmployee.getEmpName());
        employeeDto.setEmpEmail(savedEmployee.getEmpEmail());
        employeeDto.setEmpBaseLocation(savedEmployee.getEmpBaseLocation());
        employeeDto.setProjectCode(project.getProjectCode());
        employeeDto.setProjectName(project.getProjectName());

        return employeeDto;
    }

    @Override
    public EmployeeDto getEmployeeById (long empId){

        Employee savedEmployee = employeeRepo.findById(empId).get();
        Project project = projectRepo.findByProjectCode(savedEmployee.getEmployeeAssignedProject());

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setEmpId(savedEmployee.getEmpId());
        employeeDto.setEmpName(savedEmployee.getEmpName());
        employeeDto.setEmpEmail(savedEmployee.getEmpEmail());
        employeeDto.setEmpBaseLocation(savedEmployee.getEmpBaseLocation());
        employeeDto.setProjectCode(project.getProjectCode());
        employeeDto.setProjectName(project.getProjectName());


        return employeeDto;
    }
}
