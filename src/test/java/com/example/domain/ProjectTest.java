package com.example.domain;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Data JPA tests for entity {@link Project}.
 *
 * @author simon
 */
@DataJpaTest
@RunWith(SpringRunner.class)
public class ProjectTest {

    @Autowired
    private TestEntityManager entityManager;

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

    @org.junit.Test
    public void saveShouldPersistData() throws Exception {
        Project project = new Project();
        project.setName("project name");
        project.setCustomer(this.customer);

        final Project savedEntity = this.entityManager.persistFlushFind(project);
        assertThat(savedEntity.getName()).isEqualTo("project name");
    }

}