package com.example.repository;

import com.example.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface CountryRepository extends JpaRepository<Country, String> {

}
