package edu.umb.cs681.hw20;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        Car car1 = new Car("audi", "rs5", 30000,90000,2017, "red");
        Car car2 = new Car("audi", "rs4", 20000,80000,2021, "blue");
        Car car3 = new Car("bwm", "m6", 10500,110000,2018, "black");
        Car car4 = new Car("benz", "gtr", 20000,130000,2020, "pink");
        List<Car> cars = new ArrayList<>(); // cannot use linkedlist here
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);

        // implement min() price with reduce
        Integer minimumPrice = cars.stream().parallel().map(car -> car.getPrice()).reduce(0, (result, price) ->{
            if (result == 0) {
                return price;
            } else if (result > price) {
                return price;
            } else {
                return result;
            }
        });

        System.out.println("minimum price of carlist is " + minimumPrice);

        // implement max() mileage with reduce

        Integer maxMileage = cars.stream().parallel().map(car -> car.getMileage()).reduce(0, (result, mileage) -> {
            if (result == 0) {
                return mileage;
            }
            if (result < mileage) {
                return mileage;
            } else {
                return result;
            }
        });
        System.out.println("max milage of carlist is " + maxMileage);

        // implemnt count() with reduce

        Integer numberOfCarMaker = cars.stream().parallel().map(car -> car.getMake())
                .distinct().reduce(0, (result, carMaker) -> ++result, (finalResult,intermidiateResult) -> finalResult + intermidiateResult);
        System.out.println("number of disctinct car maker of carlist is " + numberOfCarMaker);



        Integer numberOfColortype = cars.stream().parallel().map(car -> car.getColor())
                .distinct().reduce(0, (result, carMaker) -> ++result, (finalResult,intermidiateResult) -> finalResult + intermidiateResult);
        System.out.println("number of disctinct car color in carlist is " + numberOfColortype);
    }
}


