🧠 Серія: Групування та робота з Map — Частина 1
✅ Завдання 1: Групування слів за кількістю літер

String[] words = {"apple", "dog", "banana", 
"cat", "kiwi", "plum", "watermelon"};

Очікуваний результат:
{
3=[dog, cat],
4=[kiwi, plum],
5=[apple],
6=[banana],
10=[watermelon]
}

Тип: Map<Integer, List<String>>
Підказка: .groupingBy(word -> word.length())


✅ Завдання 2: Групування за першою літерою,
але всі слова в нижньому регістрі
List<String> words = List.of("Apple", "apricot",
"Banana", "blue", "Cherry", "cranberry");

Очікуваний результат:
{
a=[apple, apricot],
b=[banana, blue],
c=[cherry, cranberry]
}

Тип: Map<Character, List<String>>
Підказка: .map(String::toLowerCase) перед groupingBy



✅ Завдання 3: Порахуй, скільки слів 
починається на кожну літеру
String[] words = {"apple", "banana", "apricot",
"blue", "berry", "cherry"};

Очікуваний результат:
{
a=2,
b=3,
c=1
}
Тип: Map<Character, Long>
Підказка: groupingBy(..., counting())



✅ Завдання 4: Побудуй Map<String, Boolean> — слово ➜ чи містить воно голосні
String[] words = {"sky", "apple", "dry", "orange", "sun"};

Очікуваний результат:
{
sky=false,
apple=true,
dry=false,
orange=true,
sun=true
}

Тип: Map<String, Boolean>
Підказка: використовуй .toMap(...) і chars().anyMatch(...)
Підказка: використовуй .toMap(...) і chars().filter(...).count > 0 ? true : false;


-----------------------------НОВЕ-------------------------------

✅ Задача 1: Кількість повторів символів (літери та цифри)
📋 Умова:
Поверни кількість різних символів, які зустрічаються двічі або більше у вхідному рядку.
Регістр не має значення ('A' = 'a').

🧠 Підказка:
toLowerCase()

chars() -> mapToObj(c -> (char)c)

groupingBy(..., counting())

map.entrySet() → filter(value > 1) → count()

✅ Очікуване рішення:
java
Copy
Edit
public static int countDuplicates(String text) {
Map<Character, Long> map = text.toLowerCase()
.chars().mapToObj(c -> (char) c)
.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    return (int) map.entrySet().stream()
        .filter(e -> e.getValue() > 1)
        .count();
}
🧪 Задача 2: Найчастіше слово у тексті
📋 Умова:
Знайди слово, яке зустрічається найчастіше в тексті (всі слова через пробіли).

Вхід: "java is fun and java is powerful"

Вихід: "java" (зустрічається 2 рази)

🧠 Підказка:
.split(" ")

.collect(groupingBy(..., counting()))

Collections.max(map.entrySet(), comparingByValue()).getKey()

🧪 Задача 3: Сума чисел з однаковими останніми цифрами
📋 Умова:
Є масив чисел. Поверни Map<Integer, Integer>, де ключ — остання цифра, а значення — сума всіх чисел, що мають цю останню цифру.

Вхід: [12, 23, 34, 45, 16, 7]

Вихід: {2=28, 3=23, 4=34, 5=45, 6=16, 7=7}

🧠 Підказка:
n % 10 → ключ

groupingBy(..., summingInt(n -> n))

🧪 Задача 4: Порахувати довжини слів
📋 Умова:
Дано список слів. Побудуй Map, де ключ — довжина слова, а значення — кількість таких слів.

Вхід: [“one”, “two”, “three”, “six”, “seven”]

Вихід: {3=2, 5=2, 4=1}

🧠 Підказка:
.collect(groupingBy(s -> s.length(), counting()))

🧪 Задача 5: Перша літера → список слів
📋 Умова:
Є масив слів. Поверни Map, де ключ — перша літера слова, а значення — список слів, які з неї починаються.

Вхід: [“apple”, “banana”, “avocado”, “blueberry”, “apricot”]

Вихід: {a=[apple, avocado, apricot], b=[banana, blueberry]}

🧠 Підказка:
groupingBy(word -> word.charAt(0))

🧪 Задача 6: Найчастіше число в масиві (інтеграція з entrySet)
📋 Умова:
Є масив цілих чисел. Потрібно повернути число, яке зустрічається найчастіше.

Вхід: [1,2,2,3,3,3,4,4]
Вихід: 3

🧠 Підказка:
groupingBy(..., counting())

map.entrySet() → max(Map.Entry::getValue) → .getKey()

💡 Бонусна ідея:
Можеш додатково після кожного Map:

Виводити: map.keySet(), map.values(), map.entrySet()

