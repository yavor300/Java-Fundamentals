package com.company;


import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.List;


public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            int pokePower = Integer.parseInt(bfr.readLine());
            int pokePowerOriginalValues = pokePower;
            int distance = Integer.parseInt(bfr.readLine());
            int exhaustionFactor = Integer.parseInt(bfr.readLine());
            int pokedTargets = 0;

            while (pokePower >= distance) {
                pokedTargets++;
                pokePower -= distance;
                if (pokePower == 0.5 * pokePowerOriginalValues && exhaustionFactor != 0) {
                    pokePower /= exhaustionFactor;
                }
            }
            System.out.println(pokePower);
            System.out.println(pokedTargets);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}