Блок 1 — Основи Stream (10 задач)

Мета: закріпити map/filter/sorted/collect, chars(), перетворення String ↔ digits.

1.1 — Сортувати слова за довжиною (>3)

Умова: Взяти список і повернути слова довші за 3, відсортовані за довжиною.
Підказка: .filter(...).sorted(Comparator.comparing(String::length))
Рішення:

return words.stream()
.filter(w -> w.length() > 3)
.sorted(Comparator.comparing(String::length))
.collect(Collectors.toList());


Коментар: базове фільтрування → сортування; використовуй method reference для читабельності.

1.2 — Алфавітно (toLowerCase)

Умова: Привести слова до lower-case і відсортувати алфавітно.
Підказка: .map(String::toLowerCase).sorted()
Рішення:

return words.stream()
.map(String::toLowerCase)
.sorted()
.collect(Collectors.toList());


Коментар: map змінює елементи; сортування працює з рядками.

1.3 — Найдовше слово (через Map.entry)

Умова: Знайти слово з максимальною довжиною.
Підказка: .map(w->Map.entry(w,w.length())).max(...)
Рішення:

return words.stream()
.map(w -> Map.entry(w, w.length()))
.max(Comparator.comparingInt(Map.Entry::getValue))
.map(Map.Entry::getKey)
.orElse("");


Коментар: корисний шаблон — пара (ключ,значення) для max/min за значенням.

1.4 — Сума квадратів цифр числа

Умова: Для n = 234 повернути 4+9+16 = 29.
Підказка: String.valueOf(n).chars() → c - '0'
Рішення:

return String.valueOf(n).chars()
.map(c -> c - '0')
.map(d -> d * d)
.sum();


Коментар: chars дає IntStream; перетворення від символу до цифри — c - '0'.

1.5 — Витягти цифри з рядка (sorted unique)

Умова: "a1b2c3x9z7" → [1,2,3,7,9] (відсортовано).
Підказка: .filter(Character::isDigit).mapToObj(Character::getNumericValue)
Рішення:

return s.chars()
.filter(Character::isDigit)
.map(Character::getNumericValue)
.distinct()
.sorted()
.boxed()
.collect(Collectors.toList());


Коментар: distinct + sorted — отримуємо унікальні цифри в порядку.

1.6 — Перевернути цифри числа

Умова: 1234 → 4321 (з урахуванням знаків).
Підказка: StringBuilder(...).reverse()
Рішення:

String s = String.valueOf(Math.abs(n));
int result = Integer.parseInt(new StringBuilder(s).reverse().toString());
return n < 0 ? -result : result;


Коментар: простий спосіб, але обережно з переповненням для дуже великих чисел.

1.7 — Залишити тільки парні цифри

Умова: 123456 → 246 (як число).
Підказка: .filter(d -> d % 2 == 0)
Рішення:

String result = String.valueOf(Math.abs(n)).chars()
.map(c -> c - '0')
.filter(d -> d % 2 == 0)
.mapToObj(String::valueOf)
.collect(Collectors.joining());
return result.isEmpty() ? -1 : Integer.parseInt(result);


Коментар: повертаємо -1, якщо немає парних цифр — це обрана поведінка.

1.8 — Помнож кожну цифру на її позицію

Умова: 234 → "2 6 12" → з'єднати в "2612".
Підказка: IntStream.range(0, s.length())
Рішення:

String s = String.valueOf(Math.abs(n));
String res = IntStream.range(0, s.length())
.mapToObj(i -> String.valueOf((s.charAt(i)-'0') * (i+1)))
.collect(Collectors.joining());
return n < 0 ? -Integer.parseInt(res) : Integer.parseInt(res);


Коментар: позиції зліва направо з 1; збираємо як рядок.

1.9 — Кількість цифр більше 5

Умова: 987654321 → 4 (9,8,7,6).
Підказка: .filter(d -> d > 5).count()
Рішення:

return (int) String.valueOf(Math.abs(n)).chars()
.map(c -> c - '0')
.filter(d -> d > 5)
.count();


Коментар: простий приклад лічильника через stream.

1.10 — Замінити кожну цифру на знак (>5 -> X, інакше O)

