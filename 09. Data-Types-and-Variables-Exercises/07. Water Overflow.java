package com.company;


import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.List;


public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(bfr.readLine());
            int maxCapacity = 255;
            int pouredWater = 0;
            for (int i = 0; i < n; i++) {
                int pour = Integer.parseInt(bfr.readLine());
                if (pour > maxCapacity) {
                    System.out.println("Insufficient capacity!");
                } else {
                    maxCapacity -= pour;
                    pouredWater += pour;
                }
            }
            System.out.println(pouredWater);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}