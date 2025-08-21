прибрав бо залегкі

✅ Ця добірка вже охоплює:
joining, summarizing, groupingBy, partitioningBy
вкладені колектори (mapping, reducing, collectingAndThen)
сортування Map, роботу з Set, TreeSet, LinkedHashMap
flatMapping, mapping + partitioningBy — все,
що треба для потужного старту в FP на Java.

📘 ЗАДАЧІ STREAM API – Частина 1: Колектори

✅ Задача ---запроста--- : joining
-
📌 У тебе є список імен.
Об’єднай їх в один рядок, розділений комами.

List<String> names = List.of("Alice", "Bob", "Charlie");
Очікувано: "Alice, Bob, Charlie"

names.stream().collect(Collectors.joining(", "));


**✅ Задача 2: Summarizing**
-
`📌 Є список чисел. Отримай статистику:
кількість, суму, мінімум, максимум, середнє.

List<Integer> numbers = List.of(4, 8, 15, 16, 23, 42);
Очікувано:

count = 6
sum = 108
min = 4
max = 42
average = 18.0

public void mySummarizing () {
List<Integer> numbers = List.of(4, 8, 15, 16, 23, 42);
numbers.stream().collect(Collectors
.summarizingInt(value -> value));
}`


**✅ Задача 3: groupingBy**
-
📌 Є список слів. Згрупуй їх за довжиною.

List<String> words = List.of("hi", "book",
"sun", "day", "Java", "sky");
Очікувано:

{
2=[hi],
3=[sun, day, sky],
4=[book, Java]
}


**✅ Задача 4: groupingBy + counting**
-
📌 Порахуйте, скільки разів зустрічається
кожна довжина слова.

List<String> words = List.of("hi", "book",
"sun", "day", "Java", "sky");
Очікувано:

{
2=1,
3=3,
4=2
}

    public Map <Integer, Long> practice4 () {
        List<String> words = List.of("hi", "book",
                "sun", "day", "Java", "sky");
        return words.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));
    }

**✅ Задача 5: partitioningBy**
-
📌 Є список чисел. Розділи їх на парні та непарні.

List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
Очікувано:

{
true=[2, 4, 6],
false=[1, 3, 5]
}

    public Map <Boolean, List <Integer>> practice5 () {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
    return numbers.stream().collect(Collectors.partitioningBy(value->(int)value%2==0));
}
