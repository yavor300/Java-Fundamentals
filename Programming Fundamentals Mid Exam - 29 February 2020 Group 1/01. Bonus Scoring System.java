import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int studentsCount = Integer.parseInt(scanner.nextLine());
        int lecturesCount = Integer.parseInt(scanner.nextLine());
        int initialBonus = Integer.parseInt(scanner.nextLine());

        double max = Double.MIN_VALUE;
        int attendancesWinnerCount = 0;
        for (int i = 0; i < studentsCount; i++) {
            int attendances = Integer.parseInt(scanner.nextLine());
            double bonus = 0;
            bonus = (double) attendances / lecturesCount * (5 + initialBonus);
            if (bonus >= max) {
                max = bonus;
                attendancesWinnerCount = attendances;
            }
        }
        if (studentsCount == 0) {
            System.out.printf("Max Bonus: 0.%nThe student has attended 0 lectures.");
        } else {
            System.out.printf("Max Bonus: %.0f.%nThe student has attended %d lectures.", Math.ceil(max), attendancesWinnerCount);

        }


    }

}
















