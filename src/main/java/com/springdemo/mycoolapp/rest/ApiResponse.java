package com.springdemo.mycoolapp.rest;

import org.springframework.http.HttpStatus;

public class ApiResponse {
    private String message;
    private HttpStatus status;

    public ApiResponse(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    // Getters and setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}

