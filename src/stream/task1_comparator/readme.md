--------------------------------------------------------

🔹 Задача 1: Знайти перший елемент, що ділиться на 5
(твоя базова задача, залишаємо як шаблон)

List<Integer> numbers = List.of(3, 8, 10, 15, 4);
int result = numbers.stream()
.filter(n -> n % 5 == 0)
.findFirst()
.orElse(-1); // 👉 результат: 10

--------------------------------------------------------

🔹 Задача 2: Знайти слово з найбільшою кількістю літер 'a'
📥 List.of("alpha", "arena", "java", "banana", "lava")
📤 Очікуване: "banana" → має 3 літери 'a'

💡 Підказка: .map(w -> Map.entry(w, countOf(w, 'a'))).max(Comparator.comparing(...))

String result = words.stream()
.map(w -> Map.entry(w, w.chars().filter(c -> c == 'a').count()))
.max(Comparator.comparing(Map.Entry::getValue))
.map(Map.Entry::getKey)
.orElse("нема");

--------------------------------------------------------

🔹 Задача 3: Знайти число з найбільшою кількістю різних цифр
📥 List.of(111, 123, 444, 1212)
📤 "123" → 3 різні цифри

💡 .map(n -> Map.entry(n, new HashSet<>(цифри)))

--------------------------------------------------------

🔹 Задача 4: Сортувати слова за кількістю голосних у зростанні
📥 List.of("apple", "zebra", "sky", "education")
📤 ["sky", "zebra", "apple", "education"]

--------------------------------------------------------

💡 Comparator.comparing(w -> countVowels(w))

🔹 Задача 5: Знайти пару чисел із найменшою різницею
📥 List.of(3, 8, 15, 9)
📤 Пара: (8, 9) → різниця 1

💡 .sorted().reduce((a,b) -> ...) або вручну пройти .pairwise

--------------------------------------------------------

🔹 Задача 6: Знайти слово з найвищою "ASCII-сумою" символів
📥 List.of("abc", "aaa", "zzz")
📤 "zzz" → 3×122 = 366

String result = list.stream()
.map(w -> Map.entry(w, w.chars().sum()))
.max(Comparator.comparing(Map.Entry::getValue))
.map(Map.Entry::getKey)
.orElse("нема");

--------------------------------------------------------

🔹 Задача 7: Знайти найдовше слово, що починається на 's'
📥 List.of("sun", "star", "supernova", "apple")
📤 "supernova"

💡 filter -> startsWith("s"), потім max(Comparator.comparing(String::length))

--------------------------------------------------------

🔹 Задача 8: Сортувати масив рядків за останньою літерою
📥 ["abc", "def", "gka", "lol"]
📤 ["gka", "lol", "abc", "def"]

List<String> sorted = list.stream()
.sorted(Comparator.comparing(s -> s.charAt(s.length() - 1)))
.collect(Collectors.toList());

--------------------------------------------------------

🔹 Задача 9: Знайти найменше слово за довжиною, яке містить 'e'
📥 ["java", "hello", "me", "zebra"]
📤 "me"

💡 filter.contains("e") + min(Comparator.comparing(String::length))

--------------------------------------------------------

🔹 Задача 10: Сортувати числа за кількістю нулів у записі
📥 List.of(100, 1010, 5, 2000, 10)
📤 List.of(5, 10, 100, 1010, 2000)

💡 Comparator.comparing(n -> countOf(n, '0'))

