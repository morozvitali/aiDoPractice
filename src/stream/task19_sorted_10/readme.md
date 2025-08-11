🎯 Завдання: sorted
Твоя місія — написати метод, який:

Має список слів
Вибирає тільки ті, що довші за 3 літери
Сортує за:
спочатку довжиною слова
потім — в алфавітному порядку
Повертає список

📥 Вхід:
List<String> words = List.of("sun", "banana", "kiwi",
"cherry", "apple", "tea", "pear");

📤 Результат:
[kiwi, pear, apple, banana, cherry]


💡 Підказка:
.sorted(Comparator.comparing(String::length)
.thenComparing(Comparator.naturalOrder()))

🔧 Початковий шаблон:
public List<String> sortWordsSmart(List<String> words) {
return words.stream()
.filter(w -> w.length() > 3)
.sorted(
Comparator.comparing(String::length)
.thenComparing(Comparator.naturalOrder())
)
.collect(Collectors.toList());
}


?--?--?--?--?--?--?--?--THEORY--?--?--?--?--?--?--?--?


🧠 Тема: sorted() — сортування в Stream API
📌 Що це таке?
Метод sorted() дозволяє відсортувати потік елементів.

🔹 Варіант 1: Сортування за замовчуванням (natural order)

List.of(3, 1, 4, 2)
.stream()
.sorted()
.toList();   // [1, 2, 3, 4]
🔹 Варіант 2: Зі своїм компаратором

.sorted(Comparator.reverseOrder())     // за спаданням
.sorted(Comparator.comparing(String::length)) // за довжиною рядка
[🔹 Варіант 3: Комплексне сортування

Comparator.comparing(Person::getAge)
.thenComparing(Person::getName)


🧠 Теорія: sorted() — що, коли і навіщо]()
✅ 1. sorted() без параметрів
Сортує елементи в природному порядку
(для String — алфавітно, для Integer — по зростанню)

Stream.of("pear", "apple", "banana")
.sorted()
.toList();  // [apple, banana, pear]

✅ 2. sorted(Comparator) — з компаратором
Дозволяє кастомізувати логіку сортування

🔹 За спаданням:
.sorted(Comparator.reverseOrder())

🔹 За довжиною рядка:
.sorted(Comparator.comparing(String::length))

🔹 За довжиною, потім — алфавітно:
.sorted(Comparator
.comparing(String::length)
.thenComparing(Comparator.naturalOrder()))
📌 thenComparing(...) означає: “якщо значення однакові — сортуємо далі за другим критерієм”

🧊 Аналогія:
Уяви, що ти сортуєш список студентів:
Спочатку — за курсом
Якщо студенти на одному курсі — за прізвищем

.sorted(Comparator
.comparing(Student::getCourse)
.thenComparing(Student::getLastName))
⏱ Що важливо:
Сортування не змінює оригінальний список

Сортування працює на основі стріму, результат — новий список

🔁 Підсумок по теорії sorted():
Метод	                            Опис
sorted()	                        Природний порядок
sorted(Comparator.reverseOrder())	За спаданням
sorted(Comparator.comparing(...))	Сортування за певним полем
.thenComparing(...)	                Додаткове сортування, якщо рівні

🧪 А тепер — бери теорію й застосуй на практиці.

--------------------------------------------------------------

Ось кілька схожих і простіших завдань для тренування сортування в Java Stream API. Почнемо з м’яких варіантів — так, щоб рука й око набилися. У кожної задачі є умова, вхід, очікуваний результат, підказка та початковий шаблон коду.

✅ Задача 1: Сортувати слова за довжиною (тільки >3)
📋 Умова:
Є список слів. Залиш тільки ті, що довші за 3 символи,
і відсортуй за довжиною.

📥 Вхід:

List<String> words = List.of("tea", "lemon", "fig", "grape", "banana");
📤 Очікувано:

[lemon, grape, banana]
💡 Підказка:

.filter(w -> w.length() > 3)
.sorted(Comparator.comparing(String::length))
📦 Початковий код:

public List<String> sortByLength(List<String> words) {
return words.stream()
.filter(w -> w.length() > 3)
.sorted(Comparator.comparing(String::length))
.collect(Collectors.toList());
}

✅ Задача 2: Алфавітно + toLowerCase
📋 Умова:
Зроби всі слова малими літерами та відсортуй їх в алфавітному порядку.

📥 Вхід:

List<String> words = List.of("Zebra", "apple", "Lemon", "banana");
📤 Очікувано:

[apple, banana, lemon, zebra]
💡 Підказка:

.map(String::toLowerCase)
.sorted()
📦 Початковий код:

public List<String> sortAlphabetically(List<String> words) {
return words.stream()
.map(String::toLowerCase)
.sorted()
.collect(Collectors.toList());
}

✅ Задача 3: Сортувати числа у зворотному порядку
📋 Умова:
Відсортуй список чисел за спаданням.

📥 Вхід:

List<Integer> numbers = List.of(3, 7, 1, 9, 2);
📤 Очікувано:

[9, 7, 3, 2, 1]
💡 Підказка:

.sorted(Comparator.reverseOrder())
📦 Початковий код:

public List<Integer> sortDescending(List<Integer> numbers) {
return numbers.stream()
.sorted(Comparator.reverseOrder())
.collect(Collectors.toList());
}


✅ Задача 4: Сортувати об’єкти за полем
📋 Умова:
Є клас Person(name, age). Відсортуй список за віком.

📥 Вхід:

List<Person> people = List.of(
new Person("Alice", 30),
new Person("Bob", 20),
new Person("Charlie", 25)
);
📤 Очікувано:

[Bob, Charlie, Alice]
💡 Підказка:

.sorted(Comparator.comparing(Person::age))
📦 Початковий код:

