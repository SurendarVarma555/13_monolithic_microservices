package com.teluguskillhub.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "project_tb", uniqueConstraints = {@UniqueConstraint(columnNames = "projectCode")})
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long projectId;
    @Column(name = "project_code", nullable = false)
    private long projectCode;
    @Column(name = "project_name", nullable = false)
    private String projectName;

}
