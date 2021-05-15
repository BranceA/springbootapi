package com.springbootapi.springbootapi.controllers;

import com.springbootapi.springbootapi.models.Person;
import com.springbootapi.springbootapi.repositories.PersonRepository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    private final PersonRepository personDao;


    public PersonController(PersonRepository personDao) {
        this.personDao = personDao;
    }

    @GetMapping("/people")
    public List<Person> viewAllPeopleList(){
        return personDao.findAll();
    };

    @GetMapping("/person/{id}")
    public Person viewPersonById(@PathVariable Long id){
        List<Person> people = personDao.findAll();
        Person personById = null;
        for(Person person : people){
            if(person.getId() == id){
                personById = person;
            }
        }
        return personById;
    };

    @PostMapping("/people")
    Person newPerson(@RequestBody Person newPerson) {
        return personDao.save(newPerson);
    }
    
}
