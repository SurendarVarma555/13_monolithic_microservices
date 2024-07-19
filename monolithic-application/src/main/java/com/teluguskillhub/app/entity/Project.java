package com.teluguskillhub.app.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "project_tb", uniqueConstraints = {@UniqueConstraint(columnNames = "projectCode")})
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long projectId;
    @Column(nullable = false)
    private long projectCode;
    @Column(nullable = false)
    private String projectName;

}
