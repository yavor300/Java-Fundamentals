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
            int[] numbers = parseLineOfNumbers(bfr.readLine());
            int number = Integer.parseInt(bfr.readLine());
            for (int i = 0; i < numbers.length; i++) {
                int element = numbers[i];
                for (int j = i + 1; j < numbers.length; j++) {
                    if (element + numbers[j] == number) {
                        System.out.printf("%d %d%n", element, numbers[j]);
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}