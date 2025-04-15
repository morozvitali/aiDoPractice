// 🔹 ЕТАП 1: Основи функціонального програмування в Java

// 🧠 Теорія:
// @FunctionalInterface - інтерфейс з лише одним абстрактним методом.
// Lambda-вираз — скорочена форма реалізації методу функціонального інтерфейсу.

// Стандартні функціональні інтерфейси:
// 1. Predicate<T> — boolean test(T t);
// 2. Function<T, R> — R apply(T t);
// 3. Consumer<T> — void accept(T t);
// 4. Supplier<T> — T get();
// 5. UnaryOperator<T> extends Function<T, T>
// 6. BinaryOperator<T> extends BiFunction<T, T, T>

// 🧪 Приклади практики:

// 1. Consumer: приймає список чисел і дію
void applyToList(List<Integer> list, Consumer<Integer> consumer) {
list.forEach(consumer);
}

// Використання:
// applyToList(List.of(1, 2, 3), n -> System.out.println(n * 2));

// 2. Predicate: фільтрація рядків за довжиною > 3
List<String> filterStrings(List<String> strings) {
return strings.stream()
.filter(s -> s.length() > 3)
.collect(Collectors.toList());
}

// 3. Function: перетворення імен у список їх довжин
List<Integer> mapNameLengths(List<String> names) {
return names.stream()
.map(String::length)
.collect(Collectors.toList());
}

// 4. Supplier: генерація випадкових чисел
List<Integer> generateRandomNumbers(int count, Supplier<Integer> supplier) {
return Stream.generate(supplier)
.limit(count)
.collect(Collectors.toList());
}

// Використання:
// generateRandomNumbers(5, () -> new Random().nextInt(100));
