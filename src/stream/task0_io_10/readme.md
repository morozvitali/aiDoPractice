🔹 Завдання 1. Прочитати файл і вивести на екран
-
📋 Умова:
Створіть програму, яка зчитує файл input.txt і виводить його вміст у консоль.

💡 Підказка:
Використайте FileReader разом із BufferedReader для построчного зчитування.

✅ Рішення:

try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
String line;
while ((line = br.readLine()) != null) {
System.out.println(line);
}
} catch (IOException e) {
e.printStackTrace();
}


🔄 Альтернативне рішення (Java 11+):

Files.lines(Path.of("input.txt")).forEach(System.out::println);


📚 Теорія:
FileReader читає символи з файлу, а BufferedReader зменшує кількість звернень до диску, читаючи блоками.

🔹 Завдання 2. Порахувати кількість рядків у файлі
-
📋 Умова:
Порахуйте кількість рядків у файлі input.txt.

💡 Підказка:
Можна лічити рядки в циклі while (br.readLine() != null).

✅ Рішення:

int count = 0;
try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
while (br.readLine() != null) {
count++;
}
} catch (IOException e) {
e.printStackTrace();
}
System.out.println("Кількість рядків: " + count);


🔄 Альтернативне рішення (Stream API):

long count = Files.lines(Path.of("input.txt")).count();
System.out.println("Кількість рядків: " + count);


📚 Теорія:
BufferedReader.readLine() повертає null, коли файл закінчується.

🔹 Завдання 3. Записати текст у файл
-
📋 Умова:
Запишіть рядок "Hello, Java!" у файл output.txt.

💡 Підказка:
Використайте FileWriter або BufferedWriter.

✅ Рішення:

try (BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {
bw.write("Hello, Java!");
} catch (IOException e) {
e.printStackTrace();
}


🔄 Альтернативне рішення (Java 11+):

Files.writeString(Path.of("output.txt"), "Hello, Java!");


📚 Теорія:
FileWriter пише символи у файл, а BufferedWriter накопичує дані в пам’яті і записує їх пачками, що швидше.

🔹 Завдання 4. Копіювати один файл в інший
-
📋 Умова:
Прочитайте вміст input.txt і запишіть його у copy.txt.

💡 Підказка:
Використайте цикл зчитування рядків і запис їх у BufferedWriter.

✅ Рішення:

try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));
BufferedWriter bw = new BufferedWriter(new FileWriter("copy.txt"))) {

    String line;
    while ((line = br.readLine()) != null) {
        bw.write(line);
        bw.newLine(); // додати перехід рядка
    }
} catch (IOException e) {
e.printStackTrace();
}


🔄 Альтернативне рішення (Java 7+):

Files.copy(Path.of("input.txt"), Path.of("copy.txt"), StandardCopyOption.REPLACE_EXISTING);


📚 Теорія:
BufferedReader зчитує рядки, а BufferedWriter дозволяє зручно їх записати з переносом рядка.

🔹 Завдання 5. Записати лог з датою і часом
-
📋 Умова:
Запишіть у файл log.txt повідомлення "Program started" разом з поточною датою та часом.

💡 Підказка:
Використайте LocalDateTime.now() і BufferedWriter у режимі append (true).

✅ Рішення:

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

try (BufferedWriter bw = new BufferedWriter(new FileWriter("log.txt", true))) {
String log = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
+ " - Program started";
bw.write(log);
bw.newLine();
} catch (IOException e) {
e.printStackTrace();
}


🔄 Альтернативне рішення (Java 11+):

String log = LocalDateTime.now() + " - Program started\n";
Files.writeString(Path.of("log.txt"), log, StandardOpenOption.CREATE, StandardOpenOption.APPEND);


📚 Теорія:
Файл можна відкрити у режимі append, щоб не перезаписувати попередні записи, а додавати нові.

🔹 Завдання 6. Порахувати кількість слів у файлі
-
📋 Умова:
Прочитайте input.txt і порахуйте, скільки слів у файлі (слова розділені пробілами).

