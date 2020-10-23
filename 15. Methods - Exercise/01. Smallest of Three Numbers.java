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

    public static void smallestNumber(int num1, int num2, int num3) {
        int[] numbers = new int[] {num1, num2, num3};
        int min = Integer.MAX_VALUE;
        for (int i : numbers) {
            if (i < min) {
                min = i;
            }
        }
        System.out.println(min);

    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            int num1 = Integer.parseInt(bfr.readLine());
            int num2 = Integer.parseInt(bfr.readLine());
            int num3 = Integer.parseInt(bfr.readLine());
            smallestNumber(num1, num2, num3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}