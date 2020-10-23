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
            List<Integer> firstDeck = getIntegersInList(bfr.readLine());
            List<Integer> secondDeck = getIntegersInList(bfr.readLine());

            while (firstDeck.size() != 0 && secondDeck.size() != 0) {
                if (firstDeck.get(0) > secondDeck.get(0)) {
                    firstDeck.add(firstDeck.get(0));
                    firstDeck.remove(0);
                    firstDeck.add(secondDeck.get(0));
                    secondDeck.remove(0);
                } else if (firstDeck.get(0) < secondDeck.get(0)) {
                    secondDeck.add(secondDeck.get(0));
                    secondDeck.remove(0);
                    secondDeck.add(firstDeck.get(0));
                    firstDeck.remove(0);
                } else {
                    firstDeck.remove(0);
                    secondDeck.remove(0);
                }
            }
            int sum = 0;
            if (firstDeck.size() > secondDeck.size()) {
                for (Integer integer : firstDeck) {
                    sum += integer;
                }
                System.out.printf("First player wins! Sum: %d", sum);
            } else {
                for (Integer integer : secondDeck) {
                    sum += integer;
                }
                System.out.printf("Second player wins! Sum: %d", sum);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}