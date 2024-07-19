package com.teluguskillhub.app.controller;

import com.teluguskillhub.app.entity.Project;
import com.teluguskillhub.app.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/projects")
    public ResponseEntity<Project> saveProject (@RequestBody Project project){
        Project savedProject = projectService.saveProject(project);
        return new ResponseEntity<>(savedProject, HttpStatus.CREATED);
    }

    @GetMapping("/projects/{projectCode}")
    public ResponseEntity<Project> getProjectById (@PathVariable("projectCode") long projectCode){
        Project projectByCode = projectService.getProjectByCode(projectCode);
        return new ResponseEntity<>(projectByCode, HttpStatus.OK);


    }
}
