package com.nexora.jobservice.controller;

import com.nexora.jobservice.entity.Job;
import com.nexora.jobservice.service.JobService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    // CREATE - POST
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Job createJob(@RequestBody Job job) {
        return jobService.create(job);
    }

    // READ ALL - GET
    @GetMapping
    public List<Job> getAllJobs() {
        return jobService.getAll();
    }

    // READ BY ID - GET
    @GetMapping("/{id}")
    public Job getJobById(@PathVariable Long id) {
        return jobService.getById(id);
    }

    // UPDATE - PUT
    @PutMapping("/{id}")
    public Job updateJob(
            @PathVariable Long id,
            @RequestBody Job job) {
        return jobService.update(id, job);
    }

    // DELETE - DELETE
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteJob(@PathVariable Long id) {
        jobService.delete(id);
    }
}