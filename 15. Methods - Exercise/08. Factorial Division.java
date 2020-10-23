package com.company;


import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.List;


public class Main {
    private static double calcFact(double number) {
        long fact = 1;
        for (int i = 1; i <= number; i++) {
            fact *= i;
        }
        return fact;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            double first = calcFact(Double.parseDouble(bfr.readLine()));
            double second = calcFact(Double.parseDouble(bfr.readLine()));
            System.out.printf("%.2f", first / second);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}