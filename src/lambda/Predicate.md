🔹 ЕТАП 1.2 — Predicate<T>
📘 Теорія:
🔹 Predicate<T> — це функціональний інтерфейс, що перевіряє умову
Має один абстрактний метод:

java
Копіювати
Редагувати
boolean test(T t);
Якщо потрібно перевірити щось (наприклад, "рядок не порожній", "число > 0", "user активний") — це до Predicate.

🔧 Використовується:
✅ 1. Stream API:
java
Копіювати
Редагувати
list.stream().filter(s -> s.length() > 3).toList();
✅ 2. List.removeIf(Predicate<T>):
java
Копіювати
Редагувати
list.removeIf(s -> s.isEmpty());
✅ 3. Optional.filter(Predicate):
java
Копіювати
Редагувати
Optional<String> name = Optional.of("Vitalii");
name.filter(n -> n.length() > 5);
✅ 4. Method references:
java
Копіювати
Редагувати
list.stream().filter(String::isEmpty);
🛠 Додаткові (дефолтні) методи Predicate<T>:

Метод	Опис
and(Predicate)	логічне І між двома Predicate'ами
or(Predicate)	логічне АБО
negate()	логічне НЕ — заперечення
isEqual(Object)	static метод: перевірка на рівність (equals)
🔧 Приклад:
java
Копіювати
Редагувати
Predicate<String> startsWithA = s -> s.startsWith("A");
Predicate<String> longerThan3 = s -> s.length() > 3;

Predicate<String> finalCheck = startsWithA.and(longerThan3);

System.out.println(finalCheck.test("Apple")); // true
System.out.println(finalCheck.test("Ax"));    // false
🧩 ЗАДАЧА: "Фільтр рядків за Predicate"
📌 Завдання:
Напиши метод filterWords, який:

приймає список слів List<String>

приймає Predicate<String> predicate

повертає список відфільтрованих слів

📥 Приклад виклику:
java
Копіювати
Редагувати
List<String> words = List.of("apple", "banana", "pie", "apricot");

List<String> result = filterWords(words, s -> s.startsWith("a") && s.length() > 4);
System.out.println(result); // [apple, apricot]