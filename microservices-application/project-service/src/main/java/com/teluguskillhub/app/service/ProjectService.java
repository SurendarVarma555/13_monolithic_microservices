package com.teluguskillhub.app.service;

import com.teluguskillhub.app.entity.Project;

public interface ProjectService {

    public Project saveProject (Project project);

    public Project getProjectByCode (long project_code);
}
