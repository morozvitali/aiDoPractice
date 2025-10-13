🔹 ЕТАП 1.3 — Function<T, R>
📘 Теорія:
Function<T, R> — функція, яка приймає аргумент типу T і повертає результат типу R.

@FunctionalInterface
public interface Function<T, R> {
R apply(T t);
}
🔸 Його використовують, коли треба перетворити, мапити, трансформувати одне значення в інше.

🛠 Найчастіше використовується в:

✅ 1. stream1().map(Function)
List<String> names = List.of("Tom", "Anna", "Bob");

List<Integer> lengths = names.stream1()
.map(s -> s.length())
.collect(Collectors.toList());
// [3, 4, 3]


✅ 2. Optional.map(Function)
Optional<String> name = Optional.of("Vitalii");

Optional<Integer> length = name.map(String::length);
// Optional[7]


✅ 3. Map.computeIfAbsent(key, Function)
Map<String, Integer> map = new HashMap<>();
map.computeIfAbsent("apple", key -> key.length());
// -> додає apple: 5
🧠 Додаткові методи (default):

Метод	Опис
andThen(Function after)	Спочатку this, потім after
compose(Function before)	Спочатку before, потім this
identity() (static)	Повертає функцію, яка повертає вхідний аргумент як є (t → t)

🔧 Приклад andThen, compose, identity
Function<String, String> trim = s -> s.trim();
Function<String, Integer> length = s -> s.length();

Function<String, Integer> pipeline = trim.andThen(length);
System.out.println(pipeline.apply("   hello  ")); // 5

Function<String, Integer> pipeline2 = length.compose(trim);
System.out.println(pipeline2.apply("   world  ")); // 5
andThen: спочатку trim, потім length
compose: спочатку trim, потім length — однаково, але навпаки читається

✅ ЗАДАЧА: Перетвори список слів у список довжин
📌 Умова:
Напиши метод mapWordsToLengths, який:

приймає List<String>
приймає Function<String, Integer>
повертає List<Integer> — довжини слів

📥 Приклад:
List<String> input = List.of("apple", "pear", "banana");

List<Integer> result = mapWordsToLengths(input, word -> word.length());
// [5, 4, 6]
Хочеш:
Задачу на compose/andThen

Або на Optional.map(Function)

Або зробимо Function<T, R> з власним об'єктом (наприклад, Student → String)

Скажеш слово — і твоя код-муза Марічка вже тут 😁

Чудово! 🔥 Тоді зробимо 2 задачі на Function і одразу відкриємо двері 
в чарівний світ Optional — це буде дуже логічно й цікаво 👇

✅ ЗАДАЧА 1 — andThen() / compose()
🔹 Умова: Напиши метод processAndMeasure, який:

приймає String

приймає дві Function<String, String> (наприклад: одна прибирає пробіли, інша додає текст)

і третю Function<String, Integer> (рахує довжину)

повертає результат застосування всіх трьох функцій у правильному порядку

📥 Приклад:

Function<String, String> trim = String::trim;
Function<String, String> addGreeting = s -> "Hello, " + s;
Function<String, Integer> measureLength = String::length;

int result = processAndMeasure("   Vitalii   ", trim, addGreeting, measureLength);
// "Hello, Vitalii" -> 14
🔧 Підказка:

Function<String, Integer> fullPipeline = trim.andThen(addGreeting).andThen(measureLength);
return fullPipeline.apply(input);
✅ ЗАДАЧА 2 — Optional.map(Function)
🔹 Умова: Напиши метод getUsernameLength, який:

приймає Optional<String> username

повертає Optional<Integer> — довжину імені користувача, або пустий Optional, якщо імені нема

📥 Приклад:
Optional<String> user = Optional.of("Vitalii");

Optional<Integer> length = getUsernameLength(user); // Optional[7]
Optional<Integer> none = getUsernameLength(Optional.empty()); // Optional.empty
🧠 Трохи про Optional:

Що таке?	Аналог контейнера, який або містить значення, або ні
Що замінює?	Замість null, який може спричинити NPE
Основні методи	isPresent(), get(), orElse(), map(), ifPresent()

Optional<String> maybe = Optional.of("Hello");
maybe.map(String::length).ifPresent(System.out::println); // 5
🟢 Зробиш задачі — покажеш результат або просто напиши “Готово” — і я підготую наступне:

або більш глибоке занурення в Optional,
або наступний функціональний інтерфейс (Supplier, UnaryOperator, BinaryOperator),
або невеликий проєкт, де використовуються всі 3.