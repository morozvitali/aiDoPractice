🔹 toMap()
-
Використовуємо тоді, коли з кожним ключем 
пов’язується одне значення.

🔹 groupingBy()
-
Використовуємо тоді, коли нам треба згрупувати
елементи і щось зробити з групою:
підрахувати (counting()),
скласти в список,
знайти максимум/мінімум тощо.

🔑 Різниця
toMap() → один-до-одного (ключ → значення).
groupingBy() → один-до-багатьох (ключ → група/агрегація).

--------------------------------------------------------
✅ Завдання 1: Побудуй Map<String, Boolean>
— слово ➜ чи містить воно голосні
String[] words = {"sky", "apple",
"dry", "orange", "sun"};

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
Підказка: використовуй .toMap(...) і chars()
.filter(...).count > 0 ? true : false;

    public Map<String, Boolean> practice0 () {
        String[] words = {"sky", "apple",
                "dry", "orange", "sun"};

        return Arrays.stream(words)
    .collect(Collectors.toMap(Function.identity(), 
    this::isHaveVowels));

        return s.chars().filter(c -> "aeiou".indexOf(c) >= 0)
    .findAny().isPresent();

----------------------------------------------------------

✅ Задача 2: Кількість повторів символів 
(літери та цифри)
📋 Умова:
Поверни кількість різних символів,
які зустрічаються двічі або більше 
у вхідному рядку.
Регістр не має значення ('A' = 'a').

🧠 Підказка:
toLowerCase()

chars() -> mapToObj(c -> (char)c
groupingBy(..., counting())
map.entrySet() → filter(value > 1) → count()

✅ Очікуване рішення:

        Map <Character, Long> map =  s.toLowerCase()
        .chars().mapToObj(c->(char)c)
        .collect(Collectors.groupingBy(Function.identity(),
        Collectors.counting()));
        return map.entrySet().stream().filter(e->e.getValue() >1).count();
    }

🔍 Що тут відбувається:
toLowerCase() — щоб 'A' і 'a' вважалися однаковими.
chars().mapToObj(...) — отримуємо потік символів як Character.
groupingBy(..., counting()) — групуємо символи та рахуємо кількість кожного.
filter(e -> e.getValue() > 1) — залишаємо тільки ті, що повторюються.
count() — рахуємо скільки таких різних символів.

----------------------------------------------------------

🧪 Задача 3: Найчастіше слово у тексті
📋 Умова:
Знайди слово, яке зустрічається найчастіше в тексті
(всі слова через пробіли).
Вхід: "java is fun and java is powerful"
Вихід: "java" (зустрічається 2 рази) 

🧠 Підказка:
.split(" ")
.collect(groupingBy(..., counting()))
Collections.max(map.entrySet(), comparingByValue()).getKey()

        return Arrays.stream(s.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("");


🔍 Що відбувається:
split(" ") — розділяє текст на слова.
groupingBy(Function.identity(), counting()) — групує слова і рахує кількість кожного.
Collections.max(..., comparingLong(...)) — знаходить запис з найбільшою кількістю.
getKey() — повертає саме слово, а не кількість.


-----------------------------------------------------------

🧪 Задача 4: Сума чисел з однаковими останніми цифрами
📋 Умова:
**Є масив чисел. Поверни Map<Integer, Integer>,
де ключ — остання цифра, а значення — сума всіх чисел,
що мають цю останню цифру.

Вхід: [12, 23, 34, 45, 16, 7]**
Вихід: {2=12, 3=23, 4=34, 5=45, 6=16, 7=7}

n % 10 → ключ
groupingBy(..., summingInt(n -> n))
Це означає:

Ключ — остання цифра числа (n % 10)

Значення — сума всіх чисел, які мають таку саму останню цифру
→ тобто потрібно згрупувати числа за n % 10,
а потім для кожної групи порахувати суму.
Варіант з groupingBy + summingInt → ✅ дасть {2 = 66}

public Map<Integer, Integer> practice3() {
return List.of(12, 23, 34, 45, 16, 7).stream()
// 1️⃣ Групуємо за останньою цифрою
.collect(Collectors.groupingBy(
value -> value % 10,          // ключ → остання цифра
Collectors.summingInt(n -> n) // значення → сума всіх чисел з таким ключем
));
}

-----------------------------------------------------------

🧪 Задача --залегка-- Порахувати довжини слів
📋 Умова:
Дано список слів. Побудуй Map, де ключ — довжина слова,
а значення — кількість таких слів.

Вхід: String[] words = {"one", "two", "three", "six", "seven"};
Вихід: {3=2, 5=2, 4=1}

🧠 Підказка:
.collect(groupingBy(s -> s.length(), counting()))

-----------------------------------------------------------

🧪 Задача --залегка-- Перша літера → список слів
📋 Умова:
Є масив слів. Поверни Map, де ключ — перша літера слова,
а значення — список слів, які з неї починаються.

Вхід: String[] words = {"apple", "banana", "avocado",
"blueberry", "bleuberry", "apricot"};

Вихід: {a=[apple, avocado, apricot], b=[banana, blueberry]}

🧠 Підказка:
groupingBy(word -> word.charAt(0))

-----------------------------------------------------------

🧪 Задача 5: Найчастіше число в масиві (інтеграція з entrySet)

📋 Умова:
Є масив цілих чисел. Потрібно повернути число, яке
зустрічається найчастіше.

Вхід: [1,2,2,3,3,3,4,4]
Вихід: 3

🧠 Підказка:
groupingBy(..., counting())

map.entrySet() → max(Map.Entry::getValue) → .getKey()

    public Integer practice6 () {
    int[] numbers = {1, 2, 2, 3, 3, 3, 4, 4};
    Map<Integer, Long> map = Arrays.stream(numbers)
    .boxed()
    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    return map.entrySet().stream()
            .max(Comparator.comparingLong(Map.Entry::getValue)) // просто й лаконічно
            .get()
            .getKey();
}


-----------------------------------------------------------

**💡 Бонусна ідея:
Можеш додатково після кожного Map:
Виводити: map.keySet(), map.values(), map.entrySet()
Проходити по for (var e : map.entrySet())**

-----------------------------------------------------------

✅ Задача 6: Порахувати кількість цифр у рядку
📋 Умова:
Є рядок, що містить літери та цифри. 
Потрібно повернути Map <Integer, Long>, 
у якому ключ — цифра, а значення — скільки 
разів вона зустрічається.

Вхід: "ab123cc44a77"

Вихід: {1=1, 2=1, 3=1, 4=2, 7=2}

🧠 Підказка:
фільтруй лише символи Character.isDigit(c)

groupingBy(c -> c, counting())

    public Map <Integer, Long> practice7 () {
        return "ab123cc44a77"
                .chars()
                .filter(c->Character.isDigit(c))
                .boxed()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
    }


-----------------------------------------------------------

✅ Задача 7: Чи є дублікат у масиві?
📋 Умова:
Є масив чисел. Потрібно повернути true, якщо є хоча 
б одне число, яке зустрічається більше одного разу.

Вхід: [1, 2, 3, 2] → true
Вхід: [1, 2, 3] → false

🧠 Підказка:
groupingBy(..., counting())

entrySet().stream().anyMatch(entry -> entry.getValue() > 1)

    public boolean practice8 () {
        Map <Integer, Long> map = List.of(1, 2, 3, 2).stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return map.entrySet().stream().anyMatch(entry -> entry.getValue() > 1);
    }

Другий спосіб з HashSet працює швидше, 
бо зупиниться одразу при знаходженні дубліката.

    public boolean practice8() {
    Set<Integer> seen = new HashSet<>();
    return List.of(1, 2, 3, 2).stream().anyMatch(n -> !seen.add(n));
    }

-----------------------------------------------------------

✅ Задача 8: Групування чисел по парності

📋 Умова:
Є масив чисел. Поверни Map:
"even" → список парних
"odd" → список непарних

Вхід: [1, 2, 3, 4, 5]
Вихід: {"even"=[2, 4], "odd"=[1, 3, 5]}

🧠 Підказка:
.collect(Collectors
.groupingBy(n -> n % 2 == 0 ? "even" : "odd"))

    public Map <String, List <Integer>> practice9 () {
         return List.of(1, 2, 3, 4, 5).stream().collect(Collectors.groupingBy(value -> value %2 == 0 ? "even" : "odd"));
    }

-----------------------------------------------------------

✅ Задача 9: Порахувати середнє значення по групах 
📋 Умова:
Є список чисел. Потрібно розділити їх 
по остачі від ділення на 3 (n % 3) і знайти 
середнє у кожній групі.

Вхід: [3, 6, 7, 8, 9, 10, 12]
Вихід: {0=7.5, 1=7.5, 2=9.0}
(наприклад: 0 → [3,6,9,12] → середнє 7.5)

🧠 Підказка:
groupingBy(n -> n % 3, averagingInt(n -> n))

        int[] numbers = {3, 6, 7, 8, 9, 10, 12};
        Map <Integer, Double> map = Arrays.stream(numbers)
                .boxed()
                .collect(Collectors
                        .groupingBy(a->a%3,Collectors
                                .averagingInt(n->n)));
    }

🧠 Що тут відбувається:
a -> a % 3 — визначає групу: залишок від ділення на 3.
Collectors.averagingDouble(n -> n) — обчислює 
середнє значення всіх чисел у кожній групі.
.boxed() — перетворює int на Integer, щоб можна 
було використовувати Stream API для об'єктів.

    public Map <Integer, Double> practice10 () {
        return List.of(3, 6, 7, 8, 9, 10, 12).stream().collect(Collectors.groupingBy(value-> value %3, Collectors.averagingDouble(n->n)));
    }

**🎯 Для кожної задачі тренуй:
System.out.println(map.keySet());
System.out.println(map.values());
for (var e : map.entrySet()) {
System.out.println(e.getKey() + " → " + e.getValue());}**

---------------------------------------------------------

✅ Задача 10: Найчастіший перший символ слова
📋 Умова:
Є список слів. Знайди символ, який найчастіше 
стоїть на початку слів.

Вхід: String[] words = {"apple", "banana", "avocado",
"blueberry", "bleuberry", "apricot"};

Вихід: 'a'

🧠 Підказка:
groupingBy(word -> word.charAt(0), counting())

    public Character practice11 () {
        String[] words = {"apple", "banana", "avocado",
                "blueberry", "bleuberry", "apricot"};
        Map<Character, Long> map = Arrays.stream(words)
                .collect(Collectors.groupingBy(w -> w.charAt(0), Collectors.counting()));
        return map.entrySet().stream()
                .max(Comparator.comparingLong(n->n.getValue().size()))
                .map(Map.Entry::getKey)
                .orElse(null);
    }

---------------------------------------------------------

✅ Задача 11: Сортування Map за значенням
-
📋 Умова:
Є Map з літерами та кількістю входжень. Потрібно 
вивести всі пари, відсортовані за значенням 
у зворотному порядку.

    Map <Character, Long> map = new HashMap<>();
        map.put('a', 2L);
        map.put('b', 5L);
        map.put('c', 1L);

Вхід: {a=2, b=5, c=1}
Вихід: b=5, a=2, c=1

    return map.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .collect(Collectors.toMap(
                    Map.Entry::getKey,
                    Map.Entry::getValue,
                    (oldValue, newValue) -> oldValue, // вирішення колізій (на всяк випадок)
                    LinkedHashMap::new // ось тут ми зберігаємо порядок
            ));
}
.collect(Collectors.toMap(
Map.Entry::getKey,
Map.Entry::getValue,
(e1, e2) -> e1,
LinkedHashMap::new  // зберігаємо порядок вставки
));
}

