package com.company;


import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.List;


public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            String input = bfr.readLine();
            double sum = 0;
            while(!"Start".equals(input)) {
                double coin = Double.parseDouble(input);
                if (coin == 0.1 || coin == 0.2 || coin == 0.5 || coin == 1.00 || coin == 2.00) {
                    sum += coin;
                } else {
                    System.out.printf("Cannot accept %.2f%n", coin);
                }
                input = bfr.readLine();
            }
            String drinks = bfr.readLine();
            while (!"End".equals(drinks)) {
                if ("Nuts".equals(drinks)) {
                    if (sum >= 2.00) {
                        sum -= 2.00;
                        System.out.printf("Purchased %s%n", drinks);
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                } else if ("Water".equals(drinks)) {
                    if (sum >= 0.70) {
                        sum -= 0.70;
                        System.out.printf("Purchased %s%n", drinks);
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                } else if ("Crisps".equals(drinks)) {
                    if (sum >= 1.50) {
                        sum -= 1.50;
                        System.out.printf("Purchased %s%n", drinks);
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                } else if ("Soda".equals(drinks)) {
                    if (sum >= 0.80) {
                        sum -= 0.80;
                        System.out.printf("Purchased %s%n", drinks);
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                } else if ("Coke".equals(drinks)) {
                    if (sum >= 1.00) {
                        sum -= 1.00;
                        System.out.printf("Purchased %s%n", drinks);
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                } else {
                    System.out.println("Invalid product");
                }
                drinks = bfr.readLine();
            }
            System.out.printf("Change: %.2f", sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}