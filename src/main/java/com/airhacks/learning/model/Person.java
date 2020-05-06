package com.airhacks.learning.model;

import javax.persistence.*;

/**
 * @author Kemal BEYAZ
 * @created 06/05/2020
 */
@Entity
@NamedQueries({
        @NamedQuery(name = Person.NAMED_QUERY_PREFIX + "-all", query = "SELECT p FROM Person p"),
        @NamedQuery(name = Person.NAMED_QUERY_PREFIX + "-findById", query = "SELECT p FROM Person p WHERE p.id = :id"),
        @NamedQuery(name = Person.NAMED_QUERY_PREFIX + "-deleteById", query = "DELETE FROM Person p WHERE p.id = :id")
})
public class Person implements BaseEntity {

    public static final String NAMED_QUERY_PREFIX = "Person";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getNamedQueryPrefix() {
        return NAMED_QUERY_PREFIX;
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
