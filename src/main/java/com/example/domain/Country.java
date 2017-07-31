package com.example.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.Assert;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@Entity
public class Country {

    @Id
    @Column(name = "countryCode", length = 2, columnDefinition = "char(2)", nullable = false)
    private String countryCode;
    
    @NotNull
    private String name;

    Country(String countryCode, String name) {
        Assert.notNull(countryCode, "countryCode must not be null");
        Assert.notNull(name, "name must not be null");
        this.countryCode = countryCode;
        this.name = name;
    }

    Country() {
        //jpa
    }

}
