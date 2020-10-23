package com.company;


import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.List;


public class Main {

    public static int[] parseLineOfNumbers(String line) {
        String[] numberString = line.split(" ");
        int[] numbers = new int[numberString.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(numberString[i]);
        }
        return numbers;
    }

    private static List<Integer> getIntegersInList(String line) {
        List<Integer> numbers = new ArrayList<>();
        String[] strings = line.split(" ");
        for (String numberString : strings) {
            numbers.add(Integer.parseInt(numberString));
        }
        return numbers;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {

            List<Vehicle> vehicles = new ArrayList<>();
            String input = bfr.readLine();
            while (!"End".equals(input)) {
                String[] vehicleData = input.split(" ");
                if (!vehicleData[0].equals("car") && !vehicleData[0].equals("truck")) {
                    return;
                }
                Vehicle vehicle = new Vehicle(vehicleData[0], vehicleData[1], vehicleData[2], Integer.parseInt(vehicleData[3]));
                vehicles.add(vehicle);
                input = bfr.readLine();
            }

            String model = bfr.readLine();
            while (!"Close the Catalogue".equals(model)) {
                for (int i = 0; i < vehicles.size(); i++) {
                    if (vehicles.get(i).getModel().equals(model)) {
                        if (vehicles.get(i).getType().equals("car")) {
                            System.out.printf("Type: Car%nModel: %s%nColor: %s%nHorsepower: %d%n",
                                    vehicles.get(i).getModel(), vehicles.get(i).getColor(), vehicles.get(i).getHorsepower());
                        } else {
                            System.out.printf("Type: Truck%nModel: %s%nColor: %s%nHorsepower: %d%n",
                                    vehicles.get(i).getModel(), vehicles.get(i).getColor(), vehicles.get(i).getHorsepower());
                        }

                    }
                }
                model = bfr.readLine();
            }

            double totalHorsePowerCars = 0;
            double countCars = 0;
            double totalHorsePowerTrucks = 0;
            double countTrucks = 0;

            for (Vehicle vehicle : vehicles) {
                if (vehicle.getType().equals("car")) {
                    totalHorsePowerCars += vehicle.getHorsepower();
                    countCars++;
                } else {
                    totalHorsePowerTrucks += vehicle.getHorsepower();
                    countTrucks++;
                }
            }

            if (countCars == 0) {
                System.out.printf("Cars have average horsepower of: 0.00.%n");
            } else {
                System.out.printf("Cars have average horsepower of: %.2f.%n", totalHorsePowerCars / countCars);
            }

            if (countTrucks == 0) {
                System.out.printf("Trucks have average horsepower of: 0.00.%n");
            } else {
                System.out.printf("Trucks have average horsepower of: %.2f.%n",totalHorsePowerTrucks / countTrucks);
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Vehicle {
        private String type;
        private String model;
        private String color;
        private int horsepower;

        public Vehicle(String type, String model, String color, int horsepower) {
            this.type = type;
            this.model = model;
            this.color = color;
            this.horsepower = horsepower;
        }

        public String getType() {
            return type;
        }

        public String getModel() {
            return model;
        }

        public String getColor() {
            return color;
        }

        public int getHorsepower() {
            return horsepower;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public void setHorsepower(int horsepower) {
            this.horsepower = horsepower;
        }
    }

    static class Student {
        private String firstName;
        private String lastName;
        private double grade;

        public Student(String firstName, String lastName, double grade) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.grade = grade;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public double getGrade() {
            return grade;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setGrade(double grade) {
            this.grade = grade;
        }
    }

    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    static class Article {
        private String title;
        private String content;
        private String author;

        public Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }

        public String getAuthor() {
            return author;
        }

        @Override
        public String toString() {
            return String.format("%s - %s: %s", this.getTitle(), this.getContent(), this.getAuthor());
        }
    }
}