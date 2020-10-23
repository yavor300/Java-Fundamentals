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

            String regex = "\\|([A-Z]+)\\|:#([A-Za-z]+\\s[A-Za-z]+)#";
            Pattern pattern = Pattern.compile(regex);

            int n = Integer.parseInt(bfr.readLine());
            for (int i = 0; i < n; i++) {
                String input = bfr.readLine();

                Matcher matcher = pattern.matcher(input);
                if (matcher.find()) {
                    String boss = matcher.group(1);
                    String title = matcher.group(2);

                    if (boss.length() < 4) {
                        System.out.println("Access denied!");
                    } else {
                        System.out.printf("%s, The %s%n>> Strength: %d%n>> Armour: %d%n", boss, title, boss.length(), title.length());
                    }



                } else {
                    System.out.println("Access denied!");
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}