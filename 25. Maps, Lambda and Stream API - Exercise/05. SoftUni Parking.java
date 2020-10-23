package com.company;


import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.List;


public class Main {

    public static int[] parseLineOfNumbers(String line) {
        String[] numberString = line.split(" ");
        int[] numbers = new int[numberString.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(numberString[i]);
        }
        return numbers;
    }

    private static List<Integer> getIntegersInList(String line) {
        List<Integer> numbers = new ArrayList<>();
        String[] strings = line.split(" ");
        for (String numberString : strings) {
            numbers.add(Integer.parseInt(numberString));
        }
        return numbers;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            Map<String, String> users = new LinkedHashMap<>();
            int n = Integer.parseInt(bfr.readLine());

            for (int i = 0; i < n; i++) {
                String[] tokens = bfr.readLine().split("\\s+");
                switch (tokens[0]) {
                    case "register":
                        if (!users.containsKey(tokens[1])) {
                            users.put(tokens[1], tokens[2]);
                            System.out.printf("%s registered %s successfully%n", tokens[1], tokens[2]);
                        } else {
                            System.out.printf("ERROR: already registered with plate number %s%n", users.get(tokens[1]));
                        }
                        break;

                    case "unregister":
                        if (users.containsKey(tokens[1])) {
                            users.remove(tokens[1]);
                            System.out.printf("%s unregistered successfully%n", tokens[1]);
                        } else {
                            System.out.printf("ERROR: user %s not found%n", tokens[1]);
                        }
                        break;
                }
            }

            users.forEach((key, value) -> System.out.printf("%s => %s%n", key, value));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

