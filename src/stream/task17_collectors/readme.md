✅ Ця добірка вже охоплює:
joining, summarizing, groupingBy, partitioningBy
вкладені колектори (mapping, reducing, collectingAndThen)
сортування Map, роботу з Set, TreeSet, LinkedHashMap
flatMapping, mapping + partitioningBy — все,
що треба для потужного старту в FP на Java.

📘 ЗАДАЧІ STREAM API – Частина 1: Колектори
✅ Задача 1: joining
📌 У тебе є список імен. Об’єднай їх в один рядок, розділений комами.

List<String> names = List.of("Alice", "Bob", "Charlie");
Очікувано: "Alice, Bob, Charlie"


✅ Задача 2: Summarizing
📌 Є список чисел. Отримай статистику: кількість, суму, мінімум, максимум, середнє.

List<Integer> numbers = List.of(4, 8, 15, 16, 23, 42);
Очікувано:

count = 6
sum = 108
min = 4
max = 42
average = 18.0
public void mySummarizing () {
List<Integer> numbers = List.of(4, 8, 15, 16, 23, 42);
numbers.stream().collect(Collectors.summarizingInt(value -> Integer::sum));
}

✅ Задача 3: groupingBy
📌 Є список слів. Згрупуй їх за довжиною.

List<String> words = List.of("hi", "book", "sun", "day", "Java", "sky");
Очікувано:

{
2=[hi],
3=[sun, day, sky],
4=[book, Java]
}


✅ Задача 4: groupingBy + counting
📌 Порахуйте, скільки разів зустрічається кожна довжина слова.

List<String> words = List.of("hi", "book", "sun", "day", "Java", "sky");
Очікувано:

{
2=1,
3=3,
4=2
}


✅ Задача 5: partitioningBy
📌 Є список чисел. Розділи їх на парні та непарні.

List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
Очікувано:

{
true=[2, 4, 6],
false=[1, 3, 5]
}


✅ Задача 6: groupingBy + mapping
📌 Є список слів. Згрупуй їх за першою літерою, і перетвори кожне слово в верхній регістр.

List<String> words = List.of("apple", "ant", "banana", "bat", "car");
Очікувано:

{
a=[APPLE, ANT],
b=[BANANA, BAT],
c=[CAR]
}

--------------------------------------------------------------------------

📘 STREAM API – Частина 2: Колектори, що розширює ті, які ти вже бачив.
Вони торкаються схожих тем, але додають нові аспекти, такі як mapping, 
toSet(), collectingAndThen, groupingBy(..., mapping(...)), 
partitioningBy(...) з підрахунком.

✅ Задача 7: groupingBy + mapping до довжини
📌 Є список слів. Згрупуй слова за першою літерою, 
але замість самих слів збережи лише їхню довжину.

🔍 Підказка: groupingBy(..., mapping(...))

List<String> words = List.of("apple", "ant", "banana", "bat", "car");
🧪 Очікувано:

{
a=[5, 3],
b=[6, 3],
c=[3]
}

📦 Початковий код:

public Map<Character, List<Integer>> groupByFirstLetterLength() {
List<String> words = List.of("apple", "ant", "banana", "bat", "car");
return words.stream()
.collect(Collectors.groupingBy(
word -> word.charAt(0),
Collectors.mapping(String::length, Collectors.toList())
));
}
✅ Задача 8: partitioningBy з підрахунком
📌 Є список чисел. Порахуйте скільки серед них парних і непарних.

🔍 Підказка: partitioningBy(..., counting())

List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
🧪 Очікувано:

java
Copy
Edit
{
true=3,
false=3
}
📦 Початковий код:

public Map<Boolean, Long> countEvenOdd() {
List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
return numbers.stream()
.collect(Collectors.partitioningBy(
n -> n % 2 == 0,
Collectors.counting()
));
}
✅ Задача 9: groupingBy + toSet
📌 Є список рядків. Згрупуй слова за довжиною, але зберігай кожну групу без повторень.

🔍 Підказка: Collectors.toSet()

List<String> words = List.of("hi", "hi", "book", "sun", "day", "Java", "sky");
🧪 Очікувано:

{
2=[hi],
3=[sun, day, sky],
4=[book, Java]
}
📦 Початковий код:

public Map<Integer, Set<String>> groupUniqueByLength() {
List<String> words = List.of("hi", "hi", "book", "sun", "day", "Java", "sky");
return words.stream()
.collect(Collectors.groupingBy(
String::length,
Collectors.toSet()
));
}
✅ Задача 10: collectingAndThen
📌 Отримай кількість чисел у списку, але як String, наприклад "Count: 6".

🔍 Підказка: collectingAndThen(...)

List<Integer> numbers = List.of(4, 8, 15, 16, 23, 42);
🧪 Очікувано: "Count: 6"

📦 Початковий код:

public String countAsString() {
List<Integer> numbers = List.of(4, 8, 15, 16, 23, 42);
return numbers.stream()
.collect(Collectors.collectingAndThen(
Collectors.counting(),
count -> "Count: " + count
));
}
✅ Задача 11: groupingBy + joining
📌 Є список слів. Згрупуй їх за першою літерою та об’єднай кожну групу у рядок.

