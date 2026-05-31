package com.project.WorkWave_JobPortal.App.Repository;

import com.project.WorkWave_JobPortal.App.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
}
