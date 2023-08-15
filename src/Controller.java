import java.io.*;
import java.util.ArrayList;

public class Controller {
    public static void main(String[] args) {


        System.out.println();
        System.out.println();
        System.out.println("=========================================");
        System.out.println("Data.txt output");
        System.out.println("=========================================");
        try {
            String fileLocation = "./Data/data.txt";

            BufferedReader br = new BufferedReader(new FileReader("./data/data.txt"));
            String line;
            String strCurrentLine;
            while ((strCurrentLine = br.readLine()) != null) {
                System.out.println(strCurrentLine);
            }//end while
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Car> cars = new ArrayList<>();
        ArrayList<Human> humans = new ArrayList<>();
        ArrayList<Wolf> wolves = new ArrayList<>();
        ArrayList<Kennel> kennels = new ArrayList<>();

        try {
            // for mac os
            BufferedReader br = new BufferedReader(new FileReader("./data/data.txt"));
            String line;
            String strCurrentLine;
            while ((strCurrentLine = br.readLine()) != null) {
                String[] token = strCurrentLine.split(",");
                if (token[0].equals("Car")) {
                    Car car = new Car(token[1], token[2], token[3]);
                    cars.add(car);
                } else if (token[0].equals("Human")) {
                    Human human = new Human(token[1]);
                    humans.add(human);
                    if(token[0].equals("Human") && (token.length == 7)) {
                        Car car = new Car(token[4], token[5], token[6]);
                        human = new Human(car, token[1]);
                        cars.add(car);
                        humans.add(human);
                    }
                } else if (token[0].equals("Wolf")) {
                    Wolf wolf = new Wolf(token[1], token[2]);
                    wolves.add(wolf);

                } else if (token[0].equals("Kennel")) {
                    ArrayList<Wolf> kennelWolves = new ArrayList<>();
                    if (token.length > 3) {
                        for (int i = 4; i < token.length; i += 3) {
                            Wolf wolf = new Wolf(token[i + 1], token[i + 2]);
                            kennelWolves.add(wolf);
                            wolves.add(wolf);
                        }
                        Kennel kennel = new Kennel(kennelWolves, token[1], token[2]);
                        kennels.add(kennel);
                    } else {
                        Kennel kennel = new Kennel(kennelWolves, token[1], token[2]);
                        kennels.add(kennel);
                    }

                }
            } // while
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("=========================================");
        System.out.println("Car List");
        System.out.println("=========================================");

        for (Car car : cars) {
            car.displayInfo();
        }

        System.out.println();
        System.out.println("=========================================");
        System.out.println("Human List");
        System.out.println("=========================================");

        for (Human human : humans) {
            human.displayInfo();
        }

        System.out.println();
        System.out.println("=========================================");
        System.out.println("Wolf List");
        System.out.println("=========================================");

        for (Wolf wolf : wolves) {
            wolf.displayInfo();
        }

        System.out.println();
        System.out.println("=========================================");
        System.out.println("Kennel List");
        System.out.println("=========================================");

        for (Kennel kennel : kennels) {
            kennel.displayInfo();
        }

        System.out.println();
        System.out.println("=========================================");
        System.out.println("Youngest Human without Car");
        System.out.println("=========================================");
        findYoungestHumanWithoutCar(humans);

        System.out.println();
        System.out.println("=========================================");
        System.out.println("Oldest Human with Car");
        System.out.println("=========================================");
        findOldestHumanWithCar(humans).displayInfo();

        System.out.println();
        System.out.println("=========================================");
        System.out.println("Kennel With The Most Wolf Weight");
        System.out.println("=========================================");
        kennelWithMostWolfWeight(kennels).displayInfo();
        mostExpensiveCar(cars);
        System.out.println("=========================================");
        System.out.printf("Total weight of all the wolves in kennels: %.2f",getTotalWeight(kennels));



//-----------------------------------------
    }//end main



    public static Human findYoungestHumanWithoutCar(ArrayList<Human> humans) {
        Human youngestHumanWithoutCar = null;
        for(Human human: humans){
            if(human.getCar() == null){
                if(youngestHumanWithoutCar == null){
                   youngestHumanWithoutCar = human;
                }else if(youngestHumanWithoutCar.getAge() > human.getAge()){
                    youngestHumanWithoutCar = human;
                    youngestHumanWithoutCar.displayInfo();
                }
            }
        }
        return youngestHumanWithoutCar;
    }
    public static Human findOldestHumanWithCar(ArrayList<Human> humans){
        Human oldestHumanWithCar = null;
        for(Human human: humans){
            if(human.getCar() != null){
                if(oldestHumanWithCar == null){
                    oldestHumanWithCar = human;
                }else if(oldestHumanWithCar.getAge() < human.getAge()){
                   oldestHumanWithCar = human;
                }
            }
        }
        return  oldestHumanWithCar;
    }

    public static void mostExpensiveCar(ArrayList<Car> cars){
        Car mostExpensiveCar =  null;
        for(Car c: cars){
            if(mostExpensiveCar == null){
                mostExpensiveCar = c;
            }else if(mostExpensiveCar.getPrice() < c.getPrice()){
                mostExpensiveCar = c;
            }
        }
        System.out.println(mostExpensiveCar.getPrice());
    }

    public static double getTotalWeight(ArrayList<Kennel> kennels){
        double totalWeight = 0;
        for(Kennel k: kennels){
            for(Wolf w: k.getWolves()){
                if(k.getWolves() != null){
                    totalWeight += w.getWeight();
                }
            }
        }
        return totalWeight;
    }
    public static Kennel kennelWithMostWolfWeight(ArrayList<Kennel> kennels){
        Kennel heaviestKennel = null;
        double heaviestWeight = 0;
        for (Kennel kennel : kennels) {
            double totalWeight = 0;
            for (Wolf wolf : kennel.getWolves()) {
                totalWeight += wolf.getWeight();
            }
            if (heaviestKennel == null || totalWeight > heaviestWeight) {
                heaviestKennel = kennel;
                heaviestWeight = totalWeight;
            }
        }
        return heaviestKennel;
    }

}


