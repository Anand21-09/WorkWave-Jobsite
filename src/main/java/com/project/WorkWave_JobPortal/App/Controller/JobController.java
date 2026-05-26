package com.project.WorkWave_JobPortal.App.Controller;

import com.project.WorkWave_JobPortal.App.Model.Jobs;
import com.project.WorkWave_JobPortal.App.Service.JobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {
    public JobController(JobsService jobsService) {
        this.jobsService = jobsService;
    }

    @Autowired
    private JobsService jobsService;

    @PostMapping
    public ResponseEntity<Jobs> createJobs(@RequestBody Jobs jobs){
        Jobs createdJobs = jobsService.createJobs(jobs);
        return new ResponseEntity<>(createdJobs, HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Jobs> updateJobs(@RequestBody Jobs jobs){
        Jobs updatedJobs = jobsService.updateJobs(jobs);
        if(updatedJobs == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Jobs> updateJobs(@PathVariable Long id){
        boolean isDeleted = jobsService.deleteJob(id);
        if(!isDeleted){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Jobs> searchJob(@PathVariable Long id){
        Jobs jobSearch = jobsService.getById(id);
        if(jobSearch == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(jobSearch);
    }

    @GetMapping
    public List<Jobs> getJobs(){
        return jobsService.getAllJobs();
    }
    @GetMapping("/search")
    public ResponseEntity<List<Jobs>> searchJobs(@RequestParam String keyword){

        List<Jobs> jobs = jobsService.searchJobs(keyword);

        return ResponseEntity.ok(jobs);
    }
}
