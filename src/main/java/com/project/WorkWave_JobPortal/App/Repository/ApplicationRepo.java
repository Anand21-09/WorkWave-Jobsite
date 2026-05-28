package com.project.WorkWave_JobPortal.App.Repository;

import com.project.WorkWave_JobPortal.App.Model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepo extends JpaRepository<Application,Long> {



    //List<Application> findApplicationsByJobId(Long jobId);


   // Application findApplicationByid(Long jobId);
    @Query("SELECT a FROM Application a WHERE a.job.id = :jobId")
    List<Application> findApplicationsByJobId(@Param("jobId") Long jobId);

    @Query("SELECT COUNT(a) > 0 FROM Application a " +
            "WHERE a.candidateEmail = :email " +
            "AND a.job.id = :jobId")
    boolean existsApplication(
            @Param("email") String email,
            @Param("jobId") Long jobId
    );
}
