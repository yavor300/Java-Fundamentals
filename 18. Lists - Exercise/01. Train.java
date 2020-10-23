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
            int[] wagonsArray = parseLineOfNumbers(bfr.readLine());
            List<Integer> wagons = new ArrayList<>();
            for (int i : wagonsArray) {
                wagons.add(i);
            }

            int maxCapacity = Integer.parseInt(bfr.readLine());
            String input = bfr.readLine();
            while (!"end".equals(input)) {
                if (input.contains("Add")) {
                    String[] tokens = input.split("\\s+");
                    wagons.add(Integer.parseInt(tokens[1]));
                } else {
                    for (int i = 0; i < wagons.size(); i++) {
                        int freeSpace = maxCapacity - wagons.get(i);
                        if (Integer.parseInt(input) <= freeSpace) {
                            wagons.set(i, wagons.get(i) + Integer.parseInt(input));
                            break;
                        }
                    }
                }
                input = bfr.readLine();
            }

            for (Integer wagon : wagons) {
                System.out.printf("%d ", wagon);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}