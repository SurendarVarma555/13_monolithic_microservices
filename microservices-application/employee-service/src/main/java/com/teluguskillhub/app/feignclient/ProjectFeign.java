package com.teluguskillhub.app.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8585", value = "project-feign-client", path = "/api/projects")
public interface ProjectFeign {

    @GetMapping("/{project_code}")
    feign.Response getProjectById (@PathVariable(value = "project_code") long project_code);


}
