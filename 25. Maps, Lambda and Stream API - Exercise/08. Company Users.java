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
            String input = bfr.readLine();
            Map<String, List<String>> companies = new TreeMap<>();
            while (!"End".equals(input)) {
                String[] tokens = input.split(" -> ");
                List<String> IDs = companies.get(tokens[0]);
                if (IDs == null) {
                    IDs = new ArrayList<>();
                    companies.put(tokens[0], IDs);
                }
                if (!IDs.contains(tokens[1])) {
                    IDs.add(tokens[1]);
                }
                input = bfr.readLine();
            }

            companies.entrySet().stream()
                    .forEach(e -> {
                        System.out.printf("%s%n", e.getKey());
                        List<String> IDs = e.getValue();
                        for (String id : IDs) {
                            System.out.printf("-- %s%n", id);
                        }

                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}