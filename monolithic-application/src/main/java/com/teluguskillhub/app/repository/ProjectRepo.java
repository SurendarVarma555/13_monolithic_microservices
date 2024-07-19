package com.teluguskillhub.app.repository;

import com.teluguskillhub.app.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project, Long> {
    Project findByProjectCode (long projectCode);
}
