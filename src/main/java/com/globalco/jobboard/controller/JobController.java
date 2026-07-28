package com.globalco.jobboard.controller;

import com.globalco.jobboard.entity.Job;
import com.globalco.jobboard.service.JobService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {
        "http://127.0.0.1:5500",
        "http://localhost:5500",
        "https://jobboard-frontend-ws9p-cmdbq0wjd-lavanya18.vercel.app"
})
@RequestMapping("/jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }


    // Get all jobs
    @GetMapping
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }


    // Get job by id
    @GetMapping("/{id}")
    public Job getJobById(@PathVariable Long id) {
        return jobService.getJobById(id);
    }


    // Add new job
    @PostMapping
    public Job addJob(@RequestBody Job job) {
        return jobService.saveJob(job);
    }


    // Update existing job
    @PutMapping("/{id}")
    public Job updateJob(
            @PathVariable Long id,
            @RequestBody Job job
    ) {
        return jobService.updateJob(id, job);
    }


    // Delete job
    @DeleteMapping("/{id}")
    public String deleteJob(@PathVariable Long id) {

        jobService.deleteJob(id);

        return "Job deleted successfully";
    }
}