package com.airhacks.learning;

import com.airhacks.learning.model.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Kemal BEYAZ
 * @created 06/05/2020
 */
@Stateless
public class PersonService {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Person person) {
        this.entityManager.persist(person);
    }

    public void saveAll(List<Person> persons) {
        persons.forEach(this::save);
    }

    public List<Person> getAll() {
        return this.entityManager.createNamedQuery("all", Person.class).getResultList();
    }

    public Person findById(long id) {
        return this.entityManager.createNamedQuery("findById", Person.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
