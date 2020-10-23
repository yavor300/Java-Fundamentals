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
            Map<String, Integer> studentsMaxPoints = new LinkedHashMap<>();
            Map<String, Integer> languageSubmitions = new LinkedHashMap<>();
            while (!"exam finished".equals(input)) {
                String[] tokens = input.split("-");
                if ("banned".equals(tokens[1])) {
                    studentsMaxPoints.remove(tokens[0]);
                } else {
                    int points = Integer.parseInt(tokens[2]);
                    if (studentsMaxPoints.containsKey(tokens[0]) && studentsMaxPoints.get(tokens[0]) < points) {
                        studentsMaxPoints.put(tokens[0], points);
                    } else if (!studentsMaxPoints.containsKey(tokens[0])) {
                        studentsMaxPoints.put(tokens[0], points);
                    }
                    if (languageSubmitions.containsKey(tokens[1])) {
                        languageSubmitions.put(tokens[1], languageSubmitions.get(tokens[1]) + 1);
                    } else {
                        languageSubmitions.put(tokens[1], 1);
                    }
                }
                input = bfr.readLine();
            }

            System.out.println("Results:");
            studentsMaxPoints.entrySet()
                    .stream()
                    .sorted((f, s) -> {
                        int firstComparison = s.getValue().compareTo(f.getValue());
                        if (firstComparison == 0) {
                            return f.getKey().compareTo(s.getKey());
                        }
                        return firstComparison;
                    })
                    .forEach(e -> System.out.printf("%s | %d%n", e.getKey(), e.getValue()));
            System.out.println("Submissions:");
            languageSubmitions.entrySet()
                    .stream()
                    .sorted((f, s) -> {
                        int firstComparison = s.getValue().compareTo(f.getValue());
                        if (firstComparison == 0) {
                            return f.getKey().compareTo(s.getKey());
                        }
                        return firstComparison;
                    })
                    .forEach(e -> System.out.printf("%s - %d%n", e.getKey(), e.getValue()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}