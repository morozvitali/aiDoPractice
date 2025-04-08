--------------------------------PART-I-----------------------------------

Цей проєкт для того щоб:

⚙️ натренувати Stream API в умовах наближених до реальних
🧠 зв’язати flatMap, sorted, collectingAndThen, peek, groupingBy в одному “потоку”
💼 і зробити щось, що можна зберегти як частину навчального портфоліо

🎯 Мініпроєкт: Аналіз студентів у групі

📦 Суть:
У нас є список студентів, де кожен має:

ім’я
вік
стать
назва групи (типу "A", "B", "C")
список оцінок

💡 Що ми зможемо робити:

Завдання / Яка тема Stream API буде задіяна
🔹 Знайти середній бал по кожному студенту	map, collect, averagingDouble

🔹 Знайти студента з найвищим середнім балом	map, max, comparing
🔹 Згрупувати по групах → список студентів	groupingBy(...)
🔹 Знайти групу з найвищим середнім балом	groupingBy(...) + averagingDouble + max
🔹 Знайти всіх "відстаючих" (у кого середній < 60)	filter + map + collect
🔹 Створити Map<String, List<Student>>, де ключ — група	groupingBy(...)
🔹 Вивести студентів по групах із сортуванням	groupingBy + sorted
🔹 Показати студентів у незмінному списку	collectingAndThen(...)

👨‍🎓 Клас Student — буде ось таким:

public class Student {
private String name;
private int age;
private String gender;
private String group;
private List<Integer> grades;

    // конструктор, геттери, сеттери

    public double getAverageGrade() {
        return grades.stream()
                     .mapToInt(i -> i)
                     .average()
                     .orElse(0);
    }
}

🔧 Що робимо зараз?

Ти почнеш з простого — наприклад: ✅ "Порахувати середній бал кожного студента"
А далі ми плавно переходимо до все складніших завдань 🧗

List<Student> students = List.of(
new Student("Alice", 20, "female", "A", List.of(80, 75, 90)),
new Student("Bob", 21, "male", "A", List.of(60, 55, 70)),
new Student("Charlie", 22, "male", "B", List.of(95, 85, 100)),
new Student("Diana", 19, "female", "B", List.of(50, 40, 45)),
new Student("Eve", 20, "female", "C", List.of(78, 82, 88)),
new Student("Frank", 23, "male", "C", List.of(30, 50, 40)),
new Student("Grace", 21, "female", "A", List.of(92, 88, 95)),
new Student("Henry", 20, "male", "B", List.of(67, 72, 75))
);

-------------------------------C-O-N-T-I-N-U-E------------------------------

Метод getAverageGrade() виглядає просто, але насправді він використовує 
потужні інструменти Stream API, зокрема mapToInt.

Ось повний метод:

public double getAverageGrade() {
return grades.stream()
.mapToInt(Integer::intValue)
.average()
.orElse(0.0);
}
🔍 Що тут відбувається, крок за кроком:
🧱 grades.stream()
Створює Stream<Integer> зі списку оцінок, наприклад:

List<Integer> grades = List.of(80, 75, 90);
Після .stream() — ми маємо потік чисел:

Stream<Integer>
🔧 mapToInt(Integer::intValue)
Оце — головний герой!

Цей метод перетворює Stream<Integer> на IntStream, 
тобто потік примітивних int.

Чому це потрібно?
Бо деякі операції, як-от average(), sum(), min(), 
max() — працюють тільки з примітивами (int, long, double) через:

