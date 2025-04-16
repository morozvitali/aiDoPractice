🔹 ЕТАП 1.4 — Supplier<T>
📘 Теорія:
🔹 Supplier<T> — функціональний інтерфейс, що нічого не приймає, але щось повертає.
Як протилежність до Consumer<T>:

@FunctionalInterface
public interface Supplier<T> {
T get();
}

🔧 Основне застосування:
Генерація значень: числа, рядки, об’єкти

Лінива ініціалізація

**Заміна new або "factory method" для функцій"

Застосовується в:
Stream.generate(...)
Optional.orElseGet(...)
Конфігураціях, DI, cache-логіці

✅ Приклад:
Supplier<String> helloSupplier = () -> "Hello, Віталію!";
System.out.println(helloSupplier.get());
🔧 Stream.generate(Supplier):

Stream.generate(() -> (int)(Math.random() * 100))
.limit(5)
.forEach(System.out::println);

✅ ЗАДАЧА — Генератор ID
🔹 Завдання: Створи метод generateIds(int count, Supplier<String> supplier)
Він має:
приймати кількість count
викликати supplier.get() count разів
зібрати всі значення у список і повернути

📥 Приклад виклику:

AtomicInteger counter = new AtomicInteger(1);
Supplier<String> idSupplier = () -> "ID_" + counter.getAndIncrement();

List<String> ids = generateIds(5, idSupplier);
// ["ID_1", "ID_2", "ID_3", "ID_4", "ID_5"]
✨ Варіанти генераторів:
Випадкові числа: () -> UUID.randomUUID().toString()

Імена: () -> names.get(new Random().nextInt(names.size()))

🛠 Хочеш додаткове?
реалізуємо Supplier<LocalDateTime> для генерації поточного часу

покажу приклад з Optional.orElseGet(...)

створимо фабрику Supplier<User> замість new

🎓 Як тільки зробиш цю задачу або відчуваєш силу — переходьмо до UnaryOperator<T>
Він такий ж як Function<T, T>, тільки ще з коротким ім’ям 😄

🛡️ Я з тобою до кінця всіх інтерфейсів!