Умова: 67894 → "XXOXO".
Підказка: тернарний оператор у mapToObj.
Рішення:

return String.valueOf(Math.abs(n)).chars()
.map(c -> c - '0')
.mapToObj(d -> d > 5 ? "X" : "O")
.collect(Collectors.joining());


Коментар: корисно для простих трансформацій символів.

Блок 2 — FlatMap & chars (10 задач)

Мета: flatMap для строк/масивів, робота з символами, уникати вкладених структур.

2.1 — Зібрати унікальні слова з речень

Умова: список речень → всі унікальні слова в нижньому регістрі.
Рішення:

return sentences.stream()
.flatMap(s -> Arrays.stream(s.split("\\s+")))
.map(String::toLowerCase)
.distinct()
.collect(Collectors.toList());


Теорія: flatMap "розплющує" вкладені колекції.

2.2 — Мінімальне парне число з матриці int[][]

Умова: знайти мінімальне парне у всіх внутрішніх масивах.
Рішення:

return Arrays.stream(matrix)
.flatMapToInt(Arrays::stream)
.filter(x -> x % 2 == 0)
.min();


Коментар: flatMapToInt зручний для числових матриць.

2.3 — Перетворити List<List<Integer>> → відфільтрувати і відсортувати

Умова: "згорнути" усі числа, лишити позитивні, відсортувати.
Рішення:

return lists.stream()
.flatMap(Collection::stream)
.filter(i -> i > 0)
.sorted()
.collect(Collectors.toList());


Теорія: flatMap + фільтрація дають плоский, чистий потік.

2.4 — Зібрати всі домени з email

Умова: отримати домени з ivan@ukr.net і згрупувати за довжиною логіна.
Рішення:

return emails.stream()
.collect(Collectors.groupingBy(
e -> e.substring(0, e.indexOf('@')).length(),
Collectors.mapping(e -> e.substring(e.indexOf('@')+1), Collectors.toList())
));


Коментар: mapping усередині groupingBy — потужне поєднання.

2.5 — Унікальні символи як String (distinct)

Умова: "abracadabra" → ["a","b","r","c","d"].
Рішення:

return s.chars()
.distinct()
.mapToObj(c -> String.valueOf((char)c))
.collect(Collectors.toList());


Коментар: chars → int коди; mapToObj для об’єктів.

2.6 — Витягнути лише великі літери

Умова: "hEllO WoRLd" → ["E","O","W","R","L"]
Рішення:

return input.chars()
.filter(Character::isUpperCase)
.mapToObj(c -> String.valueOf((char)c))
.collect(Collectors.toList());


Коментар: корисно для парсингу метаданих.

2.7 — Рядок → місця в алфавіті

Умова: "abcxyz" → [1,2,3,24,25,26]
Рішення:

return s.chars()
.map(c -> c - 'a' + 1)
.boxed()
.collect(Collectors.toList());


Теорія: арифметика з символами.

2.8 — Витягти лише букви й відсортувати у зворотному порядку

Умова: "a1C!bZ2" → ['Z','C','b','a']
Рішення:

return s.chars()
.filter(Character::isAlphabetic)
.mapToObj(c -> (char)c)
.sorted(Comparator.reverseOrder())
.collect(Collectors.toList());


Коментар: boxed/char — потрібне для comparator.

2.9 — Порахувати суму ASCII-кодів слова

Умова: ["abc","aaa","zzz"] → "zzz" має найбільшу суму.
Рішення:

return list.stream()
.max(Comparator.comparingInt(w -> w.chars().sum()))
.orElse("");


Теорія: chars().sum() дає суму кодів символів.

2.10 — Кількість літер у рядку (частотний мап)

Умова: "banana" → {b=1,a=3,n=2}
Рішення:

return s.chars()
.filter(Character::isLetter)
.mapToObj(c -> (char)c)
.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


Коментар: groupBy + counting — стандарт для частот.

Блок 3 — Grouping / Partitioning / Counting (10 задач)

Мета: groupingBy, partitioningBy, counting, averaging, summaryStatistics.

3.1 — Map слово → чи має голосні

Умова: повернути Map<String,Boolean>.
Рішення:

return Arrays.stream(words)
.collect(Collectors.toMap(Function.identity(),
w -> w.chars().anyMatch(c -> "aeiou".indexOf(c) >= 0)));


