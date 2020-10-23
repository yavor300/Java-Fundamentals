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
            i int[] numbers = parseLineOfNumbers(bfr.readLine());
            int start = 0;
            int max = 0;
            int count = 0;

            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i] == numbers[i + 1]) {
                    count++;
                    if (count > max) {
                        start = i - count;
                        max = count;
                    }
                } else {
                    count = 0;
                }
            }

            for (int i = start + 1; i <= start + max + 1; i++) {
                System.out.printf("%d ", numbers[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}