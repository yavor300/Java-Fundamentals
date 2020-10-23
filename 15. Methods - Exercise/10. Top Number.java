package com.company;


import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.List;


public class Main {
    private static boolean checkSum(int number) {
        int sum = 0;
        String[] value = String.valueOf(number).split("");
        for (String s : value) {
            sum += Integer.parseInt(s);
        }
        return sum % 8 == 0;
    }

    private static boolean checkForHoldingADigit(int number) {
        String[] value = String.valueOf(number).split("");
        for (String s : value) {
            if (Integer.parseInt(s) % 2 != 0) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(bfr.readLine());
            for (int i = 1; i <= n; i++) {
                if (checkSum(i) && checkForHoldingADigit(i)) {
                    System.out.println(i);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}