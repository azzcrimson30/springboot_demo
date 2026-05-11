package com.examplemyproject.demo.Model;

public class Car {
    private String brand;
    private String type;
    private double price;

    // Constructor to quickly add data
    public Car(String brand, String type, double price) {
        this.brand = brand;
        this.type = type;
        this.price = price;
    }

    // Getters are CRITICAL for Thymeleaf to read the data
    public String getBrand() { return brand; }
    public String getType() { return type; }
    public double getPrice() { return price; }
}