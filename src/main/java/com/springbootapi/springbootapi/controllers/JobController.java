package com.springbootapi.springbootapi.controllers;

import com.springbootapi.springbootapi.models.Job;
import com.springbootapi.springbootapi.repositories.JobRepository;

import org.springframework.web.bind.annotation.*;

@RestController
public class JobController {
    private final JobRepository jobDao;


    public JobController(JobRepository jobDao) {
        this.jobDao = jobDao;
    }


    // curl -X POST localhost:8080/jobs -H 'Content-type:application/json' -d '{"jobTitle":"Code Tester","salary":3500}'
    @PostMapping("/jobs")
    Job newJob(@RequestBody Job newJob){
        return jobDao.save(newJob);
    }
}
