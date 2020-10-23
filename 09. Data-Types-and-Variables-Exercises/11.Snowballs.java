package com.company;


import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.List;


public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(bfr.readLine());
            double max = Integer.MIN_VALUE;
            int bestSnow = 0;
            int bestTime = 0;
            int bestQuality = 0;
            for (int i = 0; i < n; i++) {
                int snow = Integer.parseInt(bfr.readLine());
                int time = Integer.parseInt(bfr.readLine());
                int quality = Integer.parseInt(bfr.readLine());


                double value = Math.pow((snow / time), quality);
                if (value > max) {
                    max = value;
                    bestQuality = quality;
                    bestSnow = snow;
                    bestTime = time;
                }
            }
            System.out.printf("%d : %d = %.0f (%d)", bestSnow, bestTime, max, bestQuality);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}