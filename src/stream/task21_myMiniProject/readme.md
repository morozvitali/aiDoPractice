
--------------------------------PART-I-----------------------------------
Завдання / Яка тема Stream API буде задіяна
🔹 Знайти середній бал по кожному студенту	map, collect, averagingDouble1
🔹 Знайти студента з найвищим середнім балом	map, max, comparing2
🔹 Згрупувати по групах → список студентів	groupingBy(...)0
🔹 Знайти групу з найвищим середнім балом	groupingBy(...) + averagingDouble + max3
🔹 Знайти всіх "відстаючих" (у кого середній < 60)	filter + map + collect4
🔹 Створити Map<String, List<Student>>, де ключ — група	groupingBy(...)0
🔹 Вивести студентів по групах із сортуванням	groupingBy + sorted0
🔹 Показати студентів у незмінному списку	collectingAndThen(...)0


--------------------------------------------------------------------------
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

--------------------------------------------------------------------------

Дані студентів (без коду, тільки сировина):
Ім’я	    Вік	Стать	Група	Оцінки
Alice	    20	female	A	80, 75, 90
Bob	        21	male	A	60, 55, 70
Charlie	    22	male	B	95, 85, 100
Diana	    19	female	B	50, 40, 45
Eve	        20	female	C	78, 82, 88
Frank	    23	male	C	30, 50, 40
Grace	    21	female	A	92, 88, 95
Henry	    20	male	B	67, 72, 75

-------------------------------------------------------------------------


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

-----------------------------C-O-N-T-I-N-U-E-1-----------------------------
🔹 Знайти середній бал по кожному студенту	map, collect, averagingDouble
double getAverageGrade()

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
List<Integer> grades = List.of(80, 75, 90);

double avg = grades.stream()            // Stream<Integer>
.mapToInt(Integer::intValue)            // IntStream
.average()                              // OptionalDouble
.orElse(0.0);                           // double

📤 avg → 81.6̅

🎯 У двох словах:
mapToInt(...) — перетворює об'єкти в потік примітивів,
щоб ми могли працювати з математичними методами
(average, sum) без зайвих обгорток.

-------------------------------C-O-N-T-I-N-U-E-2-----------------------------
🔹 Знайти студента з найвищим середнім балом	map, max, comparing
Optional<Student> getMaxGradeStudent(List<Student> students)

getMaxGradeStudent()
📌 Переваги:
Optional<Student> — безпечний варіант (не кидає виключення)
читабельність і гнучкість: можна обгорнути orElse(null), orElseThrow(),
або щось додаткове зробити можна комбінувати сортування за іншими полями:

Comparator.comparingDouble(Student::getAverageGrade)
.thenComparing(Student::getName)

-------------------------------C-O-N-T-I-N-U-E-3-----------------------------
🔹 Знайти групу з найвищим середнім балом	groupingBy(...) + averagingDouble + max
String getTopGroup (List<Student> students)

🎯 Що потрібно:
Згрупувати студентів по групі (група A, B, C)
Для кожної групи обчислити середній бал студентів
Знайти групу з найвищим середнім

✅ Логіка:

public String getTopGroup(List<Student> students) {
return students.stream()
.collect(Collectors.groupingBy(
Student::getGroup,
Collectors.averagingDouble(Student::getAverageGrade)
))
.entrySet().stream()
.max(Map.Entry.comparingByValue())
.map(Map.Entry::getKey)
.orElse(null);
}
🔍 Пояснення:
groupingBy(...) — групуємо по group
averagingDouble(...) — обчислюємо середній бал для кожної групи
Отримали Map<String, Double> — група → середній бал
Далі: entrySet().stream() — і шукаємо max по value
Повертаємо key (назву групи з найвищим середнім)

🧪 Приклад результату:

Група B → 85.3
Група A → 74.0
Група C → 62.1

→ Найкраща група: B
✅ Цей метод буде корисним для розширення (наприклад,
якщо захочеш не лише назву групи, а й середній бал —
можемо повернути Map.Entry<String, Double>).

-------------------------------C-O-N-T-I-N-U-E-4-----------------------------
🔹 Знайти всіх "відстаючих" (у кого середній < 60)	filter + map + collect
List<Student> getOutsiders(List<Student> list)

метод getOutsiders 
✅ Все на своєму місці:

