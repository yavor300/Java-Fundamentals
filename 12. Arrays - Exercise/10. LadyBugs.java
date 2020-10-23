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
            int[] field = new int[Integer.parseInt(bfr.readLine())];
            int[] bugIndexes = parseLineOfNumbers(bfr.readLine());
            for (int index : bugIndexes) {
                if (index >= 0 && index < field.length) {
                    field[index] = 1;
                }
            }

            String input = bfr.readLine();
            while (!"end".equals(input)) {
                String[] tokens = input.split(" ");
                int index = Integer.parseInt(tokens[0]);
                String direction = tokens[1];
                int flyLength = Integer.parseInt(tokens[2]);

                if (index >= 0 && index < field.length && field[index] == 1) {
                    field[index] = 0;

                    if ("right".equals(direction)) {
                        index += flyLength;
                        while (index < field.length && field[index] == 1) {
                            index += flyLength;
                        }
                        if (index < field.length) {
                            field[index] = 1;
                        }
                    } else if ("left".equals(direction)) {
                        index -= flyLength;
                        while (index >= 0 && field[index] == 1) {
                            index -= flyLength;
                        }
                        if (index >= 0) {
                            field[index] = 1;
                        }
                    }

                }
                input = bfr.readLine();
            }

            for (int i : field) {
                System.out.printf("%d ", i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}