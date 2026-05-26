package com.project.WorkWave_JobPortal.App.Exceptions;

public class ApplicationNotFoundException extends RuntimeException{
    public ApplicationNotFoundException(String message) {
        super(message);
    }
}
