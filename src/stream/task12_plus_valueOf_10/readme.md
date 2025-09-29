Я залишаю завдання ускладненими, 
але тепер після кожного одразу 
дам один робочий приклад коду, 
щоб ви точно бачили хоча б один 
правильний спосіб реалізації без помилок.

🔥 Завдання 1: Конвертація з різними системами числення

Умова:
Є вхідні дані у вигляді рядків з числами в різних системах числення:

List<String> inputs = List.of("1010", "7B", "377", "42");


Ці рядки представляють:
"1010" → двійкова система (base 2)
"7B" → шістнадцяткова система (base 16)
"377" → вісімкова система (base 8)
"42" → десяткова система (base 10)
Напиши метод, який приймає список чисел + список їхніх основ систем числення:
List<Integer> bases = List.of(2, 16, 8, 10);

і повертає List<Long> у десятковому вигляді.

✅ Приклад рішення:

List<Long> result = IntStream.range(0, inputs.size())
.mapToObj(i -> Long.parseLong(inputs.get(i), bases.get(i)))
.toList();

🔥 Завдання 2: Перетворення з форматуванням

Умова:
Є long balance = 123456789L;
Виведи його як відформатований рядок у вигляді:

"123 456 789"
"123,456,789"
"123.456.789"

⚡ Порада: використати NumberFormat, DecimalFormat, або String.format(...).

✅ Приклад рішення:

NumberFormat nf = NumberFormat.getInstance(Locale.US);
String formatted = nf.format(balance); // "123,456,789"

🔥 Завдання 3: Робота з nullable-значеннями

Умова:
Є список строкових чисел, де можуть бути null
або пусті строки:

List<String> numbers = Arrays.asList("10", 
null, "20", "", "30");


Задача:

відфільтрувати null і пусті рядки,

конвертувати валідні значення у Long,

повернути List<Long>.

✅ Приклад рішення:

List<Long> result = numbers.stream()
.filter(Objects::nonNull)
.filter(s -> !s.isBlank())
.map(Long::valueOf)
.toList();

🔥 Завдання 4: Гібридне перетворення

Умова:
Дано:

int value = 123;

Пройди послідовність конверсій:
int → String
String → Long
Long → Double
Double → BigDecimal (без втрати точності)
⚡ Завдання: показати різницю між 
new BigDecimal(double) і 
BigDecimal.valueOf(double).


Послідовність: int → String → Long → Double → BigDecimal.

✅ Приклад рішення:

String str = String.valueOf(value);
Long l = Long.valueOf(str);
Double d = l.doubleValue();
BigDecimal bd = BigDecimal.valueOf(d); // краще, ніж new BigDecimal(d)

🔥 Завдання 5: Валідація та підрахунок

Умова:
Є список:
List<String> values = List.of("100", "abc", 
"300", "-50", "9999999999999");

Зроби метод, який:
Розділяє список на валідні long і невалідні (Map<Boolean, List<String>> через partitioningBy).
Для валідних рахує:
мінімальне значення
максимальне значення
суму
середнє
⚡ Використай LongSummaryStatistics.

✅ Приклад рішення:

Map<Boolean, List<String>> partition = values.stream()
.collect(Collectors.partitioningBy(s -> {
try {
Long.parseLong(s);
return true;
} catch (NumberFormatException e) {
return false;
}
}));

List<Long> valid = partition.get(true).stream().map(Long::parseLong).toList();

LongSummaryStatistics stats = valid.stream().mapToLong(Long::longValue).summaryStatistics();

🔥 Завдання 6: Конвертація у Map

Умова:
Є список рядків із числовими значеннями:

List<String> inputs = List.of("1", "2", "2", "3", "3", "3");
Зроби Map, де:
ключ → число (Long)
значення → кількість появ
⚡ Використати Collectors.groupingBy(...).


✅ Приклад рішення:

Map<Long, Long> freq = inputs.stream()
.map(Long::valueOf)
.collect(Collectors.groupingBy(
x -> x,
Collectors.counting()
));

🔥 Завдання 7: Генерація та конвертація

