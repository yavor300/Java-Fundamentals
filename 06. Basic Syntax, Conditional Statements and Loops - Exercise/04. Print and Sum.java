package com.company;


import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.List;


public class Main {
    
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            int start = Integer.parseInt(bfr.readLine());
            int end = Integer.parseInt(bfr.readLine());
            int sum = 0;
            for (int i = start; i <= end; i++) {
                System.out.printf("%d ", i);
                sum += i;
            }
            System.out.printf("%nSum: %d", sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}