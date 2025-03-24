Давай дам тобі ще одну цікаву задачу з .reduce(...), щоб зміцнити твоє розуміння.

🧠 Завдання 3 — Знайти слово з найбільшою кількістю голосних
Умова: Дано рядок зі слів. Потрібно знайти слово, яке містить найбільше голосних (a, e, i, o, u).
Якщо таких декілька — поверни останнє (праве) з них.

🔠 Приклади:
"hello world"          ➜ "hello"   // 2 голосні vs 1
"apple orange banana"  ➜ "orange"  // 3 голосні vs 3 vs 3 → беремо останнє
"sky dry why"          ➜ "sky"     // всі 0 голосних → беремо останнє

✍️ Скелет методу:
public static String wordWithMostVowels(String sentence) {
String[] words = sentence.split(" ");
return Arrays.stream(words)
.reduce(words[0], (w1, w2) ->
countVowels(w2) >= countVowels(w1) ? w2 : w1);
}

🧩 Допоміжний метод:
private static int countVowels(String word) {
return (int) word.toLowerCase().chars()
.filter(c -> "aeiou".indexOf(c) >= 0)
.count();
}

🧪 Перевірка:
System.out.println(wordWithMostVowels("hello world"));           // ➜ "hello"
System.out.println(wordWithMostVowels("apple orange banana"));   // ➜ "banana"
System.out.println(wordWithMostVowels("sky dry why"));           // ➜ "why"


🔍 Що ми тут робимо:

split(" ") — поділили рядок на слова

stream(...)

reduce(...)

Порівнюємо кількість голосних у словах
Якщо w2 має більше або стільки ж голосних — беремо w2 (праве)
countVowels() — метод, який перетворює слово в символи та рахує голосні