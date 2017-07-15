package com.example.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
public class Language {
        
    @Id
    @Column(name = "languageCode", nullable = false, columnDefinition = "char(2)")
    private String languageCode;

    @NotNull
    @Column(name = "name", length = 45, nullable = false)
    private String name;

    Language(String languageCode, String name) {
        this.languageCode = languageCode;
        this.name = name;
    }

    private Language() {
        //jpa
    }

}
