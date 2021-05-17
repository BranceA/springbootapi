package com.springbootapi.springbootapi.repositories;

import com.springbootapi.springbootapi.models.Job;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    
}