Умова:
Згенеруй 100 випадкових int-чисел (від -100 до 100).

Перетвори їх у List<String>
Потім у List<Long>
Відфільтруй лише позитивні числа
Відсортуй за спаданням
Виведи топ-10

✅ Приклад рішення:

List<Long> top10 = new Random().ints(100, -100, 101)
.mapToObj(String::valueOf)   // int → String
.map(Long::valueOf)          // String → Long
.filter(n -> n > 0)          // тільки позитивні
.sorted(Comparator.reverseOrder())
.limit(10)
.toList();


✨ От тепер ви маєте і цікаві завдання, і гарантовано робочий приклад рішення до кожного.
---------------------------------------------------

🟡 Задача 1: Квадрат кожної цифри (square every digit)

🎓 Умова:
Дано ціле число n. Піднеси кожну його цифру
до квадрату та з’єднай результати в один рядок.
Поверни результат як ціле число.

🧪 Приклади:
Вхід	Результат
9119	811181
765     493625
1234	14916

💡 Підказка:
Перетвори число в рядок (String.valueOf(n)),
Пройди по кожному символу,
Перетвори в цифру (Character.getNumericValue(c)),
Піднеси до квадрату,
З'єднай результат,

Перетвори назад у число (Integer.parseInt(...)).

    public int practice1 (int number) {
        return Integer.valueOf(String.valueOf(number)
                .chars()
                .map(ch-> Character.getNumericValue(ch))
                .map(a->a*a)
                .mapToObj(n->String.valueOf(n))
                .collect(Collectors.joining()));
    }


✅ **Готове рішення (Java):

public class SquareDigit {
public int squareDigits(int n) {
return Integer.parseInt(
String.valueOf(n)
.chars()
.map(Character::getNumericValue)
.map(d -> d * d)
.mapToObj(String::valueOf)
.collect(java.util.stream.Collectors.joining())
);
}
}
🎯 Пояснення крок за кроком:
🔢 String.valueOf(n) — перетворюємо число в текст (наприклад, "9119").
🎶 .chars() — робимо потік чисел (по Unicode-значенням символів).
🔍 Character.getNumericValue — перетворюємо '9' → 9, '1' → 1 тощо.
💥 .map(d -> d * d) — підносимо кожну цифру до квадрату.
🧵 .mapToObj(String::valueOf) — перетворюємо назад у рядки.
🧲 .collect(joining()) — зшиваємо все в один рядок ("811181").
🧪 Integer.parseInt(...) — назад в int.

-------------------------------------------

✅ Задача 2: Cube every digit -- // --
Умова:
Кожну цифру піднеси до куба і з’єднай.
Приклад: 23 → 827 (2³=8, 3³=27)

Очікуваний результат:
12 → 18 (1³=1, 2³=8)

Підказка:
Замість d * d, використовуй d * d * d.

    public static int cubeDigits(int number) {
    return Integer.parseInt(
    String.valueOf(number)
    .chars()
    .map(Character::getNumericValue)   // '2' → 2
    .map(d -> d * d * d)               // 2³ = 8
    .mapToObj(String::valueOf)         // 8 → "8"
    .collect(Collectors.joining())     // "8" + "27" = "827"
    );
    }



✅ Задача 3: Залишити тільки парні цифри
Умова:
Залиш тільки парні цифри числа й з’єднай їх.
Приклад: 123456 → 246

Очікуваний результат:
9876543210 → 86420

Порада:
Використовуй .filter(d -> d % 2 == 0).

    public int practice3(int number) {
        String result = String.valueOf(number)
                .chars()
                .map(c -> Character.getNumericValue(c))
                .filter(a -> a % 2 == 0)
                .mapToObj(s -> String.valueOf(s))
                .collect(Collectors.joining());

        return result.isEmpty() ? -1 : Integer.parseInt(result);
    }


✅ Задача 4: Перетвори кожну цифру в зірочки
Умова:
Перетвори кожну цифру в відповідну кількість зірочок.
Приклад: 203 → "** ***"

