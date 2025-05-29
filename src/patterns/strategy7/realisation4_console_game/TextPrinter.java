package patterns.strategy7.realisation4_console_game;

import java.util.Scanner;
import java.util.function.Function;

public class TextPrinter {

    private Function<String, String> strategy;

    public void setStrategy(Function<String, String> strategy) {
        this.strategy = strategy;
    }

    public void print(String text) {
        System.out.println("👉 Результат: " + strategy.apply(text));
    }

    /// --------------------- Main ----------------------- ///
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TextPrinter printer = new TextPrinter();

        System.out.println("🎤 Введи фразу, яку хочеш вигукнути:");
        String phrase = scanner.nextLine();
        System.out.println("""
                🔊 Обери стиль вигуку:
                1 — ГРОМКО (великі літери)
                2 — пошепки (малі літери)
                3 — задом наперед
                4 — драматично з пробілами
                """);
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> printer.setStrategy(s -> s.toUpperCase());
            case 2 -> printer.setStrategy(s -> s.toLowerCase());
            case 3 -> printer.setStrategy(s -> new StringBuilder(s).reverse().toString());
            case 4 -> printer.setStrategy(s -> String.join(" ", s.split("")));
            default -> {
                System.out.println("Невірний вибір. За замовчуванням — пошепки");
                printer.setStrategy(s -> s.toLowerCase());
            }
        }
        printer.print(phrase);
    }
}
