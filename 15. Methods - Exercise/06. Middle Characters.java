package com.company;


import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.List;


public class Main {

    private static void printMiddleChar(String string) {
        String[] chars = string.split("");
        if (string.length() % 2 == 0) {
            int firstIndex = string.length() / 2 - 1;
            int secondIndex = string.length() / 2;
            System.out.print(chars[firstIndex]);
            System.out.print(chars[secondIndex]);
        } else {
            int index = string.length() / 2;
            System.out.println(chars[index]);
        }
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            printMiddleChar(bfr.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}