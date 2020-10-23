package com.company;


import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.List;


public class Main {

    private static int sum(int num1, int num2) {
        return num1 + num2;
    }

    private static int substract(int num1, int num2, int num3) {
        return sum(num1, num2) - num3;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(substract(Integer.parseInt(bfr.readLine()),
                    Integer.parseInt(bfr.readLine()),
                    Integer.parseInt(bfr.readLine())));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}