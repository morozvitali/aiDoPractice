⚙️ Модуль: IntStream / DoubleStream / LongStream — практична серія (10 завдань)
✅ Завдання 1 — Діапазон чисел

🎯 Мета: зрозуміти range() vs rangeClosed().

IntStream.range(1, 5).forEach(System.out::print);      // 1234
System.out.println();
IntStream.rangeClosed(1, 5).forEach(System.out::print); // 12345


🧠 Різниця — rangeClosed() включає кінцеве число.

✅ Завдання 2 — Сума квадратів

🎯 Мета: використати IntStream без колекцій.

📋 Умова: знайди суму квадратів чисел від 1 до 5.

int sum = IntStream.rangeClosed(1, 5)
.map(n -> n * n)
.sum();
System.out.println(sum); // 55

✅ Завдання 3 — DoubleStream.generate()

🎯 Мета: створити нескінченний потік випадкових чисел і обмежити його.

DoubleStream.generate(Math::random)
.limit(5)
.forEach(System.out::println);


🧠 Генерація без колекцій, але завжди використовуйте .limit()!

✅ Завдання 4 — Конвертація між потоками

🎯 Мета: потренуватись mapToInt, mapToLong, asDoubleStream.

int result = DoubleStream.of(1.2, 2.5, 3.8)
.mapToInt(d -> (int) Math.round(d))
.sum(); // 7

✅ Завдання 5 — LongStream.range() і factorial

🎯 Мета: тренування reduce() з LongStream.

📋 Умова: обчисли 5! (факторіал числа 5).

long factorial = LongStream.rangeClosed(1, 5)
.reduce(1, (a, b) -> a * b);
System.out.println(factorial); // 120

✅ Завдання 6 — Знайти середнє

🎯 Мета: робота з average().

OptionalDouble avg = IntStream.of(10, 20, 30, 40).average();
System.out.println(avg.getAsDouble()); // 25.0

✅ Завдання 7 — Конвертація у Stream<String>

🎯 Мета: використати mapToObj() для створення текстового представлення.

📋 Умова: створити рядки типу "Num: X" для кожного елемента.

List<String> list = IntStream.rangeClosed(1, 3)
.mapToObj(i -> "Num: " + i)
.toList();

System.out.println(list); // [Num: 1, Num: 2, Num: 3]

✅ Завдання 8 — Комбінування IntStream і DoubleStream

🎯 Мета: побачити різницю типів.

📋 Умова: згенеруй випадкові double і перетвори їх у int.

List<Integer> rounded = DoubleStream.generate(Math::random)
.limit(5)
.map(d -> d * 10)
.mapToInt(d -> (int) Math.round(d))
.boxed()
.toList();

System.out.println(rounded);


🧠 Зверни увагу: .mapToInt() → потім .boxed() (бо IntStream не є Stream<Integer>).

✅ Завдання 9 — Робота зі статистикою

🎯 Мета: практика summaryStatistics().

📋 Умова: отримай статистику чисел (мін, макс, середнє).

IntSummaryStatistics stats = IntStream.of(2, 4, 6, 8, 10)
.summaryStatistics();

System.out.println(stats.getAverage()); // 6.0
System.out.println(stats.getSum());     // 30
System.out.println(stats.getMax());     // 10

✅ Завдання 10 — Комбіноване завдання: Random → обробка → результат

🎯 Мета: використати всі три типи потоків.

📋 Умова:

Згенеруй 10 випадкових чисел типу double.

Перетвори їх у long (округливши).

Поверни середнє цих значень.

double avg = DoubleStream.generate(() -> Math.random() * 100)
.limit(10)
.mapToLong(Math::round)
.asDoubleStream()
.average()
.orElse(0);

System.out.println(avg);

🧠 Після виконання всіх 10 завдань ви:

повністю відчуєте різницю між Stream<T> і примітивними потоками;

навчитеся перетворювати між типами (Int → Double → Long → Object);

знатимете, як генерувати, змінювати, аналізувати й статистично обробляти числові потоки;

і підготуєтеся до складніших тем (напр., flatMapToInt(), range().boxed(), performance tuning).