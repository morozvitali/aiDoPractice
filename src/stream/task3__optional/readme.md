Optional — важлива частина сучасного Java API,
яка допомагає боротися з null'ами без NullPointerException.
Тема і проста, і складна водночас — особливо, 
коли ми говоримо про map, flatMap, filter, ifPresent, orElse, orElseGet, orElseThrow.



Ось 5 задач + одна зі зірочкою ⭐ — для глибшого розуміння Optional.

🔹 Задача 1: Знайти перший елемент у списку чисел, що ділиться на 5

List<Integer> numbers = List.of(3, 8, 10, 15, 4);
Очікуваний результат: 10
або -1

List<Integer> numbers = List.of(1, 2, 3);
→ результат: -1

Підказка:
.stream().filter(n -> n % 5 == 0).findFirst().orElse(-1);

------------------------------------------------------------------

🔹 Задача 2: Якщо значення Optional є, повернути його подвоєним, 
інакше повернути -1

Optional<Integer> value = Optional.of(7); // → 14  
Optional<Integer> value = Optional.empty(); // → -1
Підказка:
.map(x -> x * 2).orElse(-1)

------------------------------------------------------------------

🔹 Задача 3: Якщо Optional містить рядок довший за 5 символів 
— повернути цей рядок, інакше — "short"

Optional<String> word = Optional.of("HelloWorld"); → "HelloWorld"  
Optional<String> word = Optional.of("Hi"); → "short"
Підказка:
.filter(s -> s.length() > 5).orElse("short")

------------------------------------------------------------------

🔹 Задача 4: Вивести повідомлення "Hello, [name]!", 
якщо ім’я присутнє, або "Hello, guest!" — якщо порожнє

Optional<String> name = Optional.of("Vitali"); → "Hello, Vitali!"  
Optional<String> name = Optional.empty(); → "Hello, guest!"
Підказка:
.map(n -> "Hello, " + n + "!").orElse("Hello, guest!")

-----------------------------------------------------------------

🔹 Задача 5: Є список чисел. Знайди максимум, 
але замість orElse використай ifPresent() для друку
або System.out.println("Немає значень"), якщо порожньо

List<Integer> nums = List.of(1, 2, 3, 4, 5); → друкує 5  
List<Integer> nums = List.of(); → друкує "Немає значень"
Підказка:

nums.stream()
.max(Integer::compareTo)
.ifPresentOrElse(
System.out::println,
() -> System.out.println("Немає значень")
);

------------------------------------------------------------------

⭐ Задача 6 (з зірочкою):
Є метод, що повертає Optional з email за ім’ям користувача. Потрібно:

Знайти email

Якщо є, перетворити в lowercase
Перевірити, чи він містить ".com"
Якщо не містить — кинути помилку "Invalid email"
Якщо містить — повернути сам email

Optional<String> email = Optional.of("ADMIN@SITE.COM");
Очікуваний результат: "admin@site.com"

Підказка:

email
.map(String::toLowerCase)
.filter(e -> e.contains(".com"))
.orElseThrow(() -> new IllegalArgumentException("Invalid email"));



------------------------------THEORY-------------------------------------

✅ Частина 1: Різниця між orElse, orElseGet, orElseThrow
🟢 orElse(value)
просто повертає value, навіть якщо Optional має значення

тобто вираз усередині orElse() завжди виконується

🔧 Приклад:

String name = Optional.of("Марко").orElse(getDefaultName()); // getDefaultName() виконається, навіть якщо "Марко" є
🟡 orElseGet(() -> value)
повертає значення лише якщо Optional пустий

лямбда виконується ТІЛЬКИ у випадку empty

🔧 Приклад:

String name = Optional.of("Марко").orElseGet(() -> getDefaultName()); // getDefaultName() НЕ виконається
🔴 orElseThrow()
викидає NoSuchElementException, якщо Optional пустий

можна передати власний виняток:

String name = Optional.empty()
.orElseThrow(() -> new IllegalArgumentException("Нема імені!"));
🧪 Демонстрація:

public class TestOptional {
public static void main(String[] args) {
System.out.println("with orElse:");
String name1 = Optional.of("Віталій").orElse(getName());

System.out.println("\nwith orElseGet:");
String name2 = Optional.of("Віталій").orElseGet(() -> getName());
}

public static String getName() {
System.out.println("👉 getName() виконується");
return "Заміна";
}
}

🔍 Вивід:

with orElse:
👉 getName() виконується

with orElseGet:
(нічого не виконується)
✅ Частина 2: Задача для практики ⭐
🔹 Задача 1: Знайти перше ім’я, довжина якого більше 4 символів.
→ Якщо немає — згенерувати дефолтне ім’я через лямбду.

List<String> names = List.of("Tom", "Amy", "Max");
Очікуваний результат: "DefaultName"

А в списку:

List<String> names = List.of("Tom", "Alexander", "Eva");
Очікуваний результат: "Alexander"

✨ Розв'язок:

import java.util.List;

public class OptionalGetExample {
public static void main(String[] args) {
List<String> names = List.of("Tom", "Amy", "Max");

String result = names.stream()
.filter(name -> name.length() > 4)
.findFirst()
.orElseGet(() -> generateDefaultName());

System.out.println(result);
}

public static String generateDefaultName() {
System.out.println("🔧 Генеруємо дефолтне ім’я");
return "DefaultName";
}
}
🧠 А тепер перевір себе:
Заміни orElseGet(...) на orElse(...).
Чи виконається generateDefaultName()?

Замініть на orElseThrow(() -> new RuntimeException("Імен немає!"))
Чи впаде програма?

Зроби цей метод універсальним:

public static String getFirstLongNameOrDefault(List<String> names)
💬 Якщо ти хочеш — можу створити 2–3 додаткові задачки типу:

повернути квадрат першого парного числа або згенерувати випадкове

перевести перший рядок у uppercase або кинути виняток

перевірити .filter(...).map(...) із Optional

Тренуємось далі?