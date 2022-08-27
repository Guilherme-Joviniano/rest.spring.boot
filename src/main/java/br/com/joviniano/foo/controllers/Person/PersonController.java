package br.com.joviniano.foo.controllers.Person;

import br.com.joviniano.foo.models.Person;
import br.com.joviniano.foo.services.Person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/person/")

public class PersonController {
    @Autowired
    private PersonService services;

    // List
    @RequestMapping(method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll()   {
        return services.findAll();
    }

    // Show
    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(@PathVariable("id") String id)   {
        return services.findById(id);
    }

    //Create
    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person create(@RequestBody Person person)   {
        return services.create(person);
    }

    //Update
    @RequestMapping(
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person update(@RequestBody Person person)   {
        return services.update(person);
    }

    //Delete
    @RequestMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            method =  RequestMethod.DELETE)
    public Person delete(@PathVariable("id") String id) {
        return services.delete(id);
    }


}
