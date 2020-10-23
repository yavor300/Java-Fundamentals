package com.company;


import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.List;


public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(bfr.readLine());
            int p = Integer.parseInt(bfr.readLine());
            System.out.println((int) Math.ceil((double) n / p));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}