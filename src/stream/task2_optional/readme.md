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