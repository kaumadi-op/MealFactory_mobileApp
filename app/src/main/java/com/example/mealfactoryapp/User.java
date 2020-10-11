package com.example.mealfactoryapp;

public class User {
    private String Name;
    private String Email;
    private String Message;

    public User() {
    }

    public void setName(String name) {
        Name = name;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return Email;
    }

    public String getMessage() {
        return Message;
    }
}