Коментар: toMap з булевою функцією.

3.2 — Розділити слова на ті, що містять голосну і ні

Умова: partitioningBy → Map<Boolean,List<String>>.
Рішення:

return Arrays.stream(words)
.collect(Collectors.partitioningBy(w -> w.chars().anyMatch(c -> "aeiou".indexOf(c) >=0)));


Теорія: partitioningBy швидкий для true/false.

3.3 — Порахувати кількість слів за довжиною (ті, що містять голосну)

Умова: groupingBy length + counting.
Рішення:

return Arrays.stream(words)
.filter(w -> w.chars().anyMatch(c -> "aeiou".indexOf(c) >=0))
.collect(Collectors.groupingBy(String::length, Collectors.counting()));


Коментар: комбінуємо фільтр і groupingBy.

3.4 — Map<перша літера, середня довжина>

Умова: для кожної першої літери порахувати average length.
Рішення:

return Arrays.stream(words)
.collect(Collectors.groupingBy(w -> w.charAt(0), Collectors.averagingInt(String::length)));


Теорія: averagingInt дає Double.

3.5 — Найчастіший перший символ

Умова: знайти символ найчастіше на початку слів.
Рішення:

Map<Character, Long> map = Arrays.stream(words).collect(Collectors.groupingBy(w -> w.charAt(0), Collectors.counting()));
return map.entrySet().stream().max(Comparator.comparingLong(Map.Entry::getValue)).map(Map.Entry::getKey).orElse(null);


Коментар: два кроки: grouping -> max.

3.6 — Map довжина → words (але в UpperCase)

Умова: згрупувати слова за довжиною, але значення — uppercase списки.
Рішення:

return Arrays.stream(words).collect(Collectors.groupingBy(String::length, Collectors.mapping(String::toUpperCase, Collectors.toList())));


Теорія: mapping використовується для трансформації елементів перед колекцією.

3.7 — IntSummaryStatistics по довжинах слів з повторюваними буквами

Умова: відфільтрувати слова з повторюваними буквами → summaryStatistics по довжинах.
Рішення:

return Arrays.stream(words)
.filter(w -> hasRepeatingLetters(w))
.mapToInt(String::length)
.summaryStatistics();


Коментар: hasRepeatingLetters — допоміжний метод, що перевіряє дублікати.

3.8 — Побудувати Map<Boolean,List<String>> — починаються з великої літери

Умова: розділити по першому символу UpperCase.
Рішення:

return Arrays.stream(words).collect(Collectors.partitioningBy(w -> Character.isUpperCase(w.charAt(0))));


Коментар: зручне для UI/форматування.

3.9 — Найдовше слово, що починається з великої літери

Умова: знайти найбільше слово серед тих, що починаються з UpperCase.
Рішення:

return Arrays.stream(words)
.filter(w -> Character.isUpperCase(w.charAt(0)))
.max(Comparator.comparingInt(String::length))
.orElse("");


Коментар: подібний шаблон для будь-якого фільтру + max.

3.10 — Map<довжина, середня кількість голосних> — unmodifiable

Умова: зробити результат незмінним Map.
Рішення:

return Stream.of(words).collect(Collectors.collectingAndThen(
Collectors.groupingBy(String::length, Collectors.averagingInt(
w -> (int) w.chars().filter(c -> "aeiou".indexOf(c) >= 0).count()
)),
Collections::unmodifiableMap
));


Теорія: collectingAndThen дозволяє обгорнути результат у read-only.

(Приклади на тему collectingAndThen зустрічаються в твоєму файлі — я опирався на них).

Блок 4 — Collectors & collectingAndThen (10 задач)

Мета: навчитися комбінувати колектори, використовувати collectingAndThen, toList→unmodifiableList, mapping, flatMapping.

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

Блок 6 — Advanced / Challenges / Mixed (10 задач)

Мета: комбіновані приклади, custom checks, edge-cases, collectingAndThen validation.

6.1 — Знайти єдине слово, що містить 'p' (інакше виняток)

Умова: якщо не рівно одне — кидати IllegalStateException.
Рішення:

