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
 * Data JPA tests for entity {@link Customer}.
 *
 * @author simon
 */
@DataJpaTest
@RunWith(SpringRunner.class)
public class CustomerTest {

    @Autowired
    private TestEntityManager entityManager;

    private Language language;
    private Country country;

    @Before
    public void setUp() throws Exception {

        // create language
        language = Fixtures.createLanguage();
        this.entityManager.persistFlushFind(language);

        // create country
        country =  Fixtures.createCountry();
        this.entityManager.persistFlushFind(country);
    }

    @Test
    public void saveShouldPersistData() throws Exception {
        // create customer
        Customer customer = new Customer("simon", this.country, this.language);

        final Customer savedEntity = this.entityManager.persistFlushFind(customer);

        assertThat(savedEntity.getName()).isEqualTo("simon");
    }

}