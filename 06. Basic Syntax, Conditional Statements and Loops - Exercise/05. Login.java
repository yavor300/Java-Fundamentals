package com.company;


import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.List;


public class Main {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {

            String username = bfr.readLine();
            String password = "";
            for (int i = username.length() - 1; i >= 0; i--) {
                password += username.charAt(i);
            }
            String userInput = bfr.readLine();
            int fails = 0;
            while (!userInput.equals(password)) {

                fails++;
                if (fails == 4) {
                    System.out.printf("User %s blocked!", username);
                    return;
                }
                System.out.println("Incorrect password. Try again.");
                userInput = bfr.readLine();
            }
            System.out.printf("User %s logged in.", username);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}