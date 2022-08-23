package com.app.zadatak.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.app.zadatak.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer>{


}