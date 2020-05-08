package com.airhacks.learning.model;

import javax.persistence.*;

/**
 * @author Kemal BEYAZ
 * @created 08/05/2020
 */
@Entity
@NamedQueries({
        @NamedQuery(name = Tweet.NAMED_QUERY_PREFIX + "-all", query = "SELECT t FROM Tweet t"),
        @NamedQuery(name = Tweet.NAMED_QUERY_PREFIX + "-findById", query = "SELECT t FROM Tweet t WHERE t.id = :id"),
        @NamedQuery(name = Tweet.NAMED_QUERY_PREFIX + "-deleteById", query = "DELETE FROM Tweet t WHERE t.id = :id"),
        @NamedQuery(name = Tweet.NAMED_QUERY_PREFIX + "-findByPersonId", query = "SELECT t FROM Tweet t WHERE t.person.id = :person_id"),
})
public class Tweet implements BaseEntity {

    public static final String NAMED_QUERY_PREFIX = "Tweet";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String message;
    @ManyToOne
    private Person person;

    public Tweet() {
    }

    public Tweet(String message, Person person) {
        this.message = message;
        this.person = person;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
