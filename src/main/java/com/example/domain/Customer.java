package com.example.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.Assert;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "countryCode", nullable = false)
    private Country country;

    @ManyToOne(optional = false)
    @JoinColumn(name = "languageCode", nullable = false)
    private Language language;

    public Customer(String name, Country country, Language language) {
        Assert.notNull(name, "name must not be null");
        Assert.notNull(country, "country must not be null");
        Assert.notNull(language, "language must not be null");
        this.name = name;
        this.country = country;
        this.language = language;
    }

    private Customer() {
        // jpa
    }
}
