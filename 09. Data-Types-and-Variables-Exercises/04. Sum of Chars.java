package com.company;


import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.List;


public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {

            int sum = 0;
            int n = Integer.parseInt(bfr.readLine());
            for (int i = 0; i < n; i++) {
                char letter = bfr.readLine().charAt(0);
                sum += (int)letter;
            }
            System.out.printf("The sum equals: %d", sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}