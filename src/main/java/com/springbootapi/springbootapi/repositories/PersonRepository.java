package com.springbootapi.springbootapi.repositories;

import com.springbootapi.springbootapi.models.Person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    
}
