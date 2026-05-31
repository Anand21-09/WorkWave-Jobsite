package com.project.WorkWave_JobPortal.App.Service;

import com.project.WorkWave_JobPortal.App.Controller.UserController;
import com.project.WorkWave_JobPortal.App.Exceptions.UserNotFoundException;
import com.project.WorkWave_JobPortal.App.Model.User;
import com.project.WorkWave_JobPortal.App.Repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepo userRepo;
    private User user;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User createUser(User user) {
        return userRepo.save(user);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User updateUser(Long id, User updatedUser) {

        User existingUser = userRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPhoneNumber(updatedUser.getPhoneNumber());
        existingUser.setPassword(updatedUser.getPassword());

        return userRepo.save(existingUser);
    }
}
