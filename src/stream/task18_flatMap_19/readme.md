👉 Завдання для тебе:
✏️ Зроби свій метод:
Отримай List<List<Integer>> — список чисел

Збери всі числа в один список.
Відфільтруй ті, що > 50.
Відсортуй за спаданням.
Поверни список.

📥 Наприклад:

List<List<Integer>> weeklyData = List.of(
List.of(40, 55, 60),
List.of(30, 70),
List.of(65, 10, 90)
);
📤 Очікуваний результат:

[90, 70, 65, 60, 55]


?--?--?--?--?--?--?--?--THEORY--?--?--?--?--?--?--?--?


📌 У чому суть?
flatMap потрібен тоді, коли ти працюєш зі списками всередині списку.
Звичайний .map() перетворює кожен елемент → але залишає "вкладеність".

А flatMap — "розплющує" вкладені колекції в один загальний потік.

📦 Приклад:

List<List<String>> data = List.of(
List.of("java", "python"),
List.of("c++", "go"),
List.of("kotlin")
);
🧪 map:

data.stream()
.map(list -> list.stream())   // Stream<Stream<String>>
🔥 flatMap:

data.stream()
.flatMap(list -> list.stream())   // Stream<String>
.collect(Collectors.toList());
✅ Результат:

[java, python, c++, go, kotlin]
🧪 Завдання: flatMap

✅ Задача 1: Зібрати всі унікальні слова з колекції речень
-

List<String> sentences = List.of(
"Java is powerful",
"Streams are cool",
"Java makes sense"
);
🔍 Треба:

Розбити речення на слова
Зібрати їх у список
Зробити унікальними (distinct)
Привести до нижнього регістру

📤 Очікуваний результат:
[java, is, powerful, streams, are, cool, makes, sense]

💻 Початковий шаблон:
public List<String> extractWords(List<String> sentences) {
return sentences.stream()
.flatMap(sentence -> Arrays.stream(sentence.split(" ")))
.map(String::toLowerCase)
.distinct()
.collect(Collectors.toList());
}

    public void practice1 () {
        List<String> sentences = List.of(
                "Java is powerful",
                "Streams are cool",
                "Java makes sense"
        );
        sentences.stream().flatMap(sentence -> Arrays.stream(sentence.split(""))).distinct().collect(Collectors.toList());
    }


Так, Віталію! 😄 Ти ідеально підловив суть:

🧠 flatMap() "розплющує" вкладені колекції у єдиний потік,
щоб ми могли оперувати над усіма елементами так, ніби вони були в одному списку.

🧊 Уяви:
У тебе є три тарілки 🍽️:

одна з яблуками 🍎
інша з бананами 🍌
третя з апельсинами 🍊

map() — дасть тобі три списки фруктів

Stream<List<Фрукти>>

flatMap() — змішає всі фрукти в одну купу 🧃

Stream<Фрукти>

📦 Аналог в Java:

List<List<String>> fruits = List.of(
List.of("apple", "pear"),
List.of("banana"),
List.of("orange", "lemon")
);

Stream<Stream<String>>  // кожна "тарілка" окремо
.flatMap(...)

Stream<String>  // все на одній "тарілці"
🎯 Тепер — твоя черга!
Ти вже маєш завдання:

обробити List<List<Integer>>

через flatMap(), filter(), sorted() та collect()

----------------------------------------------------

