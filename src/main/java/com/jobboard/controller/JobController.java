package com.jobboard.controller;

import com.jobboard.model.Job;
import com.jobboard.service.JobService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin(origins = "http://localhost:5173")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("/")
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }

    @PostMapping
    public Job createJob(@Valid @RequestBody Job job) {
        return jobService.createJob(job);
    }

    @DeleteMapping("/{id}")
    public String deleteJob(@PathVariable Long id) {
        return jobService.deleteJob(id);
    }

    @PutMapping("/{id}")
    public Job updateJob(@PathVariable Long id, @Valid @RequestBody Job jobData) {
        return jobService.updateJob(id, jobData);
    }

    @GetMapping("/search")
    public List<Job> searchJobs(@RequestParam String keyword) {
        return jobService.searchJobs(keyword);
    }
}
