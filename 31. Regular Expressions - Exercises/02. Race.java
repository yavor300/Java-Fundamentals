import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String regex = "([A-Za-z])|([\\d])";
        Pattern pattern = Pattern.compile(regex);
        List<String> names = new ArrayList<>(Arrays.asList(bfr.readLine().split(", ")));
        Map<String, Integer> competitors = new LinkedHashMap<>();
        String nameOfCompetitor = "";
        int distance = 0;
        String input = bfr.readLine();
        while (!"end of race".equals(input)) {
            List<String> nameChars = new ArrayList<>();
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                if (matcher.group(1) != null) {
                    nameChars.add(matcher.group(1));
                }
                nameOfCompetitor = String.join("", nameChars);
                if (matcher.group(2) != null) {
                    distance += Integer.parseInt(matcher.group(2));
                }
            }
            if (names.contains(nameOfCompetitor)) {
                if (competitors.containsKey(nameOfCompetitor)) {
                    int oldDistance = competitors.get(nameOfCompetitor);
                    competitors.put(nameOfCompetitor, oldDistance + distance);
                } else {
                    competitors.put(nameOfCompetitor, distance);
                }
            }
            nameOfCompetitor = "";
            distance = 0;
            input = bfr.readLine();
        }

        Map<String, Integer> topThree = competitors.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .limit(3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        List<String> winners = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : topThree.entrySet()) {
            winners.add(entry.getKey());
        }

        for (int i = 0; i < winners.size(); i++) {
            if (i == 0) {
                System.out.printf("1st place: %s%n", winners.get(i));
            } else if (i == 1) {
                System.out.printf("2nd place: %s%n", winners.get(i));
            } else {
                System.out.printf("3rd place: %s%n", winners.get(i));
            }
        }

    }
}
