package com.airhacks.learning.controller;

import com.airhacks.learning.dao.service.TweetDAOService;
import com.airhacks.learning.model.Tweet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * @author Kemal BEYAZ
 * @created 08/05/2020
 */
@Path("tweet")
@Produces("application/json;charset=UTF-8 ")
public class TweetController extends BaseEntityController<Tweet> {

    @GET
    @Path("person/{id}")
    public List<Tweet> findByPersonId(@PathParam("id") final long id) {
        TweetDAOService daoService = (TweetDAOService) getBaseEntityDAOService();
        return daoService.findByPersonId(id);
    }
}
