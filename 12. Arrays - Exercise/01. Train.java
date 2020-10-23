package com.company;


import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.List;


public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(bfr.readLine());
            int[] people = new int[n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                people[i] = Integer.parseInt(bfr.readLine());
                sum += people[i];
            }
            for (int person : people) {
                System.out.printf("%d ", person);
            }
            System.out.println();
            System.out.println(sum);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}