ефективність (менше об'єктів = швидше)

набір специфічних методів

📌 Що робить Integer::intValue?
Це метод посилання, який для кожного об'єкта Integer 
бере його примітивне значення:

Integer x = 80;
x.intValue() → 80
У стрімі:

.mapToInt(Integer::intValue)
означає: "візьми кожен Integer і дістань з нього int"

💡 Після цього маємо IntStream
У якого є спеціальні методи:

.average()
.sum()
.min()
.max()
.boxed() ← назад у Stream<Integer>

📈 .average()
Повертає OptionalDouble — бо може бути ситуація, 
коли немає жодного елемента.
Наприклад: List<Integer> grades = List.of();

🔒 .orElse(0.0)
Якщо студент не має жодної оцінки, 
то ми повернемо 0.0, щоб не було NoSuchElementException.

✅ Повний приклад:
java
Копіювати
Редагувати
List<Integer> grades = List.of(80, 75, 90);

double avg = grades.stream()          // Stream<Integer>
.mapToInt(Integer::intValue) // IntStream
.average()                   // OptionalDouble
.orElse(0.0);                // double
📤 avg → 81.6̅

🎯 У двох словах:
mapToInt(...) — перетворює об'єкти в потік примітивів, 
щоб ми могли працювати з математичними методами 
(average, sum) без зайвих обгорток.



😎

-------------------------------C-O-N-T-I-N-U-E------------------------------

mapToObj, mapToLong, boxed — коли,
навіщо й як саме вони працюють під капотом

🧠 Спочатку — невеличка структура Stream API:
Java має два основні типи потоків:

📦 1. Stream<T> — об'єктний стрім
працює з будь-якими об'єктами: String, Integer, Student, List<T>, тощо

⚙ 2. Примітивні стріми:
IntStream — потік int
LongStream — потік long
DoubleStream — потік double

🔄 Переходи між стрімами:
З	У	Як
Stream<Integer>	IntStream	.mapToInt(...)
IntStream	Stream<Integer>	.boxed()
LongStream	Stream<Long>	.boxed()
Stream<String>	IntStream	.mapToInt(String::length)
IntStream	Stream<String>	.mapToObj(...)
🔧 1. boxed()
Перетворює примітивний стрім → у стрім об'єктів

📌 Коли потрібно:

коли тобі треба зібрати в колекцію

коли потрібен непримітивний тип (List<Integer>, а не IntStream)

IntStream.range(1, 5)         // IntStream: 1, 2, 3, 4
.boxed()             // Stream<Integer>
.collect(Collectors.toList());  // [1, 2, 3, 4]
🔧 2. mapToObj(...)
Перетворює примітив → об’єкт за твоїм правилом

📌 Коли потрібно:

коли ти маєш IntStream і хочеш створити об'єкти на його основі

IntStream.range(1, 4)
.mapToObj(i -> "Day " + i)  // Stream<String>
.collect(Collectors.toList());
// [Day 1, Day 2, Day 3]
🔧 3. mapToLong(...), mapToDouble(...)
Звичайні перетворювачі типів:
Stream<T> → LongStream або DoubleStream
📌 Коли потрібно:

коли тобі треба математичні обчислення з long/double
або коли збираєш великі числа (наприклад, ID, timestamps)
Stream<String> words = Stream.of("apple", "banana");

words.mapToLong(w -> w.length())  // LongStream
.sum();                      // long
🧩 Коли що використовувати?
Ситуація	Метод
Маєш IntStream, хочеш List<Integer>	.boxed()
Маєш IntStream, хочеш створити String, Student, тощо	.mapToObj(...)
Маєш Stream<T>, хочеш робити sum(), average() по int	.mapToInt(...)
Маєш Stream<T>, але хочеш LongStream чи DoubleStream	.mapToLong(...), 
.mapToDouble(...)
✅ Мікроприклади для кожного:
boxed():

IntStream.of(1, 2, 3)
.boxed()
.collect(Collectors.toList()); // [1, 2, 3]
mapToObj(...):

IntStream.of(1, 2, 3)
.mapToObj(i -> "Item " + i)
.toList(); // ["Item 1", "Item 2", "Item 3"]
mapToLong(...):

Stream<String> list = Stream.of("one", "two");
list.mapToLong(s -> s.length()).sum(); // 6
Хочеш потренуватись?
Можу дати завдання:

Створити List<String> типу "Length: 5" з потоку List<Integer>
З IntStream створити список Student з ID
Або зробити обчислення: середня довжина рядків як double
Сигналізуй, і я підготую 💪😉

-------------------------------C-O-N-T-I-N-U-E------------------------------



