package com.example.domain;

import org.junit.Before;
import org.junit.Test;
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
        Language language = Fixtures.createLanguage();
        this.entityManager.persistFlushFind(language);

        // create country
        Country country = Fixtures.createCountry();
        this.entityManager.persistFlushFind(country);

        // create customer
        customer = new Customer("simon", country, language );
        this.entityManager.persistFlushFind(customer);
    }

    @Test
    public void saveShouldPersistData() throws Exception {
        Project project = new Project("project name", this.customer);

        final Project savedEntity = this.entityManager.persistFlushFind(project);
        assertThat(savedEntity.getName()).isEqualTo("project name");
    }

}