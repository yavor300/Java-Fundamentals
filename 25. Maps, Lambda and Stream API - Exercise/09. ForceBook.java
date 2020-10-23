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
            Map<String, List<String>> forceSidesUsers = new LinkedHashMap<>();
            List<String> allUsers = new ArrayList<>();
            while (!"Lumpawaroo".equals(input)) {
                if (input.contains("|")) {
                    String[] tokens = input.split(" \\| ");
                    List<String> users = forceSidesUsers.get(tokens[0]);
                    if (users == null) {
                        users = new ArrayList<>();
                        forceSidesUsers.put(tokens[0], users);
                    }
                    if (!allUsers.contains(tokens[1])) {
                        users.add(tokens[1]);
                        allUsers.add(tokens[1]);
                    }
                } else {
                    List<String> users;
                    String[] tokens = input.split(" -> ");

                    if (!forceSidesUsers.containsKey(tokens[1])) {
                        forceSidesUsers.put(tokens[1], new ArrayList<>());
                        for (Map.Entry<String, List<String>> entry : forceSidesUsers.entrySet()) {
                            if (entry.getValue().contains(tokens[0])) {
                                entry.getValue().remove(tokens[0]);
                                break;
                            }
                        }

                        forceSidesUsers.get(tokens[1]).add(tokens[0]);
                        System.out.printf("%s joins the %s side!%n", tokens[0], tokens[1]);
                    } else {
                        boolean isExisting = false;
                        for (Map.Entry<String, List<String>> entry : forceSidesUsers.entrySet()) {
                            users = entry.getValue();
                            for (String existingUser : users) {
                                if (existingUser.equals(tokens[0])) {
                                    isExisting = true;
                                    users.remove(tokens[0]);
                                    users = forceSidesUsers.get(tokens[1]);
                                    users.add(tokens[0]);
                                    System.out.printf("%s joins the %s side!%n", tokens[0], tokens[1]);
                                    break;
                                }
                                if (isExisting) {
                                    break;
                                }
                            }
                        }

                        if (!isExisting) {
                            users = forceSidesUsers.get(tokens[1]);
                            users.add(tokens[0]);
                            allUsers.add(tokens[0]);
                            System.out.printf("%s joins the %s side!%n", tokens[0], tokens[1]);
                        }
                    }

                }
                input = bfr.readLine();
            }

            forceSidesUsers.entrySet()
                    .stream()
                    .sorted((f, s) -> {
                        if (s.getValue().size() == f.getValue().size()) {
                            return f.getKey().compareTo(s.getKey());
                        }
                        return Integer.compare(s.getValue().size(), f.getValue().size());
                    })
                    .forEach(side -> {
                        List<String> users = side.getValue();
                        users.sort(Comparator.naturalOrder());
                        if (side.getValue().size() > 0) {
                            System.out.printf("Side: %s, Members: %d%n", side.getKey(), side.getValue().size());
                            for (String user : users) {
                                System.out.printf("! %s%n", user);
                            }

                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}