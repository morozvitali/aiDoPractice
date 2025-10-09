🧠 Завдання 1. Знайди слово, яке має найбільше різних літер
-
Є список слів. Знайди те, у якому найбільше різних символів (ігноруючи регістр).
List<String> words = List.of("banana", "alphabet", "committee", "coffee", "rhythm");


💡 Підказка: перетвори слово в потік символів і зроби .distinct().count().

✅ Рішення:

String result = words.stream()
.max(Comparator.comparing(
w -> w.toLowerCase().chars().distinct().count()
))
.orElse("нема");




📘 Пояснення:
chars() → перетворює рядок у потік чисел символів.
.distinct() → прибирає повтори.
.count() → рахує унікальні символи.

🧠 Завдання 2. Знайди найчастіший символ у списку слів
-
List<String> words = List.of("apple", "banana", "grape", "pear");
💡 Підказка: розбий усі слова на символи й порахуй частоту через groupingBy.

✅ Рішення:

Character mostCommon = words.stream()
.flatMap(w -> w.chars().mapToObj(c -> (char) c))
.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
.entrySet().stream()
.max(Map.Entry.comparingByValue())
.map(Map.Entry::getKey)
.orElse('?');
System.out.println(mostCommon);


📘 Пояснення:
flatMap() створює потік усіх символів усіх слів, потім ми групуємо й шукаємо максимум за частотою.

🧠 Завдання 3. Відсортуй слова за кількістю голосних
-
List<String> words = List.of("moon", "sky", "cloud", "aeroplane", "tree");


💡 Підказка: створи метод countVowels(String) і використай .sorted().

✅ Рішення:

Predicate<Character> vowel = c -> "aeiou".indexOf(c) >= 0;
List<String> sorted = words.stream()
.sorted(Comparator.comparingLong(
w -> w.toLowerCase().chars().filter(c -> vowel.test((char)c)).count()
))
.toList();
System.out.println(sorted);


📘 Пояснення:
filter() залишає лише голосні, .count() підраховує їх, а .sorted() сортує за цим числом.

🧠 Завдання 4. Обчисли середню довжину унікальних слів
-
List<String> words = List.of("sun", "moon", "sun", "sky", "star");
💡 Підказка: .distinct() перед .mapToInt(String::length).

✅ Рішення:

double avg = words.stream()
.distinct()
.mapToInt(String::length)
.average()
.orElse(0);
System.out.println(avg);


📘 Пояснення:
.distinct() прибирає повтори, .mapToInt() перетворює в довжини, .average() обчислює середнє.

🧠 Завдання 5. Знайди найкоротше слово, яке починається з приголосної
-
List<String> words = List.of("apple", "grape", "sky", "cloud", "orange");


💡 Підказка: відфільтруй слова, що починаються не з голосної.

✅ Рішення:

String result = words.stream()
.filter(w -> !"aeiou".contains("" + w.toLowerCase().charAt(0)))
.min(Comparator.comparingInt(String::length))
.orElse("нема");
System.out.println(result);

📘 Пояснення:
Перевіряємо першу букву кожного слова і шукаємо мінімальну довжину.

🧠 Завдання 6. Знайди всі літери, які зустрічаються рівно 2 рази
-
String text = "banana";

💡 Підказка: групуй символи й фільтруй .filter(e -> e.getValue() == 2).

✅ Рішення:

List<Character> result = text.chars()
.mapToObj(c -> (char) c)
.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
.entrySet().stream()
.filter(e -> e.getValue() == 2)
.map(Map.Entry::getKey)
.toList();
System.out.println(result);


📘 Пояснення:
Мапа рахує частоту кожного символу, потім вибираємо тільки ті, що трапляються двічі.

🧠 Завдання 7. Перетвори список фраз у список усіх унікальних слів
-
List<String> phrases = List.of("I love Java", "Java is great", "I love streams");


💡 Підказка: .flatMap(phrase -> Arrays.stream(phrase.split(" ")))

✅ Рішення:

List<String> unique = phrases.stream()
.flatMap(p -> Arrays.stream(p.split(" ")))
.map(String::toLowerCase)
.distinct()
.toList();
System.out.println(unique);


📘 Пояснення:
flatMap() “розплющує” усі слова з речень у єдиний потік.

🧠 Завдання 8. Групуй слова за їхньою довжиною
-
List<String> words = List.of("sun", "sky", "blue", "cloud", "rain");


💡 Підказка: використовуй Collectors.groupingBy(String::length).

✅ Рішення:

Map<Integer, List<String>> grouped = words.stream()
.collect(Collectors.groupingBy(String::length));
System.out.println(grouped);


📘 Пояснення:
groupingBy() створює мапу, де ключ — довжина, значення — список слів цієї довжини.

🧠 Завдання 9. Порахуй, скільки різних слів містить певну літеру
-
List<String> words = List.of("apple", "banana", "grape", "pear", "plum");


💡 Підказка: .filter(w -> w.contains("p")) + .count().

✅ Рішення:

long count = words.stream()
.map(String::toLowerCase)
.filter(w -> w.contains("p"))
.distinct()
.count();
System.out.println(count);


📘 Пояснення:
Видаляємо дублікати, лишаємо тільки слова з певною літерою і рахуємо.

🧠 Завдання 10. Знайди середню кількість символів на слово у реченні
-
String text = "Java makes coding elegant and expressive";


💡 Підказка: .flatMap(Arrays::stream) тут не треба — просто .split(" ").

✅ Рішення:

double avg = Arrays.stream(text.split(" "))
.mapToInt(String::length)
.average()
.orElse(0);
System.out.println(avg);


📘 Пояснення:
.split(" ") розділяє рядок, .mapToInt(String::length) обчислює довжини, .average() — середнє.