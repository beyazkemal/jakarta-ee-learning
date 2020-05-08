package com.airhacks.learning.controller;

import com.airhacks.learning.model.Person;

import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Kemal BEYAZ
 * @created 06/05/2020
 */
@Path("person")
@Produces("application/json;charset=UTF-8 ")
public class PersonController extends BaseEntityController<Person> {


    @GET
    @Path("sample")
    public String saveSample() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Bekir"));
        list.add(new Person("Ömer"));

        super.saveAll(list);
        return "Saved!";
    }

}