💡 Підказка:
line.split("\\s+") дає масив слів у рядку.

✅ Рішення:

int wordCount = 0;
try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
String line;
while ((line = br.readLine()) != null) {
wordCount += line.split("\\s+").length;
}
} catch (IOException e) {
e.printStackTrace();
}
System.out.println("Кількість слів: " + wordCount);


🔄 Альтернативне рішення (Stream API):

long wordCount = Files.lines(Path.of("input.txt"))
.flatMap(line -> Arrays.stream(line.split("\\s+")))
.count();
System.out.println("Кількість слів: " + wordCount);


📚 Теорія:
split("\\s+") ділить рядок за будь-якою кількістю пробілів/табів.

🔹 Завдання 7. Знайти рядки з певним словом
-
📋 Умова:
Виведіть усі рядки з файлу input.txt, які містять слово "Java".

💡 Підказка:
line.contains("Java").

✅ Рішення:

try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
String line;
while ((line = br.readLine()) != null) {
if (line.contains("Java")) {
System.out.println(line);
}
}
} catch (IOException e) {
e.printStackTrace();
}


🔄 Альтернативне рішення (Stream API):

Files.lines(Path.of("input.txt"))
.filter(line -> line.contains("Java"))
.forEach(System.out::println);


📚 Теорія:
Пошук за підрядком (contains) простіший за RegExp, але працює швидше.

🔹 Завдання 8. Порахувати кількість символів у файлі
-
📋 Умова:
Обчисліть, скільки символів (включаючи пробіли) міститься у файлі input.txt.

💡 Підказка:
Можна рахувати line.length() для кожного рядка.

✅ Рішення:

int charCount = 0;
try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
String line;
while ((line = br.readLine()) != null) {
charCount += line.length();
}
} catch (IOException e) {
e.printStackTrace();
}
System.out.println("Кількість символів: " + charCount);


🔄 Альтернативне рішення (Java 11+):

long charCount = Files.readString(Path.of("input.txt")).length();
System.out.println("Кількість символів: " + charCount);


📚 Теорія:
Метод length() працює з кількістю символів у рядку (не байтів).

🔹 Завдання 9. Записати тільки унікальні рядки у новий файл
-
📋 Умова:
Прочитайте файл input.txt і створіть unique.txt, у який запишіть тільки унікальні рядки.

💡 Підказка:
Можна використати Set для збереження лише унікальних рядків.

✅ Рішення:

Set<String> uniqueLines = new HashSet<>();

try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));
BufferedWriter bw = new BufferedWriter(new FileWriter("unique.txt"))) {

    String line;
    while ((line = br.readLine()) != null) {
        if (uniqueLines.add(line)) { // true тільки якщо рядка ще не було
            bw.write(line);
            bw.newLine();
        }
    }
} catch (IOException e) {
e.printStackTrace();
}


🔄 Альтернативне рішення (Stream API):

Files.lines(Path.of("input.txt"))
.distinct()
.forEach(line -> {
try {
Files.writeString(Path.of("unique.txt"), line + "\n",
StandardOpenOption.CREATE, StandardOpenOption.APPEND);
} catch (IOException e) {
e.printStackTrace();
}
});


📚 Теорія:
HashSet не дозволяє дублікати, тому зручно відфільтровувати унікальні рядки.

🔹 Завдання 10. Перетворити всі літери на великі і зберегти у файл
-
📋 Умова:
Прочитайте файл input.txt, перетворіть усі літери на великі (toUpperCase()) і запишіть результат у upper.txt.

💡 Підказка:
Використовуйте line.toUpperCase().

✅ Рішення:

try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));
BufferedWriter bw = new BufferedWriter(new FileWriter("upper.txt"))) {

    String line;
    while ((line = br.readLine()) != null) {
        bw.write(line.toUpperCase());
        bw.newLine();
    }
} catch (IOException e) {
e.printStackTrace();
}


🔄 Альтернативне рішення (Stream API):

