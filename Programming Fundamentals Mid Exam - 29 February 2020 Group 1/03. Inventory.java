import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> items = new ArrayList<>(Arrays.asList(scanner.nextLine().split(", ")));
        String input = scanner.nextLine();
        while (!"Craft!".equals(input)) {
            String[] tokens = input.split(" - ");
            switch (tokens[0]) {
                case "Collect":
                    if (!items.contains(tokens[1])) {
                        items.add(tokens[1]);
                    }
                    break;
                case "Drop":
                    while (items.remove(tokens[1])) {}
                    break;
                case "Combine Items":
                    String[] oldAndNew = tokens[1].split(":");
                    if (items.contains(oldAndNew[0])) {
                        int index = 0;
                        for (int i = 0; i < items.size(); i++) {
                            if (items.get(i).equals(oldAndNew[0])) {
                                index = i;
                            }
                        }
                        items.add(index + 1, oldAndNew[1]);
                    }
                    break;
                case "Renew":
                    if (items.contains(tokens[1])) {
                        int indexToRemove = 0;
                        for (int i = 0; i < items.size(); i++) {
                            if (items.get(i).equals(tokens[1])) {
                                indexToRemove = i;
                            }
                        }
                        String removed = items.remove(indexToRemove);
                        items.add(removed);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(String.join(", ", items));
    }

}
















