🔹 Частина 1: filter
✅ Задача 1: Вивести всі слова, які починаються на літеру "b"

String[] words = {"apple", "banana", "book", "car", "blue"};

Очікуваний результат:

banana
book
blue

Підказка: використай filter(word -> word.startsWith("b"))

✅ Задача 2: Вивести всі парні числа > 10

int[] numbers = {3, 10, 14, 9, 20, 25, 8};
Очікуваний результат:

14
20
Підказка: .filter(n -> n % 2 == 0 && n > 10)