🧪 ЗАДАЧА 5: Знайти всі рядки, які містять певне слово
🧠 Теорія:
Ми читаємо кожен рядок і перевіряємо, чи містить він слово за допомогою line.contains("слово").

📄 Умова:
Зчитати всі рядки з файлу input.txt, залишити тільки ті, що містять слово "error" (незалежно від регістру), та записати у errors.txt.

🔍 Підказки:
Перетвори рядок у нижній регістр: line.toLowerCase().contains("error")

Можна використовувати Predicate<String>

📌 Приклад:
input.txt

vbnet
Копіювати
Редагувати
All systems operational
Minor error occurred in module 1
Critical ERROR detected
Success
👉 Вихід (errors.txt):

vbnet
Копіювати
Редагувати
Minor error occurred in module 1
Critical ERROR detected
🧪 ЗАДАЧА 6: Записати лише унікальні рядки
🧠 Теорія:
Можна використовувати Set<String> для зберігання унікальних рядків. Якщо такий рядок уже був — пропустити.

📄 Умова:
Прочитати input.txt, записати в unique.txt лише унікальні (неповторні) рядки.

📌 Приклад:
input.txt

nginx
Копіювати
Редагувати
hello
world
hello
java
world
👉 Вихід (unique.txt):

nginx
Копіювати
Редагувати
hello
world
java
🔍 Підказка:
Використовуй Set<String> seen = new HashSet<>();

Додавай рядок у Set перед записом у файл

🧪 ЗАДАЧА 7: Видалити порожні рядки або ті, що складаються лише з пробілів
🧠 Теорія:
Порожні рядки не завжди мають довжину 0 — вони можуть містити пробіли. Метод line.trim().isEmpty() допоможе.

📄 Умова:
Прочитати input.txt, видалити усі порожні або «пусті» рядки, записати результат у cleaned.txt.

📌 Приклад:
input.txt

nginx
Копіювати
Редагувати
Hello


Java
👉 Вихід:

nginx
Копіювати
Редагувати
Hello
Java
🔍 Підказка:
if (line.trim().isEmpty()) continue;

🧪 ЗАДАЧА 8: Зберегти лише ті рядки, що мають парну кількість символів
🧠 Теорія:
Перевірка довжини: line.length() % 2 == 0

📄 Умова:
Зчитати файл, залишити лише ті рядки, довжина яких парна, і записати у even.txt.

📌 Приклад:
input.txt

bash
Копіювати
Редагувати
cat
doggy
java
code
👉 Вихід:

css
Копіювати
Редагувати
java
code
⚙ Формат реалізації (рекомендований):
Можеш зробити універсальний метод:

java
Копіювати
Редагувати
void filterLines(String inPath, String outPath, Predicate<String> filter)
І викликати його так:

java
Копіювати
Редагувати
filterLines("input.txt", "cleaned.txt", line -> !line.trim().isEmpty());
Хочеш, я зроблю шаблон класу для цих задач з методом filterLines(...), щоб ти міг просто передавати умову і не дублювати код?







Ви сказали:
так


Програма ChatGPT сказала:
Супер, Віталію! Ось тобі універсальний шаблон для задач з читанням/фільтрацією/записом рядків у файли — максимально зручно і гнучко: просто передаєш шлях до вхідного і вихідного файлу та Predicate<String> як умову фільтрації.

✅ LineProcessor.java — головний клас
java
Копіювати
Редагувати
package iostreams.util;

import java.io.*;
import java.util.function.Predicate;

public class LineProcessor {

    /**
     * Загальний метод для фільтрації рядків з одного файлу та запису у інший.
     *
     * @param inputPath  шлях до вхідного файлу
     * @param outputPath шлях до вихідного файлу
     * @param filter     Predicate, який визначає, чи записувати рядок
     * @throws IOException при помилках читання/запису
     */
    public static void filterLines(String inputPath, String outputPath, Predicate<String> filter) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                if (filter.test(line)) {
                    writer.write(line);
                    writer.newLine();
                }
            }
        }
    }
}
🚀 Як використовувати:
🧪 ЗАДАЧА 7 — прибрати порожні рядки
java
Копіювати
Редагувати
import iostreams.util.LineProcessor;
import java.io.IOException;

public class RemoveEmptyLines {
public static void main(String[] args) {
try {
LineProcessor.filterLines("input.txt", "cleaned.txt",
line -> !line.trim().isEmpty());
} catch (IOException e) {
System.out.println("Помилка обробки файлу: " + e.getMessage());
}
}
}
🧪 ЗАДАЧА 5 — фільтрація по слову error:
java
Копіювати
Редагувати
LineProcessor.filterLines("log.txt", "errors.txt",
line -> line.toLowerCase().contains("error"));
🧪 ЗАДАЧА 8 — тільки рядки з парною довжиною:
java
Копіювати
Редагувати
LineProcessor.filterLines("input.txt", "even.txt",
line -> line.length() % 2 == 0);
🧠 Бонус: комбіновані умови
java
Копіювати
Редагувати
Predicate<String> notEmpty = line -> !line.trim().isEmpty();
Predicate<String> containsJava = line -> line.contains("Java");

LineProcessor.filterLines("notes.txt", "filtered.txt",
notEmpty.and(containsJava));
🔥 Переваги:
1 файл → багато задач.

Вся логіка фільтрації — у Predicate (лямбда).

Можна легко тестувати й розширювати.