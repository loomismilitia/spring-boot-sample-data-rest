package com.example.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Data JPA tests for entity {@link Language}.
 *
 * @author simon
 */
@DataJpaTest
@RunWith(SpringRunner.class)
public class LanguageTest {

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void saveShouldPersistData() throws Exception {
        final Language savedEntity = this.entityManager.persistFlushFind(createLanguage());
        assertThat(savedEntity.getLanguageCode()).isEqualTo("pt");
        assertThat(savedEntity.getName()).isEqualTo("Portuguese");
    }

    public static Language createLanguage(){
        Language language = new Language();
        language.setLanguageCode("pt");
        language.setName("Portuguese");
        return language;
    }

}