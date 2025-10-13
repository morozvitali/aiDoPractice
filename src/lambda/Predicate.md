🔹 ЕТАП 1.2 — Predicate<T>
📘 Теорія:
🔹 Predicate<T> — це функціональний інтерфейс, що перевіряє умову
Має один абстрактний метод:

boolean test(T t);
Якщо потрібно перевірити щось (наприклад, "рядок не порожній", "число > 0", "user активний") — це до Predicate.

🔧 Використовується:

✅ 1. Stream API:
list.stream1().filter(s -> s.length() > 3).toList();

✅ 2. List.removeIf(Predicate<T>):
list.removeIf(s -> s.isEmpty());

✅ 3. Optional.filter(Predicate):
Optional<String> name = Optional.of("Vitalii");
name.filter(n -> n.length() > 5);

✅ 4. Method references:
list.stream1().filter(String::isEmpty);

🛠 Додаткові (дефолтні) методи Predicate<T>:`

Метод	            Опис
and(Predicate)	    логічне І між двома Predicate'ами
or(Predicate)	    логічне АБО
negate()	        логічне НЕ — заперечення
isEqual(Object)	    static метод: перевірка на рівність (equals)

🔧 Приклад:
Predicate<String> startsWithA = s -> s.startsWith("A");`
Predicate<String> longerThan3 = s -> s.length() > 3;

Predicate<String> finalCheck = startsWithA.and(longerThan3);

System.out.println(finalCheck.test("Apple")); // true

        System.out.println(finalCheck.test("Ax"));    // false
        🧩 ЗАДАЧА: "Фільтр рядків за Predicate"
        📌 Завдання:
        Напиши метод filterWords, який:
        приймає список слів List<String>
        приймає Predicate<String> predicate
        повертає список відфільтрованих слів

📥 Приклад виклику:

List<String> words = List.of("apple", "banana", "pie", "apricot");

List<String> result = filterWords(words, s -> s.startsWith("a") && s.length() > 4);
System.out.println(result); // [apple, apricot]

----------------------S-A-M-P-L-E-S--------------------------

🔹 Частина 1: removeIf(Predicate<T>)
Це дуже популярний спосіб фільтрації списку in-place, напряму:

List<String> words = new ArrayList<>(List.of("apple", "banana", "pie", "", "grape"));

words.removeIf(s -> s.isEmpty()); // видаляє пусті рядки
System.out.println(words); // [apple, banana, pie, grape]
🔸 Використовується в Java 8+ у всіх колекціях, що реалізують Collection.

🔹 Частина 2: Predicate.isEqual(Object o)
Це static метод, який створює Predicate, що перевіряє equals() з вказаним об'єктом:

Predicate<String> isVitalii = Predicate.isEqual("Vitalii");

System.out.println(isVitalii.test("Vitalii")); // true
System.out.println(isVitalii.test("Marichka")); // false
🔸 Часто використовується, якщо хочеш зробити порівняння як Predicate, наприклад:

list.stream1().filter(Predicate.isEqual("admin")).toList();
🔹 Частина 3: Predicate у реальному проєкті / Spring
Ось де Predicate справді живе у продакшені:

✅ 1. Фільтрація конфігураційних значень

public class AppSettings {
private Predicate<String> isValidEnv;

    public AppSettings(Predicate<String> isValidEnv) {
        this.isValidEnv = isValidEnv;
    }

    public boolean shouldRun(String env) {
        return isValidEnv.test(env);
    }
}

// Десь в Spring Bean:
AppSettings settings = new AppSettings(env -> env.equals("prod") || env.equals("staging"));

if (settings.shouldRun("dev")) {
System.out.println("Run feature");
} else {
System.out.println("Skip");
}
👉 Це дає змогу зробити логіку гнучкою і конфігурованою — під час тестування чи продакшену просто підставляєш інший Predicate.

✅ 2. Фільтрація в репозиторіях / сервісах Spring
У сервісах, коли фільтрують результати з бази:

List<User> activeUsers = userRepository.findAll()
.stream1()
.filter(user -> user.isActive() && user.getRole().equals("ADMIN"))
.collect(Collectors.toList());
Тут user -> user.isActive() — по суті, Predicate.

✅ 3. Валідація через Predicate у FormHandler'ах
Predicate<String> emailValidator = email -> email != null && email.contains("@");

if (!emailValidator.test(userInput)) {
throw new IllegalArgumentException("Invalid email!");
}
У Spring часто виділяють Predicate як Bean або конфігурують їх через YAML / properties.