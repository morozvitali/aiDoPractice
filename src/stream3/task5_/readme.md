Блок 5 — Comparator / Sorting / toMap / entries (10 задач)

Мета: складніші сортування, комбіновані порівняння, робота з Map.Entry.

5.1 — Сортувати за кількістю голосних, потім алфавіт

Умова: custom comparator через thenComparing.
Рішення:

return words.stream()
.sorted(Comparator.comparingInt((String w) -> (int)w.chars().filter(c->"aeiou".indexOf(c)>=0).count())
.thenComparing(Comparator.naturalOrder()))
.collect(Collectors.toList());


Коментар: multi-criteria sorting.

5.2 — Сортування чисел: парні першими, всередині спадання

Рішення: (як у твоєму файлі)

return numbers.stream()
.sorted(Comparator.comparingInt((Integer n)-> n % 2).thenComparing(Comparator.reverseOrder()))
.collect(Collectors.toList());


Коментар: використовуємо два критерії.

5.3 — Сортувати Map<Integer,List<String>> за розміром списку

Умова: повернути LinkedHashMap в порядку зростання розміру списків.
Рішення:

return input.entrySet().stream()
.sorted(Comparator.comparingInt(e -> e.getValue().size()))
.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a,b)->b, LinkedHashMap::new));


Теорія: .entrySet().stream() — шаблон для сортування map.

5.4 — Сортувати слова за довжиною у зворотному порядку

Рішення:

return words.stream().sorted(Comparator.comparing(String::length).reversed()).collect(Collectors.toList());


Коментар: reversed() інвертує порядок.

5.5 — Сортування Map за значенням (reverse)

Умова: {a=2,b=5,c=1} → b,a,c
Рішення: (аналогічно 4.8)

return map.entrySet().stream()
.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(e1,e2)->e1,LinkedHashMap::new));


Теорія: зберігаємо порядок через LinkedHashMap.

5.6 — Знайти слово з найбільшою кількістю літер 'a'

Умова: List.of("alpha","arena","java","banana","lava") → "banana"
Рішення:

return words.stream().max(Comparator.comparingLong(w -> w.chars().filter(c->c=='a').count())).orElse("");


Коментар: map->count pattern, потім max.

5.7 — Сортування з thenComparing: vowels then length

Умова: спочатку за кількістю голосних, якщо рівно — за довжиною.
Рішення:

return words.stream().sorted(Comparator.comparingInt((String w)-> countVowels(w)).thenComparingInt(String::length)).collect(Collectors.toList());


Коментар: thenComparingInt прискорює для int.

5.8 — Витягти топ-N елементів після сортування Map.Entry

Умова: повернути keys top-N за value.
Рішення:

return map.entrySet().stream()
.sorted(Map.Entry.<K,Long>comparingByValue().reversed())
.limit(n)
.map(Map.Entry::getKey)
.collect(Collectors.toList());


Теорія: часто корисно у frequency-based задачах.

5.9 — Перетворити list → Map<element, count>

Умова: ["1","2","2","3","3","3"] → Map<Long,Long> (value→count).
Рішення:

return inputs.stream().map(Long::valueOf).collect(Collectors.groupingBy(x->x, Collectors.counting()));


Коментар: стандартна побудова frequency map.

5.10 — Найчастіший перший символ (виправлений)

Умова: знайти найчастіший перший символ (коректна версія).
Рішення:

return Arrays.stream(words)
.collect(Collectors.groupingBy(w->w.charAt(0), Collectors.counting()))
.entrySet().stream()
.max(Map.Entry.comparingByValue())
.map(Map.Entry::getKey)
.orElse(null);


Коментар: зверни увагу на коректний Comparator та типи.
