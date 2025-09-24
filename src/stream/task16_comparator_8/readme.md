✅ Задача 1: Відсортуй слова за кількістю голосних,
-
потім — за алфавітом
-

📥 Вхід:


📤 Очікувано:

sky
plum
grape
apple
banana
orange

🧠 Підказка:

words.stream()
.sorted(Comparator
.comparing(Main3::getCount))
.toList();


-------------------------------------------

🔹 Задача 2: Знайти слово з найбільшою кількістю літер 'a'
-
📥 List.of("alpha", "arena", "java", "banana", "lava")
📤 Очікуване: "banana" → має 3 літери 'a'

💡 Підказка: .map(w -> Map.entry(w, countOf(w, 'a')))
.max(Comparator.comparing(...))

String result = words.stream()
.map(w -> Map.entry(w, w.chars().filter(c -> c == 'a').count()))
.max(Comparator.comparing(Map.Entry::getValue))
.map(Map.Entry::getKey)
.orElse("нема");

--------------------------------------------------------

🔹 Задача 3: Знайти число з найбільшою кількістю різних цифр
-
📥 List.of(111, 123, 444, 1212)
📤 "123" → 3 різні цифри

💡 numbers.stream()
.map(n -> Map.entry(n,
    (int) String.valueOf(n)
        .chars()
        .distinct()
        .count()))
.max(Map.Entry.comparingByValue())
.get().getKey();

.max(...) // повертає Optional<Map.Entry<Integer, Integer>>
.get()    // ← оце бере значення з Optional 
← отримали Map.Entry
.getKey()       // ← тепер беремо з неї ключ

Map.entry(123, 3).getKey() → 123

--------------------------------------------------------

🔹 Задача 4: Знайти слово з найвищою "ASCII-сумою" символів
-
📥 List.of("abc", "aaa", "zzz")
📤 "zzz" → 3×122 = 366

        String result = list.stream()
            .map(w -> Map.entry(w, w.chars().sum()))
            .max(Comparator.comparing(Map.Entry::getValue))
            .map(Map.Entry::getKey)
            .orElse("нема");

--------------------------------------------------------

🔹 Задача 5: Знайти найдовше слово, що починається на 's'
-
List<String> words = 
List.of("sun", "star", "supernova", "apple");
📤 "supernova"

        String result = words.stream()
                .filter(word -> word.startsWith("s"))
                .max(Comparator.comparing(word -> word.length()))
                .orElse("Немає слів на 's'");

--------------------------------------------------------

🔹 Задача 6: Сортувати масив рядків за останньою літерою
-
📥 ["abc", "def", "gka", "lol"]
📤 ["gka", "lol", "abc", "def"]

        List<String> sorted = list.stream()
                .sorted(Comparator
                .comparing(s -> s.charAt(s.length() - 1)))
                .collect(Collectors.toList());

--------------------------------------------------------

🔹 Задача 7: Знайти найменше слово за довжиною, яке містить 'e'
-
📥 ["java", "hello", "me", "zebra"]
📤 "me"

💡 filter.contains("e") + min(Comparator.comparing(String::length))

        List.of("java", "hello", "me", "zebra")
                .stream().filter(w->w.contains("e"))
                .min(Comparator.comparing(word -> word.length()))
                .orElse("empty value");

--------------------------------------------------------

🔹 Задача 8: Сортувати числа за кількістю нулів у записі
-
📥 List.of(100, 1010, 5, 2000, 10)
📤 List.of(5, 10, 100, 1010, 2000)

💡 Comparator.comparing(n -> countOf(n, '0'))

        List.of(100, 1010, 5, 2000, 10).stream().sorted(Comparator.comparing(n->countOf(n, '0')));
    public long countOf (int n, char ch){
        return String.valueOf(n).chars().filter(c->c == ch).count();
    }
----------------------------------

🔹 Задача 9: Сортувати слова за кількістю голосних у зростанні
-
📥 List.of("apple", "zebra", "sky", "education")
📤 ["sky", "zebra", "apple", "education"]

💡 Comparator.comparing(w -> countVowels(w))

        List.of("apple", "zebra", "sky", "education").stream()
                .sorted(Comparator
                        .comparing(a->countVowels(a)))
                .collect(Collectors.toList());
    }

    public long countVowels(String word) {
        return word.chars().filter(c->"aeiou".indexOf(c)>=0).count();
    }
