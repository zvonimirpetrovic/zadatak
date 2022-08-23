package com.app.zadatak.service;

import com.app.zadatak.model.Project;

import java.util.List;

public interface ProjectService {

    List<Project> getAllProjects();
    
    Project getProjectById(int id);
    
    Project createProject(Project project);
    
    Project updateProject(int id, Project project);
    
    void deleteProject(int id);
}
