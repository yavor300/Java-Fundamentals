package com.company;


import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.List;


public class Main {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            String num = bfr.readLine();
            int sum = 0;
            for (int i = 0; i < num.length(); i++) {
                int separateNum = num.charAt(i) - '0';
                int fact = 1;
                for (int j = 2; j <= separateNum; j++) {
                    fact *= j;
                }
                sum += fact;
            }
            if (sum == Integer.parseInt(num)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}