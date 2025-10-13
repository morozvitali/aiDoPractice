⚙️ Модуль №4 — Stream.iterate() / generate()

📘 Мета:
навчитися створювати, обмежувати та комбінувати нескінченні потоки,
розуміти різницю між iterate() і generate(),
та вміти “зупиняти” потік правильно (через limit() або takeWhile()).

✅ Завдання 1 — Проста арифметична послідовність (iterate)

🎯 Мета: зрозуміти базову логіку.

Stream.iterate(0, n -> n + 2)
.limit(5)
.forEach(System.out::print); // 02468


🧠 iterate(seed, next) — починає з 0 і щоразу додає 2.

✅ Завдання 2 — Випадкові числа (generate)

🎯 Мета: побачити, що generate() не має залежності між елементами.

Stream.generate(() -> (int)(Math.random() * 10))
.limit(5)
.forEach(System.out::print);


📤 Результат: 5 випадкових чисел від 0 до 9.

✅ Завдання 3 — Квадрат числа (iterate)

🎯 Мета: створити послідовність квадратів.

Stream.iterate(1, n -> n + 1)
.map(n -> n * n)
.limit(5)
.forEach(System.out::println);
// 1 4 9 16 25

✅ Завдання 4 — Умовне iterate (Java 9+)

🎯 Мета: використати форму iterate з умовою зупинки.

Stream.iterate(1, n -> n <= 10, n -> n + 2)
.forEach(System.out::print); // 13579


🧠 Java 9+ дозволяє одразу вказати умову завершення, без .limit().

✅ Завдання 5 — Stream.generate() з UUID

🎯 Мета: створювати унікальні значення.

Stream.generate(UUID::randomUUID)
.limit(3)
.forEach(System.out::println);


📤 3 випадкові UUID — зручно для тестів або фіктивних ID.

✅ Завдання 6 — Нескінченний потік Фібоначчі

🎯 Мета: комбінувати iterate() і масив для стану.

Stream.iterate(new int[]{0, 1}, a -> new int[]{a[1], a[0] + a[1]})
.limit(10)
.map(a -> a[0])
.forEach(System.out::print); // 01123581321


🧠 Тут a — пара [попереднє, наступне].

✅ Завдання 7 — Симуляція секундного таймера

🎯 Мета: створити послідовність із затримкою.

Stream.iterate(1, n -> n + 1)
.peek(n -> {
try { Thread.sleep(1000); } catch (InterruptedException e) {}
})
.limit(5)
.forEach(n -> System.out.println("Tick " + n));


📤 Вивід:

Tick 1  
Tick 2  
...

✅ Завдання 8 — takeWhile + iterate

🎯 Мета: поєднати дві концепції.

Stream.iterate(1, n -> n + 3)
.takeWhile(n -> n < 20)
.forEach(System.out::println);
// 1 4 7 10 13 16 19


🧠 Потік “сам себе обмежує” умовою.

✅ Завдання 9 — generate() + Random + mapToInt

🎯 Мета: згенерувати 100 випадкових чисел і знайти середнє.

Random random = new Random();
double avg = Stream.generate(() -> random.nextInt(100))
.limit(100)
.mapToInt(Integer::intValue)
.average()
.orElse(0);

System.out.println(avg);

✅ Завдання 10 — Комбіноване: iterate → mapToObj → filter → collect

🎯 Мета: створити послідовність чисел, відфільтрувати та зібрати.

📋 Умова:
Створи послідовність чисел від 1 до 100
→ залиш тільки ті, що кратні 7
→ перетвори їх у текст “Num: X”
→ збери в список.

List<String> result = IntStream.iterate(1, n -> n + 1)
.takeWhile(n -> n <= 100)
.filter(n -> n % 7 == 0)
.mapToObj(n -> "Num: " + n)
.toList();

System.out.println(result);


📤 [Num: 7, Num: 14, ..., Num: 98]

💡 Підсумок
Метод	Тип	Призначення
Stream.iterate(seed, next)	послідовний	залежить від попереднього елемента
Stream.generate(supplier)	незалежний	кожен елемент створюється наново
takeWhile() / limit()	контроль потоку	без них generate() → нескінченність
iterate(..., predicate, next)	(Java 9+)	умовна ітерація без limit()
