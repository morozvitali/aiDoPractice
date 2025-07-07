🔥 Завдання 1: Сума цифр у квадраті
📋 Умова:
Дано число n. Порахуй суму квадратів кожної цифри.

📥 Вхід: n = 234
📤 Очікуване: 2² + 3² + 4² = 4 + 9 + 16 = 29

public int sumOfDigitSquares(int n) {
return String.valueOf(n).chars()
.map(c -> c - '0') toChar
.map(d -> d * d) toSquare
.sum();
}

------------------------------------------

💡 Завдання 2: Чи всі цифри парні?
📋 Умова:
Перевір, чи всі цифри числа парні.

📥 Вхід: n = 2486 → true
📥 Вхід: n = 1234 → false

public boolean areAllDigitsEven(int n) {
return String.valueOf(n).chars()
.map(c -> c - '0')
.allMatch(d -> d % 2 == 0);
}

-----------------------------------------

🌟 Завдання 3: Знайти найбільшу цифру
📋 Умова:
Поверни найбільшу цифру в числі.

📥 Вхід: n = 8354 → 8

public int maxDigit(int n) {
return String.valueOf(n).chars()
.map(c -> c - '0')
.max()
.orElse(-1); // якщо n == 0
}

-----------------------------------------------

🧪 Завдання 4: Порахуй, скільки цифр більше за 5
📋 Умова:
Знайди кількість цифр у числі, більших за 5

📥 Вхід: n = 987654321 → 4 (9, 8, 7, 6)

public long countDigitsGreaterThan5(int n) {
return String.valueOf(n).chars()
.map(c -> c - '0')
.filter(d -> d > 5)
.count();
}

------------------------------------------------

🔮 Завдання 5: Добуток цифр з непарними індексами
📋 Умова:
Порахуй добуток цифр на непарних 
позиціях (0-індексація зліва)

📥 Вхід: n = 123456
Цифри з індексами 1, 3, 5 → 2 * 4 * 6 = 48

public int productOfDigitsAtOddIndexes(int n) {
int[] digits = String.valueOf(n).chars()
.map(c -> c - '0')
.toArray();

    int product = 1;
    for (int i = 1; i < digits.length; i += 2) {
        product *= digits[i];
    }
    return product;
}

-----------------------------------------------

✅ Задача 6: peek для відлагодження
📋 Є список слів. Виведи кожне слово, 
потім у верхгьому регістрі, потім — лише ті, 
що мають довжину > 3.

public void debugWords() {
List<String> words = List.of("sun", "apple",
"bee", "banana");

    List<String> result = words.stream()
        .peek(w -> System.out.println(
"Початкове слово: " + w))
        .map(String::toUpperCase)
        .peek(w -> System.out.println(
"У верхньому регістрі: " + w))
        .filter(w -> w.length() > 3)
        .peek(w -> System.out.println(
"Залишилось після фільтрації: " + w))
        .collect(Collectors.toList());

    System.out.println("Фінальний список: "
+ result);
}

--------------------------------------------

✅ Задача 7: Collectors.mapping() для 
отримання всіх доменів
📋 Є список email. Виведи список доменів 
групованих за довжиною логіна.

List<String> emails = List.of("ivan@ukr.net",
"olga@gmail.com", "petro@ukr.net");

Map<Integer, List<String>> map = emails
.stream()
.collect(Collectors.groupingBy(email -> email.substring(0, email.indexOf("@")).length(),
Collectors.toList()));
return map;

-----------------------------------------------

✅ Задача 8: peek + filter
📋 У тебе є список чисел. Виведи ті, що парні, 
але попередньо покажи всі:

public void peekNumbers() {
List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);

    List<Integer> evens = nums.stream()
        .peek(n -> System.out.println("Початкове: "
+ n))
        .filter(n -> n % 2 == 0)
        .peek(n -> System.out.println("Парне: " + n))
        .collect(Collectors.toList());

    System.out.println("Парні числа: " + evens);
}

--------------------------------------------------

✅ Задача 9: Collectors.mapping()
для витягу прізвищ по групах
📋 Є список людей із групами. Отримай Map<група,
List<прізвища>>:

class Person {
String lastName;
String group;
Person(String ln, String g) {
lastName = ln;
group = g;
}
String getGroup() { return group; }
String getLastName() { return lastName; }
}

List<Person> people = List.of(
new Person("Shevchenko", "A"),
new Person("Franko", "B"),
new Person("Skovoroda", "A")
);

Map<String, List<String>> groupToLastNames = 
people.stream()
.collect(Collectors.groupingBy(
Person::getGroup,
Collectors.mapping(Person::getLastName,
Collectors.toList())
));

-------------theory-----------------
🔎 peek(...):
Це проміжний метод, який дозволяє "зазирнути" 
всередину потоку без його зміни. 
Часто використовується для відлагодження 
або логування проміжних результатів.

🧠 Але він працює лише тоді, коли потік 
завершується термінальною операцією 
(наприклад, collect, count, 
forEach, reduce, anyMatch тощо)

🔎 Collectors.mapping(...):
Це вкладений колектор, який дозволяє 
перед збиранням змінити тип даних.

💬 Якщо в тебе є groupingBy(...), 
але ти хочеш не цілий об’єкт, 
а тільки частинку з нього — 
тоді mapping(...) — ідеальне рішення.

🔹Приклад Collectors.mapping(...):

class User {
String name;
String city;
User(String name, String city) {
this.name = name;
this.city = city;
}
public String getName() { return name; }
public String getCity() { return city; }
}
Задача:
🔸 З групи юзерів зробити Map<місто, список імен>

List<User> users = List.of(
new User("Ivan", "Kyiv"),
new User("Olya", "Lviv"),
new User("Petro", "Kyiv")
);

Map<String, List<String>> cityToNames = 
users.stream()
.collect(Collectors.groupingBy(
User::getCity,
Collectors.mapping(User::getName, 
Collectors.toList())
));
🎯 Результат:

{
Kyiv = [Ivan, Petro],
Lviv = [Olya]
}
🧪 Тренувальні задачі на peek(...) і 
Collectors.mapping(...)