Files.lines(Path.of("input.txt"))
.map(String::toUpperCase)
.forEach(line -> {
try {
Files.writeString(Path.of("upper.txt"), line + "\n",
StandardOpenOption.CREATE, StandardOpenOption.APPEND);
} catch (IOException e) {
e.printStackTrace();
}
});

📚 Теорія:
Метод toUpperCase() працює з кожним символом рядка і повертає новий рядок.

---------------------------theory-------------------------------



📚 План навчання по роботі з файлами (Java I/O)
🔹 Етап 1. Основи читання і запису

👉 Ціль: навчитися відкривати файл, читати його вміст і щось записувати.

Завдання 1. Прочитати файл і вивести на екран.
Завдання 3. Записати текст у файл.
Завдання 5. Записати лог з датою і часом (режим append).

🔹 Етап 2. Циклічне читання і підрахунок

👉 Ціль: тренування на повторення і базові операції.

Завдання 2. Порахувати кількість рядків у файлі.
Завдання 6. Порахувати кількість слів у файлі.
Завдання 8. Порахувати кількість символів у файлі.

🔹 Етап 3. Фільтрація та пошук

👉 Ціль: навчитися обробляти умови при читанні.

Завдання 7. Знайти рядки з певним словом.
Завдання 10. Перетворити всі літери на великі і зберегти у файл.

🔹 Етап 4. Копіювання і унікальні дані

👉 Ціль: потренувати комбіновані сценарії (читання + запис).

Завдання 4. Копіювати один файл в інший.
Завдання 9. Записати тільки унікальні рядки у новий файл.

🔹 Етап 5. Альтернативні підходи (для закріплення)

👉 Ціль: побачити, що ті самі завдання можна вирішити коротше через 
Files.* (Java 8–11).

Перепробуйте усі задачі ще раз, але вже з альтернативними рішеннями 
(Files.lines, Files.writeString, Files.copy).

✅ Таким чином у вас вийде логічна прогресія:
читання → запис → підрахунок → пошук → копіювання → унікальність →
альтернативні API.

---------------------------чек-ліст----------------------------

📋 Чек-ліст: Java I/O (FileReader, BufferedReader, FileWriter, BufferedWriter)
🔹 Етап 1. Основи читання і запису

Умію відкрити файл на читання (FileReader + BufferedReader).
Умію відкрити файл на запис (FileWriter + BufferedWriter).
Умію вивести вміст файлу на консоль.
Умію записати рядок у файл.
Умію записати текст у файл у режимі append (не перезаписувати, а додавати).

🔹 Етап 2. Циклічне читання і підрахунок

Умію рахувати кількість рядків у файлі.
Умію рахувати кількість слів у файлі.
Умію рахувати кількість символів у файлі.
Розумію різницю між line.length() і підрахунком байтів.

🔹 Етап 3. Фільтрація та пошук

Умію знаходити і виводити рядки, які містять певне слово.
Умію перетворювати рядки перед записом (наприклад, у верхній регістр).
Розумію, що таке line.contains(...) і як відрізняється від RegExp.

🔹 Етап 4. Копіювання і унікальні дані

Умію зробити копію файлу через BufferedReader і BufferedWriter.
Умію зробити копію файлу через Files.copy(...).
Умію записати у файл лише унікальні рядки.
Знаю, що таке Set і чому він зручний для унікальності.

🔹 Етап 5. Альтернативні підходи (Java 8+)

Умію читати файл через Files.lines(Path).
Умію писати у файл через Files.writeString(...).
Умію копіювати файли через Files.copy(...).
Розумію різницю між класичними потоками (FileReader/Writer) і новими API
з java.nio.file.Files.

📌 Порада: йдіть послідовно — спершу закрийте всі пункти в Етапах 1–2,
тоді переходьте далі.
Так ви матимете відчуття прогресу і чітко бачитимете, де ще є прогалини.

Хочете, я ще зроблю для вас невеличкі тести-питання по цих пунктах 
(без коду, просто теорія) — щоб ви могли перевірити, чи справді розібрались?

------------------------------------------------------------

https://chatgpt.com/c/68a43ed9-b1e8-8325-a290-68e77be4401c