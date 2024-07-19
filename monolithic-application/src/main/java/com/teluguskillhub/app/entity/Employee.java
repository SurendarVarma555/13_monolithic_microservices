package com.teluguskillhub.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee_tb", uniqueConstraints = {@UniqueConstraint(columnNames = "empEmail")})
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long empId;
    @Column(nullable = false)
    private String empName;
    @Column(nullable = false)
    private String empEmail;
    @Column(nullable = false)
    private long employeeAssignedProject;
    @Column(nullable = false)
    private String empBaseLocation;

}
