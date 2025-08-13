
перетворення .map(w -> Map.entry(...)),
подальшої обробки Map.Entry,
і пошуку max/min чи іншої логіки на основі 
.getKey() та .getValue().

------------------------------------------------

✅ Задача 1: Найдовше слово у списку
📋 Умова:
Є список слів. Знайди слово з найбільшою довжиною.
📥 Вхід:
List<String> words = List.of("stream", "code", 
"developer", "Engineer");
📤 Очікуване: developer

💡 Підказка:
.map(w -> Map.entry(w, w.length()))
.reduce((a, b) -> a.getValue() >= b.getValue() ? a : b)
.map(Map.Entry::getKey)
.orElse("");

map(a->a.getKey()) ---> map(Map.Entry::getKey)

------------------------------------------------

✅ Задача 2: Найкоротше слово у списку
📋 Знайди слово з найменшою довжиною.
📥 List<String> list = List.of("Java", "C",
"Python", "Go", "Kotlin");
📤 Очікуване: "C"

💡 Підказка: .reduce(...) з a.getValue() <= b.getValue()

    list.stream()
    .map(w->Map.entry(w, w.length()))
    .reduce((a,b) -> a.getValue() <= b.getValue() ? a:b)
    .map(Map.Entry::getKey).orElse("");

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

        list.stream().map(w->Map.entry(w, countVovels(w)))
                .reduce((a,b)->a.getValue() > b.getValue() ? a :b )
                .map(Map.Entry::getKey).orElse("Empty");
    }

    public long countVovels (String str) {
        return str.chars().filter(w->"aeiou".indexOf(w) >= 0).count();
    }

map(a->a.getKey()) ---> map(Map.Entry::getKey)

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

✅ Задача 5: Слово з найбільшою кількістю 
однакових літер
📋 Порахуй максимальну кількість
повторів однієї літери в кожному слові.
📤 Очікуване: "committee" (3 't' чи 'm')

    [шукаємо всі повтори]

        List<String> list = List.of("apple",
                "committee", "banana", "success");
        list.stream().map(w->Map.entry(w, (w.length() - w.chars().distinct().count())))
                .reduce((a,b)->a.getValue() > b.getValue() ? a : b)
                .map(Map.Entry::getKey).orElse("empty");
    }
map(a->a.getKey()) ---> map(Map.Entry::getKey)

-----------------------------------------------

✅ Задача 6: Слово з найбільшою сумою ASCII-кодів
📋 Для кожного слова обчисли суму ASCII-кодів
усіх символів.
📥 List.of("abc", "aaa", "zzz")
📤 Очікуване: "zzz" → 3 * 122 = 366

💡 .mapToInt(c -> c) у chars() + .sum()

    public void practice7 () {
        List<String> list = List.of("abc", "aaa", "zzz");
        list.stream()
        .mapToInt(word -> countAscii(word))
        .max();
    }
    public int countAscii (String s) {
        return s.chars().sum();
    }




-----------------------------------------------

✅ Задача 7: Слово, що містить 
найбільше літер 'a'
📋 Знайди слово з найбільшою 
кількістю літер 'a'.
📥 List.of("alpha", "arena", 
"java", "banana", "lava")
📤 Очікуване: "banana"

💡 Створити .map(w -> Map.entry(w, countOf(w, 'a')))
Далі — .reduce(...)

    public void practice7 () {
        List.of("alpha", "arena",
                "java", "banana", "lava").stream()
                .map(w->Map.entry(w, w.chars()
                        .filter(c->c=='a')
                        .count()))
                .reduce((a,b)-> a.getValue() > b.getValue() ? a : b)
                .map(Map.Entry::getKey).orElse("empty");

------

    return list.stream()
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

✅ Задача 8: Найдовше слово, 
що починається з великої літери
📋 Знайди найдовше слово, 
яке починається з великої.
📥 List.of("apple", "Tree", 
"Java", "stream", "Engineer")
📤 Очікуване: "Engineer"

💡 .filter(w -> Character
.isUpperCase(w.charAt(0)))
Далі — .map(w -> Map.entry(w, w.length()))

https://chatgpt.com/c/68679839-b104-8009-abdc-19e134bff306