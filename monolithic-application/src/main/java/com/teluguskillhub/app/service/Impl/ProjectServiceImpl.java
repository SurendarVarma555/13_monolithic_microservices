package com.teluguskillhub.app.service.Impl;

import com.teluguskillhub.app.entity.Project;
import com.teluguskillhub.app.repository.ProjectRepo;
import com.teluguskillhub.app.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepo projectRepo;

    @Override
    public Project saveProject (Project project){
        // Ensure projectName is set before saving
        if (project.getProjectName() == null) {
            throw new IllegalArgumentException("Project name must not be null");
        }
        return projectRepo.save(project);
    }

    @Override
    public Project getProjectByCode (long projectCode){
        Project foundProject = projectRepo.findByProjectCode(projectCode);
        return foundProject;
    }
}
