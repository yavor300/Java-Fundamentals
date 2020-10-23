package com.company;


import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.List;


public class Main {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            int num = Integer.parseInt(bfr.readLine());
            if (num % 10 == 0) {
                System.out.println("The number is divisible by 10");
            } else if (num % 7 == 0) {
                System.out.println("The number is divisible by 7");
            } else if (num % 6 == 0) {
                System.out.println("The number is divisible by 6");
            } else if (num % 3 == 0) {
                System.out.println("The number is divisible by 3");
            } else if (num % 2 == 0) {
                System.out.println("The number is divisible by 2");
            } else {
                System.out.println("Not divisible");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}