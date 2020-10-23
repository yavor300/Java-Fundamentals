package com.company;


import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.List;


public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputOne = bfr.readLine().split(" ");
            String[] inputTwo = bfr.readLine().split(" ");

            if (inputOne.length > inputTwo.length) {
                for (int i = 0; i < inputOne.length; i++) {
                    for (int j = 0; j < inputTwo.length; j++) {
                        if (inputOne[i].equals(inputTwo[j])) {
                            System.out.printf("%s ", inputTwo[j]);
                        }
                    }
                }
            } else {
                for (int i = 0; i < inputTwo.length; i++) {
                    for (int j = 0; j < inputOne.length; j++) {
                        if (inputTwo[i].equals(inputOne[j])) {
                            System.out.printf("%s ", inputTwo[i]);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}