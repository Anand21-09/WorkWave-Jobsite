package com.project.WorkWave_JobPortal.App.Model;
import jakarta.persistence.*;

@Entity
@Table(name = "jobs")
public class Jobs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String role;
    private String company;
    private String location;
    private String jobType;
    private String experienceRequired;
    private String skillsRequired;
    private String status;

    public Jobs() {
    }

    public Jobs( String role, String company, String location, String jobType, String experienceRequired, String skillsRequired, String status) {
        //this.id = id;
        this.role = role;
        this.company = company;
        this.location = location;
        this.jobType = jobType;
        this.experienceRequired = experienceRequired;
        this.skillsRequired = skillsRequired;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getExperienceRequired() {
        return experienceRequired;
    }

    public void setExperienceRequired(String experienceRequired) {
        this.experienceRequired = experienceRequired;
    }

    public String getSkillsRequired() {
        return skillsRequired;
    }

    public void setSkillsRequired(String skillsRequired) {
        this.skillsRequired = skillsRequired;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Jobs{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", company='" + company + '\'' +
                ", location='" + location + '\'' +
                ", jobType='" + jobType + '\'' +
                ", experienceRequired='" + experienceRequired + '\'' +
                ", skillsRequired='" + skillsRequired + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
