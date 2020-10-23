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

            String rawActivationKey = bfr.readLine();

            String input = bfr.readLine();
            while (!"Generate".equals(input)) {
                String[] tokens = input.split(">>>");

                switch (tokens[0]) {
                    case "Contains":
                        String substring = tokens[1];
                        if (rawActivationKey.contains(substring)) {
                            System.out.printf("%s contains %s%n", rawActivationKey, substring);
                        } else {
                            System.out.println("Substring not found!");
                        }
                        break;

                    case "Flip":
                        int startIndex = Integer.parseInt(tokens[2]);
                        int endIndex = Integer.parseInt(tokens[3]);
                        String substringToUpdate = rawActivationKey.substring(startIndex, endIndex);

                        switch (tokens[1]) {
                            case "Upper":
                                String upperSubstring = substringToUpdate.toUpperCase();
                                rawActivationKey = rawActivationKey.replace(substringToUpdate, upperSubstring);
                                System.out.println(rawActivationKey);
                                break;

                            case "Lower":
                                String lowerSubstring = substringToUpdate.toLowerCase();
                                rawActivationKey = rawActivationKey.replace(substringToUpdate, lowerSubstring);
                                System.out.println(rawActivationKey);
                                break;
                        }
                        break;

                    case "Slice":
                        int start = Integer.parseInt(tokens[1]);
                        int end = Integer.parseInt(tokens[2]);

                        StringBuilder sb = new StringBuilder(rawActivationKey);
                        sb.delete(start, end);

                        rawActivationKey = sb.toString();
                        System.out.println(rawActivationKey);
                        break;
                }

                input = bfr.readLine();
            }

            System.out.printf("Your activation key is: %s", rawActivationKey);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
