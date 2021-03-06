package io.agileintelligence.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.agileintelligence.domain.Project;
import io.agileintelligence.exceptions.ProjectIdException;
import io.agileintelligence.repositories.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	
	public Project saveOrUpdate(Project project) {
		try {
			project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
			
			return projectRepository.save(project);
		} catch (Exception e) {
			throw new ProjectIdException("Project ID '" + project.getProjectIdentifier().toUpperCase() + "' already exists.");
		}
	}
	
	public Project findProjectByIdentifier(String projectId) {
		Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase()); 
		
		if(project == null) {
			throw new ProjectIdException("Project ID '" + projectId + "' does not exist.");
		}
		
		return project;
	}
	
	public List<Project> findAllProjects() {
		return projectRepository.findAll();
	}
	
	public void deleteProjectByIdentifier(String projectId) {
		Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase()); 
		
		if(project == null) {
			throw new ProjectIdException("Cannot Delete Project with ID '" + projectId + "'. This project does not exist.");
		}
		
		projectRepository.delete(project);
	}
}
