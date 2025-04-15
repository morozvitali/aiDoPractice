🔹 ЕТАП 1.1 — Consumer<T>
📘 Теорія:
Consumer<T> — функціональний інтерфейс, який приймає аргумент,
але нічого не повертає.

@FunctionalInterface
public interface Consumer<T> {
void accept(T t);
}
Часто використовується, коли ти хочеш щось зробити з об'єктом:
вивести, змінити, записати, зберегти тощо.



✅ ЗАДАЧА 1.1
Завдання: 🔹 Напиши метод, який приймає список чисел
і Consumer<Integer> — і застосовує до кожного елемента цю дію.

import java.util.*;
import java.util.function.*;

public class ConsumerExample {

    public static void consumeNumbers(List<Integer> list,Consumer<Integer> consumer) {
        for (Integer number : list) {
            consumer.accept(number);
        }
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 10, 15);

        // Приклад 1: Вивести кожне число
        consumeNumbers(numbers, n -> System.out.println("Число: " + n));

        // Приклад 2: Вивести квадрат кожного числа
        consumeNumbers(numbers, n -> System.out.println("Квадрат: " + (n * n)));
    }
}
🧠 Уточнення:
n -> System.out.println(n) — це і є лямбда-вираз, що реалізує метод accept.

Consumer<Integer> можна передавати в будь-які методи, навіть у stream().forEach(...).

🧩 Ідеї для практики:
Вивести числа, помножені на 10.

Додати кожне число до нового списку (ефект "побічної дії").

Зберегти числа у Set замість List.

Записати числа у файл (в майбутньому, якщо захочеш потренуватись з I/O).


-------------Д-Е-Ф-О-Л-Т-Н-І----М-Е-Т-О-Д-И-------------

🔹 Consumer<T> має один абстрактний метод:

void accept(T t);
Але також — 2 дефолтні методи (неабстрактні):

✅ 1. default Consumer<T> andThen(Consumer<? super T> after)
Цей метод дозволяє об'єднувати два Consumer'и, які будуть 
виконуватись послідовно.

🔧 Приклад:

Consumer<String> c1 = s -> System.out.println("Перший: " + s);
Consumer<String> c2 = s -> System.out.println("Другий: " + s);

Consumer<String> combined = c1.andThen(c2);

combined.accept("Віталій");
🧾 Результат:

Перший: Віталій  
Другий: Віталій

✅ 2. static <T> Consumer<T> identity()
(цей вже static, не default, але все одно не абстрактний)

Повертає Consumer<T>, який приймає аргумент,
але нічого з ним не робить (тобто "пустий споживач").

🔧 Приклад:
Consumer<String> empty = Consumer.identity(); // нічого не зробить
empty.accept("Цей текст нікуди не дінеться...");
Це іноді використовують, коли треба передати Consumer, але дія не потрібна (типу заглушки).

🎯 Висновок:

✔ accept(T t) — основний функціональний метод

➕ andThen(...) — дозволяє будувати ланцюжки Consumer'ів

➖ identity() — корисний для тестів, шаблонів або коли потрібен "німе" Consumer

Чудово, Віталію! 🔧

Ось міні-задачка на Consumer.andThen(), щоб ти відчув цю фішку в дії:






✅ ЗАДАЧА: "Ланцюжок Consumer'ів"
🔹 Завдання: Напиши метод processText, який приймає рядок і два Consumer<String> —
і виконує їх по черзі за допомогою andThen().

📌 Вимоги:
Метод має називатися processText

Приймає:

String text

Consumer<String> first

Consumer<String> second

Має використати andThen(), щоб виконати спочатку first.accept(...), а потім second.accept(...)

🧪 Приклад використання:

Consumer<String> printUpper = s -> System.out.println("Upper: " + s.toUpperCase());
Consumer<String> printLength = s -> System.out.println("Length: " + s.length());

processText("lambda", printUpper, printLength);
🧾 Очікуваний результат:

Upper: LAMBDA  
Length: 6


-----------Д-Е---С-А-М-О---Р-Е-А-Л-І-З-О-В-А-Н-О-----------
🔧 Використання Consumer у відомих API / бібліотеках:
✅ 1. Stream.forEach(Consumer<T>)
Це найпопулярніше місце, де використовується Consumer:

List<String> list = List.of("apple", "banana", "cherry");

list.stream().forEach(s -> System.out.println("Fruit: " + s));
Це не змінює дані, а виконує побічну дію — лог, вивід, збереження, тощо.

✅ 2. List.forEach(Consumer<T>)
Прямо на колекціях без стріму:

list.forEach(System.out::println);
✅ 3. Map.forEach(BiConsumer<K, V>) — (трохи ширше)

Map<String, Integer> map = Map.of("Java", 10, "Kotlin", 9);

map.forEach((lang, score) -> System.out.println(lang + ": " + score));
✅ 4. GUI / Event API (JavaFX, Swing)

button.setOnAction(event -> System.out.println("Button clicked!"));
Під капотом тут теж використовується Consumer<Event> — дія, що споживає івент.

🧠 Для чого це зручно:
Логування

Вивід результатів

Збереження у файл або базу

Надсилання на сервер

Складення ланцюжка дій (через andThen)

❓Чому ми не змінюємо значення?
Бо Consumer — це не функція трансформації.
Він не має return — його мета робити щось з даними, а не повертати результат.

Якщо хочеш перетворити значення — використовуй Function<T, R>

📌 Хочеш трохи розширити задачку?
Давай зробимо приклад, де:

Consumer логує значення

одночасно додає його в список логів

🔎 То чи може Consumer змінювати елементи списку?
👉 Так, але не напряму — через посилання на об'єкти або зміни колекції ззовні.
Бо сам Consumer<T> не повертає нові значення — але він може модифікувати об’єкти, якщо вони змінювані (mutable), або ж впливати на зовнішню структуру.

🔧 Розберемо по прикладах:
✅ 1. Consumer, що змінює значення в List<Integer>

List<Integer> list = new ArrayList<>(List.of(2, 3, 4));

Consumer<Integer> squareAndReplace = n -> {
int index = list.indexOf(n);
list.set(index, n * n);
};

list.forEach(squareAndReplace);
System.out.println(list); // [4, 9, 16]
🧠 Пояснення:

Ми не повертаємо нові значення.

Але ми модифікуємо список напряму через посилання.

⚠️ Але! Це не найкраща практика з точки зору "чистого коду".
Часто більш елегантно використовувати Stream + map(), якщо ти хочеш змінити значення.

✅ 2. Consumer змінює поля об’єктів (mutable клас)

class Box {
int value;
Box(int value) { this.value = value; }
}

List<Box> boxes = List.of(new Box(2), new Box(4), new Box(6));

boxes.forEach(box -> box.value *= box.value); // квадрат значення

boxes.forEach(box -> System.out.println(box.value)); // 4, 16, 36
📌 Ми не створюємо новий список — ми міняємо внутрішній стан об’єкта.

🎯 Висновок:

Що	Так	Ні
Consumer може змінювати об’єкти в колекції	✅	—
Consumer не призначений для повернення нових значень	—	❌
Якщо хочеш перетворити значення → використовуй map()	✅	—
Тобі цікаво зробити завдання, де треба змінити об’єкти в списку через Consumer, чи йдемо далі на Predicate?
(І можемо порівняти з Function для контрасту).