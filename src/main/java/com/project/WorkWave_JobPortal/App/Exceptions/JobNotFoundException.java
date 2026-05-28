package com.project.WorkWave_JobPortal.App.Exceptions;

public class JobNotFoundException extends RuntimeException{
    public JobNotFoundException(String message) {
        super(message);
    }
}
