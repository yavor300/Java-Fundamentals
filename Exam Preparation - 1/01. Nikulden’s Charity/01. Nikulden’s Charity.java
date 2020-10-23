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
            String command = bfr.readLine();
            while (!"Finish".equals(command)) {
                String[] tokens =  command.split("\\s+");
                switch (tokens[0]) {
                    case "Replace":
                        String currentChar = tokens[1];
                        String newChar = tokens[2];
                        input = input.replaceAll(currentChar, newChar);
                        System.out.println(input);
                        break;

                    case "Cut":
                        int startIndex = Integer.parseInt(tokens[1]);
                        int endIndex = Integer.parseInt(tokens[2]);
                        if (startIndex >= 0 && endIndex < input.length()) {
                            StringBuilder stringBuilder = new StringBuilder(input);
                            stringBuilder.delete(startIndex, endIndex + 1);
                            input = stringBuilder.toString();
                            System.out.println(input);
                        } else {
                            System.out.println("Invalid indexes!");
                        }
                        break;

                    case "Make":
                        String caseTtpe = tokens[1];
                        if (caseTtpe.equals("Upper")) {
                            input = input.toUpperCase();
                        } else {
                            input = input.toLowerCase();
                        }
                        System.out.println(input);
                        break;

                    case "Check":
                        String toCheck = tokens[1];
                        boolean isContaining = false;

                        if (input.contains(toCheck)) {
                            isContaining = true;
                        }

                        if (isContaining) {
                            System.out.printf("Message contains %s%n", toCheck);
                        } else {
                            System.out.printf("Message doesn't contain %s%n", toCheck);
                        }
                        break;

                    case "Sum":
                        int startIndexToSum = Integer.parseInt(tokens[1]);
                        int endIndexToSum = Integer.parseInt(tokens[2]);

                        if (startIndexToSum >= 0 && endIndexToSum < input.length()) {
                            String substring = input.substring(startIndexToSum, endIndexToSum + 1);
                            int sum = 0;
                            for (int i = 0; i < substring.length(); i++) {
                                sum += substring.charAt(i);
                            }
                            System.out.println(sum);
                        } else {
                            System.out.println("Invalid indexes!");
                        }

                        break;
                }
                command = bfr.readLine();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

