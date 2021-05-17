package com.springbootapi.springbootapi.controllers;

import javax.persistence.EntityNotFoundException;

import java.util.List;

import com.springbootapi.springbootapi.models.Job;
import com.springbootapi.springbootapi.repositories.JobRepository;

import org.springframework.web.bind.annotation.*;

@RestController
public class JobController {
    private final JobRepository jobDao;


    public JobController(JobRepository jobDao) {
        this.jobDao = jobDao;
    }

    // curl -v http://localhost:8080/job
    @GetMapping("/job")
    public List<Job> viewAllJobsList(){
        return jobDao.findAll();
    };

    // curl -v http://localhost:8080/job/3
    @GetMapping("/job/{id}")
    public Job viewJobById(@PathVariable Long id){
        return jobDao.findById(id).orElseThrow(() -> new EntityNotFoundException());
    };


    // curl -X POST localhost:8080/jobs -H 'Content-type:application/json' -d '{"jobTitle":"Code Tester","salary":3500}'
    @PostMapping("/jobs")
    Job newJob(@RequestBody Job newJob){
        return jobDao.save(newJob);
    }
}
