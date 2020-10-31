package edu.umb.cs681.hw3;

import java.util.LinkedList;
import java.util.List;

public class Client {

    public static void main(String[] args) {
        Car car1 = new Car("audi", "rs5", 30000,90000,2017);
        Car car2 = new Car("audi", "rs4", 20000,80000,2021);
        Car car3 = new Car("bwm", "m6", 10500,110000,2018);
        Car car4 = new Car("benz", "gtr", 20000,130000,2020);
        List<Car>  cars = new LinkedList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);


        // implement min() price with reduce
        Integer minimumPrice = cars.stream().map(car -> car.getPrice()).reduce(0, (result, price) ->{
            if (result == 0) {
                return price;
            }
            if (result > price) {
               return price;
            } else {
                return result;
            }
        });
        System.out.println("min price of the carlist is " + minimumPrice);

        // implement max() mileage with reduce

        Integer maxMileage = cars.stream().map(car -> car.getMileage()).reduce(0, (result, mileage) -> {
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

        Integer numberOfCarMaker = cars.stream().map(car -> car.getMake())
                .distinct().reduce(0, (result, carMaker) -> ++result, (finalResult,intermidiateResult) -> finalResult);
        System.out.println("number of disctinct car maker of carlist is " + numberOfCarMaker);
    }
}
