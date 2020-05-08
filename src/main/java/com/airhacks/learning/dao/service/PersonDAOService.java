package com.airhacks.learning.dao.service;

import com.airhacks.learning.model.Person;

import javax.ejb.Stateless;

/**
 * @author Kemal BEYAZ
 * @created 06/05/2020
 */
@Stateless
public class PersonDAOService extends BaseEntityDAOService<Person> {

    @Override
    public Class<Person> getEntityClass() {
        return Person.class;
    }

    @Override
    public String getNamedQueryPrefix() {
        return Person.NAMED_QUERY_PREFIX;
    }

}