Пояснення:
.entrySet().stream() — створюємо потік пар ключ-значення.
.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) — сортуємо за значенням у зворотньому порядку.
.collect(Collectors.toMap(...)) — збираємо назад у Map.
LinkedHashMap::new — потрібен, щоб зберегти порядок елементів згідно сортування (у звичайному HashMap порядок не гарантовано).

---------------------------------------------------------

✅ Задача 12: Сума чисел, отриманих з рядків
-
📋 Умова:
Дано список рядків, які містять числа. 
Побудуй Map, де ключ — перша літера рядка, 
значення — сума чисел, які починаються на цю літеру.

Вхід: [“a10”, “a20”, “b5”, “b7”]
Вихід: {a=30, b=12}

🧠 Підказка:
Розділи: s.charAt(0) і 
Integer.parseInt(s.substring(1))

groupingBy(..., summingInt(...))

    public Map <Character, Integer> practice13 () {
        String[] words = {"a10", "b20",
                "a5", "b7", "b12", "a6"};
        return Arrays.stream(words).collect(Collectors.groupingBy(w->w.charAt(0), Collectors.summingInt(w->Integer.parseInt(w.substring(1)))));
    }
}

---------------------------------------------------------

✅ Задача 13: Знайти слово з макс кількістю голосних
-
📋 Умова:
Є список слів. Знайди слово з найбільшою 
кількістю голосних літер (a, e, i, o, u).

