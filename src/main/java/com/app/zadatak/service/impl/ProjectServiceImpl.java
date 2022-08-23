package com.app.zadatak.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.zadatak.model.Project;
import com.app.zadatak.repository.ProjectRepository;
import com.app.zadatak.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService{
	
	private final ProjectRepository projectRepository;
	
	public ProjectServiceImpl(ProjectRepository projectRepository) {
		super();
		this.projectRepository = projectRepository;
	}

	@Override
	public List<Project> getAllProjects() {
		return projectRepository.findAll();
	}

	@Override
	public Project getProjectById(int id) {
		Project project = projectRepository.findById(id).orElseThrow();
		return project;
	}

	@Override
	public Project createProject(Project project) {
		return projectRepository.save(project);
	}

	@Override
	public Project updateProject(int id, Project project) {
		Project projectToUpdate = projectRepository.findById(id).orElseThrow();
		
		projectToUpdate.setName(project.getName());
		projectToUpdate.setClient_id(project.getClient_id());
		projectToUpdate.setProject_manager(project.getProject_manager());
		projectToUpdate.setContact_email(project.getContact_email());
		projectToUpdate.setContact_number(project.getContact_number());
		projectToUpdate.setBilling_address(project.getBilling_address());
		
		return projectToUpdate;
	}

	@Override
	public void deleteProject(int id) {
		Project project = projectRepository.findById(id).orElseThrow();
		projectRepository.delete(project);
	}

}
