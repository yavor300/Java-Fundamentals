package com.company;


import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.List;


public class Main {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {

            int age = Integer.parseInt(bfr.readLine());
            if (age >= 0 && age <= 2) {
                System.out.println("baby");
            } else if (age >= 3 && age <= 13) {
                System.out.println("child");
            } else if (age >= 14 && age <= 19) {
                System.out.println("teenager");
            } else if (age >= 20 && age <= 65) {
                System.out.println("adult");
            } else if (age >= 66) {
                System.out.println("elder");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}