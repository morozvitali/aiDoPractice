package common.scanners;

import java.util.Scanner;

public class TrainScanner2 {
    public void printer () {
        System.out.println("Введіть ім'я і вік");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int age = Integer.parseInt(input.replaceAll("[^0-9]", ""));
        String name = input.replaceAll("[^a-zA-Z ]", "").trim();
    }
}