Вхід: [“java”, “engineer”, “platform”, “stream”]
Вихід: "engineer" (містить 4 голосних)

🧠 Підказка:
Для кожного слова порахуй .chars().filter(...)

Map<String, Long> — ключ: слово, значення: 
кількість голосних

entrySet().stream().max(...)

    public String practice14() {
        String[] words = {"java", "engineer", "platform", "stream"};
        Map <String,Long> map = Arrays.stream(words).collect(Collectors.toMap(w->w, w->w.chars().filter(c->"aeiou".indexOf(c) >=0).count()));
        return map.entrySet().stream().max(Comparator.comparingLong(a->a.getValue())).map(a->a.getKey()).orElse("");
    }

----------------------------------------------

✅ Задача 14: Чи всі значення в Map парні?
-
📋 Умова:
Є Map типу <String, Integer>. Перевір, 
чи всі значення парні.

Вхід: {a=2, b=4, c=6} → true
Вхід: {a=2, b=3, c=4} → false

🧠 Підказка:
map.values().stream().allMatch(v -> v % 2 == 0)

    public boolean practice15 (Map <String, Integer> map) {
        return map.values().stream().allMatch(value -> value % 2 ==0);
    }


-------------------------------------------------------


✅ Завдання 15: Згрупуй слова за довжиною
-
і зроби їх великими літерами

