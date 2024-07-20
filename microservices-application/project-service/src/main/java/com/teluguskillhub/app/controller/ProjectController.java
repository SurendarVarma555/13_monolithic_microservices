package com.teluguskillhub.app.controller;

import com.teluguskillhub.app.entity.Project;
import com.teluguskillhub.app.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping()
    public ResponseEntity<Project> saveProject (@RequestBody Project project){
        Project savedProject = projectService.saveProject(project);
        return new ResponseEntity<>(savedProject, HttpStatus.CREATED);
    }

    @GetMapping("/{project_code}")
    public ResponseEntity<Project> getProjectById (@PathVariable("project_code") long project_code){
        Project projectByCode = projectService.getProjectByCode(project_code);
        return new ResponseEntity<>(projectByCode, HttpStatus.OK);


    }
}
