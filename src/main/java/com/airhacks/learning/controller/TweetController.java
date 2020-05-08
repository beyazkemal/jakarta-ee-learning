package com.airhacks.learning.controller;

import com.airhacks.learning.dao.service.TweetDAOService;
import com.airhacks.learning.model.Tweet;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Kemal BEYAZ
 * @created 08/05/2020
 */
@Path("tweet")
@Produces("application/json;charset=UTF-8 ")
public class TweetController extends BaseEntityController<Tweet> {

    @Inject
    PersonController personController;

    @GET
    @Path("sample")
    public String saveSample() {
        List<Tweet> list = personController.getAllPerson()
                .stream()
                .limit(5)
                .map(person -> new Tweet("Message about something, like complaints about systems.", person))
                .collect(Collectors.toList());

        super.saveAll(list);
        return "Saved!";
    }

    @GET
    @Path("person/{id}")
    public List<Tweet> findByPersonId(@PathParam("id") final long id) {
        TweetDAOService daoService = (TweetDAOService) getBaseEntityDAOService();
        return daoService.findByPersonId(id);
    }
}
