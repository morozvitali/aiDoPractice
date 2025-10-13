Модуль №10 — summaryStatistics() + groupingBy() Advanced — це вершина Stream API, де ми поєднуємо аналітику і групування.
Тут ви навчитеся не просто групувати, а й збирати статистику по групах,
використовувати вкладені колектори, і навіть комбінувати IntSummaryStatistics вручну.

⚙️ Модуль №10 — summaryStatistics() + groupingBy() Advanced

📘 Мета:

навчитись збирати статистику по числових полях;

комбінувати groupingBy() із колекторами (summarizingInt, averagingDouble, mapping тощо);

опанувати вкладені колектори для глибокої обробки даних.

✅ Завдання 1 — summaryStatistics() базовий приклад

📋 Умова:
Отримай статистику для чисел 5, 10, 15, 20.

IntSummaryStatistics stats = IntStream.of(5, 10, 15, 20)
.summaryStatistics();

System.out.println(stats);
// IntSummaryStatistics{count=4, sum=50, min=5, average=12.5, max=20}


🧠 Усі параметри одразу доступні: getCount(), getSum(), getAverage(), getMin(), getMax().

✅ Завдання 2 — summaryStatistics() з колекції об’єктів

📋 Умова:
Є клас:

record Product(String name, int price) {}


Знайди статистику цін:

List<Product> products = List.of(
new Product("Apple", 10),
new Product("Pear", 8),
new Product("Mango", 12)
);

IntSummaryStatistics stats = products.stream()
.collect(Collectors.summarizingInt(Product::price));

System.out.println(stats); // count=3, sum=30, average=10.0

✅ Завдання 3 — Середня ціна по категорії (groupingBy + averagingInt)

📋 Умова:

record Item(String category, int price) {}


Порахуйте середню ціну в кожній категорії.

List<Item> items = List.of(
new Item("fruit", 10),
new Item("fruit", 20),
new Item("veg", 5)
);

Map<String, Double> avgPrice = items.stream()
.collect(Collectors.groupingBy(
Item::category,
Collectors.averagingInt(Item::price)
));

System.out.println(avgPrice); // {fruit=15.0, veg=5.0}

✅ Завдання 4 — summaryStatistics() по групах

📋 Умова:
Збери IntSummaryStatistics для кожної категорії.

Map<String, IntSummaryStatistics> statsByCat = items.stream()
.collect(Collectors.groupingBy(
Item::category,
Collectors.summarizingInt(Item::price)
));

statsByCat.forEach((k, v) ->
System.out.println(k + " → " + v.getAverage())
);


📤

fruit → 15.0  
veg → 5.0

✅ Завдання 5 — Підрахунок кількості товарів по групах (counting)
Map<String, Long> countByCat = items.stream()
.collect(Collectors.groupingBy(
Item::category,
Collectors.counting()
));

System.out.println(countByCat); // {fruit=2, veg=1}


🧠 counting() — один із найчастіших допоміжних колекторів.

✅ Завдання 6 — Середня довжина слів по першій літері
List<String> words = List.of("apple", "ape", "banana", "ball", "berry");

Map<Character, Double> avgLen = words.stream()
.collect(Collectors.groupingBy(
w -> w.charAt(0),
Collectors.averagingInt(String::length)
));

System.out.println(avgLen); // {a=4.0, b=5.0}

✅ Завдання 7 — Комбінований колектор (mapping + summarizing)

📋 Умова:
Зроби статистику довжин слів по першій літері.

Map<Character, IntSummaryStatistics> stats = words.stream()
.collect(Collectors.groupingBy(
w -> w.charAt(0),
Collectors.mapping(String::length, Collectors.summarizingInt(Integer::intValue))
));

System.out.println(stats.get('b').getAverage()); // 5.0


🧠 mapping() трансформує елемент перед передачею у внутрішній колектор.

✅ Завдання 8 — Дві групи + summaryStatistics

📋 Умова:
Відокрем продукти за ціною — дешеві (<=10) і дорогі (>10).

Map<Boolean, IntSummaryStatistics> priceStats = products.stream()
.collect(Collectors.partitioningBy(
p -> p.price() > 10,
Collectors.summarizingInt(Product::price)
));

System.out.println("Cheap: " + priceStats.get(false));
System.out.println("Expensive: " + priceStats.get(true));

✅ Завдання 9 — Об’єднання двох статистик вручну

📋 Умова:
Зли дві IntSummaryStatistics у одну.

IntSummaryStatistics s1 = IntStream.of(1, 2, 3).summaryStatistics();
IntSummaryStatistics s2 = IntStream.of(4, 5, 6).summaryStatistics();

s1.combine(s2);

System.out.println(s1); // count=6, sum=21, avg=3.5


🧠 .combine() об’єднує результати — ідеально для паралельних потоків.

✅ Завдання 10 — Комбіноване: категорія → статистика → форматований звіт

📋 Умова:
Створи форматований звіт по категоріях із середнім, мінімальним і максимальним значеннями.

record Item(String category, int price) {}

List<Item> data = List.of(
new Item("A", 5),
new Item("A", 15),
new Item("B", 10),
new Item("B", 20)
);

Map<String, IntSummaryStatistics> stats = data.stream()
.collect(Collectors.groupingBy(
Item::category,
Collectors.summarizingInt(Item::price)
));

stats.forEach((cat, s) -> System.out.printf(
"%s → avg=%.1f, min=%d, max=%d%n",
cat, s.getAverage(), s.getMin(), s.getMax()
));


📤

A → avg=10.0, min=5, max=15  
B → avg=15.0, min=10, max=20

💡 Підсумок
Комбінація	Що робить
summarizingInt()	Повертає об’єкт IntSummaryStatistics
averagingInt()	Обчислює середнє значення
counting()	Підраховує кількість
mapping()	Перетворює перед групуванням
groupingBy() + summarizingInt()	Статистика по групах
combine()	Об’єднує дві статистики

🧠 Порада від Марічки:
Цей модуль — ідеальний перехід до практичних бізнес-аналітичних завдань (як у звітах, дашбордах, REST API аналітиці).
Після нього ви готові створювати звіти прямо з Java Stream API, без SQL.