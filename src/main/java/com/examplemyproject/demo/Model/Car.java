package com.examplemyproject.demo.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Car {

    @Id
    private String id;
    private String model;
    private String brand;
    private Double price;
    private String type;

    // Constructor to quickly add data
    public Car(String brand, String type, String model, double price) {
        this.brand = brand;
        this.type = type;
        this.price = price;
        this.model = model;
    }

    // Getters are CRITICAL for Thymeleaf to read the data
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}