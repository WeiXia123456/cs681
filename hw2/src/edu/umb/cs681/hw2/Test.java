package edu.umb.cs681.hw2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        Car car1 = new Car("Audi","rs7",30000,40000,2010);
        Car car2 = new Car("Bmw","m8",20000,15000,2012);
        Car car3 = new Car("Benz","gt63",10000,10000,2013);
        Car car4 = new Car("Porsche","panamera",9000,95000,2018);
        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carList.add(car4);
        System.out.println("sort by car mileage ");
        List<Car> sortedCarList1 = carList.stream().sorted((Car c1, Car c2) -> c1.getMileage() - c2.getMileage())
                                    .collect(Collectors.toList());
        sortedCarList1.forEach(car -> System.out.println("Make: " + car.getMake() + ", mileage: " + car.getMileage()));
        System.out.println("sort by car price: ");
        List<Car> sortedCarList2 = carList.stream().sorted((Car c1, Car c2) -> c1.getPrice() - c2.getPrice())
                .collect(Collectors.toList());
        sortedCarList2.forEach(car -> System.out.println("Make: " + car.getMake() + ", price: " + car.getPrice()));
        System.out.println("sort by car year");
        List<Car> sortedCarList3 = carList.stream().sorted((Car c1, Car c2) -> c2.getYear() - c1.getYear())
                .collect(Collectors.toList());
        sortedCarList3.forEach(car -> System.out.println("Make: " + car.getMake()+ ", year: " + car.getYear()));
        System.out.println("sort by car dominationCount ");
        carList.forEach(car -> car.setDominationCount(carList));
        List<Car> sortedCarList4 = carList.stream().sorted((Car c1, Car c2) -> c1.getDominationCount() - c2.getDominationCount())
                .collect(Collectors.toList());
        sortedCarList4.forEach(car -> System.out.println("Make: " + car.getMake()+ ", dominationCount: " + car.getDominationCount()));

    }
}
