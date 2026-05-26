package com.project.WorkWave_JobPortal.App.Service;

import com.project.WorkWave_JobPortal.App.Exceptions.UserNotFoundException;
import com.project.WorkWave_JobPortal.App.Model.Jobs;
import com.project.WorkWave_JobPortal.App.Repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobsService {

    @Autowired
    private JobRepo jobRepo;

    public JobsService(JobRepo jobRepo) {
        this.jobRepo = jobRepo;
    }

    public  Jobs createJobs(Jobs jobs) {
        return jobRepo.save(jobs);
    }

    public Jobs updateJobs(Jobs jobs){

        Optional<Jobs> existingJob = jobRepo.findById(jobs.getId());

        if(existingJob.isPresent()){

            Jobs updatedJob = existingJob.get();

            if(jobs.getRole() != null){
                updatedJob.setRole(jobs.getRole());
            }

            if(jobs.getCompany() != null){
                updatedJob.setCompany(jobs.getCompany());
            }

            if(jobs.getLocation() != null){
                updatedJob.setLocation(jobs.getLocation());
            }

            if(jobs.getJobType() != null){
                updatedJob.setJobType(jobs.getJobType());
            }

            if(jobs.getExperienceRequired() != null){
                updatedJob.setExperienceRequired(jobs.getExperienceRequired());
            }

            if(jobs.getSkillsRequired() != null){
                updatedJob.setSkillsRequired(jobs.getSkillsRequired());
            }

            if(jobs.getStatus() != null){
                updatedJob.setStatus(jobs.getStatus());
            }

            return jobRepo.save(updatedJob);
        }

        return null;
    }
    public List<Jobs> getAllJobs() {
        List<Jobs> jobss = jobRepo.findAll();
        if(jobss.isEmpty()){
            throw new NullPointerException("No jobs found");
        }
        return jobss;
    }

    public boolean deleteJob(Long id) {
        if(!jobRepo.existsById(id)){
            throw new UserNotFoundException("user with ID " + id + " does not exist");
        }
        jobRepo.deleteById(id);
        return true;
    }

    public Jobs getById(Long id) {
        return jobRepo.findById(id).orElseThrow(()->new UserNotFoundException("user not found"));

    }

    public List<Jobs> searchJobs(String keyword) {
        return jobRepo.searchJobs(keyword);
    }
}
