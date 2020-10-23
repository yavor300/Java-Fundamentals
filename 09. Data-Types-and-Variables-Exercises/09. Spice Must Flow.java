package com.company;


import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.List;


public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            int startingYield = Integer.parseInt(bfr.readLine());
            int total = 0;
            int days = 0;
            while (startingYield >= 100) {
                total += startingYield;
                if (total >= 26) {
                    total -= 26;
                }
                days++;
                startingYield -= 10;
            }
            if (total >= 26) {
                total -= 26;
            }
            System.out.println(days);
            System.out.println(total);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}