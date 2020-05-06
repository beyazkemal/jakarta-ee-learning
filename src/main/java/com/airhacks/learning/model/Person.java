package com.airhacks.learning.model;

import javax.persistence.*;

/**
 * @author Kemal BEYAZ
 * @created 06/05/2020
 */
@Entity
@NamedQuery(name = "all", query = "SELECT p FROM Person p")
@NamedQuery(name = "findById", query = "SELECT p FROM Person p WHERE p.id = :id")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
