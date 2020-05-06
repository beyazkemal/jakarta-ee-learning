package com.airhacks.learning.controller;

import com.airhacks.learning.dao.service.BaseEntityDAOService;
import com.airhacks.learning.model.BaseEntity;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

/**
 * @author Kemal BEYAZ
 * @created 08/05/2020
 */
public abstract class BaseEntityController<T extends BaseEntity> {

    @Inject
    private BaseEntityDAOService<T> baseEntityDAOService;

    public BaseEntityDAOService<T> getBaseEntityDAOService() {
        return baseEntityDAOService;
    }

    protected void setBaseEntityDAOService(BaseEntityDAOService<T> baseEntityDAOService) {
        this.baseEntityDAOService = baseEntityDAOService;
    }

    @POST
    public T save(final T entity) {
        return this.baseEntityDAOService.save(entity);
    }

    @POST
    @Path("all")
    public void saveAll(final List<T> entities) {
        this.baseEntityDAOService.saveAll(entities);
    }

    @GET
    public List<T> getAllPerson() {
        return this.baseEntityDAOService.getAll();
    }

    @GET
    @Path("{id}")
    public T findById(@PathParam("id") final long id) {
        return this.baseEntityDAOService.findById(id);
    }

    @DELETE
    @Path("{id}")
    public void deleteById(@PathParam("id") final long id) {
        this.baseEntityDAOService.delete(id);
    }

}
