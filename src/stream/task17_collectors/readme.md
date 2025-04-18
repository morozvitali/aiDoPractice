📘 ЗАДАЧІ STREAM API – Частина 1: Колектори
✅ Задача 1: joining
📌 У тебе є список імен. Об’єднай їх в один рядок, розділений комами.

List<String> names = List.of("Alice", "Bob", "Charlie");
Очікувано: "Alice, Bob, Charlie"


✅ Задача 2: Su
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

         public Map <Integer, Long> myGroupCounting() {
            List<String> words = List.of("hi", "book", "sun", "day", "Java", "sky");
            return words.stream().collect(Collectors.groupingBy(a->a.length(), 
                    Collectors.counting()));
         }
         
         public Map <Boolean, List <Integer>> myGrouping5 () {
             List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
             return numbers.stream().collect(Collectors.partitioningBy((a-> a%2 == 0)));
         }

        public Map <Boolean, List <Integer>> myGrouping6 () {
            List<String> words = List.of("apple", "ant", "banana", "bat", "car");
            return words.stream().map(a->a.toUpperCase()).collect(Collectors.groupingBy(a->a.charAt(0));
        }