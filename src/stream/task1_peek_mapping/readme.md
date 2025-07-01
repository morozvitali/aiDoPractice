🔎 peek(...):
Це проміжний метод, який дозволяє "зазирнути" всередину потоку без його зміни. Часто використовується для відлагодження або логування проміжних результатів.

🧠 Але він працює лише тоді, коли потік завершується термінальною операцією (наприклад, collect, count, forEach, reduce, anyMatch тощо)

🔎 Collectors.mapping(...):
Це вкладений колектор, який дозволяє перед збиранням змінити тип даних.

💬 Якщо в тебе є groupingBy(...), але ти хочеш не цілий об’єкт, а тільки частинку з нього — тоді mapping(...) — ідеальне рішення.

🔹Приклад Collectors.mapping(...):
java
Copy
Edit
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
❓Задача:
🔸 З групи юзерів зробити Map<місто, список імен>

java
Copy
Edit
List<User> users = List.of(
new User("Ivan", "Kyiv"),
new User("Olya", "Lviv"),
new User("Petro", "Kyiv")
);

Map<String, List<String>> cityToNames = users.stream()
.collect(Collectors.groupingBy(
User::getCity,
Collectors.mapping(User::getName, Collectors.toList())
));
🎯 Результат:

java
Copy
Edit
{
Kyiv = [Ivan, Petro],
Lviv = [Olya]
}
🧪 Тренувальні задачі на peek(...) і Collectors.mapping(...)
✅ Задача 1: peek для відлагодження
📋 Є список слів. Виведи кожне слово, потім довжину слова, потім — лише ті, що мають довжину > 3.

java
Copy
Edit
public void debugWords() {
List<String> words = List.of("sun", "apple", "bee", "banana");

    List<String> result = words.stream()
        .peek(w -> System.out.println("Початкове слово: " + w))
        .map(String::toUpperCase)
        .peek(w -> System.out.println("У верхньому регістрі: " + w))
        .filter(w -> w.length() > 3)
        .peek(w -> System.out.println("Залишилось після фільтрації: " + w))
        .collect(Collectors.toList());

    System.out.println("Фінальний список: " + result);
}
✅ Задача 2: Collectors.mapping() для отримання всіх доменів
📋 Є список email. Виведи список доменів групованих за довжиною логіна.

java
Copy
Edit
List<String> emails = List.of("ivan@ukr.net", "olga@gmail.com", "petro@ukr.net");

Map<Integer, List<String>> byLoginLength = emails.stream()
.collect(Collectors.groupingBy(
email -> email.substring(0, email.indexOf("@")).length(),
Collectors.mapping(
email -> email.substring(email.indexOf("@") + 1),
Collectors.toList()
)
));
✅ Задача 3: peek + filter
📋 У тебе є список чисел. Виведи ті, що парні, але попередньо покажи всі:

java
Copy
Edit
public void peekNumbers() {
List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);

    List<Integer> evens = nums.stream()
        .peek(n -> System.out.println("Початкове: " + n))
        .filter(n -> n % 2 == 0)
        .peek(n -> System.out.println("Парне: " + n))
        .collect(Collectors.toList());

    System.out.println("Парні числа: " + evens);
}
✅ Задача 4: Collectors.mapping() для витягу прізвищ по групах
📋 Є список людей із групами. Отримай Map<група, List<прізвища>>:

java
Copy
Edit
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

Map<String, List<String>> groupToLastNames = people.stream()
.collect(Collectors.groupingBy(
Person::getGroup,
Collectors.mapping(Person::getLastName, Collectors.toList())
));