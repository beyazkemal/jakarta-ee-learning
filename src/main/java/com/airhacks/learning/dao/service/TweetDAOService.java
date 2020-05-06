package com.airhacks.learning.dao.service;

import com.airhacks.learning.model.Tweet;

import javax.ejb.Stateless;
import java.util.List;

/**
 * @author Kemal BEYAZ
 * @created 08/05/2020
 */
@Stateless
public class TweetDAOService extends BaseEntityDAOService<Tweet> {

    @Override
    public Class<Tweet> getEntityClass() {
        return Tweet.class;
    }

    @Override
    public String getNamedQueryPrefix() {
        return Tweet.NAMED_QUERY_PREFIX;
    }

    public List<Tweet> findByPersonId(long id) {
        return this.entityManager.createNamedQuery(getNamedQueryPrefix() + "-findByPersonId", Tweet.class)
                .setParameter("person_id", id)
                .getResultList();
    }
}