String[] words = {"apple", "banana",
"dog", "kiwi", "plum"};
Очікуваний результат:

{
3=[DOG],
4=[KIWI, PLUM],
5=[APPLE],
6=[BANANA]
}
📌 Тип: Map<Integer, List<String>>

    public Map <Integer, List <String>> practice16 () {
        String[] words = {"apple", "banana",
                "dog", "kiwi", "plum"};
        return Arrays.stream(words).collect(Collectors.groupingBy(word-> word.length()));
    }

Якщо порівнювати з counting():
counting() — просто рахує кількість елементів,
mapping() — спочатку трансформує елементи, 
потім передає далі.

----------------------------------------------------

✅ Завдання 16: Порахуй кількість
-
слів для кожної довжини, але тільки
якщо слово містить голосну

    String[] words = {"apple", "banana",
        "dog", "kiwi", "plum"};
Очікуваний результат:

{
5=1,
6=1,
2=1
}

📌 Тип: Map<Integer, Long>
🧠 Підказка: фільтр на countVowels > 0,
потім groupingBy(...,
counting())

    public Map <Integer, Long> practice17 () {
        String[] words = {"apple", "banana",
                "dog", "kiwi", "plum"};
        return Arrays.stream(words).filter(w->w.chars().anyMatch(c->"aeiou".indexOf(c) >=0)).collect(Collectors.groupingBy(String::length, Collectors.counting()));
    }

    public Map <Integer, Long> practice2 () {
        String[] words = {"apple", "banana",
                "dog", "kiwi", "plum"};
        return Arrays.stream(words).filter(w->w.chars().anyMatch(c->"aeiou".indexOf(c) >=0)).collect(Collectors.groupingBy(w->w.length(), Collectors.counting()));
    }

-------------------------------------------------------

✅ Завдання 17: Розділи слова на 2 групи —
ті, що містять голосну, і ті, що ні

String[] words = {"apple", "sky",
"banana", "dry", "orange"};
Очікуваний результат:

{
true=[apple, banana, orange],
false=[sky, dry]
}

📌 Тип: Map<Boolean, List<String>>
🧠 Підказка: Collectors.partitioningBy(...)

    public Map <Boolean, List <String>> practice18 () {
        String[] words = {"apple", "sky",
                "banana", "dry", "orange"};
        return Arrays.stream(words).collect(Collectors.partitioningBy(word -> word.chars().anyMatch(c->"aeiou".indexOf(c) >=0)));
    }


-----------------------------------------------------

✅ Завдання 18: Створи мапу:
довжина слова → кількість
слів із такою довжиною,
що починаються на голосну

String[] words = {"apple", "banana",
"orange", "umbrella",
"ant", "dog", "egg"};
Очікуваний результат:

{
3=1,
5=2,
6=1,
8=1
}

📌 Тип: Map<Integer, Long>
🧠 Підказка: перевірка startsWith(...),
groupingBy(length, counting())


    public Map <Integer, Long> practice19 () {
        String[] words = {"apple", "banana",
                "orange", "umbrella",
                "ant", "dog", "egg"};
        return Arrays.stream(words).filter(w->"aeiou".indexOf(w.charAt(0))>=0).collect(Collectors.groupingBy(String::length, Collectors.counting()));
    }

------------------------------------------

https://chatgpt.com/c/68529e9e-80a4-8009-a646-0591c2e6f37b


