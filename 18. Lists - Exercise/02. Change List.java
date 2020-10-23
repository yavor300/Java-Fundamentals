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

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            int[] wagonsArray = parseLineOfNumbers(bfr.readLine());
            List<Integer> wagons = new ArrayList<>();
            for (int i : wagonsArray) {
                wagons.add(i);
            }
            String input = bfr.readLine();
            while (!"end".equals(input)) {
                String[] tokens = input.split("\\s+");
                switch (tokens[0]) {
                    case "Delete":
                        if (wagons.contains(Integer.parseInt(tokens[1]))) {
                            while(wagons.remove(Integer.valueOf(tokens[1]))) {}
                        }

                        break;
                    case "Insert":
                        if (Integer.parseInt(tokens[2]) >= 0 && Integer.parseInt(tokens[2]) < wagons.size()) {
                            wagons.add(Integer.parseInt(tokens[2]), Integer.parseInt(tokens[1]));
                        }
                        break;
                }
                input = bfr.readLine();
            }

            if (wagons.size() > 0) {
                for (Integer wagon : wagons) {
                    System.out.printf("%d ", wagon);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}