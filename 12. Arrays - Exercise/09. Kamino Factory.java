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
            int dnaLength = Integer.parseInt(bfr.readLine());
            String input = bfr.readLine();
            if (input.length() == 1) {
                System.out.printf("Best DNA sample 1 with sum: %d.%n", Integer.parseInt(input));
                System.out.print(Integer.parseInt(input));
                return;
            }
            int[] winningSequence = new int[dnaLength];
            int max = Integer.MIN_VALUE;
            int winningSequenceNumber = 0;
            int iterator = 0;
            int winningIndex = 0;
            while (!"Clone them!".equals(input)) {
                iterator++;
                String[] dnaSequenceString = input.split("!+");
                int[] dnaSequence = new int[dnaSequenceString.length];
                for (int i = 0; i < dnaSequenceString.length; i++) {
                    dnaSequence[i] = Integer.parseInt(dnaSequenceString[i]);
                }

                int count = 0;
                int startingIndex = 0;


                for (int i = 0; i < dnaSequence.length - 1; i++) {
                    if (dnaSequence[i] == dnaSequence[i + 1] && dnaSequence[i] == 1) {
                        count++;
                        startingIndex = i - count + 1;
                    } else {
                        count = 0;
                    }
                    if (count > max) {
                        max = count;
                        winningSequenceNumber = iterator;
                        winningIndex = startingIndex;
                        winningSequence = dnaSequence;
                    } else if (count == max) {
                        if (startingIndex < winningIndex) {
                            winningIndex = startingIndex;
                            winningSequence = dnaSequence;
                            winningSequenceNumber = iterator;
                        } else if (startingIndex == winningIndex) {
                            int sumFirst = 0;
                            int sumSecond = 0;
                            for (int j = 0; j < winningSequence.length; j++) {
                                sumFirst += winningSequence[i];
                            }
                            for (int j = 0; j < dnaSequence.length; j++) {
                                sumSecond += dnaSequence[i];
                            }
                            if (sumSecond > sumFirst) {
                                winningIndex = startingIndex;
                                winningSequence = dnaSequence;
                                winningSequenceNumber = iterator;
                            }
                        }
                    }
                }
                input = bfr.readLine();
            }
            int sumWinner = 0;
            for (int i = 0; i < winningSequence.length; i++) {
                sumWinner += winningSequence[i];
            }
            System.out.printf("Best DNA sample %d with sum: %d.%n", winningSequenceNumber, sumWinner);
            for (int i = 0; i < winningSequence.length; i++) {
                System.out.print(winningSequence[i] + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}