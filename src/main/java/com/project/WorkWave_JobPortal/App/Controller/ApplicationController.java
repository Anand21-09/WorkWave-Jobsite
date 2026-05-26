package com.project.WorkWave_JobPortal.App.Controller;

import com.project.WorkWave_JobPortal.App.Model.Application;
import com.project.WorkWave_JobPortal.App.Model.Jobs;
import com.project.WorkWave_JobPortal.App.Service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {
    @Autowired
    private ApplicationService applicationService;

    @PostMapping
    public ResponseEntity<Application> createApplication(@RequestBody Application application){
        Application createdApplication = applicationService.createApplication(application);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdApplication);
    }

   @GetMapping
    public List<Application> getApplications(){
        return applicationService.getAllApplications();
   }

   @DeleteMapping("/{id}")
    public ResponseEntity<Application> deleteApplication(@PathVariable Long id){
        boolean deletedApplication = applicationService.deleteApplication(id);
        if(!deletedApplication){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
   }
    @PostMapping("/{jobId}/apply")
    public ResponseEntity<Application> applyToJob(@PathVariable Long jobId,
                                                  @RequestBody Application application){

        Application savedApplication =
                applicationService.applyToJob(jobId, application);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedApplication);
    }
}
