package com.company;


import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.List;


public class Main {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            int num = Integer.parseInt(bfr.readLine());
            int num2 = Integer.parseInt(bfr.readLine());
            int num3 = Integer.parseInt(bfr.readLine());
            int num4 = Integer.parseInt(bfr.readLine());

            System.out.println(((num + num2) / num3) * num4);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}