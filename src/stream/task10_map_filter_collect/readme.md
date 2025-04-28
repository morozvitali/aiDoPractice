🎯 Тренажер: map + filter + collect — Частина 1

✅ Задача 1: Знайти довжини слів, які довші за 3 літери
String[] words = {"hi", "apple", "go", "banana", "car"};
Результат у списку: [5, 6]

Пояснення:

"apple" → 5, "banana" → 6 — бо тільки вони довші за 3 літери
"hi", "go", "car" — відкидаємо

Підказка: .filter(...), потім .map(...), потім .collect(...)

✅ Задача 2: Отримати список квадратів непарних чисел
int[] numbers = {1, 2, 3, 4, 5};
Результат: [1, 9, 25]

Непарні числа: 1, 3, 5
Квадрати: 1² = 1, 3² = 9, 5² = 25

✅ Задача 3: Отримати список великих слів, які починаються на "a"
String[] words = {"apple", "banana", "apricot", "cherry", "avocado"};
Результат: [APPLE, APRICOT, AVOCADO]

Всі слова на "a", перетворені у верхній регістр

🧪 Формат прикладу:
List<String> result = Arrays.stream(array)
.filter(...)      // фільтруємо
.map(...)         // перетворюємо
.collect(Collectors.toList()); // збираємо в список

------------------------------

🎯 Тренажер: map + filter + collect — Частина 2
✅ Задача 4: Подвоїти всі числа, які діляться на 5
📌 Умова:
Маємо масив чисел. Потрібно залишити лише ті, що діляться на 5, і подвоїти їх значення.

📥 Вхід:

int[] numbers = {3, 5, 10, 14, 15};
📤 Очікуваний результат:

[10, 20, 30]
🔧 Підказка:
.filter(n -> n % 5 == 0).map(n -> n * 2).boxed().collect(...)

public List<Integer> doubleMultiplesOfFive() {
return Arrays.stream(new int[] {3, 5, 10, 14, 15})
.filter(n -> n % 5 == 0)
.map(n -> n * 2)
.boxed()
.collect(Collectors.toList());
}

--------------------------------------------------------------------
✅ Задача 5: Слова з довжиною 4 — зробити першу літеру великою
📌 Умова:
Із масиву рядків вибрати слова довжиною 4. У кожному зробити першу літеру великою, решту — маленькими.

📥 Вхід:

String[] words = {"java", "code", "home", "sun", "snow"};
📤 Очікуваний результат:

[Java, Code, Home, Snow]
🔧 Підказка:
.filter(w -> w.length() == 4).map(...)

public List<String> capitalizeFourLetterWords() {
return Arrays.stream(new String[] {"java", "code", "home", "sun", "snow"})
.filter(w -> w.length() == 4)
.map(w -> w.substring(0, 1).toUpperCase() + w.substring(1).toLowerCase())
.collect(Collectors.toList());
}


--------------------------------
✅ Задача 6: Унікальні квадрати парних чисел
📌 Умова:
Знайти парні числа, звести їх у квадрат, і повернути унікальні значення.

📥 Вхід:

int[] numbers = {2, 2, 4, 6, 3, 4};
📤 Очікуваний результат:

[4, 16, 36]
🔧 Підказка:
.filter(...).map(...).distinct().boxed().collect(...)

public List<Integer> uniqueSquaresOfEvenNumbers() {
return Arrays.stream(new int[] {2, 2, 4, 6, 3, 4})
.filter(n -> n % 2 == 0)
.map(n -> n * n)
.distinct()
.boxed()
.collect(Collectors.toList());
}
🔚 Готово!


