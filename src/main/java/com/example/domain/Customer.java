package com.example.domain;

import lombok.Getter;
import lombok.Setter;

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

    public Customer() {
        // jpa
    }
}
