package com.example.mealfactoryapp;

public class PaymentHelper {
    String name,Contact,amount,date;

    public PaymentHelper() {
    }

    public PaymentHelper(String name, String contact, String amount, String date) {
        this.name = name;
        Contact = contact;
        this.amount = amount;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}


