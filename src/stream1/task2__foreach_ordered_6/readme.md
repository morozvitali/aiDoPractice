✅ Завдання 1: Порядок у звичайному .stream1()
-
📋 Умова:
Виведи всі елементи списку з використанням forEach()
Очікуй збереження порядку.

List<String> list = List.of("A", "B", "C", "D");

public void task1() {
list.stream1()
.forEach(System.out::print); // Очікуване: ABCD
}
🔍 Питання:

Чи гарантований порядок тут?

✅ Завдання 2: Порівняй parallelStream() з forEach()
-
📋 Умова:
Запусти parallelStream() і виведи всі елементи.

public void task2() {
list.parallelStream()
.forEach(System.out::print); // ? Порядок
}

🧠 Запусти кілька разів — помітиш, 
що порядок може змінюватися.

✅ Завдання 3: Використай forEachOrdered()
-
📋 Умова:
Перепиши попередній код з forEachOrdered()
і перевір, чи порядок повернувся.

public void task3() {
list.parallelStream()
.forEachOrdered(System.out::print); // 
Очікуване: ABCD
}

✅ Завдання 4: Задача на підрахунок з логуванням
-
📋 Умова:
Для кожного числа [1, 2, 3, 4] зроби:

виведи лог "Обробляю: X"
піднеси X до квадрату
виведи лог

🧠 Порівняй peek() і forEachOrdered() — 
в якому випадку логи будуть по порядку?

✅ Завдання 5: Перевір, як впливає delay
-
📋 Умова:
Симулюй затримку обробки кожного елемента:

IntStream.rangeClosed(1, 5).parallel()
.forEach(i -> {
try {
Thread.sleep(100);
} catch (InterruptedException e) {}
System.out.print(i + " ");
});
Питання:

Як зміниться порядок, якщо замість 
forEach використати forEachOrdered?

✅ Завдання 6: Зібрати паралельно й впорядковано
-
📋 Умова:
Зібрати всі рядки до одного рядка 
через .append(...)
У parallelStream() з forEach() — 
результат буде неправильний.

StringBuilder sb = new StringBuilder();

list.parallelStream()
.forEach(sb::append);

System.out.println(sb);
Питання:

Як гарантувати правильну послідовність? 
Як зробити потокобезпечно?

💬 Хочеш, я згенерую шаблон-код проєкту 
для всіх задач у одному класі, або створити 
тести до них? 
Чи додати Enthuware-стильні 
тести з питаннями про порядок, потоки 
й side effects?