Проходити по for (var e : map.entrySet())

✅ Задача 7: Порахувати кількість цифр у рядку
📋 Умова:
Є рядок, що містить літери та цифри. Потрібно повернути Map<Character, Long>, у якому ключ — цифра, а значення — скільки разів вона зустрічається.

Вхід: "ab123cc44a77"

Вихід: {1=1, 2=1, 3=1, 4=2, 7=2}

🧠 Підказка:
фільтруй лише символи Character.isDigit(c)

groupingBy(c -> c, counting())

✅ Задача 8: Найдовше слово для кожної довжини
📋 Умова:
Є список слів. Знайди для кожної довжини слово, яке є найдовшим (а якщо рівні — перше за порядком).

Вхід: [“one”, “two”, “three”, “four”, “six”, “seventy”]

Вихід: {3=“one”, 5=“three”, 4=“four”, 7=“seventy”}

🧠 Підказка:
groupingBy(String::length, Collectors.collectingAndThen(...))

або вручну в Map<Integer, String> порівнювати довжину

✅ Задача 9: Чи є дублікат у масиві?
📋 Умова:
Є масив чисел. Потрібно повернути true, якщо є хоча б одне число, яке зустрічається більше одного разу.

Вхід: [1, 2, 3, 2] → true
Вхід: [1, 2, 3] → false

🧠 Підказка:
groupingBy(..., counting())

entrySet().stream().anyMatch(entry -> entry.getValue() > 1)

✅ Задача 10: Групування чисел по парності
📋 Умова:
Є масив чисел. Поверни Map:

"even" → список парних

"odd" → список непарних

Вхід: [1, 2, 3, 4, 5]
Вихід: {"even"=[2, 4], "odd"=[1, 3, 5]}

🧠 Підказка:
.collect(Collectors.groupingBy(n -> n % 2 == 0 ? "even" : "odd"))

✅ Задача 11: Порахувати середнє значення по групах
📋 Умова:
Є список чисел. Потрібно розділити їх по остачі від ділення на 3 (n % 3) і знайти середнє у кожній групі.

Вхід: [3, 6, 7, 8, 9, 10, 12]
Вихід: {0=7.5, 1=7.5, 2=9.0}
(наприклад: 0 → [3,6,9,12] → середнє 7.5)

🧠 Підказка:
groupingBy(n -> n % 3, averagingInt(n -> n))

🎯 Для кожної задачі тренуй:

System.out.println(map.keySet());
System.out.println(map.values());
for (var e : map.entrySet()) {
System.out.println(e.getKey() + " → " + e.getValue());
}


✅ Задача 12: Найчастіший перший символ слова
📋 Умова:
Є список слів. Знайди символ, який найчастіше стоїть на початку слів.

Вхід: [“apple”, “apricot”, “banana”, “blueberry”, “avocado”]
Вихід: 'a'

🧠 Підказка:
groupingBy(word -> word.charAt(0), counting())

.entrySet().stream().max(comparingByValue())

✅ Задача 13: Сортування Map за значенням
📋 Умова:
Є Map з літерами та кількістю входжень. Потрібно вивести всі пари, відсортовані за значенням у зворотному порядку.

Вхід: {a=2, b=5, c=1}
Вихід: b=5, a=2, c=1

🧠 Підказка:
entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))

✅ Задача 14: Сума чисел, отриманих з рядків
📋 Умова:
Дано список рядків, які містять числа. Побудуй Map, де ключ — перша літера рядка, значення — сума чисел, які починаються на цю літеру.

Вхід: [“a10”, “a20”, “b5”, “b7”]
Вихід: {a=30, b=12}

🧠 Підказка:
Розділи: s.charAt(0) і Integer.parseInt(s.substring(1))

groupingBy(..., summingInt(...))

✅ Задача 15: Знайти слово з максимальною кількістю голосних
📋 Умова:
Є список слів. Знайди слово з найбільшою кількістю голосних літер (a, e, i, o, u).

Вхід: [“java”, “engineer”, “platform”, “stream”]
Вихід: "engineer" (містить 4 голосних)

🧠 Підказка:
Для кожного слова порахуй .chars().filter(...)

Map<String, Long> — ключ: слово, значення: кількість голосних

entrySet().stream().max(...)

✅ Задача 16: Чи всі значення в Map парні?
📋 Умова:
Є Map типу <String, Integer>. Перевір, чи всі значення парні.

Вхід: {a=2, b=4, c=6} → true
Вхід: {a=2, b=3, c=4} → false

🧠 Підказка:
map.values().stream().allMatch(v -> v % 2 == 0)

https://chatgpt.com/c/68529e9e-80a4-8009-a646-0591c2e6f37b
