package com.company;


import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.List;


public class Main {
    private static boolean isPalindrome(String string) {
        int number = Integer.parseInt(string);
        String[] chars = string.split("");
        String reversedString = "";
        for (int i = chars.length - 1; i >= 0; i--) {
            reversedString += chars[i];
        }
        int numberReversed = Integer.parseInt(reversedString);
        return number == numberReversed;
    }


    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            String input = bfr.readLine();
            while (!"END".equals(input)) {
                System.out.println(isPalindrome(input));
                input = bfr.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}