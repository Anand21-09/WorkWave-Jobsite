package com.project.WorkWave_JobPortal.App.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="Application")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String candidateName;
    private String candidateEmail;
    private String resumeLink;
    private String status;
    private LocalDate appliedDate;
    @ManyToOne
    private Jobs job;

    public Application(Jobs job) {
        this.job = job;
    }

    public Jobs getJob() {
        return job;
    }

    public void setJob(Jobs job) {
        this.job = job;
    }

    public Application() {
    }

    public Application(String candidateName, String candidateEmail, String resumeLink, String status, LocalDate appliedDate) {
        this.candidateName = candidateName;
        this.candidateEmail = candidateEmail;
        this.resumeLink = resumeLink;
        this.status = status;
        this.appliedDate = appliedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getCandidateEmail() {
        return candidateEmail;
    }

    public void setCandidateEmail(String candidateEmail) {
        this.candidateEmail = candidateEmail;
    }

    public String getResumeLink() {
        return resumeLink;
    }

    public void setResumeLink(String resumeLink) {
        this.resumeLink = resumeLink;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(LocalDate appliedDate) {
        this.appliedDate = appliedDate;
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", candidateName='" + candidateName + '\'' +
                ", candidateEmail='" + candidateEmail + '\'' +
                ", resumeLink='" + resumeLink + '\'' +
                ", status='" + status + '\'' +
                ", appliedDate=" + appliedDate +
                ", job=" + job +
                '}';
    }
}
