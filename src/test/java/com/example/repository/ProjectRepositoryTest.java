package com.example.repository;

import com.example.domain.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for repository {@link ProjectRepository}.
 *
 * @author simon
 */
@DataJpaTest
@RunWith(SpringRunner.class)
public class ProjectRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProjectRepository repository;

    private Customer customer;

    @Before
    public void setUp() throws Exception {

        // create language
        Language language = LanguageTest.createLanguage();
        this.entityManager.persistFlushFind(language);

        // create country
        Country country = CountryTest.createCountry();
        this.entityManager.persistFlushFind(country);

        // create customer
        customer = new Customer();
        customer.setCountry(country);
        customer.setLanguage(language);
        customer.setName("simon");
        this.entityManager.persistFlushFind(customer);
    }

    @Test
    public void findByCustomerShouldReturnProject() throws Exception {
        Project project = new Project();
        project.setName("project name");
        project.setCustomer(this.customer);

        this.entityManager.persist(project);

        List<Project> byCustomer = repository.findByCustomer(this.customer);
        assertThat(byCustomer).hasSize(1);
        assertThat(byCustomer.get(0).getName()).isEqualTo("project name");
    }

}