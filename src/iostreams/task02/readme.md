🧪 ЗАДАЧА 2: Знайти найдовший рядок у файлі
📄 Умова:
Напиши програму, яка відкриває файл і знаходить рядок 
із найбільшою кількістю символів (включно з пробілами). 
Вивести сам рядок і його довжину.

🔧 Логіка:
Відкрити файл (BufferedReader).
Зчитувати кожен рядок.
Для кожного рядка:
Якщо його довжина > поточного максимуму → зберегти цей рядок.
Наприкінці — вивести результат.

🧾 Вміст файлу example.txt:
Java
BufferedReader is cool
Stream API

👉 Вихід:
Найдовший рядок: BufferedReader is cool
Довжина: 23

🧠 Реалізація:
import java.io.*;

public class LongestLineFinder {
public static void main(String[] args) {
String longestLine = "";
int maxLength = 0;

try (BufferedReader reader = new BufferedReader
(new FileReader("example.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.length() > maxLength) {
                    maxLength = line.length();
                    longestLine = line;
                }
            }
            System.out.println("Найдовший рядок: " + longestLine);
            System.out.println("Довжина: " + maxLength);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

🔍 Варіації для самостійної перевірки:
Що буде, якщо файл порожній?
Що, якщо два рядки однакової довжини?