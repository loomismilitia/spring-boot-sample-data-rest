package com.example.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Project {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "customerId", nullable = false)
    private Customer customer;


    public Project(String name, Customer customer) {
        this.name = name;
        this.customer = customer;
    }

    private Project() {
        //jpa
    }
}
