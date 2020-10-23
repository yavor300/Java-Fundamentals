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
            List<Integer> numbers = getIntegersInList(bfr.readLine());
            int[] specialNumberAndPower = parseLineOfNumbers(bfr.readLine());
            int specialBombNumber = specialNumberAndPower[0];
            int power = specialNumberAndPower[1];

            for (int i = 0; i < numbers.size(); i++) {
                if (specialBombNumber == numbers.get(i)) {
                    int bombIndex = i;
                    int startingIndex = bombIndex - power;
                    int endIndex = bombIndex + power;
                    for (int j = startingIndex; j <= endIndex; j++) {
                        if (j >= 0 && j < numbers.size()) {
                            numbers.set(j, 0);
                        }
                    }
                }
            }
            int sum = 0;
            for (Integer number : numbers) {
                sum += number;
            }
            System.out.println(sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}