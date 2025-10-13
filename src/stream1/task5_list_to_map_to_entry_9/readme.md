
перетворення .map(w -> Map.entry(...)),
подальшої обробки Map.Entry,
і пошуку max/min чи іншої логіки на основі 
.getKey() та .getValue().

------------------------------------------------

✅ Задача 1: Найдовше слово у списку
📋 Умова:
Є список слів. Знайди слово з найбільшою довжиною.
📥 Вхід:
List<String> words = List.of("stream1", "code", 
"developer", "Engineer");
📤 Очікуване: developer

💡 Підказка:
.map(w -> Map.entry(w, w.length()))
.reduce((a, b) -> a.getValue() >= b.getValue() ? a : b)
.map(Map.Entry::getKey)
.orElse("");

------------------------------------------------

✅ Задача 2: Найкоротше слово у списку
📋 Знайди слово з найменшою довжиною.
📥 List<String> list = List.of("Java", "C",
"Python", "Go", "Kotlin");
📤 Очікуване: "C"

💡 Підказка: .reduce(...) з a.getValue() <= b.getValue()

------------------------------------------------

✅ Задача 3: Слово з найбільшою
кількістю голосних
📋 Порахуй кількість голосних
у кожному слові та знайди
слово з найбільшою кількістю.
📥 List<String> list = List.of("apple", "banana",
"orange", "blueberry");
📤 Очікуване: "banana" (3 голосні)

💡 Підказка:

.map(w -> Map.entry(w, countVowels(w)))
.reduce((a, b) -> a.getValue() >= b.getValue() ? a : b)

------------------------------------------------

✅ Задача 4: Слово з найбільшою 
кількістю унікальних літер
📋 У кожному слові визначити 
кількість унікальних літер.
📥 List<String> list = List.of("apple", "pear",
"banana", "kiwi");
📤 Очікуване: "banana" → 3 унікальні літери

💡 Порахуємо через Set<Character>

------------------------------------------------

✅ Задача 6: Слово з найбільшою кількістю 
однакових літер
📋 Порахуй максимальну кількість
повторів однієї літери в кожному слові.
📤 Очікуване: "committee" (3 't' чи 'm')

💡 Map<Character, Long> → потім max значення
List<String> list = List.of("apple",
        "committee", "banana", "success");
        list.stream1().map(word-> Map.entry(word, word.chars().mapToObj(c->(char)c)
        .collect(Collectors.groupingBy(c->c, Collectors.counting()))
        .values().stream1()
        .max(Long::compareTo)
        .orElse(0L)))
               .max(Comparator.comparing(Map.Entry::getValue))
               .map(Map.Entry::getKey)
               .orElse("empty");

-----------------------------------------------

✅ Задача 7: Слово з найбільшою сумою ASCII-кодів
📋 Для кожного слова обчисли суму ASCII-кодів
усіх символів.
📥 List.of("abc", "aaa", "zzz")
📤 Очікуване: "zzz" → 3 * 122 = 366

💡 .mapToInt(c -> c) у chars() + .sum()

    public void practice7 () {
        List<String> list = List.of("abc", "aaa", "zzz");
        list.stream1().mapToInt(word -> countAscii(word)).max();
    }
    public int countAscii (String s) {
        return s.chars().sum();
    }




-----------------------------------------------

✅ Задача 8: Слово, що містить найбільше літер 'a'
📋 Знайди слово з найбільшою кількістю літер 'a'.
📥 List.of("alpha", "arena", 
"java", "banana", "lava")
📤 Очікуване: "banana"

💡 Створити .map(w -> Map.entry(w, countOf(w, 'a')))
Далі — .reduce(...)

    return list.stream1()
        .map(word -> Map.entry(word, countOf(word, 'a'))) // створюємо пару слово → кількість 'a'
        .reduce((a, b) -> a.getValue() >= b.getValue() ? a : b) // залишаємо пару з найбільшою кількістю
        .map(a->a.getKey()).orElse(""); // витягуємо слово
    }

    public int countOf(String word, char target) {
    return (int) word.chars()
    .filter(c -> c == target)
    .count(); // кількість символів target
    }
------------------------------------------------

✅ Задача 9: Найдовше слово, 
що починається з великої літери
📋 Знайди найдовше слово, 
яке починається з великої.
📥 List.of("apple", "Tree", 
"Java", "stream1", "Engineer")
📤 Очікуване: "Engineer"

💡 .filter(w -> Character
.isUpperCase(w.charAt(0)))
Далі — .map(w -> Map.entry(w, w.length()))

https://chatgpt.com/c/68679839-b104-8009-abdc-19e134bff306