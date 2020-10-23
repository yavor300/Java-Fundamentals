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
            String[] input = bfr.readLine().split("");
            Map<String, Integer> count = new LinkedHashMap<>();

            for (int i = 0; i < input.length; i++) {
                if (!input[i].equals(" ")) {
                    if (count.containsKey(input[i])) {
                        count.put(input[i], count.get(input[i]) + 1);
                    } else {
                        count.put(input[i], 1);
                    }
                }
            }

            for (Map.Entry<String, Integer> entry : count.entrySet()) {
                System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