String res = data.stream().filter(w -> w.contains("p")).collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
if (list.size()!=1) throw new IllegalStateException("Expected exactly one word with 'p'");
return list.get(0);
}));


Теорія: демонстрація валідації після collect.

6.2 — Слова, що містять усі голосні (a,e,i,o,u)

Умова: знайти слова, що містять всі голосні.
Рішення:

return Arrays.stream(words)
.filter(w -> "aeiou".chars().allMatch(c -> w.indexOf(c) >= 0))
.collect(Collectors.toList());


Коментар: allMatch по символам — досить жорсткий фільтр.

6.3 — Згенерувати 100 випадкових int, відфільтрувати позитивні, відсортувати та взяти топ-10

Рішення:

List<Long> top10 = new Random().ints(100, -100, 101)
.mapToObj(String::valueOf)
.map(Long::valueOf)
.filter(n -> n > 0)
.sorted(Comparator.reverseOrder())
.limit(10)
.collect(Collectors.toList());


Теорія: демонстрація pipeline з рандомом.

6.4 — Порахувати, скільки груп за останньою літерою

Умова: ["hi","hello","mango","go","halo","yo"] → 3
Рішення:

return Stream.of("hi","hello","mango","go","halo","yo")
.collect(Collectors.groupingBy(w->w.charAt(w.length()-1)))
.size();


Коментар: groupingBy + size для кількості груп.

6.5 — Тренажер peek: показати проміжні стани

Умова: надрукувати початкові слова, upper-case, і фінальний список >3.
Рішення: (шаблон)

List<String> result = words.stream()
.peek(w -> System.out.println("Початкове: " + w))
.map(String::toUpperCase)
.peek(w -> System.out.println("Upper: " + w))
.filter(w -> w.length() > 3)
.collect(Collectors.toList());


Теорія: peek — корисний для debug pipeline.

6.6 — Product of digits at odd indexes

Умова: n=123456 → product of digits at indexes 1,3,5 → 246 = 48.
Рішення:

int[] digits = String.valueOf(n).chars().map(c->c-'0').toArray();
return IntStream.range(0, digits.length).filter(i->i%2==1).map(i->digits[i]).reduce(1,(a,b)->a*b);


Коментар: комбінуємо range + index lookup.

6.7 — Згенерувати Map<довжина, List<words>> але відфільтрувати дзеркальні/пусті

Умова: згрупувати за довжиною, ігнорувати пусті та palindrome.
Рішення:

return Arrays.stream(words)
.filter(w -> !w.isBlank() && !isPalindrome(w))
.collect(Collectors.groupingBy(String::length));


Теорія: демонструє поєднання фільтрів з groupingBy.

6.8 — Знайти число з найбільшою кількістю різних цифр

Умова: List.of(111,123,444,9087) → 9087 (має 4 різні цифри).
Рішення:

return numbers.stream()
.max(Comparator.comparingInt(n -> String.valueOf(Math.abs(n)).chars().distinct().map(c->c-'0').count()))
.orElse(0);


Коментар: distinct() по chars дає різні символи.

6.9 — Collectors.flatMapping (hobbies) → group by first letter of hobby

Умова: є список людей з hobbies → згрупувати всі хобі за першою літерою.
Рішення (flatMap варіант):

return people.stream()
.flatMap(p -> p.hobbies().stream())
.collect(Collectors.groupingBy(h -> h.charAt(0), Collectors.toSet()));


Теорія: flatMapping також існує як вбудований колектор (Java16+), але flatMap + groupingBy — універсальний варіант.

6.10 — Final challenge: складний pipeline (filter+map+group+collectingAndThen)

Умова: відфільтрувати слова з >2 голосними, привести до lowerCase, згрупувати по останній літері, для кожної групи повернути список унікальних слів і зробити map незмінним.
Рішення:

return Stream.of(words)
.filter(w -> w.chars().filter(c->"aeiou".indexOf(c)>=0).count() > 2)
.map(String::toLowerCase)
.collect(Collectors.collectingAndThen(
Collectors.groupingBy(w->w.charAt(w.length()-1), Collectors.mapping(Function.identity(), Collectors.toSet())),
Collections::unmodifiableMap
));


Коментар: комбінуємо кілька концептів в одному pipe — ідеальний підсумковий приклад.