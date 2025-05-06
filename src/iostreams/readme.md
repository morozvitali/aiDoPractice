Посилання на класи io
https://docs.oracle.com/javase/8/docs/api/java/io/Reader.html
https://docs.oracle.com/javase/8/docs/api/java/io/InputStreamReader.html
https://docs.oracle.com/javase/8/docs/api/java/io/BufferedReader.html

Привіт, Віталію! Чудове бажання — потоки введення/виведення (I/O streams)
— це дуже важлива тема в Java, особливо коли працюєш із файлами, мережею
чи великими обсягами тексту. Давай поетапно: теорія → приклади → практика → завдання. Почнемо!

📚 Теорія: Потоки в Java
1. Що таке потік?
   У Java потік (stream) — це абстракція послідовності даних. Є два типи:

InputStream / Reader — для читання.

OutputStream / Writer — для запису.

2. Основні класи:

Категорія	                              Базові класи	                Опис
Байт-потоки	                              InputStream, OutputStream	    Для роботи з байтами (файли, зображення)
Символьні потоки	                      Reader, Writer	            Для роботи з текстом (UTF-8, Unicode)
✏️ BufferedReader / BufferedWriter
Ці класи належать до символьних потоків. Вони обгортають інші потоки (наприклад, FileReader, FileWriter) для підвищення продуктивності.

BufferedReader: читає текст рядками або символами.
має метод readLine() — читає рядок до символу нового рядка.

BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
String line = reader.readLine();
reader.close();

BufferedWriter: дозволяє буферизовано записувати символи або рядки.
має метод write(String) + newLine().

BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
writer.write("Привіт, Віталію!");
writer.newLine();
writer.close();

🔁 Читання та запис буферизовані = зменшення системних викликів → швидше.

🛠 Приклад: Читання з одного файлу, запис в інший

import java.io.*;

public class FileCopy {
public static void main(String[] args) {
try (
BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))
) {
String line;
while ((line = reader.readLine()) != null) {
writer.write(line);
writer.newLine();
}
} catch (IOException e) {
e.printStackTrace();
}
}
}
🧪 Завдання для практики
1. Практика 1: Порахувати кількість рядків у файлі
   Задача: відкрий файл, порахуй скільки в ньому рядків.

2. Практика 2: Знайти найдовший рядок
   Задача: зчитати всі рядки і вивести той, у якому найбільше символів.

3. Практика 3: Записати до файлу всі слова з великої літери
   Задача: зчитати рядки, зробити .toUpperCase() для кожного, записати в інший файл.

🧠 Тест на розуміння
Що з цього не відноситься до BufferedReader?

a) readLine()
b) write(String)
c) close()
d) ready()

🔹 Правильна відповідь: b) — це метод BufferedWriter.

💡 Додатково
Коли використовувати BufferedReader?
коли читаєш великий файл пострічково.

коли потрібна ефективність.

Порівняння:

Клас	Продуктивність	Зручність
FileReader/FileWriter	Повільніше	Прості
BufferedReader/Writer	Швидше	Потрібен try-with-resources
Хочеш, я зроблю тобі інтерактивні тести, чи почнемо із задач №1–3 та розв’яжемо разом?