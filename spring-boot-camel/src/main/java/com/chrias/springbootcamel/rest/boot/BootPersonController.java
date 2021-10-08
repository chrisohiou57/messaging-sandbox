package com.chrias.springbootcamel.rest.boot;

import com.chrias.springbootcamel.model.Person;
import com.chrias.springbootcamel.service.PersonService;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/person1")
// @Api(value = "person", description = "The Boot version of the Person REST API")
public class BootPersonController {

    private PersonService personService;

    public BootPersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Person getPerson() {
        return personService.getPeople();
    }
    
}
