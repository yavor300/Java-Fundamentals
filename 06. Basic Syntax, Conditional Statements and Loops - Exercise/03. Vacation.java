package com.company;


import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.List;


public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            int numberOfPeople = Integer.parseInt(bfr.readLine());
            String type = bfr.readLine();
            String day = bfr.readLine();
            double totalPrice = 0;

            if (day.equals("Friday")) {
                switch (type) {
                    case "Students":
                        totalPrice = numberOfPeople * 8.45;
                        break;
                    case "Business":
                        totalPrice = numberOfPeople * 10.90;
                        if (numberOfPeople >= 100) {
                            totalPrice -= 10 * 10.90;
                        }
                        break;
                    case "Regular":
                        totalPrice = numberOfPeople * 15;
                        break;
                }
            } else if (day.equals("Saturday")) {
                switch (type) {
                    case "Students":
                        totalPrice = numberOfPeople * 9.80;
                        break;
                    case "Business":
                        totalPrice = numberOfPeople * 15.60;
                        if (numberOfPeople >= 100) {
                            totalPrice -= 10 * 15.60;
                        }
                        break;
                    case "Regular":
                        totalPrice = numberOfPeople * 20;
                        break;
                }
            } else if (day.equals("Sunday")) {
                switch (type) {
                    case "Students":
                        totalPrice = numberOfPeople * 10.46;
                        break;
                    case "Business":
                        totalPrice = numberOfPeople * 16;
                        if (numberOfPeople >= 100) {
                            totalPrice -= 10 * 16;
                        }
                        break;
                    case "Regular":
                        totalPrice = numberOfPeople * 22.50;
                        break;
                }
            }

            if (numberOfPeople >= 30 && type.equals("Students")) {
                totalPrice *= 0.85;
            } else if (numberOfPeople >= 10 && numberOfPeople <= 20 && type.equals("Regular")) {
                totalPrice *= 0.95;
            }

            System.out.printf("Total price: %.2f", totalPrice);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}