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
            boolean isItemObtained = false;

            Map<String, Integer> junkMaterials = new TreeMap<>();
            Map<String, Integer> keyMaterials = new LinkedHashMap<>();
            keyMaterials.put("motes", 0);
            keyMaterials.put("fragments", 0);
            keyMaterials.put("shards", 0);

            while (!isItemObtained) {
                String input = bfr.readLine().toLowerCase();
                String[] tokens = input.split("\\s+");

                List<String> materialsList = new ArrayList<>();
                List<Integer> quanityList = new ArrayList<>();
                for (int i = 0; i < tokens.length; i++) {
                    if (i % 2 == 0) {
                        quanityList.add(Integer.parseInt(tokens[i]));
                    } else {
                        materialsList.add(tokens[i]);
                    }
                }

                for (int i = 0; i < materialsList.size(); i++) {
                    if (keyMaterials.containsKey(materialsList.get(i))) {
                        keyMaterials.put(materialsList.get(i), keyMaterials.get(materialsList.get(i)) + quanityList.get(i));
                        for (Map.Entry<String, Integer> entry : keyMaterials.entrySet()) {
                            if (entry.getKey().equals("shards") && entry.getValue() >= 250) {
                                System.out.println("Shadowmourne obtained!");
                                keyMaterials.put("shards", keyMaterials.get("shards") - 250);
                                isItemObtained = true;
                                break;
                            } else if (entry.getKey().equals("fragments") && entry.getValue() >= 250) {
                                System.out.println("Valanyr obtained!");
                                keyMaterials.put("fragments", keyMaterials.get("fragments") - 250);
                                isItemObtained = true;
                                break;
                            } else if (entry.getKey().equals("motes") && entry.getValue() >= 250) {
                                System.out.println("Dragonwrath obtained!");
                                keyMaterials.put("motes", keyMaterials.get("motes") - 250);
                                isItemObtained = true;
                                break;
                            }
                        }
                        if (isItemObtained) {
                            break;
                        }
                    } else {
                        if (junkMaterials.containsKey(materialsList.get(i))) {
                            junkMaterials.put(materialsList.get(i), junkMaterials.get(materialsList.get(i)) + quanityList.get(i));
                        } else {
                            junkMaterials.put(materialsList.get(i), quanityList.get(i));
                        }
                    }
                }


            }

            keyMaterials.entrySet()
                    .stream()
                    .sorted((f, s) -> {
                        int firstComparison = s.getValue().compareTo(f.getValue());
                        if (firstComparison == 0) {
                            return f.getKey().compareTo(s.getKey());
                        }
                        return s.getValue().compareTo(f.getValue());
                    })
                    .forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));

            junkMaterials.entrySet()
                    .stream()
                    .forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

