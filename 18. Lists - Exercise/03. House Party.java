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

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(bfr.readLine());
            List<String> guests = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String input = bfr.readLine();
                String[] commands = input.split("\\s+");
                switch (commands[2]) {
                    case "going!":
                        if (!guests.contains(commands[0])) {
                            guests.add(commands[0]);
                        } else {
                            System.out.printf("%s is already in the list!%n", commands[0]);
                        }
                        break;
                    case "not":
                        if (guests.contains(commands[0])) {
                            guests.remove(commands[0]);
                        } else {
                            System.out.printf("%s is not in the list!%n", commands[0]);
                        }
                        break;
                }
            }

            for (String guest : guests) {
                System.out.printf("%s%n", guest);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}