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

    private static void charactersInrange(char f, char s) {
        if (f < s) {
            for (int i = f + 1; i < s; i++) {
                System.out.printf("%c ", i);
            }
        } else {
            for (int i = s + 1; i < f; i++) {
                System.out.printf("%c ", i);
            }

        }
    }


    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            char f = bfr.readLine().charAt(0);
            char s = bfr.readLine().charAt(0);
            charactersInrange(f, s);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}