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
            String[] phrases = new String[]{"Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.", "Exceptional product.", "I can’t live without this product."};
            String[] events = new String[] {"Now I feel good.","I have succeeded with this product.", "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"};
            String[] authors = new String[] {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva","Annie", "Eva"};
            String[] cities = new String[] {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};
            int n = Integer.parseInt(bfr.readLine());
            for (int i = 0; i < n; i++) {
                Random random = new Random();
                System.out.printf("%s %s %s - %s%n", phrases[random.nextInt(phrases.length)], events[random.nextInt(events.length)], authors[random.nextInt(authors.length)], cities[random.nextInt(authors.length)]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}