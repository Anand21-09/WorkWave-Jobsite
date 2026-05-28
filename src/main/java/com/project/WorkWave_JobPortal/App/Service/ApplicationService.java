package com.project.WorkWave_JobPortal.App.Service;

import com.project.WorkWave_JobPortal.App.Exceptions.ApplicationNotFoundException;
import com.project.WorkWave_JobPortal.App.Exceptions.DuplicateApplicationException;
import com.project.WorkWave_JobPortal.App.Exceptions.JobNotFoundException;
import com.project.WorkWave_JobPortal.App.Model.Application;
import com.project.WorkWave_JobPortal.App.Model.Jobs;
import com.project.WorkWave_JobPortal.App.Repository.ApplicationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
public class ApplicationService {
    @Autowired
    private ApplicationRepo applicationRepo;
    @Autowired
    private JobsService jobsService;


    public ApplicationService(ApplicationRepo applicationRepo) {
        this.applicationRepo = applicationRepo;
    }

//    public Application createApplication(Application application) {
//        return applicationRepo.save(application);
//    }

    public List<Application> getAllApplications() {
        List<Application> applications = applicationRepo.findAll();
        if(applications.isEmpty()){
            throw new ApplicationNotFoundException("Application Not Found");
        }
        return applications;
    }

    public boolean deleteApplication(Long id) {
        if(!applicationRepo.existsById(id)){
            throw new ApplicationNotFoundException("Not found");
        }
        applicationRepo.deleteById(id);
        return true;
    }

    public Application applyToJob(Long jobId, Application application){

        Jobs job = jobsService.getById(jobId);
        if(job == null){
            throw new JobNotFoundException("No such Jobs");
        }
        boolean alreadyApplied =
                applicationRepo.existsApplication(
                        application.getCandidateEmail(),
                        jobId
                );

        if(alreadyApplied){
            throw new DuplicateApplicationException(
                    "Candidate already applied to this job"
            );
        }

        application.setJob(job);

        application.setAppliedDate(LocalDate.now());

        application.setStatus("APPLIED");

        return applicationRepo.save(application);
    }

    public List<Application> getAllApplicationsById(Long jobId) {

        Jobs job = jobsService.getById(jobId);

        List<Application> applications =
                applicationRepo.findApplicationsByJobId(jobId);

        if(applications.isEmpty()){
            throw new ApplicationNotFoundException(
                    "No applications to this job"
            );
        }

        return applications;
    }
}