🔍 Підказка: groupingBy(..., joining())

List<String> words = List.of("apple", "ant", "banana", "bat", "car");
🧪 Очікувано:

{
a="apple, ant",
b="banana, bat",
c="car"
}
📦 Початковий код:

public Map<Character, String> groupAndJoinByFirstLetter() {
List<String> words = List.of("apple", "ant", "banana", "bat", "car");
return words.stream()
.collect(Collectors.groupingBy(
word -> word.charAt(0),
Collectors.joining(", ")
));
}

------------------------------------------------------------

📘 STREAM API – Частина 3: Reducing, TreeMap, Sorted
✅ Задача 12: groupingBy + reducing
📌 Є список чисел. Згрупуй їх за остачею 
від ділення на 3, і порахуй суму в кожній групі.

🔍 Підказка: groupingBy(..., reducing(...))

List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
🧪 Очікувано:

{
0=18, // [3, 6, 9]
1=12, // [1, 4, 7]
2=15  // [2, 5, 8]
}
📦 Початковий код:

public Map<Integer, Integer> sumGroupedByModulo3() {
List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
return numbers.stream()
.collect(Collectors.groupingBy(
n -> n % 3,
Collectors.reducing(0, Integer::sum)
));
}
✅ Задача 13: groupingBy з TreeMap
📌 Згрупуй слова за довжиною в TreeMap, 
щоб ключі були автоматично відсортовані за зростанням.

🔍 Підказка: передай TreeMap::new як третій аргумент

List<String> words = List.of("hi", "book", "sun", "day", "Java", "sky");
🧪 Очікувано (тип – TreeMap):

{
2=[hi],
3=[sun, day, sky],
4=[book, Java]
}
📦 Початковий код:

public Map<Integer, List<String>> groupWordsSortedByLength() {
List<String> words = List.of("hi", "book", "sun", "day", "Java", "sky");
return words.stream()
.collect(Collectors.groupingBy(
String::length,
TreeMap::new,
Collectors.toList()
));
}
✅ Задача 14: sorting by value (List)
📌 Є Map<Integer, List<String>>. Відсортуй її за розміром списків.

🔍 Підказка: .entrySet().stream().sorted(...).collect(...)

Map<Integer, List<String>> input = Map.of(
2, List.of("hi"),
3, List.of("sun", "day", "sky"),
4, List.of("book", "Java")
);
🧪 Очікувано (за зростанням розміру списку):

2=[hi],
4=[book, Java],
3=[sun, day, sky]
📦 Початковий код:

public LinkedHashMap<Integer, List<String>> sortByListSize(Map<Integer, List<String>> input) {
return input.entrySet().stream()
.sorted(Comparator.comparingInt(e -> e.getValue().size()))
.collect(Collectors.toMap(
Map.Entry::getKey,
Map.Entry::getValue,
(a, b) -> b,
LinkedHashMap::new
));
}
✅ Задача 15: reducing зі String
📌 Є список слів. Виведи найдовше слово за допомогою reducing.

🔍 Підказка: Collectors.reducing(...) з порівнянням довжини

List<String> words = List.of("hi", "book", "sun", "day", "Java", "sky");
🧪 Очікувано: "book" або "Java"

📦 Початковий код:

public String findLongestWord() {
List<String> words = List.of("hi", "book", "sun", "day", "Java", "sky");
return words.stream()
.collect(Collectors.reducing(
"",
(a, b) -> a.length() >= b.length() ? a : b
));
}
✅ Задача 16: groupingBy з сортуванням значень у групі
📌 Є список слів. Згрупуй за першою літерою, і відсортуй слова в кожній групі за довжиною.

🔍 Підказка: у mapping(..., toList()), а потім .stream().sorted().toList() як post-обробка

List<String> words = List.of("apple", "ant", "alphabet", "axe", "banana", "bat");
🧪 Очікувано:

a=[ant, axe, apple, alphabet],
b=[bat, banana]
📦 Початковий код:

public Map<Character, List<String>> groupAndSortWordsByLength() {
List<String> words = List.of("apple", "ant", "alphabet", "axe", "banana", "bat");
return words.stream()
.collect(Collectors.groupingBy(
word -> word.charAt(0),
Collectors.collectingAndThen(
Collectors.toList(),
list -> list.stream()
.sorted(Comparator.comparingInt(String::length))
.toList()
)
));
}

--------------------------------------------------------------

🎓 Наступний блок — STREAM API – Частина 4: поглиблені колектори. Тут підключаємо flatMapping, 
partitioningBy + mapping, роботу з Set, LinkedHashMap, та міксування кількох колекторів. Звісно, 
кожна задача має свою назву, коротку підказку, очікуваний результат і початковий код 💪

✅ Задача 17: groupingBy + flatMapping (Java 16+)
📌 Є список людей. У кожного є список захоплень. Згрупуй усі захоплення за першою літерою.

🔍 Підказка: використай Collectors.flatMapping(...) (лише з Java 16+).

record Person(String name, List<String> hobbies) {}

