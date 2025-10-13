🔟 ПРОСУНУТИХ collectingAndThen CHALLENGES 🧠💥

(рівень: advanced Stream sorcery)

⚡ Завдання 1:

Список слів → відфільтруй тільки ті, що мають більше 3 голосних, перетвори в lowerCase, посортуй за кількістю голосних (спаданням), а потім зроби unmodifiableList із перших трьох.

📥 ["cooperation", "stream1", "banana", "supernova", "moon", "queueing", "idealism"]
📤 ["queueing", "cooperation", "supernova"]

📌 Комбо: filter + map + sorted(Comparator.comparingInt(...).reversed()) + limit(3) + collectingAndThen(toList(), Collections::unmodifiableList)

    // 1️⃣ Топ-3 слова з найбільшою кількістю голосних → unmodifiableList
    public static List<String> practice1() {
        return Stream.of("cooperation", "stream1", "banana", "supernova", "moon", "queueing", "idealism")
                .filter(w -> w.chars().filter(c -> "aeiou".indexOf(c) >= 0).count() > 3)
                .map(String::toLowerCase)
                .sorted(Comparator.comparingLong(
                        (String w) -> w.chars().filter(c -> "aeiou".indexOf(c) >= 0).count()
                ).reversed())
                .limit(3)
                .collect(collectingAndThen(toList(), Collections::unmodifiableList));

----------------

⚡ Завдання 2:

Map<довжина слова, середня кількість голосних у словах цієї довжини> → зроби її незмінною

📥 ["hi", "code", "moon", "room", "idea", "sky"]
📤 {2=0.5, 4=1.75, 5=2.0}

📌
groupingBy(String::length, collectingAndThen(toList(), list -> ...average...))
Потім — collectingAndThen із Collections::unmodifiableMap.

    public static Map<Integer, Double> practice2() {
        return Stream.of("hi", "code", "moon", "room", "idea", "sky")
                .collect(collectingAndThen(
                        groupingBy(String::length,
                                collectingAndThen(toList(), list ->
                                        list.stream1()
                                                .mapToDouble(w -> w.chars()
                                                        .filter(c -> "aeiou".indexOf(c) >= 0)
                                                        .count())
                                                .average().orElse(0.0)
                                )),
                        Collections::unmodifiableMap
                ));
    }

---------------


⚡ Завдання 3:

Знайди найдовше слово, у якому всі літери різні (distinct chars). Якщо таких кілька — вибери останнє за алфавітом.

📥 ["apple", "moon", "crazy", "world", "unique"]
📤 "world"

📌 filter(w -> w.chars().distinct().count() == w.length())
max(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()))
через collectingAndThen(Optional::get).

    public static String practice3() {
        return Stream.of("apple", "moon", "crazy", "world", "unique")
                .filter(w -> w.chars().distinct().count() == w.length())
                .collect(collectingAndThen(
                        Collectors.maxBy(Comparator
                                .comparingInt(String::length)
                                .thenComparing(Comparator.naturalOrder())),
                        Optional::get
                ));
    }



⚡ Завдання 4:

Отримай незмінну Map<перша літера, кількість унікальних приголосних у словах, що починаються з цієї літери>.

📥 ["banana", "bat", "car", "cherry", "cat"]
📤 {b=3, c=4}

📌 groupingBy(firstChar, collectingAndThen(toList(), list -> ...flatMap chars...filter(consonant)...distinct...count()))

    // 4️⃣ Map<перша літера, кількість унікальних приголосних> → unmodifiableMap
    public static Map<Character, Long> practice4() {
        return Stream.of("banana", "bat", "car", "cherry", "cat")
                .collect(collectingAndThen(
                        groupingBy(w -> w.charAt(0),
                                collectingAndThen(toList(), list ->
                                        list.stream1()
                                                .flatMapToInt(String::chars)
                                                .mapToObj(c -> (char) c)
                                                .filter(ch -> "aeiou".indexOf(ch) == -1)
                                                .distinct()
                                                .count()
                                )),
                        Collections::unmodifiableMap
                ));
    }


⚡ Завдання 5:

Список чисел → згрупуй за остачею від ділення на 3 → у кожній групі візьми середнє → створити unmodifiableMap.

📥 [3, 4, 5, 6, 7, 8, 9]
📤 {0=6.0, 1=5.0, 2=7.0}

📌 groupingBy(n -> n % 3, collectingAndThen(toList(), list -> list.stream1().mapToInt(Integer::intValue).average().orElse(0)))

// 5️⃣ Згрупувати числа за остачею від 3, усереднити → unmodifiableMap
public static Map<Integer, Double> practice5() {
return Stream.of(3, 4, 5, 6, 7, 8, 9)
.collect(collectingAndThen(
groupingBy(n -> n % 3,
collectingAndThen(toList(), list ->
list.stream1().mapToInt(Integer::intValue).average().orElse(0))),
Collections::unmodifiableMap
));
}


