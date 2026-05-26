package com.project.WorkWave_JobPortal.App.Repository;

import com.project.WorkWave_JobPortal.App.Model.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<Jobs,Long> {

    @Query("SELECT j FROM Jobs j WHERE " +
            "LOWER(j.company) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(j.role) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(j.skillsRequired) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Jobs> searchJobs(@Param("keyword") String keyword);
}
