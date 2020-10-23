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
            String inputSchedule = bfr.readLine();
            String[] scheduleArray = inputSchedule.split(", ");
            List<String> scheduleList = new ArrayList<>(Arrays.asList(scheduleArray));

            String command = bfr.readLine();
            while (!"course start".equals(command)) {
                String[] token = command.split(":");
                switch (token[0]) {
                    case "Add":
                        if (!scheduleList.contains(token[1])) {
                            scheduleList.add(token[1]);
                        }
                        break;

                    case "Insert":
                        if (Integer.parseInt(token[2]) >= 0 && Integer.parseInt(token[2]) < scheduleList.size() && !scheduleList.contains(token[1])) {
                            scheduleList.add(Integer.parseInt(token[2]), token[1]);
                        }
                        break;

                    case "Remove":
                        if (scheduleList.contains(token[1])) {
                            scheduleList.remove(token[1]);
                        }
                        if (scheduleList.contains(token[1] + "-Exercise")) {
                            scheduleList.remove(token[1] + "-Exercise");
                        }
                        break;

                    case "Swap":
                        int firstIndex = 0;
                        int secondIndex = 0;
                        if (scheduleList.contains(token[1]) && scheduleList.contains(token[2])) {
                            for (int i = 0; i < scheduleList.size(); i++) {
                                if (scheduleList.get(i).equals(token[1])) {
                                    firstIndex = i;
                                } else if (scheduleList.get(i).equals(token[2])) {
                                    secondIndex = i;
                                }
                            }
                            String firstElement = scheduleList.get(firstIndex);
                            String secondElement = scheduleList.get(secondIndex);
                            scheduleList.set(firstIndex, secondElement);
                            scheduleList.set(secondIndex, firstElement);

                            int exerciseIndexFirstElement = 0;
                            int exerciseIndexSecondElement = 0;

                            if (scheduleList.contains(token[1] + "-Exercise") || scheduleList.contains(token[2] + "-Exercise")) {
                                for (int i = 0; i < scheduleList.size(); i++) {
                                    if (scheduleList.get(i).equals(token[1] + "-Exercise")) {
                                        exerciseIndexFirstElement = i;
                                    } else if (scheduleList.get(i).equals(token[2] + "-Exercise")) {
                                        exerciseIndexSecondElement = i;
                                    }
                                }
                            }

                            if (scheduleList.contains(token[1] + "-Exercise")) {
                                scheduleList.add(secondIndex + 1, token[1] + "-Exercise");
                                scheduleList.remove(exerciseIndexFirstElement + 1);
                            }
                            if (scheduleList.contains(token[2] + "-Exercise")) {
                                scheduleList.add(firstIndex + 1, token[2] + "-Exercise");
                                scheduleList.remove(exerciseIndexSecondElement + 1);
                            }
                        }
                        break;

                    case "Exercise":
                        int lessonIndex = 0;
                        if (scheduleList.contains(token[1]) && !scheduleList.contains(token[1] + "-Exercise")) {
                            for (int i = 0; i < scheduleList.size(); i++) {
                                if (scheduleList.get(i).equals(token[1])) {
                                    lessonIndex = i;
                                }
                            }
                            scheduleList.add(lessonIndex + 1, token[1] + "-Exercise");
                        } else {
                            scheduleList.add(token[1]);
                            scheduleList.add(token[1] + "-Exercise");
                        }
                        break;
                }
                command = bfr.readLine();
            }
            for (int i = 0; i < scheduleList.size(); i++) {
                System.out.printf("%d.%s%n", i + 1, scheduleList.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}