🔹 Задача 2: Знайти мінімальне парне число
-
int[][] data = {
{3, 11},
{6, 7},
{10}
};
🧪 Очікувано: 6


    public void practice2 () {
        int[][] data = {
                {3, 11},
                {6, 7},
                {10}
        };

    Arrays.stream(data)
    .flatMapToInt(Arrays::stream) // одразу IntStream без boxed()
    .filter(a -> a % 2 == 0)       // лише парні
    .min()                         // шукаємо мінімум
    .orElse(-1);                   // якщо немає — повертаємо -1
    
        System.out.println(minEven);


------------
📦 Рішення:
Arrays.stream(data)
.flatMapToInt(Arrays::stream)
.filter(n -> n % 2 == 0)
.min()
.orElse(-1);

🔹 Задача 3: Добуток усіх додатних чисел
-
int[][] data = {
{-3, 5},
{2},
{-1, 4}
};
🧪 Очікувано: 5 * 2 * 4 = 40


    public void practice3 () {
        int[][] data = {
                {-3, 5},
                {2},
                {-1, 4}
        };
        
        Arrays.stream(data)
                .flatMap(arr->Arrays.stream(arr)
                        .boxed())
                .filter(value -> value > 0)
                .reduce((a,b)->a*b)
                .orElse(-1);
    }

📦 Рішення:
Arrays.stream(data)
.flatMapToInt(Arrays::stream)
.filter(n -> n > 0)
.reduce(1, (a, b) -> a * b);

🔹 Задача 4: Найбільше число, яке ділиться на 3
-
int[][] data = {
{3, 9},
{8, 12},
{7}
};

🧪 Очікувано: 12

    public int practice4 () {
        int[][] data = {
                {3, 9},
                {8, 12},
                {7}
        };
        
        return Arrays.stream(data)
        .flatMapToInt(arr->Arrays.stream(arr))
                .filter(value->value%3==0)
                .max()
                .orElse(-1);
    }



📦 Рішення:
Arrays.stream(data)
.flatMapToInt(Arrays::stream)
.filter(n -> n % 3 == 0)
.max()
.orElse(-1);

🔹 Задача 5: Сума квадратів парних чисел
int[][] data = {
{2, 3},
{4}
};
🧪 Очікувано: 2² + 4² = 20

    public int practice5 () {
        int[][] data = {
                {2, 3},
                {4}
        };
        
        return Arrays.stream(data).flatMapToInt(arr->Arrays.stream(arr))
                .filter(a->a%2==0)
                .map(a->a*a)
                .sum();
    }



📦 Рішення:
Arrays.stream(data)
.flatMapToInt(Arrays::stream)
.filter(n -> n % 2 == 0)
.map(n -> n * n)
.sum();

🔹 Задача 6: Середнє непарних чисел (rounded down)
int[][] data = {
{3, 5},
{7}
};
🧪 Очікувано: 5
📦 Рішення:
IntSummaryStatistics stats = Arrays.stream(data)
.flatMapToInt(Arrays::stream)
.filter(n -> n % 2 != 0)
.summaryStatistics();

int result = stats.getCount() == 0 ? -1 : (int) stats.getAverage();

⭐ Задача 7: НСД (найбільший спільний дільник)
int[][] data = {
{12},
{24, 36}
};
🧪 Очікувано: 12

    public void practce7 () {
        int[][] data = {
                {12},
                {24, 36}
        };
        Arrays.stream(data).flatMapToInt(Arrays::stream).reduce(Main1::gcd).orElse(-1);
    }
    public static int gcd (int a, int b) {
        return b==0 ? a :gcd (b, a%b);
    }

📦 Рішення:
Arrays.stream(data)
.flatMapToInt(Arrays::stream)
.reduce(Main::gcd)
.orElse(-1);

// метод gcd:
static int gcd(int a, int b) {
return b == 0 ? a : gcd(b, a % b);
}


🎁 Бонус: чому flatMapToInt?
🔧 Бо flatMap(...) повертає Stream<Stream<T>>, а нам потрібен IntStream.
Варіанти:

flatMapToInt(...) → для int[]
flatMap(...) → для об’єктів (List<List<...>>)
Скажи, коли готовий до наступного рівня:
List<List<Integer>> + flatMap
Stream<List<String>> + flatMap() + distinct()
Map<String, List<String>> + entrySet().stream().flatMap(...)


---------------instanceof-objects-filtration---------------

✅ Задача 8: Фільтр чисел
📋 Умова:
Є список із чисел, рядків і булевих значень. 
Поверни список тільки з цілими числами (Integer).

🧠 Підказка:
x instanceof Integer

📌 Приклад:

List.of(10, "hello", true, 42, false, "42") → [10, 42]
🧪 Початковий код:

public static List<Object> filterIntegers(List<Object> input) {
return input.stream()
.filter(x -> x instanceof Integer)
.collect(Collectors.toList());
}

    public List <Integer> practice8 () {
        List list = List.of(10, "hello", true, 42, false, "42");

        return list.stream().filter(value -> value instanceof Integer).toList();
    }



✅ Задача 9: Залишити рядки
📋 Умова:
Залиш у списку лише ті елементи, які є рядками (String).

📌 Приклад:

List.of("hello", 1, 2.5, true, "world") → ["hello", "world"]
🧠 Підказка:
x instanceof String

    public List <String> practice9 () {
        List <Object> list = List.of("hello", 1, 2.5, true, "world");
        return list.stream().filter(value-> value instanceof String).map(value-> (String) value).toList();
    }
📌 Пояснення:
.filter(value -> value instanceof String) — залишаємо лише рядки
.map(value -> (String) value) — приводимо тип елемента зі Object до String
.toList() — збираємо результат у List<String>

✅ Задача 10: Розумний фільтр
📋 Умова:
Залиш лише ті елементи, які є числами (Integer) і більші за 10.

📌 Приклад:

List.of("a", 3, 15, 11, 9, "99") → [15, 11]
🧠 Підказка:
x instanceof Integer && (Integer)x > 10

    public List <Integer> practice10 () {
        List <Object> list = List.of("a", 3, 15, 11, 9, "99");
        return list.stream().filter(value -> value instanceof Integer && (Integer)value > 10).map(value->(Integer)value).toList();
    }


✅ Задача 11: Фільтр істини
📋 Умова:
Поверни всі елементи типу Boolean, 
які рівні true.

📌 Приклад:
List.of("yes", true, false, true, 1) → [true, true]
🧠 Підказка:
x instanceof Boolean && (Boolean)x == true


✅ Задача 12: Конвертер рядків у великі букви
📋 Умова:
Залиши тільки String, але повертай їх у верхньому регістрі (toUpperCase()).

📌 Приклад:

List.of("hi", 123, "bye", false) → ["HI", "BYE"]
🧠 Підказка:

x instanceof String → ((String)x).toUpperCase()

--------------------------------------------------------

🔐 Задача: Duplicate Encoder
🎓 Рівень: середній (5 kyu)
🧠 Тема: String → Map → Stream → Заміна символів

📋 Умова:
Створи метод encode(String word), який повертає новий рядок на основі вхідного:
Якщо символ зустрічається лише один раз у всьому рядку — заміни його на "("
Якщо символ зустрічається два або більше разів — заміни на ")"

🔎 Порівняння символів — без урахування регістру (S = s)
🔁 Порядок символів у новому рядку має бути такий самий, як у вхідному.

📥 Приклади:
Вхід	Вихід
"din"	"((("
"recede"	"()()()"
"Success"	")())())"
"(( @"	"))(("

💡 Підказка:
Переведи String у нижній регістр.
Створи Map<Character, Long> — частоти кожного символу.
Пройдись по кожному символу:
Якщо частота > 1 → ")"
Інакше → "("

🛠 Кроки реалізації (навіть якщо забудеш усе):
🔹 КРОК 1: Приведи рядок до нижнього регістру

String lower = word.toLowerCase();
🔹 КРОК 2: Побудуй Map з частотами символів

Map<Character, Long> freq = lower.chars()
.mapToObj(c -> (char) c)
.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
🔹 КРОК 3: Перетвори символи в ( або ) за частотою

return lower.chars()
.mapToObj(c -> (char) c)
.map(ch -> freq.get(ch) > 1 ? ")" : "(")
.collect(Collectors.joining());
✅ Готове рішення:

public class DuplicateEncoder {
public static String encode(String word) {
String lower = word.toLowerCase();

        Map<Character, Long> freq = lower.chars()
            .mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        return lower.chars()
            .mapToObj(c -> (char) c)
            .map(ch -> freq.get(ch) > 1 ? ")" : "(")
            .collect(Collectors.joining());
    }
}
🔎 Як перевірити:

System.out.println(DuplicateEncoder.encode("Success")); // ")())())"
System.out.println(DuplicateEncoder.encode("(( @"));     // "))(("
💣 Вправа додаткова:
А як змінити код, щоб замінити символи на:
"1" — якщо унікальний
"0" — якщо повторюється?
💬 Хочеш таку версію для тренування? Напишу 😎
Або можемо зробити ще одну схожу задачку зі зворотним відновленням символів.