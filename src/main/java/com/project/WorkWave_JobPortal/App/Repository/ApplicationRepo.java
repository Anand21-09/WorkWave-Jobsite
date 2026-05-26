package com.project.WorkWave_JobPortal.App.Repository;

import com.project.WorkWave_JobPortal.App.Model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepo extends JpaRepository<Application,Long> {

}
