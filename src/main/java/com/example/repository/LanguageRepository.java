package com.example.repository;

import com.example.domain.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface LanguageRepository extends JpaRepository<Language, String> {

}
