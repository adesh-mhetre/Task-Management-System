package com.taskmanagement.service;

public class LoginResponce {
    String message;
    Boolean status;
    Long userId;
    
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }
    public LoginResponce(String message, Boolean status,Long userId) {
        this.message = message;
        this.status = status;
        this.userId=userId;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
