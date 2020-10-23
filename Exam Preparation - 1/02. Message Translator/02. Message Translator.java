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
            String regex = "!([A-Z][a-z]+)!:\\[([A-Za-z]+)\\]";
            Pattern pattern = Pattern.compile(regex);
            int n = Integer.parseInt(bfr.readLine());
            for (int i = 0; i < n; i++) {
                String input = bfr.readLine();
                Matcher matcher = pattern.matcher(input);

                if (matcher.find()) {
                    String command = matcher.group(1);
                    String message = matcher.group(2);

                    if (command.length() < 3) {
                        System.out.println("The message is invalid");
                        break;
                    }

                    if (message.length() < 8) {
                        System.out.println("The message is invalid");
                        break;
                    }

                    System.out.printf("%s: ", command);
                    for (int j = 0; j < message.length(); j++) {
                        System.out.print((int) message.charAt(j) + " ");
                    }
                    System.out.println();
                } else {
                    System.out.println("The message is invalid");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}