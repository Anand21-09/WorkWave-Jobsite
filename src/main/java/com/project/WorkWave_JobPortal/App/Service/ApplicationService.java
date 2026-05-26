package com.project.WorkWave_JobPortal.App.Service;

import com.project.WorkWave_JobPortal.App.Exceptions.ApplicationNotFoundException;
import com.project.WorkWave_JobPortal.App.Model.Application;
import com.project.WorkWave_JobPortal.App.Repository.ApplicationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {
    @Autowired
    private ApplicationRepo applicationRepo;

    public ApplicationService(ApplicationRepo applicationRepo) {
        this.applicationRepo = applicationRepo;
    }

    public Application createApplication(Application application) {
        return applicationRepo.save(application);
    }

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
}
