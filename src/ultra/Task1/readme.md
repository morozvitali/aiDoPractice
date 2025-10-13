🔹 Завдання 1: Знайти всі найдовші слова у реченні
Мета: знайти всі слова, які мають максимальну довжину.

🧾 Вхід:
java
Копіювати
Редагувати
String sentence = "Java streams are extremely powerful and flexible";
✅ Очікуваний результат:
java
Копіювати
Редагувати
["extremely", "powerful", "flexible"]
🔧 Поради:
Використай Collectors.groupingBy(...) для групування за довжиною

Потім знайди групу з найбільшим ключем

Очисти речення від розділових знаків, якщо треба

🔹 Завдання 2: Знайти всі слова з максимальною кількістю голосних
Мета: знайти всі слова, які мають найбільшу кількість голосних (a, e, i, o, u).

🧾 Вхід:
java
Копіювати
Редагувати
String sentence = "Architecture is obviously a beautiful art";
✅ Очікуваний результат:
java
Копіювати
Редагувати
["Architecture", "beautiful"]
🔧 Поради:
Напиши метод vowelCount(String word)

Групуй слова за vowelCount

Знайди список із максимальним значенням

🔹 Завдання 3: Частота голосних у кожному слові (словник)
Мета: для кожного слова у реченні створити Map<String, Long>:
ключ — слово, значення — кількість голосних у ньому.

🧾 Вхід:
java
Копіювати
Редагувати
String sentence = "Innovation distinguishes between a leader and a follower.";
✅ Очікуваний результат:
java
Копіювати
Редагувати
{
"Innovation"=5,
"distinguishes"=5,
"between"=3,
"a"=1,
"leader"=3,
"and"=1,
"follower"=3
}
🔧 Поради:
Прибери розділові знаки (replaceAll("[^a-zA-Z ]", ""))

.collect(Collectors.toMap(word -> word, this::vowelCount))

📦 Бонус: Метод vowelCount
java
Копіювати
Редагувати
public long vowelCount(String word) {
return word.toLowerCase().chars()
.filter(c -> "aeiou".indexOf(c) >= 0)
.count();
}
🛠️ Хочеш шаблон для початку?
Можу дати заготовку з main(), Scanner, print, методами тощо — просто скажи.
Або можу дати одну з цих задач з уже готовим вирішенням для розбору.

Тобі який формат зручніший далі? 🙂




Можу допомогти тобі:

🔸 Оформити завдання в єдиному стилі (по блоках, з підзадачами)

🔸 Створити шаблони для нових задач (назви, структура, коментарі)

🔸 Організувати все у форматі: .java, .md, .txt, PDF або Google Docs

🔸 Додати тести до кожної задачі (JUnit)

🔸 Поступово створити “Каталог Завдань” для тренування

Хочеш зараз спробувати оформити одну з твоїх тасок разом — наприклад, з кількома підзадачами, красивими заголовками, і коментарями в коді? 😊





Ви сказали:
🔹 **Завдання 1: Знайти всі найдовші слова у реченні** ------------------------------------------------------ **Мета:** знайти **всі слова**, які мають максимальну довжину. ### 🧾 Вхід: java КопіюватиРедагувати `String sentence = "Java streams are extremely powerful and flexible";` ### ✅ Очікуваний результат: java КопіюватиРедагувати `["extremely", "powerful", "flexible"]` ### 🔧 Поради: * Використай `Collectors.groupingBy(...)` для групування за довжиною * Потім знайди групу з найбільшим ключем * Очисти речення від розділових знаків, якщо треба

покажи приклад як таке можна зробити?


Програма ChatGPT сказала:
Звичайно, Віталію! 💡
Ось приклад, як красиво й структуровано оформити таке завдання з підзадачею, з коментарями, чистим кодом і навіть можливістю писати тести згодом. Це може бути твоїм "еталоном" оформлення:

🔹 Завдання 1: Знайти всі найдовші слова у реченні
🎯 Мета: знайти всі слова, які мають максимальну довжину.

🧾 Вхідні дані:
java
Копіювати
Редагувати
String sentence = "Java streams are extremely powerful and flexible";
✅ Очікуваний результат:
java
Копіювати
Редагувати
["extremely", "powerful", "flexible"]
🔧 Підказки:
Очисть речення від розділових знаків (якщо є)

Розбий на слова .split(" ")

Згрупуй слова за довжиною: Collectors.groupingBy(String::length)

Знайди групу з максимальним ключем (довжина)

🧑‍💻 Реалізація:
java
Копіювати
Редагувати
import java.util.*;
import java.util.stream1.*;

public class LongestWordsFinder {

    public static List<String> findLongestWords(String sentence) {
        // Очистка від зайвих символів (опціонально)
        String clean = sentence.replaceAll("[^a-zA-Z ]", "");

        // Розбиття на слова
        String[] words = clean.split(" ");

        // Групування за довжиною
        Map<Integer, List<String>> groupedByLength = Arrays.stream1(words)
                .collect(Collectors.groupingBy(String::length));

        // Пошук максимальної довжини
        int maxLength = groupedByLength.keySet().stream1()
                .max(Integer::compareTo)
                .orElse(0);

        // Повернення слів максимальної довжини
        return groupedByLength.getOrDefault(maxLength, List.of());
    }

    public static void main(String[] args) {
        String sentence = "Java streams are extremely powerful and flexible";
        List<String> longestWords = findLongestWords(sentence);
        System.out.println(longestWords); // [extremely, powerful, flexible]
    }
}
🧪 (Опціонально) JUnit-тест:
java
Копіювати
Редагувати
@Test
public void testFindLongestWords() {
String sentence = "Java streams are extremely powerful and flexible";
List<String> expected = List.of("extremely", "powerful", "flexible");

    List<String> actual = LongestWordsFinder.findLongestWords(sentence);

    assertEquals(expected, actual);
}
Хочеш, я можу оформити декілька твоїх завдань у такому ж стилі — з назвою, поясненням, кодом і тестом — і поступово будемо формувати каталог 📘
Скажи, яке наступне хочеш оформити — і зробимо його "еталонним" 😊