package io.agileintelligence.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.agileintelligence.domain.Project;
import io.agileintelligence.services.ProjectService;

@RestController
@RequestMapping("/projects")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@PostMapping
	public ResponseEntity<Project> create(@RequestBody Project project) {
		Project p = projectService.saveOrUpdate(project);
		
		return new ResponseEntity<Project>(project, HttpStatus.CREATED);
	}
}
