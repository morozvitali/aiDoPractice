Додати ще кілька завдань
----------------c-o-l-l-e-c-t-i-n-g-A-n-d-T-h-e-n-------------------


🧪 Завдання: collectingAndThen 
🎯 Задача:
Маємо список чисел
Вибрати ті, що > 50
Відсортувати за спаданням
Зібрати в незмінний список (List<Integer>)
Повернути його

📥 Вхід:

List<Integer> numbers = List.of(10, 70, 20, 90, 55, 30);
📤 Очікуваний результат:

[90, 70, 55]
(і список має бути немодифікований)



🔧 Шаблон:
public List<Integer> sortedUnmodifiable() {
List<Integer> numbers = List.of(10, 70, 20, 90, 55, 30);

    return numbers.stream()
            .filter(n -> n > 50)
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.collectingAndThen(
                Collectors.toList(),
                Collections::unmodifiableList
            ));
}
🌀 Твоє завдання:

Напиши свій метод на базі цього

Або створи свій приклад: наприклад, зібрати всі унікальні
слова довжиною > 4 в незмінний список



?--?--?--?--?--?--?--?--THEORY--?--?--?--?--?--?--?--?

🧠 Тема: collectingAndThen — збирай і одразу перетворюй
📌 Що це таке?
Це спеціальний колектор, який дозволяє:

Спочатку зібрати результат, наприклад, у List, Set, Map…

А потім відразу перетворити його, наприклад,
зробити список незмінним, або обгорнути в іншу структуру.

📦 Синтаксис:
Collectors.collectingAndThen(
Collector<T, A, R> downstream,
Function<R, RR> finisher
)
Перекладаючи з “джавійської”:
спочатку використовуй Collector (наприклад toList())
а потім застосуй функцію до результату (наприклад
Collections::unmodifiableList)

🔧 Приклад:
List<String> result = Stream.of("apple", "banana", "cherry")
.filter(w -> w.length() > 5)
.collect(Collectors.collectingAndThen(
Collectors.toList(),
Collections::unmodifiableList
));
🧊 Тобто: ми зібрали в List, а потім одразу зробили його незмінним.



------------------------
Так, розумію, collectingAndThen працює як Colectors
але після збирання у колекцію може зробити додаткову дію з колекцією.
А які дії можуть бути або часто використовуються?
------------------------


🔥 collectingAndThen = збирання (Collector) + додаткова дія (функція) після колекціонування.

🎯 Ідея:
Ти щось зібрав (toList(), toSet(), groupingBy()),
а потім — “довів до кондиції”: зробив колекцію незмінною, витягнув значення, обгорнув у щось тощо.

🔧 Часто використовувані дії (функції) після збирання
💡 Функція	🧠 Що робить	📌 Приклад
Collections::unmodifiableList	робить список незмінним	список для читання, без add()
List::size	повертає кількість елементів	зібрали список → порахували
Function.identity()	просто повертає те, що зібрали	іноді корисно
Map::size	розмір мапи	після groupingBy
Set::iterator().next()	повернути перший елемент з Set	якщо зібрали у Set, але хочемо один
list -> list.get(0)	повернути перший елемент списку	якщо точно знаємо, що не порожній
Optional::get	якщо збираємо щось в Optional — витягуємо значення
📌 Конкретні приклади:
✅ 1. Зробити List незмінним:

.collect(Collectors.collectingAndThen(
Collectors.toList(),
Collections::unmodifiableList
));
✅ 2. Отримати розмір списку після збирання:

.collect(Collectors.collectingAndThen(
Collectors.toList(),
List::size
)); // поверне Integer
✅ 3. Повернути перший елемент після сортування:

.collect(Collectors.collectingAndThen(
Collectors.toList(),
list -> list.get(0)
));
⚠ Але тут треба бути впевненим, що список не порожній, інакше буде IndexOutOfBoundsException

✅ 4. Зібрати Set, потім витягнути перший елемент:

.collect(Collectors.collectingAndThen(
Collectors.toSet(),
set -> set.iterator().next()
));
✨ Приклади застосування в реальному коді:
Робити колекції read-only для сервісів

Після groupingBy одразу обчислити додаткові метрики (розміри, максимуми тощо)

Повернути перший або єдиний елемент

Після фільтрації й сортування повернути найкращий варіант

🎁 Хочеш?
Можу дати тобі тренажер:

"Що буде, якщо… collectingAndThen → get(0)?"
"Як зробити Map<K, List<V>> незмінною?"
"Як витягнути top-1 зі списку після сортування без .get()?"
