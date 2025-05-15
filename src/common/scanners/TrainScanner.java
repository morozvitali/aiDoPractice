package common.scanners;

import java.util.Scanner;

public class TrainScanner {
    public void scanning () {
        Scanner scanner = new Scanner(System.in);
        String sentense;
        while (true) {
            System.out.println("Please enter name and age");
            sentense = scanner.nextLine();
            if (!sentense.isEmpty()) {
                break;
            }
        }

        int age = Integer.parseInt(sentense.replaceAll("[^0-9]", ""));
        String name = sentense.replaceAll("[^a-zA-Z ]", "").trim();

        System.out.printf("Привіт, %s! Tвій вік: %d", name, age);
    }

    public static void main(String[] args) {
        TrainScanner trainScanner = new TrainScanner();
        trainScanner.scanning();
    }
}
