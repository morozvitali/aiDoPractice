4.1 — Відфільтрувати >50, відсортувати спаданням, повернути unmodifiable List

Умова: [10,70,20,90,55,30] → [90,70,55] (unmodifiable).
Рішення:

return numbers.stream()
.filter(n -> n > 50)
.sorted(Comparator.reverseOrder())
.collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));


Теорія: приклад з файлу — стандартний use-case.

4.2 — Повернути перший елемент або "empty" через collectingAndThen

Умова: зібрати слова довше за 6 → повернути перший або "empty".
Рішення:

return Stream.of(words)
.filter(w -> w.length() > 6)
.collect(Collectors.collectingAndThen(Collectors.toList(), list -> list.isEmpty() ? "empty" : list.get(0)));


Коментар: безпечна витяжка з колекції.

4.3 — Топ-3 слів з найбільшою кількістю голосних → unmodifiableList

Умова: вибрати топ-3 по кількості голосних, lowerCase.
Рішення:

return Stream.of("cooperation", "stream", "banana", "supernova", "moon", "queueing", "idealism")
.filter(w -> w.chars().filter(c -> "aeiou".indexOf(c) >=0).count() > 1)
.map(String::toLowerCase)
.sorted(Comparator.comparingLong((String w) -> w.chars().filter(c -> "aeiou".indexOf(c) >=0).count()).reversed())
.limit(3)
.collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));


Коментар: приклад advanced collectingAndThen.

4.4 — Список непарних → рядок через collectingAndThen

Умова: [1,2,3,4,5] → "1, 3, 5".
Рішення:

String result = List.of(1,2,3,4,5).stream()
.filter(n -> n % 2 != 0)
.map(String::valueOf)
.collect(Collectors.collectingAndThen(Collectors.toList(), list -> String.join(", ", list)));


Коментар: простий шаблон для перетворення list→string.

4.5 — Знайти слово з точно 2 голосними (і кинути IllegalStateException, якщо не точно одне)

Умова: якщо більше або менше — помилка.
Рішення:

return words.stream()
.filter(w -> w.replaceAll("[^aeiouAEIOU]", "").length() == 2)
.collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
if (list.size() != 1) throw new IllegalStateException("Expected exactly one");
return list.get(0);
}));


Коментар: показує як через collectingAndThen виконувати валідацію.

4.6 — Map довжина → average vowels → unmodifiableMap

Умова: як у 3.10, але через nested collectingAndThen.
Рішення: (див. 3.10) — те ж саме, але обгорнуте в unmodifiableMap.

4.7 — Зібрати Set та витягнути перший елемент (без гарантій)

Умова: зібрати у Set і повернути один елемент.
Рішення:

return list.stream().collect(Collectors.collectingAndThen(Collectors.toSet(), set -> set.iterator().next()));


Коментар: небезпечно, бо порядок у Set не гарантується.

4.8 — Зібрати Map<String,Long> частот та повернути LinkedHashMap відсортовану за спаданням

Умова: посортувати мапу за значенням і повернути LinkedHashMap.
Рішення:

return map.entrySet().stream()
.sorted(Map.Entry.<String,Long>comparingByValue(Comparator.reverseOrder()))
.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a,b)->a, LinkedHashMap::new));


Теорія: toMap з LinkedHashMap зберігає порядок вставки.

4.9 — Зібрати перші N унікальних слів → unmodifiableList

Умова: обмежити до N унікальних після distinct.
Рішення:

return sentences.stream()
.flatMap(s -> Arrays.stream(s.split("\\s+")))
.map(String::toLowerCase)
.distinct()
.limit(n)
.collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));


Коментар: limit після distinct — важливо для очікуваного результату.

4.10 — Перетворити результати колектора в інший тип (collectingAndThen)

Умова: зібрати List → повернути його розмір (Integer).
Рішення:

return data.stream().collect(Collectors.collectingAndThen(Collectors.toList(), List::size));


Теорія: класичний приклад перетворення результату.
