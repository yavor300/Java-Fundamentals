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
            List<Integer> numbers = getIntegersInList(bfr.readLine());
            String input = bfr.readLine();
            while (!"End".equals(input)) {
                String[] tokens = input.split("\\s+");
                switch (tokens[0]) {
                    case "Add":
                        numbers.add(Integer.parseInt(tokens[1]));
                        break;
                    case "Insert":
                        if ((Integer.parseInt(tokens[2]) >= 0 && Integer.parseInt(tokens[2]) < numbers.size())) {
                            numbers.add(Integer.parseInt(tokens[2]), Integer.parseInt(tokens[1]));
                        } else {
                            System.out.println("Invalid index");
                        }
                        break;
                    case "Remove":
                        if ((Integer.parseInt(tokens[1]) >= 0 && Integer.parseInt(tokens[1]) < numbers.size())) {
                            numbers.remove(Integer.parseInt(tokens[1]));
                        } else {
                            System.out.println("Invalid index");
                        }
                        break;
                    case "Shift":
                        if ("left".equals(tokens[1])) {
                            for (int i = 0; i < Integer.parseInt(tokens[2]); i++) {
                                int firstElement = numbers.remove(0);
                                numbers.add(firstElement);
                            }
                        } else {
                            for (int i = 0; i < Integer.parseInt(tokens[2]); i++) {
                                int lastElement = numbers.remove(numbers.size() - 1);
                                numbers.add(0, lastElement);
                            }
                        }
                        break;
                }
                input = bfr.readLine();
            }

            for (Integer number : numbers) {
                System.out.printf("%d ", number);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}