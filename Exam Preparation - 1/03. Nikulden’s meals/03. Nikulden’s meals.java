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

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            String input = bfr.readLine();

            Map<String, List<String>> guestsAndMeals = new LinkedHashMap<>();

            int unlikedMeals = 0;

            while (!"Stop".equals(input)) {
                String[] tokens = input.split("-");

                switch (tokens[0]) {
                    case "Like":
                        String guest = tokens[1];
                        String meal = tokens[2];

                        List<String> meals = guestsAndMeals.get(guest);
                        if (meals == null) {
                            meals = new ArrayList<>();
                            guestsAndMeals.put(guest, meals);
                        }
                        if (!meals.contains(meal)) {
                            meals.add(meal);
                        }
                        break;

                    case "Unlike":
                        List<String> mealsToRemoveFrom = guestsAndMeals.get(tokens[1]);

                        if (mealsToRemoveFrom == null) {
                            System.out.printf("%s is not at the party.%n", tokens[1]);
                            break;
                        }

                        if (mealsToRemoveFrom.contains(tokens[2])) {
                            mealsToRemoveFrom.remove(tokens[2]);
                            unlikedMeals++;
                            System.out.printf("%s doesn't like the %s.%n", tokens[1], tokens[2]);
                        } else {
                            System.out.printf("%s doesn't have the %s in his/her collection.%n", tokens[1], tokens[2]);
                        }
                        break;
                }
                input = bfr.readLine();
            }

            guestsAndMeals.entrySet().stream()
                    .sorted((f, s) -> {
                        int firstComparison = Integer.compare(s.getValue().size(), f.getValue().size());

                        if (firstComparison == 0) {
                            return f.getKey().compareTo(s.getKey());
                        }

                        return firstComparison;
                    })
                    .forEach(g -> {
                        if (g.getValue().size() == 0) {
                            System.out.printf("%s:%n", g.getKey());
                        } else {
                            System.out.printf("%s: %s%n", g.getKey(), String.join(", ", g.getValue()));
                        }
                    });

            System.out.printf("Unliked meals: %d", unlikedMeals);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}