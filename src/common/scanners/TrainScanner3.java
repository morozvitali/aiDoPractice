package common.scanners;

import java.util.Scanner;

public class TrainScanner3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter your name and age:");
        String input = scanner.nextLine().trim();
        String name = input.replaceAll("[^a-zA-Z ]", "");
        System.out.println("your name is " + name);

        String ageParsing = input.replaceAll("[^0-9]", "");
        int age = 0;
        if (ageParsing.equals("")) {
            System.out.println("цифр не знайдено");
        } else {
            age = Integer.parseInt(ageParsing);
            System.out.println("your age is " + age);
        }
    }
}