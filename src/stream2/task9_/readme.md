Модуль №9 — це parallelStream(), forEach(), forEachOrdered() — одна з тих тем, де Java показує свій “підкапотний” рівень.
Ви навчитеся бачити, коли паралельність реально допомагає, коли вона шкодить, і як зберегти порядок навіть у parallel-потоках.

⚙️ Модуль №9 — parallelStream(), forEach() vs forEachOrdered()

📘 Мета:

зрозуміти, що parallelStream() розбиває роботу на кілька потоків;

навчитися контролювати порядок;

усвідомити різницю між “виконати швидше” і “виконати впорядковано”.

✅ Завдання 1 — Звичайний forEach (послідовний)

📋 Умова:
Виведи числа 1–5 у звичному порядку.

List.of(1, 2, 3, 4, 5)
.stream()
.forEach(System.out::print);

// 12345


🧠 Все відбувається в одному потоці, лінійно.

✅ Завдання 2 — Паралельний потік

📋 Умова:
Запусти той самий код із parallelStream().

List.of(1, 2, 3, 4, 5)
.parallelStream()
.forEach(System.out::print);

// Наприклад: 43125 (порядок випадковий)


🧠 Елементи можуть оброблятись у будь-якому порядку — залежно від CPU.

✅ Завдання 3 — forEachOrdered()

📋 Умова:
Збережи початковий порядок у паралельному потоці.

List.of(1, 2, 3, 4, 5)
.parallelStream()
.forEachOrdered(System.out::print);

// 12345


🧠 Гарантує порядок, але втрачає частину продуктивності.

✅ Завдання 4 — Візуалізація потоків

📋 Умова:
Покажи, у якому потоці працює кожен елемент.

List.of("A", "B", "C", "D")
.parallelStream()
.forEach(s ->
System.out.println(Thread.currentThread().getName() + " → " + s)
);


📤 Наприклад:

ForkJoinPool.commonPool-worker-3 → A  
main → B  
ForkJoinPool.commonPool-worker-5 → C  
ForkJoinPool.commonPool-worker-7 → D


🧠 Можна побачити розподіл по потоках.

✅ Завдання 5 — Порівняння часу виконання

📋 Умова:
Порівняй stream() і parallelStream() при обробці великих даних.

List<Integer> nums = IntStream.range(0, 1_000_000).boxed().toList();

long t1 = System.currentTimeMillis();
nums.stream().map(Math::sqrt).toList();
long t2 = System.currentTimeMillis();

nums.parallelStream().map(Math::sqrt).toList();
long t3 = System.currentTimeMillis();

System.out.println("Normal: " + (t2 - t1) + "ms");
System.out.println("Parallel: " + (t3 - t2) + "ms");


🧠 На великих обсягах parallel може бути швидше, але не завжди.

✅ Завдання 6 — forEach() і зміна колекції (⚠️)

📋 Умова:
Спробуй додавати елементи в List усередині parallelStream.

List<Integer> result = new ArrayList<>();

IntStream.range(1, 10).parallel().forEach(result::add);

System.out.println(result); // 😱 Може бути неповним або кинути Exception


🧠 Помилка: паралельне додавання в ArrayList не є безпечним.
Використовуйте ConcurrentLinkedQueue або колектори.

✅ Завдання 7 — Правильне збирання в колекцію

📋 Умова:
Використай Collector (thread-safe збирання).

List<Integer> result = IntStream.range(1, 10)
.parallel()
.boxed()
.collect(Collectors.toList());

System.out.println(result); // усі елементи присутні

✅ Завдання 8 — Змішаний порядок і forEachOrdered

📋 Умова:
Побач різницю між двома викликами.

List.of("a", "b", "c", "d")
.parallelStream()
.peek(s -> System.out.println("peek: " + s))
.forEach(System.out::println);

System.out.println("---");

List.of("a", "b", "c", "d")
.parallelStream()
.peek(s -> System.out.println("peek: " + s))
.forEachOrdered(System.out::println);


🧠 peek завжди паралельний, але forEachOrdered виводить у правильній черзі.

✅ Завдання 9 — Використання reduce() з parallelStream

📋 Умова:
Обчисли суму з асоціативною операцією.

int sum = IntStream.rangeClosed(1, 5)
.parallel()
.reduce(0, Integer::sum);

System.out.println(sum); // 15 ✅


🧠 reduce у паралелі безпечний тільки з асоціативними операціями (+, *, min, max).

✅ Завдання 10 — Небезпечне reduce() (демонстрація помилки)

📋 Умова:
Побач, що станеться, якщо функція неасоціативна.

int result = IntStream.rangeClosed(1, 5)
.parallel()
.reduce(0, (a, b) -> a - b);

System.out.println(result); // ❓ Результат випадковий


🧠 Операція a - b не асоціативна → різні частини потоків обчислюються незалежно → хаос.
Завжди переконуйся, що операція асоціативна перед parallelStream().

💡 Підсумок
Метод	Порядок	Паралельність	Примітка
.stream()	зберігає	❌	послідовна обробка
.parallelStream()	може змінювати	✅	швидше на великих даних
.forEach()	не гарантує	✅	непередбачуваний порядок
.forEachOrdered()	гарантує	✅	порядок ціною швидкості
reduce()	безпечний лише для асоціативних	✅	інакше результат непередбачуваний

🧠 Рекомендація:
Використовуйте parallelStream() лише для CPU-heavy обчислень (наприклад, математичних задач).
Для IO, логування чи синхронних структур — це тільки погіршує продуктивність.