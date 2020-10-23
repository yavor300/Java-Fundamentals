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
            int[] firstArr = new int[n];
            int[] secondArr = new int[n];
            for (int i = 1; i <= n; i++) {
                int[] numbers = parseLineOfNumbers(bfr.readLine());
                if (i % 2 == 0) {
                    firstArr[i - 1] = numbers[1];
                    secondArr[i - 1] = numbers[0];
                } else {
                    firstArr[i - 1] = numbers[0];
                    secondArr[i - 1] = numbers[1];
                }
            }

            for (int i : firstArr) {
                System.out.printf("%d ", i);
            }
            System.out.println();
            for (int i : secondArr) {
                System.out.printf("%d ", i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}