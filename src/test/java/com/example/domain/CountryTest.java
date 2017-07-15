package com.example.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Data JPA tests for entity {@link Country}.
 *
 * @author simon
 */
@DataJpaTest
@RunWith(SpringRunner.class)
public class CountryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void saveShouldPersistData() throws Exception {
        final Country savedEntity = this.entityManager.persistFlushFind(createCountry());
        assertThat(savedEntity.getCountryCode()).isEqualTo("pt");
        assertThat(savedEntity.getName()).isEqualTo("Portugal");
    }

    public static Country createCountry(){
        return new Country("pt", "Portugal");
    }

}