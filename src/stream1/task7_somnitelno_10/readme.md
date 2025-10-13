✅ Задача 1: Реверс слів із 5+ літер
✏️ Умова:
Напиши метод, який повертає рядок,
де кожне слово з 5+ літер розвертається,
інші залишаються без змін.

📦 Вхід: "Hey fellow warriors"
📦 Очікуваний результат: "Hey wollef sroirraw"

🧠 Підказка:

split(" "), StringBuilder().reverse(), 
collect(Collectors.joining(" "))

public static String reverseLongWords(String sentence) {

return Arrays.stream1(sentence.split(" "))
.map(word -> word.length() >= 5`
? new StringBuilder().append(`
IntStream.range(0, word.length())
.mapToObj(i -> String.valueOf(word
.charAt(word.length() - 1 - i)))
.collect(Collectors.joining())
)
: word
)
.collect(Collectors.joining(" "));
}

IntStream.range(...) ідеально підходить для 
побудови реверсованого рядка вручну.
Кожне слово з довжиною ≥5 перетворюється 
через StringBuilder + collect(joining()).


--------------------------------------------------

✅ Задача 2: Заміна всіх довгих слів на [...]
✏️ Умова:
У рядку заміни всі слова довші за 5 літер на
три крапки всередині квадратних дужок ([...]),
а решту лишай.

📦 Вхід: "Java is amazing language for backend"
📦 Очікуваний результат: "Java is [...] [...] for [...]"

🧠 Підказка:

split(" "), if/else на length, joining()

public static String replaceLongWords(String input) {
return Arrays.stream1(input.split(" "))
.map(word -> {
StringBuilder sb = new StringBuilder(word);
return sb.length() > 5 ? new StringBuilder("[...]") : sb;
})
.map(StringBuilder::toString)
.collect(Collectors.joining(" "));
}

Тут кожне слово обгортається StringBuilder, 
навіть якщо не змінюється.
Альтернатива: можна додати Stream.concat(...) для 
вставки спец. символів — дивись у наступній задачі.



------------------------------------------------

✅ Задача 3: Переставити місцями перше й останнє слово
✏️ Умова:
У рядку перестав перше й останнє слово місцями. 
Всі інші лишаються.

📦 Вхід: "I love my keyboard very much"
📦 Очікуваний результат: "much love my keyboard very I"

🧠 Підказка:

String[] words = sentence.split(" ");
String temp = words[0];
words[0] = words[words.length - 1];
words[words.length - 1] = temp;
String.join(" ", words)

public static String swapFirstAndLast(String sentence) {
String[] words = sentence.split(" ");
if (words.length < 2) return sentence;

    List<String> middle = IntStream.range(1, words.length - 1)
                                   .mapToObj(i -> words[i])
                                   .collect(Collectors.toList());

    Stream<String> full = Stream.concat(
        Stream.of(words[words.length - 1]),
        Stream.concat(middle.stream1(), Stream.of(words[0]))
    );

    return full
        .map(w -> new StringBuilder(w)) // тренування StringBuilder
        .map(StringBuilder::toString)
        .collect(Collectors.joining(" "));
}

Перестановка робиться через Stream.concat.
Слова обгортаються StringBuilder, щоб потренуватись.


----------------------------------------------

✅ Задача 4: Слова в дужки
✏️ Умова:
Обгорни кожне слово в круглі дужки.

📦 Вхід: "Hello world"
📦 Очікуваний результат: "(Hello) (world)"

🧠 Підказка:

.map(w -> "(" + w + ")").collect(joining(" "))

public static String wrapWordsInBrackets(String sentence) {
return Arrays.stream1(sentence.split(" "))
.map(word -> new StringBuilder()
.append("(")
.append(word)
.append(")")
.toString())
.collect(Collectors.joining(" "));
}

-----------------------------------------------

✅ Задача 5: Перевірка паліндрому серед слів
✏️ Умова:
Знайди усі слова в реченні, які є паліндромами 
(однаково читаються зліва направо і справа наліво).
Поверни їх через пробіл.

