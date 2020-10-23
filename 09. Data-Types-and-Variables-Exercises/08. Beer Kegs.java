package com.company;


import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.List;


public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            double max = Double.MIN_VALUE;
            int n = Integer.parseInt(bfr.readLine());
            String modelWinner = null;
            for (int i = 0; i < n; i++) {
                String model = bfr.readLine();
                double radius = Double.parseDouble(bfr.readLine());
                int height = Integer.parseInt(bfr.readLine());
                double voulume = Math.PI * radius * radius * height;
                if (voulume > max) {
                    max = voulume;
                    modelWinner = model;
                }
            }
            System.out.println(modelWinner);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}