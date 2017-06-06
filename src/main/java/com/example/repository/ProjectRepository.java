package com.example.repository;

import com.example.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
