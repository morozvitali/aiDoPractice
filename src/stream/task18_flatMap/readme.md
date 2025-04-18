👉 Завдання для тебе:
✏️ Зроби свій метод:
Отримай List<List<Integer>> — список чисел

Збери всі числа в один список.

Відфільтруй ті, що > 50.

Відсортуй за спаданням.

Поверни список.

📥 Наприклад:

List<List<Integer>> weeklyData = List.of(
List.of(40, 55, 60),
List.of(30, 70),
List.of(65, 10, 90)
);
📤 Очікуваний результат:

[90, 70, 65, 60, 55]


?--?--?--?--?--?--?--?--THEORY--?--?--?--?--?--?--?--?


📌 У чому суть?
flatMap потрібен тоді, коли ти працюєш зі списками всередині списку.
Звичайний .map() перетворює кожен елемент → але залишає "вкладеність".

А flatMap — "розплющує" вкладені колекції в один загальний потік.

📦 Приклад:

List<List<String>> data = List.of(
List.of("java", "python"),
List.of("c++", "go"),
List.of("kotlin")
);
🧪 map:

data.stream()
.map(list -> list.stream())   // Stream<Stream<String>>
🔥 flatMap:

data.stream()
.flatMap(list -> list.stream())   // Stream<String>
.collect(Collectors.toList());
✅ Результат:

[java, python, c++, go, kotlin]
🧪 Завдання: flatMap
✅ Задача 1: Зібрати всі унікальні слова з колекції речень

List<String> sentences = List.of(
"Java is powerful",
"Streams are cool",
"Java makes sense"
);
🔍 Треба:

Розбити речення на слова
Зібрати їх у список
Зробити унікальними (distinct)
Привести до нижнього регістру

📤 Очікуваний результат:
[java, is, powerful, streams, are, cool, makes, sense]

💻 Початковий шаблон:
public List<String> extractWords(List<String> sentences) {
return sentences.stream()
.flatMap(sentence -> Arrays.stream(sentence.split(" ")))
.map(String::toLowerCase)
.distinct()
.collect(Collectors.toList());
}


Так, Віталію! 😄 Ти ідеально підловив суть:

🧠 flatMap() "розплющує" вкладені колекції у єдиний потік,
щоб ми могли оперувати над усіма елементами так, ніби вони були в одному списку.

🧊 Уяви:
У тебе є три тарілки 🍽️:

одна з яблуками 🍎
інша з бананами 🍌
третя з апельсинами 🍊

map() — дасть тобі три списки фруктів

Stream<List<Фрукти>>

flatMap() — змішає всі фрукти в одну купу 🧃

Stream<Фрукти>

📦 Аналог в Java:

List<List<String>> fruits = List.of(
List.of("apple", "pear"),
List.of("banana"),
List.of("orange", "lemon")
);

Stream<Stream<String>>  // кожна "тарілка" окремо
.flatMap(...)

Stream<String>  // все на одній "тарілці"
🎯 Тепер — твоя черга!
Ти вже маєш завдання:

обробити List<List<Integer>>

через flatMap(), filter(), sorted() та collect()