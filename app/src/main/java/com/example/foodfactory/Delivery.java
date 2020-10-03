package com.example.foodfactory;

public class Delivery {
    String name,Address,Location,ContactNo;

    public Delivery() {
    }

    public Delivery(String name, String address, String location, String contactNo) {
        this.name = name;
        Address = address;
        Location = location;
        ContactNo = contactNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getContactNo() {
        return ContactNo;
    }

    public void setContactNo(String contactNo) {
        ContactNo = contactNo;
    }
}
