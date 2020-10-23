import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StarEnigma {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String regex = "@([A-Za-z]+)[^@\\-!:>]*?:(\\d+)[^@\\-!:>]*?!([A|D])![^@\\-!:>]*?->(\\d+)";
        Pattern pattern = Pattern.compile(regex);
        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();

        int n = Integer.parseInt(bfr.readLine());
        for (int i = 0; i < n; i++) {
            int count = 0;
            String input = bfr.readLine();
            String inputCheck = input.toLowerCase();
            for (int j = 0; j < inputCheck.length(); j++) {
                if (inputCheck.charAt(j) == 's' || inputCheck.charAt(j) == 't' || inputCheck.charAt(j) == 'a' || inputCheck.charAt(j) == 'r') {
                    count++;
                }
            }

            List<Character> previousCharacters = new ArrayList<>();
            for (int j = 0; j < input.length(); j++) {
                char curr = input.charAt(j);
                char next = (char) (curr - count);
                previousCharacters.add(next);
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (Character character : previousCharacters) {
                stringBuilder.append(character);
            }

            String decrypted = stringBuilder.toString();
            Matcher matcher = pattern.matcher(decrypted);
            while (matcher.find()) {
                String planetName = matcher.group(1);
                char attackType = matcher.group(3).charAt(0);
                if (attackType == 'A') {
                    attackedPlanets.add(planetName);
                } else {
                    destroyedPlanets.add(planetName);
                }
            }

        }

        System.out.printf("Attacked planets: %d%n", attackedPlanets.size());
        if (attackedPlanets.size() != 0) {
            attackedPlanets.stream()
                    .sorted((a, b) -> a.compareTo(b))
                    .forEach(e -> System.out.printf("-> %s%n", e));
        }
        System.out.printf("Destroyed planets: %d%n", destroyedPlanets.size());
        if (destroyedPlanets.size() != 0) {
            destroyedPlanets.stream()
                    .sorted((a, b) -> a.compareTo(b))
                    .forEach(e -> System.out.printf("-> %s%n", e));
        }
    }
}
