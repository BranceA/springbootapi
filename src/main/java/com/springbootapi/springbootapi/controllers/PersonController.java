package com.springbootapi.springbootapi.controllers;

import com.springbootapi.springbootapi.models.Person;
import com.springbootapi.springbootapi.models.Job;
import com.springbootapi.springbootapi.repositories.JobRepository;
import com.springbootapi.springbootapi.repositories.PersonRepository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;

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
    private final JobRepository jobDao;


    public PersonController(PersonRepository personDao, JobRepository jobDao) {
        this.personDao = personDao;
        this.jobDao = jobDao;
    }

    // curl -v http://localhost:8080/person
    @GetMapping("/person")
    public List<Person> viewAllPeopleList(){
        return personDao.findAll();
    };

    // curl -v http://localhost:8080/person/3
    @GetMapping("/person/{id}")
    public Person viewPersonById(@PathVariable Long id){
        return personDao.findById(id).orElseThrow(() -> new EntityNotFoundException());
    };

    // curl -X POST localhost:8080/person/5 -H 'Content-type:application/json' -d '{"name": "Dan Doe", "dateJoined": "2020-01-01", "dateUpdated": "2021-05-15", "age": 20}'
    @PostMapping("/person/{id}")
    Person newPerson(@RequestBody Person newPerson, @PathVariable Long id) {
        Job job = jobDao.findById(id).orElseThrow(() -> new EntityNotFoundException());
        newPerson.setJob(job);
        return personDao.save(newPerson);
    };

    // curl -X POST localhost:8080/person -H 'Content-type:application/json' -d '{"name": "Helen Doe", "dateJoined": "2018-11-22", "dateUpdated": "2020-05-15", "age": 88}'
    @PostMapping("/person")
    Person newPerson(@RequestBody Person newPerson) {
        return personDao.save(newPerson);
    };

    // curl -X PUT localhost:8080/person/3 -H 'Content-type:application/json' -d '{"name": "William Doe", "dateJoined": "1920-01-01", "dateUpdated": "2021-05-15", "age": 98}'
    @PutMapping("/person/{id}")
    Person replacePerson(@RequestBody Person replacePerson, @PathVariable Long id){
        Person person = personDao.findById(id).orElseThrow(() -> new EntityNotFoundException());
        person.setName(replacePerson.getName());
        person.setAge(replacePerson.getAge());
        person.setDateJoined(replacePerson.dateDateType());
        Date date = new Date();
        person.setDateUpdated(date);
        return personDao.save(person);
    }

    // curl -X DELETE localhost:8080/person/5
    @DeleteMapping("/person/{id}")
        void deletePerson(@PathVariable Long id) {
        personDao.deleteById(id);
    }
}
