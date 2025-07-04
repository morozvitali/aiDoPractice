🎯 Комбо-тренажер: map + filter + collect 
(toList / toMap / groupingBy / counting)

✅ Задача 1: Зібрати у список імен, 
які починаються на "A", з великої літери
List<String> names = List.of
("Alice", "Bob", "Anna", "George", "alex", "Amanda");
Результат:
[Alice, Anna, Amanda]

🧠 Підказка:
фільтрувати .startsWith("A")
зібрати в List<String> через collect(Collectors.toList())

✅ Задача 2: Підрахувати кількість парних чисел у списку
List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 8);
Результат: 4
🧠 Підказка:
.filter(n -> n % 2 == 0)
.collect(Collectors.counting()) ➜ повертає Long

✅ Задача 3: Згрупувати слова за їх першою літерою
List<String> words = List.of("apple", "banana", 
"apricot", "blueberry", "cherry");

✅ Задача 4: Створити Map<String, Integer> — слово ➜ довжина
List<String> words = List.of("hi", "apple", "banana");
Результат:
{hi=2,
apple=5,
banana=6}
🧠 Підказка:
.collect(Collectors.toMap(word -> word, word -> word.length()))


Результат:
{a=[apple, apricot],
b=[banana, blueberry],
c=[cherry]}
🧠 Підказка:
.collect(Collectors.groupingBy(word -> word.charAt(0)))

✅ Задача 4: Створити Map<String, Integer> — слово ➜ довжина
List<String> words = List.of("hi", "apple", "banana");
Результат:
{hi=2,
apple=5,
banana=6}
🧠 Підказка:
.collect(Collectors.toMap(word -> word, word -> word.length()))


