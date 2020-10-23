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
            int sumRemoved = 0;

            while (numbers.size() > 0) {
                int index = Integer.parseInt(bfr.readLine());
                if (index < 0) {
                    int first = numbers.remove(0);
                    sumRemoved += first;
                    numbers.add(0, numbers.get(numbers.size() - 1));
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) <= first) {
                            numbers.set(i, numbers.get(i) + first);
                        } else {
                            numbers.set(i, numbers.get(i) - first);
                        }
                    }
                }

                if (index > numbers.size() - 1) {
                    int last = numbers.remove(numbers.size() - 1);
                    sumRemoved += last;
                    numbers.add(numbers.get(0));
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) <= last) {
                            numbers.set(i, numbers.get(i) + last);
                        } else {
                            numbers.set(i, numbers.get(i) - last);
                        }
                    }
                }

                if (index >= 0 && index < numbers.size()) {
                    int removedNumber = numbers.remove(index);
                    sumRemoved += removedNumber;

                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) <= removedNumber) {
                            numbers.set(i, numbers.get(i) + removedNumber);
                        } else {
                            numbers.set(i, numbers.get(i) - removedNumber);
                        }
                    }
                }
            }

            System.out.println(sumRemoved);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}