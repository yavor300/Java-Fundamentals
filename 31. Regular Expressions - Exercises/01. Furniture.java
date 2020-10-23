import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String regex = ">>([A-Za-z]+)<<(\\d+.?\\d+)!(\\d+)";
        Pattern pattern = Pattern.compile(regex);
        String input = bfr.readLine();
        double totalSum = 0;
        List<String> furniture = new ArrayList<>();
        while (!"Purchase".equals(input)) {
            Matcher matcher = pattern.matcher(input);
            int count = matcher.groupCount();
            if (count == 3) {
                while (matcher.find()) {
                    String item = matcher.group(1);
                    furniture.add(item);
                    double price = Double.parseDouble(matcher.group(2));
                    int quantity = Integer.parseInt(matcher.group(3));
                    totalSum += price * quantity;
                }
            }
            input = bfr.readLine();
        }

        System.out.println("Bought furniture:");
        for (String s : furniture) {
            System.out.println(s);
        }
        System.out.printf("Total money spend: %.2f", totalSum);

    }
}
