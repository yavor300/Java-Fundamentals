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
            String input = bfr.readLine();
            String[] words = input.split("\\s+");
            List<String> inputValues = new ArrayList<>(Arrays.asList(words));

            String command = bfr.readLine();
            while (!"3:1".equals(command)) {
                String[] tokens = command.split("\\s+");
                switch (tokens[0]) {
                    case "merge":
                        if (Integer.parseInt(tokens[1]) < 0) {
                            tokens[1] = "0";
                        }

                        if (Integer.parseInt(tokens[2]) > inputValues.size() - 1) {
                            tokens[2] = String.valueOf(inputValues.size() - 1);
                        }

                        for (int i = Integer.parseInt(tokens[1]); i < Integer.parseInt(tokens[2]); i++) {
                            String concat = inputValues.get(Integer.parseInt(tokens[1])) + inputValues.get(Integer.parseInt(tokens[1]) + 1);
                            inputValues.set(Integer.parseInt(tokens[1]), concat);
                            inputValues.remove(Integer.parseInt(tokens[1]) + 1);
                        }
                        break;
                    case "divide":
                        int index = Integer.parseInt(tokens[1]);
                        int partions = Integer.parseInt(tokens[2]);
                        if (index >= 0 && index < inputValues.size() && partions >= 0 && partions <= 100) {
                            String element = inputValues.get(index);
                            List<String> newList = new ArrayList<>();
                            if (element.length() % partions == 0) {
                                int portionLength = element.length() / partions;
                                int count = 0;
                                for (int i = 0; i < partions; i++) {
                                    String concat = "";
                                    for (int j = 0; j < portionLength; j++) {
                                        char symbol = element.charAt(count);
                                        concat += symbol;
                                        count++;
                                    }
                                    newList.add(concat);
                                }
                            } else {
                                int portionLength = element.length() / partions;
                                int count = 0;
                                for (int i = 0; i < partions; i++) {
                                    String concat = "";
                                    if (i == partions - 1) {
                                        for (int j = count; j < element.length(); j++) {
                                            char symbol = element.charAt(count);
                                            concat += symbol;
                                            count++;
                                        }
                                    } else {
                                        for (int j = 0; j < portionLength; j++) {
                                            char symbol = element.charAt(count);
                                            concat += symbol;
                                            count++;
                                        }
                                    }
                                    newList.add(concat);
                                }

                            }
                            inputValues.remove(index);
                            inputValues.addAll(index, newList);
                        }
                        break;
                }
                command = bfr.readLine();
            }

            for (String value : inputValues) {
                System.out.printf("%s ", value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}