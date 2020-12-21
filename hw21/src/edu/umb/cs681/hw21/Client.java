package edu.umb.cs681.hw21;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Client {
    public static void main(String[] args) {
        BasketballPlayer b1 = new BasketballPlayer("Lakers", "Lebron", 36, 37, 206);
        BasketballPlayer b2 = new BasketballPlayer("Nets", "Durant", 32, 40, 211);
        BasketballPlayer b3 = new BasketballPlayer("Warriors", "Curry", 32, 41, 190);
        BasketballPlayer b4 = new BasketballPlayer("Celtics", "Jason", 23, 20, 205);
        List<BasketballPlayer> playerList = new ArrayList<>();
        playerList.add(b1);
        playerList.add(b2);
        playerList.add(b3);
        playerList.add(b4);

       List<BasketballPlayer> l1 =  playerList.stream().parallel().sorted((p1, p2) -> p1.getAge() - p2.getAge()).collect(Collectors.toList());
       System.out.println("sort by age");
       l1.forEach(p -> System.out.println("Name:" + p.getName() + ", age:" + p.getAge()));

        List<BasketballPlayer> l2 =  playerList.stream().parallel().sorted((p1, p2) -> p1.getSalary() - p2.getSalary()).collect(Collectors.toList());
        System.out.println("sort by salary");
        l2.forEach(p -> System.out.println("Name:" + p.getName() + ", salary:$" + p.getSalary() + "M"));

        Integer minimumHeight = playerList.stream().parallel().map(p -> p.getHeight()).reduce(0, (result, height) ->{
            if (result == 0) {
                return height;
            }
            if (result > height) {
                return height;
            } else{
                return result;
            }
        });
        System.out.println("mini height of those players is  " + minimumHeight + "cm");
        Integer maxSalary = playerList.stream().parallel().map(p -> p.getSalary()).reduce(0, (result, salary) ->{
            if (result == 0) {
                return salary;
            }
            if (result < salary) {
                return salary;
            } else{
                return result;
            }
        });
        System.out.println("Max salary of those players is $ " + maxSalary + "M");

        long num = playerList.stream().parallel().map(p -> p.getTeam()).distinct().
                reduce(0,(result, team) -> ++result,
                (finalResult, intermediateResult) -> finalResult + intermediateResult);
        System.out.print("number of team in the list is " + num);
    }
}
