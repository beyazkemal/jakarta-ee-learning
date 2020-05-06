package com.airhacks.learning.dao.service;

import com.airhacks.learning.model.BaseEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Kemal BEYAZ
 * @created 08/05/2020
 */
public abstract class BaseEntityDAOService<T extends BaseEntity> {

    @PersistenceContext
    protected EntityManager entityManager;

    public abstract Class<T> getEntityClass();
    public abstract String getNamedQueryPrefix();

    public T save(final T entity) {
        return this.entityManager.merge(entity);
    }

    public void saveAll(final List<T> entities) {
        entities.forEach(this::save);
    }

    public List<T> getAll() {
        return this.entityManager.createNamedQuery(getNamedQueryPrefix() +"-all", getEntityClass()).getResultList();
    }

    public T findById(final long id) {
        return this.entityManager.createNamedQuery(getNamedQueryPrefix() + "-findById", getEntityClass())
                .setParameter("id", id)
                .getSingleResult();
    }

    public void delete(final long id) {
        this.entityManager.createNamedQuery(getNamedQueryPrefix() +"-deleteById", getEntityClass())
                .setParameter("id", id)
                .executeUpdate();
    }
}
