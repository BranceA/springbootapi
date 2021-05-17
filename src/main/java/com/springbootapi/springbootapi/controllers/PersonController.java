package com.springbootapi.springbootapi.controllers;

import com.springbootapi.springbootapi.models.Person;
import com.springbootapi.springbootapi.repositories.PersonRepository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    // curl -v http://localhost:8080/people
    @GetMapping("/people")
    public List<Person> viewAllPeopleList(){
        return personDao.findAll();
    };

    // curl -v http://localhost:8080/person/3
    @GetMapping("/person/{id}")
    public Person viewPersonById(@PathVariable Long id){
        return findPersonById(id);
    };

    // curl -X POST localhost:8080/people -H 'Content-type:application/json' -d '{"name": "Dan Doe", "dateJoined": "2020-01-01", "dateUpdated": "2021-05-15", "age": 20}'
    @PostMapping("/people")
    Person newPerson(@RequestBody Person newPerson) {
        return personDao.save(newPerson);
    };

    // curl -X PUT localhost:8080/person/3 -H 'Content-type:application/json' -d '{"name": "William Doe", "dateJoined": "1920-01-01", "dateUpdated": "2021-05-15", "age": 98}'
    @PutMapping("/person/{id}")
    Person replacePerson(@RequestBody Person replacePerson, @PathVariable Long id){
        Person person = findPersonById(id);
        person.setName(replacePerson.getName());
        person.setAge(replacePerson.getAge());
        person.setDateJoined(replacePerson.dateDateType());
        Date date = new Date();
        person.setDateUpdated(date);
        return personDao.save(person);
    }

    private Person findPersonById(Long id){
        List<Person> people = personDao.findAll();
        Person personById = null;
        for(Person person : people){
            if(person.getId() == id){
                personById = person;
            }
        }
        return personById;
    }
    
}
