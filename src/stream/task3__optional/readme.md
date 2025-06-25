Optional — важлива частина сучасного Java API,
яка допомагає боротися з null'ами без NullPointerException.
Тема і проста, і складна водночас — особливо, 
коли ми говоримо про map, flatMap, filter, ifPresent, orElse, orElseGet, orElseThrow.



Ось 5 задач + одна зі зірочкою ⭐ — для глибшого розуміння Optional.

🔹 Задача 0: Знайти перший елемент у списку чисел, що ділиться на 5

List<Integer> numbers = List.of(3, 8, 10, 15, 4);
Очікуваний результат: 10
або -1

List<Integer> numbers = List.of(1, 2, 3);
→ результат: -1

Підказка:
.stream().filter(n -> n % 5 == 0).findFirst().orElse(-1);

------------------------------------------------------------------

🔹 Задача 1: Якщо значення Optional є, повернути його подвоєним, 
інакше повернути -1

Optional<Integer> value = Optional.of(7); // → 14  
Optional<Integer> value = Optional.empty(); // → -1
Підказка:
.map(x -> x * 2).orElse(-1)

------------------------------------------------------------------

🔹 Задача 2: Якщо Optional містить рядок довший за 5 символів 
— повернути цей рядок, інакше — "short"

Optional<String> word = Optional.of("HelloWorld"); → "HelloWorld"  
Optional<String> word = Optional.of("Hi"); → "short"
Підказка:
.filter(s -> s.length() > 5).orElse("short")

------------------------------------------------------------------

🔹 Задача 3: Вивести повідомлення "Hello, [name]!", 
якщо ім’я присутнє, або "Hello, guest!" — якщо порожнє

Optional<String> name = Optional.of("Vitali"); → "Hello, Vitali!"  
Optional<String> name = Optional.empty(); → "Hello, guest!"
Підказка:
.map(n -> "Hello, " + n + "!").orElse("Hello, guest!")

-----------------------------------------------------------------

🔹 Задача 4: Є список чисел. Знайди максимум, 
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

⭐ Задача 5 (з зірочкою):
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
