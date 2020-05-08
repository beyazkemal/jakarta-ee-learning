package com.airhacks.learning.controller;

import com.airhacks.learning.model.Person;

import javax.ws.rs.*;

/**
 * @author Kemal BEYAZ
 * @created 06/05/2020
 */
@Path("person")
@Produces("application/json;charset=UTF-8 ")
public class PersonController extends BaseEntityController<Person> {

}
