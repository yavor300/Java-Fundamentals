import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int initialHealth = 100;
        int initialBitcoins = 0;
        String[] rooms = scanner.nextLine().split("\\|");
        for (int i = 0; i < rooms.length; i++) {
            String[] tokens = rooms[i].split("\\s+");
            switch (tokens[0]) {
                case "potion":
                    int potionedHealth = initialHealth + Integer.parseInt(tokens[1]);
                    if (potionedHealth > 100) {
                        System.out.printf("You healed for %d hp.%nCurrent health: %d hp.%n", 100 - initialHealth, 100);
                        initialHealth = 100;
                    } else {
                        initialHealth = potionedHealth;
                        System.out.printf("You healed for %d hp.%nCurrent health: %d hp.%n", Integer.parseInt(tokens[1]), initialHealth);
                    }

                    break;

                case "chest":
                    System.out.printf("You found %d bitcoins.%n", Integer.parseInt(tokens[1]));
                    initialBitcoins += Integer.parseInt(tokens[1]);
                    break;
                default:
                    initialHealth -= Integer.parseInt(tokens[1]);
                    if (initialHealth > 0) {
                        System.out.printf("You slayed %s.%n", tokens[0]);
                    } else {
                        System.out.printf("You died! Killed by %s.%n", tokens[0]);
                        System.out.printf("Best room: %d%n", i + 1);
                        return;
                    }
                    break;
            }
        }
        System.out.println("You've made it!");
        System.out.printf("Bitcoins: %d%nHealth: %d", initialBitcoins, initialHealth);
    }

}
















