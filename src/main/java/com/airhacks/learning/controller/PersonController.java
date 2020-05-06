package com.airhacks.learning.controller;

import com.airhacks.learning.PersonService;
import com.airhacks.learning.model.Person;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Kemal BEYAZ
 * @created 06/05/2020
 */
@Path("person")
@Produces("application/json;charset=UTF-8 ")
public class PersonController {

    @Inject
    PersonService personService;

    @GET
    @Path("sample")
    public String saveSample() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Bekir"));
        list.add(new Person("Ömer"));

        this.personService.saveAll(list);
        return "Saved!";
    }

    @GET
    @Path("{id}")
    public Person findById(@PathParam("id") long id) {
        return this.personService.findById(id);
    }

    @GET
    public List<Person> getAllPerson() {
        return this.personService.getAll();
    }

    @POST
    public void save(Person person) {
        this.personService.save(person);
    }
}
