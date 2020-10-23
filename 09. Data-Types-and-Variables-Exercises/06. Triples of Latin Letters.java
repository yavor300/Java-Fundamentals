package com.company;


import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.List;


public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(bfr.readLine());
            for (int i = 97; i < 97 + n; i++) {
                for (int j = 97; j < 97 + n; j++) {
                    for (int k = 97; k < 97 + n; k++) {
                        System.out.printf("%c%c%c%n", i, j, k);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}