record Person(String name, int age) {}

public List<Person> sortByAge(List<Person> people) {
return people.stream()
.sorted(Comparator.comparing(Person::age))
.collect(Collectors.toList());
}
✅ Задача 5: Спочатку непарні, потім парні
📋 Умова:
Розмісти всі непарні числа спочатку, потім парні,
але всередині кожної групи за зростанням.

📥 Вхід:

List<Integer> nums = List.of(3, 2, 5, 6, 1, 4);
📤 Очікувано:

[1, 3, 5, 2, 4, 6]
💡 Підказка:

.sorted(Comparator.comparingInt(n -> n % 2).thenComparingInt(n -> n))
📦 Початковий код:

public List<Integer> sortOddsFirst(List<Integer> nums) {
return nums.stream()
.sorted(Comparator.comparingInt(n -> n % 2)
.thenComparingInt(n -> n))
.collect(Collectors.toList());
}

    public void practice5 () {
        List<Integer> nums = List.of(3, 2, 5, 6, 1, 4);
        nums.stream().sorted(Comparator.comparingInt(n->(int)n%2).thenComparing(n->(int)n)).collect(Collectors.toList());
    }

✅ Задача 6: Сортувати за останньою літерою слова
📋 Умова:
Залиш тільки слова з 4+ символів і відсортуй за останньою літерою.

📥 Вхід:

List<String> words = List.of("kiwi", "apple", "banana", "grape", "plum");
📤 Очікувано:

[banana, grape, kiwi, apple]
💡 Підказка:

Comparator.comparing(w -> w.charAt(w.length() - 1))
📦 Початковий код:

public List<String> sortByLastLetter(List<String> words) {
return words.stream()
.filter(w -> w.length() >= 4)
.sorted(Comparator.comparing(w -> w.charAt(w.length() - 1)))
.collect(Collectors.toList());
}
✅ Задача 7: Сортувати за кількістю голосних
📋 Умова:
Порахуй у словах голосні (a, e, i, o, u), і відсортуй за їх кількістю. 
Якщо кількість однакова — по алфавіту.

📥 Вхід:

List<String> words = List.of("apple", "banana", "cherry", "kiwi", "grape");
📤 Очікувано:

[kiwi, cherry, grape, apple, banana]
💡 Підказка:
Створи метод countVowels(String word)
Потім:

.sorted(
Comparator.comparingInt((String w) -> countVowels(w))
.thenComparing(Comparator.naturalOrder())
)

    public List <String> practice7 () {
        List<String> words = List.of("apple", "banana", "cherry", "kiwi", "grape");
        return words.stream().sorted(Comparator.comparingInt((String s)->countVowels(s)).thenComparing(Comparator.naturalOrder())).toList();
    }

    public int countVowels (String s) {
        return (int) s.chars().filter(c->"aeiou".indexOf(c)>=0).count();
    }


📦 Початковий код:

public List<String> sortByVowelCount(List<String> words) {
return words.stream()
.sorted(
Comparator.comparingInt((String w) -> countVowels(w))
.thenComparing(Comparator.naturalOrder())
)
.collect(Collectors.toList());
}

private int countVowels(String word) {
return (int) word.toLowerCase().chars()
.filter(c -> "aeiou".indexOf(c) >= 0)
.count();
}
✅ Задача 8: Сортувати за довжиною у зворотному порядку
📋 Умова:
Виведи слова, відсортовані від найдовших до найкоротших.

📥 Вхід:

List<String> words = List.of("tea", "watermelon", "apple", "pear", "banana");
📤 Очікувано:

[watermelon, banana, apple, pear, tea]
💡 Підказка:

Comparator.comparing(String::length).reversed()
📦 Початковий код:

public List<String> sortByLengthDescending(List<String> words) {
return words.stream()
.sorted(Comparator.comparing(String::length).reversed())
.collect(Collectors.toList());
}
✅ Задача 9: Сортування чисел за парністю,
потім за спаданням
📋 Умова:
Спочатку парні, потім непарні,
всередині кожної групи — за спаданням.

📥 Вхід:

List<Integer> numbers = List.of(3, 2, 5, 6, 4, 1);
📤 Очікувано:

[6, 4, 2, 5, 3, 1]
💡 Підказка:

.sorted(Comparator.comparingInt((Integer n) -> n % 2)
.thenComparing(Comparator.reverseOrder()))
📦 Початковий код:

public List<Integer> sortEvenOddDesc(List<Integer> numbers) {
return numbers.stream()
.sorted(Comparator.comparingInt((Integer n) -> n % 2)
.thenComparing(Comparator.reverseOrder()))
.collect(Collectors.toList());
}
✅ Задача 10: Сортування об'єктів за кількістю літер у імені, далі за віком
📋 Умова:
Є клас Person(name, age). Сортуй людей спершу за довжиною імені, потім за віком.

📥 Вхід:

List<Person> people = List.of(
new Person("Anna", 30),
new Person("Bob", 25),
new Person("Charlie", 22),
new Person("Eve", 28)
);
📤 Очікувано:

[Bob, Eve, Anna, Charlie]
💡 Підказка:

Comparator.comparing((Person p) -> p.name().length())
.thenComparing(Person::age)
📦 Початковий код:

record Person(String name, int age) {}

public List<Person> sortByNameLengthThenAge(List<Person> people) {
return people.stream()
.sorted(
Comparator.comparing((Person p) -> p.name().length())
.thenComparing(Person::age)
)
.collect(Collectors.toList());
}
🔔 Якщо хочеш ще більше — можу підкинути задачі зі складнішими Comparator, null-значеннями, сортуванням вкладених структур (List<List<?>>) або об’єктів за декількома полями з Comparator.comparing(...).reversed() тощо.

Коли будеш готовий — просто скажи 🧠🚀