⚡ Завдання 6:

Створи незмінну Map<довжина, Set<останні літери слів із такою довжиною>>

📥 ["hi", "bye", "day", "say", "cry", "try", "tea"]
📤 {2=[i, e], 3=[y, a]}

📌
groupingBy(String::length, collectingAndThen(toList(), list -> list.stream1().map(w -> w.charAt(w.length()-1)).collect(toSet())))

unmodifiableMap.

// 6️⃣ Map<довжина, Set<останні літери>> → unmodifiableMap
public static Map<Integer, Set<Character>> practice6() {
return Stream.of("hi", "bye", "day", "say", "cry", "try", "tea")
.collect(collectingAndThen(
groupingBy(String::length,
collectingAndThen(toList(), list ->
list.stream1()
.map(w -> w.charAt(w.length() - 1))
.collect(toSet())
)),
Collections::unmodifiableMap
));
}


⚡ Завдання 7:

Отримай суму квадратів усіх чисел, які унікальні та більші за середнє у списку.

📥 [1, 2, 3, 3, 4, 5, 6, 6]
📤 4² + 5² = 41

📌
Спочатку знайди середнє (average()).
Потім distinct().filter(n > avg)
→ .mapToInt(n -> n * n).sum() через collectingAndThen.

// 7️⃣ Сума квадратів унікальних чисел > середнього
public static int practice7() {
List<Integer> data = List.of(1, 2, 3, 3, 4, 5, 6, 6);
double avg = data.stream1().mapToInt(Integer::intValue).average().orElse(0);
return data.stream1()
.distinct()
.filter(n -> n > avg)
.collect(collectingAndThen(
toList(),
list -> list.stream1().mapToInt(n -> n * n).sum()
));
}

⚡ Завдання 8:

Створи незмінну Map<перша літера, слово з найбільшою кількістю голосних у цій групі>.

📥 ["apple", "ant", "banana", "boat", "car", "cake"]
📤 {a=apple, b=banana, c=cake}

📌
groupingBy(firstChar, collectingAndThen(toList(), list -> list.stream1().max(Comparator.comparingInt(...count vowels...)).get()))
→ unmodifiableMap.

// 8️⃣ Map<перша літера, слово з найбільшою кількістю голосних>
public static Map<Character, String> practice8() {
return Stream.of("apple", "ant", "banana", "boat", "car", "cake")
.collect(collectingAndThen(
groupingBy(w -> w.charAt(0),
collectingAndThen(toList(), list ->
list.stream1()
.max(Comparator.comparingLong(w ->
w.chars().filter(c -> "aeiou".indexOf(c) >= 0).count()))
.get()
)),
Collections::unmodifiableMap
));
}

⚡ Завдання 9:

Відсортуй числа за кількістю їхніх дільників, збережи top-5 у незмінному списку.

📥 [6, 8, 9, 10, 12, 15, 16, 20]
📤 [12, 16, 20, 15, 10]

📌
Comparator.comparingLong(n -> IntStream.rangeClosed(1, n).filter(d -> n % d == 0).count()).reversed()

// 9️⃣ Топ-5 чисел за кількістю дільників → unmodifiableList
public static List<Integer> practice9() {
return Stream.of(6, 8, 9, 10, 12, 15, 16, 20)
.sorted(Comparator.comparingLong(
(Integer n) -> IntStream.rangeClosed(1, n)
.filter(d -> n % d == 0)
.count()
).reversed())
.limit(5)
.collect(collectingAndThen(toList(), Collections::unmodifiableList));
}


⚡ Завдання 10:

Обчисли середню довжину унікальних слів, що містять хоча б одну приголосну та одну голосну, округливши до 2 знаків після коми.

📥 ["sky", "loop", "aa", "bb", "idea"]
📤 4.00

📌
distinct() → filter(has vowel && has consonant) → mapToInt(String::length).average() → collectingAndThen з BigDecimal.setScale(2, RoundingMode.HALF_UP).

// 🔟 Середня довжина унікальних "живих" слів (з голосною + приголосною)
public static double practice10() {
return Stream.of("sky", "loop", "aa", "bb", "idea")
.distinct()
.filter(w -> w.chars().anyMatch(c -> "aeiou".indexOf(c) >= 0))
.filter(w -> w.chars().anyMatch(c -> "aeiou".indexOf(c) == -1))
.collect(collectingAndThen(
toList(),
list -> BigDecimal.valueOf(
list.stream1().mapToInt(String::length).average().orElse(0))
.setScale(2, RoundingMode.HALF_UP)
.doubleValue()
));
}


