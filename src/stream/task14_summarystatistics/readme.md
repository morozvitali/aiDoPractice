🚀 Несамовиті завдання по Stream API — Розширене Видання (10 задач)
✅ Завдання 1 (🧠 ускладнено): Знайди найдовше слово, 
яке містить літеру "e" або "E", і його довжину

String[] words = {"java", "stream", "code", "developer", "Engineer"};
🧪 Очікувано: "developer" (9)

📦 Підказка:
.filter(w -> w.toLowerCase().contains("e"))
.map(w -> Map.entry(w, w.length()))
.reduce((a, b) -> a.getValue() >= b.getValue() ? a : b)

Рішення по кроках з поясненням:
🔧 Крок 1: Перетворити масив у потік Arrays.stream(words)
ℹ️ Тепер ми працюємо зі Stream'ом із елементами типу String.
🔧 Крок 2: Відфільтрувати слова з "e" або "E"
.filter(w -> w.toLowerCase().contains("e"))
.toLowerCase() — щоб не писати два варіанти (e або E).
У результаті маємо Stream з таких слів: "stream", "code", "developer", "Engineer"
🔧 Крок 3: Перетворити кожне слово на пару слово → довжина
.map(w -> Map.entry(w, w.length()))
📌 Тип кожного елементу тепер:
Map.Entry<String, Integer>
Наприклад:
("stream", 6), ("code", 4), ("developer", 9), ("Engineer", 8)
🔧 Крок 4: Знайти пару з найбільшою довжиною
.reduce((a, b) -> a.getValue() >= b.getValue() ? a : b)
a, b — дві пари Map.Entry<String, Integer>
Порівнюємо .getValue() — тобто довжину
Повертаємо пару з більшою довжиною
🔁 Це зменшує всі елементи до одного результату — найдовша пара "developer" → 9

❗ Питання: чому Optional?
Бо .reduce(...) — може не мати елементів, якщо, наприклад, всі слова були без "e".
Тоді .reduce(...) нічого не поверне → потрібно обгорнути результат у Optional.

! у нашому випадку, Оскільки у .reduce() немає початкового значення, і список 
може бути порожній,
Java не може гарантувати, що буде результат. Тому — повертає Optional<T>.

---------------------------------------------------------------

✅ Завдання 2 (🧠 ускладнено): Порахуй кількість 
унікальних парних чисел, а також поверни summaryStatistics() по ним

int[] numbers = {2, 4, 2, 6, 8, 4, 10, 10, 12};
🧪 Очікувано:

Кількість: 5
Статистика: min = 2, max = 12, sum = 42, average = 8.4

📦 Підказка:

Arrays.stream(numbers)
.distinct()
.summaryStatistics()

---------------------------------------------------------------

✅ Завдання 3 (🧠 ускладнено): Збери слова з парною довжиною
в нижньому регістрі і поверни також загальну кількість символів
List<String> words = List.of("APPLE", "Banana", "CHERRY", "kiwi", "PLUM");
🧪 Очікувано:

Список: [banana, cherry, plum]

Сума всіх символів: 6 + 6 + 4 = 16

📦 Підказка:

.stream().mapToInt(String::length).sum()

---------------------------------------------------------------

✅ Завдання 4 (🧠 ускладнено): Побудуй Map<Character, 
IntSummaryStatistics> — для перших літер слів довших за 4 символи

String[] words = {"apple", "ant", "banana", 
"blue", "berry", "dog", "dolphin"};
🧪 Очікувано:

{
a=lengths [5],
b=[6,5],   // banana, berry
d=[7]      // dolphin
}
📦 Підказка:

.groupingBy(w -> w.charAt(0),
summarizingInt(String::length)
)

---------------------------------------------------------------

✅ Завдання 5 (🧠 ускладнено): Створи Map<String, 
Integer> для слів, у яких більше 1 голосної та довжина > 3

String[] words = {"sky", "apple", "moon", "dry", "banana"};
🧪 Очікувано:

{
apple=2,
moon=2,
banana=3
}
📦 Підказка:

.filter(w -> countVowels(w) > 1 && w.length() > 3)
.collect(Collectors.toMap(...))

---------------------------------------------------------------

🆕 Додаткові 5 завдань:
✅ Завдання 6: Обчисли середню довжину всіх слів, 
які містять хоча б одну голосну

String[] words = {"sky", "apple", "moon", "dry", "sun"};
📦 Підказка:

