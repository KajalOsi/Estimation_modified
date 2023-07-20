package com.osi.estimationmodule.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osi.estimationmodule.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
	//Optional<Project> findByName(String name);
}
