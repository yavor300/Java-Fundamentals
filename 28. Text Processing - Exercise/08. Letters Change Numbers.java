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

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            String[] strings = bfr.readLine().split("\\s+");
            double sum = 0;

            for (String string : strings) {
                char before = string.charAt(0);
                char after = string.charAt(string.length() - 1);
                long number = Long.parseLong(string.substring(1, string.length() - 1));
                sum += calculateCurrentValue(before, after, number);
            }

            System.out.printf("%.2f", sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static double calculateCurrentValue(char before, char after, long number) {
        double value = 0;
        if (Character.isUpperCase(before)) {
            value += number * 1.0 / (before - 'A' + 1);
        } else {
            value += number * (before - 'a' + 1);
        }

        if (Character.isUpperCase(after)) {
            value -= (after - 'A' + 1);
        } else {
            value += (after - 'a' + 1);
        }
        return  value;
    }


}

