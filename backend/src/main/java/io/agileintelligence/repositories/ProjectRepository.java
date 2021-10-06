package io.agileintelligence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.agileintelligence.domain.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

	Project findByProjectIdentifier(String projectId);
	
	List<Project> findAll();
}
