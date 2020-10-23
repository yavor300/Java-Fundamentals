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
            String skill = bfr.readLine();

            String command = bfr.readLine();
            while (!"For Azeroth".equals(command)) {
                String[] tokens = command.split("\\s");

                switch (tokens[0]) {
                    case "GladiatorStance":
                        skill = skill.toUpperCase();
                        System.out.println(skill);
                        break;

                    case "DefensiveStance":
                        skill = skill.toLowerCase();
                        System.out.println(skill);
                        break;

                    case "Dispel":
                        int index = Integer.parseInt(tokens[1]);
                        String letter = tokens[2];

                        if (index >= 0 && index < skill.length()) {
                            StringBuilder sb = new StringBuilder(skill);
                            sb.replace(index, index + 1, letter);
                            skill = sb.toString();
                            System.out.println("Success!");
                        } else {
                            System.out.println("Dispel too weak.");
                        }
                        break;

                    case "Target":
                        switch (tokens[1]) {
                            case "Change":
                                String substring = tokens[2];
                                if (skill.contains(substring)) {
                                    String secondSubstring = tokens[3];
                                    skill = skill.replace(substring, secondSubstring);
                                    System.out.println(skill);
                                }

                                break;


                            case "Remove":
                                String substringToRemove = tokens[2];
                                if (skill.contains(substringToRemove)) {
                                    skill = skill.replace(substringToRemove, "");
                                    System.out.println(skill);
                                }
                                break;

                            default:
                                System.out.println("Command doesn't exist!");
                                break;
                        }
                        break;

                    default:
                        System.out.println("Command doesn't exist!");
                        break;
                }

                command = bfr.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
