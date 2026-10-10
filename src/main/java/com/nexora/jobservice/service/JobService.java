
package com.nexora.jobservice.service;

import com.nexora.jobservice.entity.Job;
import com.nexora.jobservice.exception.ResourceNotFoundException;
import com.nexora.jobservice.repository.JobRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class JobService {

    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public Job create(Job job) {
        job.setId(null);
        return jobRepository.save(job);
    }

    @Transactional(readOnly = true)
    public List<Job> getAll() {
        return jobRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Job getById(Long id) {
        return jobRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Job not found with ID: " + id));
    }

    public Job update(Long id, Job updatedJob) {
        Job existingJob = getById(id);

        existingJob.setTitle(updatedJob.getTitle());
        existingJob.setCompany(updatedJob.getCompany());
        existingJob.setLocation(updatedJob.getLocation());
        existingJob.setSalary(updatedJob.getSalary());
        existingJob.setDescription(updatedJob.getDescription());

        return jobRepository.save(existingJob);
    }

    public void delete(Long id) {
        Job existingJob = getById(id);
        jobRepository.delete(existingJob);
    }
}