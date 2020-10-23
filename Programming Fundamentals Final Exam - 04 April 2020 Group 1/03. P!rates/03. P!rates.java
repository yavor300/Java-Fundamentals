package com.company;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {



    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            String input = bfr.readLine();

            Map<String, Details> targetedCities = new LinkedHashMap<>();



            while (!"Sail".equals(input)) {
                String[] tokens = input.split("\\|\\|");
                String cityName = tokens[0];
                int populaiton = Integer.parseInt(tokens[1]);
                int gold = Integer.parseInt(tokens[2]);

                if (targetedCities.containsKey(cityName)) {
                    Details details = targetedCities.get(cityName);
                    details.setPopulation(details.getPopulation() + populaiton);
                    details.setGold(details.getGold() + gold);
                } else {
                    Details details = new Details(populaiton, gold);
                    targetedCities.put(cityName, details);
                }
                input = bfr.readLine();
            }

            String event = bfr.readLine();
            while (!"End".equals(event)) {
                String[] tokens = event.split("=>");

                switch (tokens[0]) {
                    case "Plunder":
                        String town = tokens[1];
                        int population = Integer.parseInt(tokens[2]);
                        int gold = Integer.parseInt(tokens[3]);

                        System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town, gold, population);

                        Details details = targetedCities.get(town);

                        int leftPopulation = details.getPopulation() - population;
                        int leftGold = details.getGold() - gold;

                        if (leftPopulation == 0 || leftGold == 0) {
                            targetedCities.remove(town);
                            System.out.printf("%s has been wiped off the map!%n", town);
                        } else {
                            details.setGold(details.getGold() - gold);
                            details.setPopulation(details.getPopulation() - population);
                        }
                        break;

                    case "Prosper":
                        String city = tokens[1];
                        int goldToIncrease = Integer.parseInt(tokens[2]);

                        if (goldToIncrease < 0) {
                            System.out.println("Gold added cannot be a negative number!");
                        } else {
                            Details detailsForIncrease = targetedCities.get(city);
                            int existingGoldBeforeIncreasing = detailsForIncrease.getGold();
                            detailsForIncrease.setGold(detailsForIncrease.getGold() + goldToIncrease);
                            System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", goldToIncrease, city, existingGoldBeforeIncreasing + goldToIncrease);
                        }
                        break;
                }

                event = bfr.readLine();
            }

            if (targetedCities.size() > 0) {
                System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", targetedCities.size());
                targetedCities.entrySet().stream().sorted((f, s) -> {
                    int firstComparison = Integer.compare(s.getValue().getGold(), f.getValue().getGold());
                    if (firstComparison == 0) {
                        return f.getKey().compareTo(s.getKey());
                    }

                    return firstComparison;
                })
                        .forEach(c -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", c.getKey(), c.getValue().getPopulation(), c.getValue().getGold()));
            } else {
                System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Details {
        private int population;
        private int gold;

        public Details(int population, int gold) {
            this.population = population;
            this.gold = gold;
        }

        public int getPopulation() {
            return population;
        }

        public void setPopulation(int population) {
            this.population = population;
        }

        public int getGold() {
            return gold;
        }

        public void setGold(int gold) {
            this.gold = gold;
        }
    }
}

