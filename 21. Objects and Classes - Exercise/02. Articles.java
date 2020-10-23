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
            String[] articleData = bfr.readLine().split(", ");
            Article article = new Article(articleData[0], articleData[1], articleData[2]);

            int n = Integer.parseInt(bfr.readLine());
            for (int i = 0; i < n; i++) {
                String[] tokens = bfr.readLine().split(": ");
                switch (tokens[0]) {
                    case "Edit":
                        article.setContent(tokens[1]);
                        break;
                    case "ChangeAuthor":
                        article.setAuthor(tokens[1]);
                        break;
                    case "Rename":
                        article.setTitle(tokens[1]);
                        break;
                }
            }
            System.out.println(article.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Article {
        private String title;
        private String content;
        private String author;

        public Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }

        public String getAuthor() {
            return author;
        }

        @Override
        public String toString() {
            return String.format("%s - %s: %s", this.getTitle(), this.getContent(), this.getAuthor());
        }
    }
}

