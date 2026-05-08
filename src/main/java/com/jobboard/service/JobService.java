package com.jobboard.service;

import com.jobboard.model.Job;
import com.jobboard.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    public Job updateJob(Long id, Job jobData) {
        Optional<Job> existingJob = jobRepository.findById(id);
        if (existingJob.isPresent()) {
            Job job = existingJob.get();
            job.setTitle(jobData.getTitle());
            job.setCompany(jobData.getCompany());
            job.setLocation(jobData.getLocation());
            job.setDescription(jobData.getDescription());
            return jobRepository.save(job);
        }
        return null;
    }

    public String deleteJob(Long id) {
        jobRepository.deleteById(id);
        return "Job deleted successfully";
    }

    public List<Job> searchJobs(String keyword) {
        return jobRepository.findByTitleContainingIgnoreCaseOrCompanyContainingIgnoreCaseOrLocationContainingIgnoreCase(keyword, keyword, keyword);
    }
}