Очікуваний результат:
504 → "***** ****"

Порада:
Можеш використати "*".repeat(d).  --!--  ("*"::repeat)

    public String practice4 (int number) {
        return String.valueOf(number)
                .chars()
                .map(a->Character.getNumericValue(a))
                .mapToObj(value->"*".repeat(value))
                .collect(Collectors.joining());
    }



✅ Задача 5: Переверни цифри в числі
Умова:
Повертай цифри в зворотному порядку.
Приклад: 1234 → 4321

Очікуваний результат:
8675309 → 9035768

Підказка:
new StringBuilder(str).reverse().toString()

👉 Якщо число буде від'ємним (-123), 
то програма викине NumberFormatException:

        int result = Integer
                .parseInt(new StringBuilder(String.valueOf(Math.abs(number)))
                .reverse()
                .toString());
        return number < 0 ? -result : result;


✅ Задача 6: Заміни кожну цифру на її квадрат, 
якщо вона непарна
Умова:
Квадратуй тільки непарні цифри, парні лишай як є.
Приклад: 1234 → 1494 (1²=1, 2=2, 3²=9, 4=4)

Очікуваний результат:
789 → 494981

    public int practice6 (int number) {
        Integer result = Integer.parseInt(Integer.toString(Math.abs(number)).chars().map(c->Character.getNumericValue(c))
                .map(value->value%2 ==0 ? value : value * value)
                .mapToObj(s->String.valueOf(s))
                .collect(Collectors.joining()));
        return number < 0  ? -result : result;
    }

✅ Задача *запроста*: Рахуємо кількість цифр у числі
Умова:
Поверни кількість цифр у числі.

Очікуваний результат:
123456 → 6

Підказка:
Можна просто String.valueOf(n).length() 😎

Якщо ви перетворюєте число у рядок, а потім:
використовуєте .chars()
працюєте з Character.getNumericValue(c)
або .map(...), .filter(...)
то символ '-' також потрапить у потік символів,
і це викликає небажану поведінку або помилки.

    public int practice7 (int number) {
        return Integer.toString(Math.abs(number)).length();
    }



✅ Задача 8: Помнож кожну цифру на її позицію
(зліва направо, з 1)
Умова:
Наприклад, 234 → 2*1, 3*2, 4*3 = 2 6 12 → "2612"

Очікуваний результат:
1234 → 2612

Порада:

IntStream.range(0, number.length())
.mapToObj(i -> {
int digit = Character
.getNumericValue(number.charAt(i));
return String.valueOf(digit * (i + 1));
})
.collect(Collectors.joining());
}

    public int practice8 (int number) {
        String s = Integer.toString(Math.abs(number));

        String result = IntStream.range(0, s.length())
                .mapToObj(i->{
                    int digit = Character.getNumericValue(s.charAt(i));
                    return String.valueOf(digit * (i+1));
                }).collect(Collectors.joining());

        return number > 0 ? Integer.parseInt(result) : -Integer.parseInt(result);
    }

✅ Задача 9: Заміни кожну цифру на
її абсолютну різницю з 5
Умова:
987 → 4 3 2 → "432"

Очікуваний результат:
135 → 420

Порада:
.map(d -> Math.abs(d - 5))

    public int practice9 (int number) {
        String result = Integer.toString(Math.abs(number)).chars().map(c->Character.getNumericValue(c))
                .map(value-> Math.abs(value - 5)).mapToObj(a->String.valueOf(a))
                .collect(Collectors.joining());
        return number > 0 ? Integer.parseInt(result) : -Integer.parseInt(result);
    }

✅ Задача 10: Заміни кожну цифру на "X", 
якщо вона > 5, і "O" інакше 
Умова: 
67894 → XXOXO 

Підказка:
(d > 5) ? "X" : "O"

Очікуваний результат:
3456789 → OOOXXXO

    public String practice10 (int number) {
        return Integer
        .toString(Math.abs(number))
        .chars().map(c->Character.getNumericValue(c))
        .mapToObj(d->d>5 ? "X" : "O")
        .collect(Collectors.joining());
    }