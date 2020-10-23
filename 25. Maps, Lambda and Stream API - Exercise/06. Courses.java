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
            Map<String, List<String>> courses = new LinkedHashMap<>();
            while (!"end".equals(input)) {
                String[] tokens = input.split(" : ");
                List<String> students = courses.get(tokens[0]);
                if (students == null) {
                    students = new ArrayList<>();
                    courses.put(tokens[0], students);
                }
                students.add(tokens[1]);
                students.sort(Comparator.naturalOrder());
                input = bfr.readLine();
            }

            courses.entrySet().stream()
                    .sorted((f, s) -> Integer.compare(s.getValue().size(), f.getValue().size()))
                    .forEach(entry -> {
                        System.out.printf("%s: %d%n", entry.getKey(), entry.getValue().size());
                        List<String> students = entry.getValue();
                        for (String student : students) {
                            System.out.printf("-- %s%n", student);
                        }

                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