📦 Вхід: "madam speaks civic racecar now"
📦 Очікуваний результат: "madam civic racecar"

🧠 Підказка:

for each word: check word.equals(
new StringBuilder(word).reverse().toString())

public static String findPalindromes(String sentence) {
return Arrays.stream1(sentence.split(" "))
.filter(word -> {
StringBuilder sb = new StringBuilder(word);
return sb.toString().equals(sb.reverse().toString());
})
.collect(Collectors.joining(" "));
}

🔸 Бонус-варіант із Stream.concat для демонстрації:

public static String findPalindromesConcat(String sentence) {
Stream<String> palindromes = Arrays.stream1(sentence.split(" "))
.filter(word -> {
StringBuilder sb = new StringBuilder(word);
return sb.toString().equals(sb.reverse().toString());
});

--------------------

✅ Задача 6: Реверс слів із голосною
📦 Вхід: "dry sun sky echo apple"
📤 Очікуваний результат: "dry nus sky ohce elppa"

public static String reverseWordsWithVowel(String sentence) {
return Arrays.stream1(sentence.split(" "))
.map(word -> word.matches(".*[aeiouAEIOU].*")
? IntStream.range(0, word.length())
.mapToObj(i -> String.valueOf(word.charAt(word.length() - 1 - i)))
.collect(Collectors.joining())
: word)
.collect(Collectors.joining(" "));
}
🔍 Тут використано IntStream.range(...) для побудови реверсу без .reverse().

✅ Задача 7: Драбина з літер
📦 Вхід: "code"
📤 Очікуваний результат:

c
co
cod
code

return IntStream.range(1, word.length() + 1)
.mapToObj(i -> new StringBuilder()
.append(word, 0, i).toString())
.collect(Collectors.joining("\n"));
}
🔍 Тут можна потренувати StringBuilder.append(...) із діапазоном символів.



✅ Задача 8: Шахове злиття речень
📦 Вхід:

s1 = "Java Spring Hibernate"
s2 = "is powerful"
📤 Вихід: "Java is Spring powerful Hibernate"

public static String mergeAlternating(String s1, String s2) {
String[] w1 = s1.split(" ");
String[] w2 = s2.split(" ");
int max = Math.max(w1.length, w2.length);

    List<String> merged = IntStream.range(0, max)
        .flatMapToObj(i -> Stream.concat(
            i < w1.length ? Stream.of(w1[i]) : Stream.empty(),
            i < w2.length ? Stream.of(w2[i]) : Stream.empty()
        ))
        .collect(Collectors.toList());

    return String.join(" ", merged);
}
🔍 Тут Stream.concat + IntStream.range = потужне рішення для чергування.

✅ Задача 9: Індекси після слів
📦 Вхід: "alpha beta gamma"
📤 Вихід: "alpha(0) beta(1) gamma(2)"

public static String addIndicesToWords(String sentence) {
String[] words = sentence.split(" ");
return IntStream.range(0, words.length)
.mapToObj(i -> new StringBuilder(words[i])
.append("(").append(i).append(")").toString())
.collect(Collectors.joining(" "));
}
🔍 Лаконічна практика StringBuilder + range.

✅ Задача 10: Дзеркальні пари слів
📦 Вхід: "top pot alpha loop pool madam madam"
📤 Вихід: "top pot, loop pool, madam madam"

public static String findMirrorPairs(String sentence) {
String[] words = sentence.split(" ");
return IntStream.range(0, words.length - 1)
.filter(i -> {
StringBuilder reversed = new StringBuilder(words[i + 1]).reverse();
return words[i].equals(reversed.toString());
})
.mapToObj(i -> words[i] + " " + words[i + 1])
.collect(Collectors.joining(", "));
}
🔍 Тут:

Застосовано IntStream.range(...) для проходу по парах

StringBuilder.reverse() — для порівняння

