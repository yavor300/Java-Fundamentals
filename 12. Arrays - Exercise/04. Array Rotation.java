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
            int n = Integer.parseInt(bfr.readLine());
            for (int i = 0; i < n; i++) {
                int firstElement = numbers[0];
                for (int j = 0; j < numbers.length - 1; j++) {
                    numbers[j] = numbers[j + 1];
                }
                numbers[numbers.length - 1] = firstElement;
            }
            for (int number : numbers) {
                System.out.printf("%d ", number);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}