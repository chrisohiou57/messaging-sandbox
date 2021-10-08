package com.chrias.springbootcamel.service;

import com.chrias.springbootcamel.model.Person;

import org.springframework.stereotype.Service;

@Service
public class PersonService {

    public Person getPeople() {
        return new Person("person", "John", "Doe");
    }
    
}
