import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BarIncome {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String regex = "%([A-z][a-z]+)%[^|?%.]*?<(\\w+)>[^|?%.]*?\\|(\\d+)\\|[^|?%.]*?(\\d+\\.?\\d+)\\$";
        Pattern pattern = Pattern.compile(regex);
        double totalPrice = 0;
        String input = bfr.readLine();
        while (!"end of shift".equals(input)) {
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                String customerName = matcher.group(1);
                String product = matcher.group(2);
                int quantity = Integer.parseInt(matcher.group(3));
                double price = quantity * Double.parseDouble(matcher.group(4));
                totalPrice += price;
                System.out.printf("%s: %s - %.2f%n", customerName, product, price);
            }
            input = bfr.readLine();
        }
        System.out.printf("Total income: %.2f",totalPrice);
    }
}
