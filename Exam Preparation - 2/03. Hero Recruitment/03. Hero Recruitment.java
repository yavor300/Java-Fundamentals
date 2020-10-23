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

            Map<String, List<String>> enrolledHeroesAndSpells = new LinkedHashMap<>();

            String command = bfr.readLine();
            while (!"End".equals(command)) {
                String[] tokens = command.split("\\s+");

                String heroName = tokens[1];

                String spellName = null;
                if (tokens.length == 3) {
                    spellName = tokens[2];
                }

                switch (tokens[0]) {
                    case "Enroll":


                        if (!enrolledHeroesAndSpells.containsKey(heroName)) {
                            enrolledHeroesAndSpells.put(heroName, new ArrayList<>());
                        } else {
                            System.out.printf("%s is already enrolled.%n", heroName);
                        }
                        break;

                    case "Learn":
                        List<String> spellsToAddInNew = enrolledHeroesAndSpells.get(heroName);

                        if (spellsToAddInNew == null) {
                            System.out.printf("%s doesn't exist.%n", heroName);
                        } else {
                            if (!spellsToAddInNew.contains(spellName)) {
                                spellsToAddInNew.add(spellName);
                            } else {
                                System.out.printf("%s has already learnt %s.%n", heroName, spellName);
                            }
                        }
                        break;

                    case "Unlearn":
                        List<String> spellsToRemoveFrom = enrolledHeroesAndSpells.get(heroName);

                        if (spellsToRemoveFrom == null) {
                            System.out.printf("%s doesn't exist.%n", heroName);
                        } else {
                            if (spellsToRemoveFrom.contains(spellName)) {
                                spellsToRemoveFrom.remove(spellName);
                            } else {
                                System.out.printf("%s doesn't know %s.%n", heroName, spellName);
                            }
                        }
                        break;
                }
                command = bfr.readLine();
            }

            System.out.println("Heroes:");

            enrolledHeroesAndSpells.entrySet()
                    .stream()
                    .sorted((f, s) -> {
                        int firstComparison = Integer.compare(s.getValue().size(), f.getValue().size());

                        if (firstComparison == 0) {
                            return f.getKey().compareTo(s.getKey());
                        }

                        return firstComparison;
                    })
                    .forEach(h -> {
                        System.out.printf("== %s: %s%n", h.getKey(), String.join(", ", h.getValue()));
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}