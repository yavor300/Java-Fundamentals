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

            Map<String, Map<Double, Integer>> products = new LinkedHashMap<>();


            while (!"buy".equals(input)) {
                String[] tokens = input.split("\\s+");
                String name = tokens[0];
                double price = Double.parseDouble(tokens[1]);
                int quantity = Integer.parseInt(tokens[2]);

                if (!products.containsKey(name)) {
                    Map<Double, Integer> details = new LinkedHashMap<>();
                    details.put(price, quantity);
                    products.put(name, details);
                } else {
                    int existingQuantity = 0;
                    Map<Double, Integer> map = products.get(name);
                    for (Map.Entry<Double, Integer> entry : map.entrySet()) {
                        existingQuantity = entry.getValue();
                    }
                    products.get(name).clear();
                    products.get(name).put(price, existingQuantity + quantity);
                }
                input = bfr.readLine();
            }

            for (Map.Entry<String, Map<Double, Integer>> entry : products.entrySet()) {
                String productName = entry.getKey();
                double totalPrice = 0;
                Map<Double, Integer> map = entry.getValue();
                for (Map.Entry<Double, Integer> doubleIntegerEntry : map.entrySet()) {
                    totalPrice = doubleIntegerEntry.getKey() * doubleIntegerEntry.getValue();
                }
                System.out.printf("%s -> %.2f%n", productName, totalPrice);


            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

