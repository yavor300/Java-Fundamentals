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

            String regex = "::([A-Z][a-z]+)::|\\*\\*([A-Z][a-z]+)\\*\\*";
            Pattern pattern = Pattern.compile(regex);

            String input = bfr.readLine();

            long coolThreshold = 1;
            for (int i = 0; i < input.length(); i++) {
                if (Character.isDigit(input.charAt(i))) {
                    coolThreshold *= Integer.parseInt(input.charAt(i) + "");
                }
            }

            List<String> coolEmojis = new ArrayList<>();
            int validEmojis = 0;

            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                int coolness = 0;

                if (matcher.group(1) == null) {
                    if (matcher.group(2).length() >= 3) {
                        validEmojis++;
                        String emoji = matcher.group(2);
                        for (int i = 0; i < emoji.length(); i++) {
                            coolness += emoji.charAt(i);
                        }
                        if (coolness >= coolThreshold) {
                            coolEmojis.add("**" + emoji + "**");
                        }
                    }
                } else {
                    if (matcher.group(1).length() >= 3) {
                        validEmojis++;
                        String emoji = matcher.group(1);
                        for (int i = 0; i < emoji.length(); i++) {
                            coolness += emoji.charAt(i);
                        }
                        if (coolness >= coolThreshold) {
                            coolEmojis.add("::" + emoji + "::");
                        }
                    }
                }
            }

            System.out.printf("Cool threshold: %d%n%d emojis found in the text. The cool ones are:%n", coolThreshold, validEmojis);
            for (String s : coolEmojis) {
                System.out.println(s);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}