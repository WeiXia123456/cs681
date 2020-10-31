package edu.umb.cs681.hw4;

public class BasketballPlayer {
    private String name;
    private String team;
    private int age;
    private int salary;
    private int height;
    private double averageScore;
    private double averageAssit;
    private double averageRebound;

    public BasketballPlayer(String team, String name, int age, int salary, int height) {
        this.name = name;
        this.team = team;
        this.age = age;
        this.salary = salary;
        this.height = height;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public double getAverageAssit() {
        return averageAssit;
    }

    public void setAverageAssit(double averageAssit) {
        this.averageAssit = averageAssit;
    }

    public double getAverageRebound() {
        return averageRebound;
    }

    public void setAverageRebound(double averageRebound) {
        this.averageRebound = averageRebound;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


}
