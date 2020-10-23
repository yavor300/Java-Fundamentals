package com.company;


import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.List;


public class Main {

    private static void isValidPass(String pass) {
        boolean isValidLength = true;
        if (pass.length() < 6 || pass.length() > 10) {
            System.out.println("Password must be between 6 and 10 characters");
            isValidLength = false;
        }

        boolean isValidCharacters = true;
        for (int i = 0; i < pass.length(); i++) {
            if (!Character.isDigit(pass.charAt(i)) && !Character.isLetter(pass.charAt(i))) {
                System.out.println("Password must consist only of letters and digits");
                isValidCharacters = false;
                break;
            }
        }

        boolean containsTwoDigits = true;
        int count = 0;
        for (int i = 0; i < pass.length(); i++) {
            if (Character.isDigit(pass.charAt(i))) {
                count++;
            }
        }
        if (count < 2) {
            System.out.println("Password must have at least 2 digits");
            containsTwoDigits = false;
        }

        if (isValidLength && isValidCharacters && containsTwoDigits) {
            System.out.println("Password is valid");
        }
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            isValidPass(bfr.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}