filter() — правильно застосований до getAverageGrade()
collect(toList()) — для отримання списку студентів

🧠 Це буде зручно для:
виведення їх в окремому блоці звіту
відправлення на додаткові заняття 😄
автоматичних сповіщень: "Пора вчитися!"

-------------------------------C-O-N-T-I-N-U-E-5-----------------------------
🔹 Створити Map<String, List<Student>>, де ключ — група	groupingBy(...)


-------------------------------C-O-N-T-I-N-U-E-6-----------------------------
🔹 Вивести студентів по групах із сортуванням	groupingBy + sorted

-------------------------------C-O-N-T-I-N-U-E-7-----------------------------
🔹 Показати студентів у незмінному списку	collectingAndThen(...)


-------------------------------C-O-N-T-I-N-U-E------------------------------
🔹 Згрупувати по групах → список студентів	groupingBy(...)0

Згрупувати студентів по групах — це класика, яка часто зустрічається у проектах:
аналіз користувачів, клієнтів, товарів, оцінок, звітів — всюди!

Давай розберемо поступово, Віталію: як, чому, і які фішки тут варто враховувати 👇

🧠 Завдання: Згрупувати студентів по групах
Мета: отримати Map<String, List<Student>>, де:

ключ — назва групи (наприклад, "A", "B")

значення — список студентів у цій групі

✅ Синтаксис:

Map<String, List<Student>> map = students.stream()
.collect(Collectors.groupingBy(Student::getGroup));
📌 Що відбувається?
🔹 groupingBy(...) — головна зірка
Це спеціальний колектор, який:

бере ключ через функцію (Student::getGroup)

збирає всі об'єкти, в яких однаковий ключ, у список (за замовчуванням)

🔍 Як виглядає результат?

{
"A" = [Alice, Bob, Grace],
"B" = [Charlie, Diana, Henry],
"C" = [Eve, Frank]
}
🔧 Що ще можна зробити?
groupingBy(...) — це лише базовий рівень. Його можна комбінувати з:


Річ	Як це виглядає	Що дає
🔹 mapping(...)	groupingBy(..., mapping(...))	Наприклад, зберігати не студентів, а тільки імена
🔹 counting()	groupingBy(..., counting())	Порахувати кількість студентів у групі
🔹 collectingAndThen(...)	groupingBy(..., collectingAndThen(...))	Обробити результат: зробити незмінним список
🔹 TreeMap	groupingBy(..., TreeMap::new, ...)	Зберегти групи у відсортованому вигляді
🧪 Приклади варіацій:
🔹 1. Map<String, List<String>> — група → імена студентів

Map<String, List<String>> map = students.stream()
.collect(Collectors.groupingBy(
Student::getGroup,
Collectors.mapping(Student::getName, Collectors.toList())
));

Map<String, Long> map = students.stream()
.collect(Collectors.groupingBy(
Student::getGroup,
Collectors.counting()
));
🔹 3. Map<String, List<Student>> — список у незмінній формі

Map<String, List<Student>> map = students.stream()
.collect(Collectors.groupingBy(
Student::getGroup,
Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList)
));
💡 Методика виконання подібних задач:
Чітко зрозумій, який має бути ключ (у нас — Student::getGroup)

Подумай: чи тобі потрібні самі об'єкти, чи щось із них (наприклад, getName)

Визнач: яка структура буде зручна — List, Set, Map, Long, Double

Якщо треба додаткова обробка — заверни все у collectingAndThen(...)

✅ Висновок:

Map<String, List<Student>> grouped = students.stream()
.collect(Collectors.groupingBy(Student::getGroup));
— це базовий, найчастіше використовуваний варіант, але він відкриває шлях до величезної кількості потужних варіацій.

Хочеш наступне завдання в проєкті — наприклад:

🔹 Вивести для кожної групи список студентів з середнім балом > 80
або
🔹 Група → імена студентів, відсортовані за балом

Скажи слово — і летимо далі! 💨📘

















-------------------------------C-O-N-T-I-N-U-E------------------------------
🔹 Створити Map<String, List<Student>>, де ключ — група	groupingBy(...)0
-------------------------------C-O-N-T-I-N-U-E------------------------------
🔹 Вивести студентів по групах із сортуванням	groupingBy + sorted
-------------------------------C-O-N-T-I-N-U-E------------------------------
🔹 Показати студентів у незмінному списку	collectingAndThen(...)0