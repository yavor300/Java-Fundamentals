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
            int n = Integer.parseInt(bfr.readLine());
            Map<String, List<Double>> students = new LinkedHashMap<>();
            for (int i = 0; i < n; i++) {
                String name = bfr.readLine();
                Double grade = Double.parseDouble(bfr.readLine());
                List<Double> grades = students.get(name);
                if (grades == null) {
                    grades = new ArrayList<>();
                    students.put(name, grades);
                }
                grades.add(grade);
            }

            Map<String, Double> studentsWithAvgGrades = new LinkedHashMap<>();
            for (Map.Entry<String, List<Double>> entry : students.entrySet()) {
                List<Double> grades = entry.getValue();
                double sum = 0;
                for (Double grade : grades) {
                    sum += grade;
                }
                double average = sum / grades.size();
                if (average >= 4.50) {
                    studentsWithAvgGrades.put(entry.getKey(), average);
                }
            }

            studentsWithAvgGrades.entrySet().stream()
                    .sorted((f, s) -> s.getValue().compareTo(f.getValue()))
                    .forEach(e -> System.out.printf("%s -> %.2f%n", e.getKey(), e.getValue()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
