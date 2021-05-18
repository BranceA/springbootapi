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

    // Returns array of all jobs
    // curl -v http://localhost:8080/job
    @GetMapping("/job")
    public List<Job> viewAllJobsList(){
        return jobDao.findAll();
    };

    // Include job id in URL to get a single job.
    // curl -v http://localhost:8080/job/3
    @GetMapping("/job/{id}")
    public Job viewJobById(@PathVariable Long id){
        return jobDao.findById(id).orElseThrow(() -> new EntityNotFoundException());
    };

    // For creating a new job
    // curl -X POST localhost:8080/job -H 'Content-type:application/json' -d '{"jobTitle":"Code Tester","salary":3500}'
    @PostMapping("/job")
    Job newJob(@RequestBody Job newJob){
        return jobDao.save(newJob);
    }

    // Include job id of the job you want to edit in the URL 
    // curl -X PUT localhost:8080/job/3 -H 'Content-type:application/json' -d '{"jobTitle":"Batman", "salary":1000000}'
    @PutMapping("/job/{id}")
    Job replaceJob(@RequestBody Job replaceJob, @PathVariable Long id){
        Job job = jobDao.findById(id).orElseThrow(() -> new EntityNotFoundException());
        job.setJobTitle(replaceJob.getJobTitle());
        job.setSalary(replaceJob.getSalary());
        return jobDao.save(job);
    }

    // Include job id in the URL of the job you want to delete
    // curl -X DELETE localhost:8080/job/5
    @DeleteMapping("/job/{id}")
    void deleteJob(@PathVariable Long id) {
        jobDao.deleteById(id);
    }
}