.filter(w -> w.matches(".*[aeiou].*"))
.mapToInt(String::length)
.summaryStatistics().getAverage()
✅ Завдання 7: Знайди найкоротше слово, 
яке починається з голосної

String[] words = {"apple", "orange", "banana", "ice", "umbrella", "echo"};
🧪 Очікувано: "ice"

📦 Підказка:

.filter(w -> w.matches("(?i)^[aeiou].*"))
.min(Comparator.comparingInt(String::length))
✅ Завдання 8: Побудуй Map<Перша_літера, середня довжина слів з цією літерою>

String[] words = {"apple", "ant", "banana", "blue", "berry", "dolphin"};
📦 Підказка:

.groupingBy(w -> w.charAt(0),
averagingInt(String::length)
)

---------------------------------------------------------------

✅ Завдання 9: Порахуй, скільки разів кожна голосна 
зустрічається у всіх словах

String[] words = {"apple", "orange", "banana", "umbrella"};
🧪 Очікувано:

a=4, e=2, o=1, u=1
📦 Підказка:

.flatMap(w -> w.chars().mapToObj(c -> (char)c))
.filter(ch -> "aeiou".indexOf(ch) >= 0)
.collect(groupingBy(Function.identity(), counting()))
✅ Завдання 10: Знайди IntSummaryStatistics 
по довжині всіх слів, які мають щонайменше 2 однакові літери

String[] words = {"apple", "moon", "sky", "banana", "loop"};
🧪 Очікувано: статистика довжин слів: apple, moon, banana, loop

📦 Підказка:

.filter(w -> hasRepeatingLetters(w))
.mapToInt(String::length)
.summaryStatistics()


------------------------------------------------------------

🚀 Несамовиті завдання по Stream API — Частина III (№11–15)
✅ Завдання 11: Знайди всі слова, які мають усі голосні (a, e, i, o, u)

String[] words = {"education", "questionnaire", "house", "audio", "universe"};
🧪 Очікувано: ["education", "questionnaire", "universe"]

📦 Підказка:

.filter(w -> "aeiou".chars().allMatch(c -> w.indexOf(c) >= 0))
✅ Завдання 12: Побудуй Map<Boolean, List<String>> — поділи слова, 
які починаються з великої літери

String[] words = {"Apple", "banana", "Cherry", "date", "Eggplant"};
🧪 Очікувано:

true  = [Apple, Cherry, Eggplant]  
false = [banana, date]
📦 Підказка:

.collect(Collectors.partitioningBy(w -> Character.isUpperCase(w.charAt(0))))

---------------------------------------------------------------

✅ Завдання 13: Побудуй Map<String, Long> — підрахуй, 
скільки разів зустрічається кожне слово (регістр не враховуємо)

String[] words = {"Java", "java", "Kotlin", "kotlin", "kotlin", "Scala"};
🧪 Очікувано:

{
java=2,
kotlin=3,
scala=1
}
📦 Підказка:

.map(String::toLowerCase)
.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))

---------------------------------------------------------------

✅ Завдання 14: Порахуй кількість усіх символів у 
словах довжиною від 4 до 6, та виведи summaryStatistics

String[] words = {"cat", "apple", "grape", "banana", "fig", "cherry"};
🧪 Враховуються: apple, grape, banana, cherry
→ Статистика довжин: min=5, max=6, sum=23, average=5.75

📦 Підказка:

.filter(w -> w.length() >= 4 && w.length() <= 6)
.mapToInt(String::length)
.summaryStatistics()

---------------------------------------------------------------

✅ Завдання 15: Знайди перше слово, у якому є принаймні дві однакові голосні

String[] words = {"apple", "tree", "orange", "banana", "loop"};
🧪 Очікувано: "tree" (дві "e")

📦 Підказка:

.filter(w -> "aeiou".chars().anyMatch(c -> w.chars()
.filter(ch -> ch == c).count() >= 2))
.findFirst()
.orElse("not found")
🧠 Хочеш бонусний виклик?
🔹 Згенеруй List<List<Integer>> — і зроби задачу з flatMap
🔹 Створи утиліту normalize(String) → яка чистить 
слова і приводить до нижнього регістру
🔹 Зроби Map<Char, Double> — середня довжина слів на кожну початкову літеру

🚀 Готовий до наступного раунду або хочеш зібрати 
всі задачі в один клас із main() і запуском як тренажера?