List<Person> people = List.of(
new Person("Alice", List.of("Reading", "Running")),
new Person("Bob", List.of("Boxing", "Running")),
new Person("Charlie", List.of("Cooking", "Reading"))
);
🧪 Очікувано:

{
R=[Reading, Running, Running, Reading],
B=[Boxing],
C=[Cooking]
}
📦 Початковий код:

public Map<Character, Set<String>> groupHobbiesByFirstLetter() {
record Person(String name, List<String> hobbies) {}

List<Person> people = List.of(
        new Person("Alice", List.of("Reading", "Running")),
        new Person("Bob", List.of("Boxing", "Running")),
        new Person("Charlie", List.of("Cooking", "Reading"))
    );

return people.stream().collect(Collectors.groupingBy(
        p -> p.hobbies().get(0).charAt(0), // мініпідказка: це не зовсім правильно 😉
        Collectors.flatMapping(
            person -> person.hobbies().stream(),
            Collectors.toSet()
        )
    ));
}
🪄 Мініпідказка: flatMapping всередині groupingBy дозволяє одразу розпаковувати підсписки.

✅ Задача 18: partitioningBy + mapping
📌 Є список людей. Поділи їх на повнолітніх та неповнолітніх, але збережи тільки імена.

🔍 Підказка: partitioningBy(..., mapping(...))

record Person(String name, int age) {}
List<Person> people = List.of(
new Person("Alice", 17),
new Person("Bob", 22),
new Person("Charlie", 15),
new Person("Diana", 30)
);
🧪 Очікувано:

{
true=[Bob, Diana],
false=[Alice, Charlie]
}
📦 Початковий код:

public Map<Boolean, List<String>> partitionByAgeAndMapToNames() {
record Person(String name, int age) {}

List<Person> people = List.of(
        new Person("Alice", 17),
        new Person("Bob", 22),
        new Person("Charlie", 15),
        new Person("Diana", 30)
    );

return people.stream().collect(Collectors.partitioningBy(
        p -> p.age() >= 18,
        Collectors.mapping(Person::name, Collectors.toList())
    ));
}
🪄 Мініпідказка: partitioningBy(...) повертає Map<Boolean, ...>, 
а mapping(...) може вкластися всередину.

✅ Задача 19: groupingBy + SortedSet
📌 Згрупуй слова за першою літерою, без повторень, у відсортованому вигляді.

🔍 Підказка: Collectors.toCollection(TreeSet::new)

List<String> words = List.of("apple", "ant", "alpha", "banana", "bat", "car", "cat");
🧪 Очікувано:

{
a=[alpha, ant, apple],
b=[banana, bat],
c=[car, cat]
}
📦 Початковий код:

public Map<Character, Set<String>> groupToSortedSets() {
List<String> words = List.of("apple", "ant", "alpha", "banana", "bat", "car", "cat");
return words.stream().collect(Collectors.groupingBy(
word -> word.charAt(0),
Collectors.toCollection(TreeSet::new)
));
}
🪄 Мініпідказка: TreeSet автоматично сортує вміст.

✅ Задача 20: groupingBy + mapping + collectingAndThen
📌 Є список чисел. Згрупуй за остачею від ділення на 2. 
Але кожну групу перетвори на кількість унікальних значень.

🔍 Підказка: groupingBy → mapping → toSet → collectingAndThen(..., Set::size)

List<Integer> numbers = List.of(1, 2, 2, 3, 4, 5, 6, 6, 6);
🧪 Очікувано:

{
true=3,  // 2, 4, 6
false=3  // 1, 3, 5
}
📦 Початковий код:

public Map<Boolean, Integer> countUniqueByParity() {
List<Integer> numbers = List.of(1, 2, 2, 3, 4, 5, 6, 6, 6);
return numbers.stream().collect(Collectors.groupingBy(
n -> n % 2 == 0,
Collectors.collectingAndThen(
Collectors.mapping(n -> n, Collectors.toSet()),
Set::size
)
));
}
🪄 Мініпідказка: collectingAndThen(..., finalizer) виконує пост-обробку після збирання.

✅ Задача 21: LinkedHashMap з сортуванням за ключем
📌 Є список чисел. Порахуйте скільки разів зустрічається кожне число, 
і поверніть мапу з упорядкованими ключами.

🔍 Підказка: .entrySet().stream().sorted(...).collect(..., LinkedHashMap::new)

List<Integer> nums = List.of(5, 3, 5, 2, 3, 3, 2);
🧪 Очікувано:

2=2,
3=3,
5=2
📦 Початковий код:

public Map<Integer, Long> countAndSortKeys() {
List<Integer> nums = List.of(5, 3, 5, 2, 3, 3, 2);
Map<Integer, Long> map = nums.stream()
.collect(Collectors.groupingBy(n -> n, Collectors.counting()));

return map.entrySet().stream()
        .sorted(Map.Entry.comparingByKey())
        .collect(Collectors.toMap(
            Map.Entry::getKey,
            Map.Entry::getValue,
            (a, b) -> b,
            LinkedHashMap::new
        ));
}
🪄 Мініпідказка: LinkedHashMap збереже порядок сортування з потоку.

----------------------------------------------------------
