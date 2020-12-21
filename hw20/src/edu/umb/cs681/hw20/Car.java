package edu.umb.cs681.hw20;

import java.util.List;

public class Car {
    private String make, model;
    private int mileage, year;
    private int price;
    private int dominationCount = 0;
    private String color;

    public Car(String make, String model, int mileage, int price, int year, String color) {
        this.make = make;
        this.model = model;
        this.mileage = mileage;
        this.price = price;
        this.year = year;
        this.color = color;
    }

    public String getMake() {
        return this.make;
    }

    public String getColor() {
        return this.color;
    }
    public int getMileage() {
        return this.mileage;
    }

    public String getModel() {
        return this.model;
    }

    public int getYear() {
        return this.year;
    }

    public int getPrice() {
        return this.price;
    }


    public void setDominationCount(List<Car> car) {
        for(Car c : car) {
            if(this.mileage >= c.mileage && this.price >= c.price && this.year <= c.year) {
                if(this.mileage > c.mileage || this.price > c.price || this.year < c.year) {
                    this.dominationCount++;
                }
            }
        }
    }


    public int getDominationCount() {
        return this.dominationCount;
    }

}
