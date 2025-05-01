🧪 ЗАДАЧА 1: Порахувати кількість рядків у файлі
📄 Умова:
Напиши програму, яка відкриває текстовий файл і рахує кількість рядків у ньому.

✅ Очікувана логіка:
Відкрити файл через BufferedReader.
Зчитувати рядки один за одним (readLine()).
Для кожного рядка — збільшити лічильник.
Після завершення — вивести кількість.

🧾 Приклад вхідного файлу (example.txt):

Hello world
This is Java
BufferedReader test
👉 Вихід: 3

🔧 Код для реалізації:

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LineCounter {
public static void main(String[] args) {
int lineCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("example.txt"))) {
            while (reader.readLine() != null) {
                lineCount++;
            }
            System.out.println("Кількість рядків у файлі: " + lineCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
📌 Рекомендації:
Використовуй try-with-resources, щоб не забути закрити файл.
Працюй із .readLine() != null — це найбезпечніший спосіб.