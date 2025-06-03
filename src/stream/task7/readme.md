🔹 Частина 1: filter
✅ Задача 1: Вивести всі слова, які починаються на літеру "b"

String[] words = {"apple", "banana", "book", "car", "blue"};

Очікуваний результат:

banana
book
blue

Підказка: використай filter(word -> word.startsWith("b"))

✅ Задача 2: Вивести всі парні числа > 10

int[] numbers = {3, 10, 14, 9, 20, 25, 8};
Очікуваний результат:

14
20
Підказка: .filter(n -> n % 2 == 0 && n > 10)

anyMatch, allMatch, noneMatch — вони перевіряють умови
на потоці елементів. Тема проста, але дуже потужна для фільтрації,
валідацій і умовних перевірок.
🔹 Задача 0: Перевірити, чи список містить хоча б одне негативне число

List<Integer> list = List.of(3, -5, 7, 10);
Очікуваний результат: true

List<Integer> list = List.of(3, 5, 7);
→ результат: false

Підказка:
.anyMatch(n -> n < 0)

🔹 Задача 1: Перевірити, чи всі числа в списку додатні

List<Integer> list = List.of(2, 5, 10, 20); → `true`  
List<Integer> list = List.of(2, -1, 5); → `false`
Підказка:
.allMatch(n -> n > 0)

🔹 Задача 2: Перевірити, чи жодне число не дорівнює 0

List<Integer> list = List.of(1, 2, 3, 0); → `false`  
List<Integer> list = List.of(1, 2, 3); → `true`
Підказка:
.noneMatch(n -> n == 0)

🔹 Задача 3: Перевірити, чи є хоча б одне число, що ділиться на 7
java
Copy
Edit
List<Integer> list = List.of(5, 14, 21); → `true`  
List<Integer> list = List.of(3, 5, 6); → `false`
Підказка:
.anyMatch(n -> n % 7 == 0)

🔹 Задача 4: Перевірити, чи всі рядки починаються з великої літери
java
Copy
Edit
List<String> names = List.of("Alice", "Bob", "Charlie"); → `true`  
List<String> names = List.of("Alice", "bob", "Charlie"); → `false`
Підказка:
.allMatch(s -> Character.isUpperCase(s.charAt(0)))

⭐ Задача 5 (з зірочкою): Перевірити, чи хоча б одне слово з колекції є паліндромом (читається однаково в обидва боки)
java
Copy
Edit
List<String> words = List.of("racecar", "apple", "madam"); → `true`  
List<String> words = List.of("java", "stream", "code"); → `false`
Підказка:

java
Copy
Edit
String reversed = new StringBuilder(s).reverse().toString();
s.equals(reversed)
Потім .anyMatch(...)

