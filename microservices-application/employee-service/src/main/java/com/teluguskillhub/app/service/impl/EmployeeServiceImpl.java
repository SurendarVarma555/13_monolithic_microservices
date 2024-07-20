package com.teluguskillhub.app.service.impl;

import com.google.gson.Gson;
import com.teluguskillhub.app.entity.Employee;
import com.teluguskillhub.app.feignclient.ProjectFeign;
import com.teluguskillhub.app.playload.EmployeeDto;
import com.teluguskillhub.app.playload.Project;
import com.teluguskillhub.app.repository.EmployeeRepo;
import com.teluguskillhub.app.service.EmployeeService;
import feign.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ProjectFeign projectFeign;

    @Override
    public EmployeeDto saveEmployee (Employee employee){
        Employee savedEmployee = employeeRepo.save(employee);
        Response response = projectFeign.getProjectById(savedEmployee.getEmployeeAssignedProject());

        Project project = null;
        try (Reader reader = new InputStreamReader(response.body().asInputStream())) {
            Gson gson = new Gson();
            project = gson.fromJson(reader, Project.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmpId(savedEmployee.getEmpId());
        employeeDto.setEmpName(savedEmployee.getEmpName());
        employeeDto.setEmpEmail(savedEmployee.getEmpEmail());
        employeeDto.setEmpBaseLocation(savedEmployee.getEmpBaseLocation());

        if (project != null) {
            employeeDto.setProjectCode(project.getProjectCode());
            employeeDto.setProjectName(project.getProjectName());
        }

        return employeeDto;
    }

    @Override
    public EmployeeDto getEmployeeById (long empId){
        Employee foundEmployee = employeeRepo.findById(empId).orElse(null);

        if (foundEmployee == null) {
            return null; // Or throw an exception if preferred
        }

        Response response = projectFeign.getProjectById(foundEmployee.getEmployeeAssignedProject());

        Project project = null;
        try (Reader reader = new InputStreamReader(response.body().asInputStream())) {
            Gson gson = new Gson();
            project = gson.fromJson(reader, Project.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmpId(foundEmployee.getEmpId());
        employeeDto.setEmpName(foundEmployee.getEmpName());
        employeeDto.setEmpEmail(foundEmployee.getEmpEmail());
        employeeDto.setEmpBaseLocation(foundEmployee.getEmpBaseLocation());

        if (project != null) {
            employeeDto.setProjectCode(project.getProjectCode());
            employeeDto.setProjectName(project.getProjectName());
        }

        return employeeDto;
    }
}
