🎮 Консольна гра: "Як вигукнути фразу?"

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
        scanner.nextLine(); // зчитує Enter

        switch (choice) {
            case 1 -> printer.setStrategy(s -> s.toUpperCase());
            case 2 -> printer.setStrategy(s -> s.toLowerCase());
            case 3 -> printer.setStrategy(s -> new StringBuilder(s).reverse().toString());
            case 4 -> printer.setStrategy(s -> String.join(" ", s.split("")));
            default -> {
                System.out.println("🙃 Невірний вибір. За замовчуванням — пошепки.");
                printer.setStrategy(s -> s.toLowerCase());
            }
        }

        printer.print(phrase);
    }
}
🧪 Як воно працює:
Користувач вводить фразу.
Обирає тип трансформації (стратегію).
Програма застосовує відповідну лямбда-функцію до введеного рядка.
Виводить результат.

🧠 Поглиблення:
Це не лише гра — це реальна демонстрація патерну Strategy в живій системі. А тепер уяви, як легко ти можеш:
Додати нову стратегію (напр., "перетворити у Pig Latin").
Замінити консоль на графічний інтерфейс або веб-форму.
Під’єднати через Spring як @Service.