package com.app.zadatak.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.zadatak.dto.ProjectDto;
import com.app.zadatak.model.Project;
import com.app.zadatak.service.ProjectService;  

@RestController  
@RequestMapping("/api/projects")
public class ProjectController {
		
	@Autowired
	private ModelMapper modelMapper;

	private ProjectService projectService; 

	public ProjectController(ProjectService projectService) {
		super();
		this.projectService = projectService;
	} 
	
	// Get all projects
	@CrossOrigin
	@GetMapping
	public List<ProjectDto> getAllProjects(){  
		return projectService.getAllProjects()
				.stream()
				.map(project -> modelMapper.map(project, ProjectDto.class))
				.collect(Collectors.toList()); 
	}  
	
	// Get 1 project
	@CrossOrigin
	@GetMapping("/{id}")  
	public  ResponseEntity<ProjectDto> getProject(@PathVariable("id") int id){  
		Project project = projectService.getProjectById(id);  
		
		ProjectDto projectDto = modelMapper.map(project, ProjectDto.class);
		return ResponseEntity.ok().body(projectDto);
	}  
	
	// Create project
	@CrossOrigin
	@PostMapping
	public ResponseEntity<ProjectDto> createProject(@RequestBody ProjectDto projectDto) {

		// convert DTO to entity
		Project projectReq = modelMapper.map(projectDto, Project.class);

		Project project = projectService.createProject(projectReq);

		// convert entity to DTO
		ProjectDto projectRes = modelMapper.map(project, ProjectDto.class);

		return new ResponseEntity<ProjectDto>(projectRes, HttpStatus.CREATED);
	}
	
	// Update project
	@Transactional
	@CrossOrigin
	@PatchMapping("/{id}")
	public ResponseEntity<ProjectDto> updatePost(@PathVariable int id, @RequestBody ProjectDto projectDto) {
		
		// convert DTO to Entity		
		Project projectReq = modelMapper.map(projectDto, Project.class);

		Project project = projectService.updateProject(id, projectReq);

		// entity to DTO
		ProjectDto projectRes = modelMapper.map(project, ProjectDto.class);

		return ResponseEntity.ok().body(projectRes);
	}
	
	// Delete a project
	@CrossOrigin
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePost(@PathVariable(name = "id") int id) {
		projectService.deleteProject(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}  