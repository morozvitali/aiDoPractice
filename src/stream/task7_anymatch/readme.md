**Task 8 : anyMatch, allMatch, noneMatch — вони перевіряють умови
на потоці елементів. Тема проста, але дуже потужна для фільтрації,
валідацій і умовних перевірок.**


🔹 Задача 1: Перевірити, чи список містить хоча б одне негативне число

List<Integer> list = List.of(3, -5, 7, 10);
Очікуваний результат: true

List<Integer> list = List.of(3, 5, 7);
→ результат: false

Підказка:
.anyMatch(n -> n < 0)

🔹 Задача 2: Перевірити, чи всі числа в списку додатні

List<Integer> list = List.of(2, 5, 10, 20); → `true`  
List<Integer> list = List.of(2, -1, 5); → `false`
Підказка:
.allMatch(n -> n > 0)

🔹 Задача 3: Перевірити, чи жодне число не дорівнює 0

List<Integer> list = List.of(1, 2, 3, 0); → `false`  
List<Integer> list = List.of(1, 2, 3); → `true`
Підказка:
.noneMatch(n -> n == 0)

🔹 Задача 4: Перевірити, чи є хоча б одне число,
що ділиться на 7

List<Integer> list = List.of(1, 2, 3, 0);  → `true`  
List<Integer> list = List.of(3, 5, 6); → `false`
Підказка:
.anyMatch(n -> n % 7 == 0)

🔹 Задача 5: Перевірити, чи всі рядки починаються
з великої літери

List<String> names = List.of("Alice", "Bob", "Charlie"); → `true`  
List<String> names = List.of("Alice", "bob", "Charlie"); → `false`
Підказка:
.allMatch(s -> Character.isUpperCase(s.charAt(0)))

**⭐ Задача 6 (з зірочкою): Перевірити, чи хоча б одне слово з 
колекції є паліндромом (читається однаково в обидва боки)**

List<String> words = List.of("racecar", "apple", "madam"); → `true`  
List<String> words = List.of("java", "stream", "code"); → `false`
Підказка:

String reversed = new StringBuilder(s).reverse().toString();
s.equals(reversed)
Потім .anyMatch(...)

