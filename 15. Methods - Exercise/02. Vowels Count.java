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

    public static void vowelsCount(String input) {
        int count = 0;
        String[] word = input.toLowerCase().split("");
        for (String s : word) {
            if (s.equals("a") || s.equals("e") || s.equals("o") || s.equals("i") || s.equals("u")) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            vowelsCount(bfr.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}