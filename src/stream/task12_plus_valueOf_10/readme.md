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