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

----------------------------------------------------

🔹 Задача 1: Знайти мінімальне парне число, якщо таке є, інакше повернути -1

int[] numbers = {3, 11, 6, 7, 10};
Очікуваний результат: 6

int[] numbers = {3, 5, 7};
→ результат має бути: -1

Підказка:
.filter(n -> n % 2 == 0)
.reduce(...)
.orElse(...)

🔹 Задача 2: Обчислити добуток усіх додатних чисел, якщо вони є, інакше повернути 1

int[] numbers = {-3, 5, 2, -1, 4};
Очікуваний результат: 5 * 2 * 4 = 40

int[] numbers = {-2, -5, -10};
→ результат має бути: 1

Підказка:
.filter(n -> n > 0)
.reduce(1, (a, b) -> a * b)

🔹 Задача 3: Знайти найбільше число, яке ділиться на 3

int[] numbers = {3, 9, 8, 12, 7};
Очікуваний результат: 12

int[] numbers = {1, 2, 4, 5};
→ результат має бути: -1

Підказка:
.filter(n -> n % 3 == 0)
.reduce(Integer::max).orElse(-1)

🔹 Задача 4: Порахувати суму квадратів усіх парних чисел

int[] numbers = {2, 3, 4};
Очікуваний результат: 2^2 + 4^2 = 4 + 16 = 20

int[] numbers = {1, 3, 5};
→ результат має бути: 0

Підказка:
.filter(n -> n % 2 == 0)
.map(n -> n * n)
.reduce(0, Integer::sum)

🔹 Задача 5: Знайти середнє арифметичне непарних чисел
(округлити вниз до int, або повернути -1 якщо немає непарних)

int[] numbers = {3, 5, 7}; // середнє: 5
java
Copy
Edit
int[] numbers = {2, 4, 6}; // результат: -1
Підказка:
.filter(n -> n % 2 != 0)
зібрати у список → порахувати .sum() і .count()

⭐ Задача 6: (з зірочкою) Знайти найбільший спільний дільник (НСД) всіх чисел у масиві

int[] numbers = {12, 24, 36}; // НСД = 12

int[] numbers = {7, 11}; // НСД = 1

int[] numbers = {}; // результат: -1
Підказка:
використати .reduce((a, b) -> gcd(a, b)).orElse(-1)
метод gcd(int a, int b) реалізувати окремо


---------------instanceof-objects-filtration---------------

✅ Задача 1: Фільтр чисел
📋 Умова:
Є список із чисел, рядків і булевих значень. Поверни список тільки з цілими числами (Integer).

🧠 Підказка:
x instanceof Integer

📌 Приклад:

List.of(10, "hello", true, 42, false, "42") → [10, 42]
🧪 Початковий код:

public static List<Object> filterIntegers(List<Object> input) {
return input.stream()
.filter(x -> x instanceof Integer)
.collect(Collectors.toList());
}
✅ Задача 2: Залишити рядки
📋 Умова:
Залиш у списку лише ті елементи, які є рядками (String).

📌 Приклад:

List.of("hello", 1, 2.5, true, "world") → ["hello", "world"]
🧠 Підказка:
x instanceof String

✅ Задача 3: Розумний фільтр
📋 Умова:
Залиш лише ті елементи, які є числами (Integer) і більші за 10.

📌 Приклад:

List.of("a", 3, 15, 11, 9, "99") → [15, 11]
🧠 Підказка:

x instanceof Integer && (Integer)x > 10
✅ Задача 4: Фільтр істини
📋 Умова:
Поверни всі елементи типу Boolean, які рівні true.

📌 Приклад:

List.of("yes", true, false, true, 1) → [true, true]
🧠 Підказка:

x instanceof Boolean && (Boolean)x == true
✅ Задача 5: Конвертер рядків у великі букви
📋 Умова:
Залиши тільки String, але повертай їх у верхньому регістрі (toUpperCase()).

📌 Приклад:

List.of("hi", 123, "bye", false) → ["HI", "BYE"]
🧠 Підказка:

x instanceof String → ((String)x).toUpperCase()