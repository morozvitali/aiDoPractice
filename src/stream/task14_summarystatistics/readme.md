✅ Завдання 1 : Порахуй кількість 
унікальних парних чисел, 
а також поверни summaryStatistics() по ним

int[] numbers = {2, 4, 2, 6, 8, 4, 10, 10, 12};
🧪 Очікувано:

Кількість: 5
Статистика: min = 2, max = 12, sum = 42, average = 8.4

📦 Підказка:

Arrays.stream(numbers)
.distinct()
.summaryStatistics()

---------------------------------------------------------------

✅ Завдання 2 : Збери слова з парною довжиною
в нижньому регістрі і поверни також загальну 
кількість символів

List<String> words = List.of("APPLE", 
"Banana", "CHERRY", "kiwi", "PLUM");

🧪 Очікувано:

Список: [banana, cherry, plum]

Сума всіх символів: 6 + 6 + 4 = 16

📦 Підказка:

.stream().mapToInt(String::length).sum()

---------------------------------------------------------------

✅ Завдання 3 : Створи Map<String, Integer> для слів,
у яких більше 1 голосної та довжина > 3

String[] words = {"sky", "apple", 
"moon", "dry", "banana"};

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

✅ Завдання 4: Обчисли середню довжину всіх слів, 
які містять хоча б одну голосну

String[] words = {"sky", "apple", "moon", 
"dry", "sun"};

📦 Підказка:

.filter(w -> w.matches(".*[aeiou].*"))
.mapToInt(String::length)
.summaryStatistics().getAverage()

---------------------------------------------------------------

✅ Завдання 5: Знайди найкоротше слово,
яке починається з голосної

String[] words = {"apple", "orange", "banana",
"ice", "umbrella", "echo"};
🧪 Очікувано: "ice"

📦 Підказка:
.filter(w -> w.matches("(?i)^[aeiou].*"))
.min(Comparator.comparingInt(String::length))
.orElse("empty");

(?i)	🔧 Ігнорування регістру (A = a, E = e, і т.д.)
^	📍 Початок рядка
[aeiou]	🔤 Одна літера з множини: a, e, i, o, u
.*	✨ Будь-яка кількість будь-яких символів (включаючи жодного)
--------------------------------------------------------------

✅ Завдання 6: Побудуй Map<Перша_літера, 
середня довжина слів з цією літерою>

String[] words = {"apple", "ant", 
"banana", "blue", "berry", "dolphin"};
📦 Підказка:

.groupingBy(w -> w.charAt(0),
averagingInt(String::length)
)


🔍 Що реально відбувається тут: 
використання методу Collectors.getAverageInt() 
дані для якого збираються за допомогою groupingBy 

Map<Character, Double> map = Arrays.stream(words)
.collect(Collectors.groupingBy(
w -> w.charAt(0),
Collectors.averagingInt(String::length)
));

🔸 Java:
Проходиться по всьому масиву
Групує слова за першою літерою:
'a' → ["apple", "ant"]
'b' → ["banana", "blue", "berry"]
'd' → ["dolphin"]
Потім для кожної групи:
бере довжини слів
обчислює середнє (sum / count)

---------------------------------------------------------------

✅ Завдання 7: Порахуй, скільки разів кожна голосна 
зустрічається у всіх словах

String[] words = {"apple", "orange",
"banana", "umbrella"};
🧪 Очікувано:

a=4, e=2, o=1, u=1
📦 Підказка:

.flatMap(w -> w.chars().mapToObj(c -> (char)c))
.filter(ch -> "aeiou".indexOf(ch) >= 0)
.collect(groupingBy(Function.identity(), counting()))

Function.identity() Означає: "використай сам елемент як ключ"

💡 Пояснення по кроках:
1 words.stream() — потік слівMap
2 flatMap(...) — перетворюємо кожне слово на символи,
3 і розплющуємо їх в один загальний потік символів
4 .mapToObj(c -> (char)c) — перетворює int на char
5 .filter(...) — залишаємо тільки голосні
6 .collect(...) — групуємо по самій букві та рахуємо

Arrays.stream(words)
.flatMap(w -> w.toLowerCase().chars().mapToObj(c -> (char) c))
.filter(ch -> "aeiou".indexOf(ch) >= 0)
.collect(Collectors.groupingBy(
Function.identity(),
Collectors.counting()
));

---------------------------------------------------------------

✅ Завдання 8: Знайди IntSummaryStatistics
по довжині всіх слів, які мають щонайменше 
2 однакові літери

String[] words = {"apple", "moon", 
"sky", "banana", "loop"};

🧪 Очікувано: статистика довжин слів: 

apple, moon, banana, loop

📦 Підказка:

.filter(w -> hasRepeatingLetters(w))
.mapToInt(String::length)
.summaryStatistics()

------------------------------------------------------------

🚀 Несамовиті завдання по Stream API
Частина III (№11–15)

✅ Завдання 9: Знайди всі слова,
які мають усі голосні (a, e, i, o, u)

String[] words = {"education", "questionnaire", 
"house", "audio", "universe"};

🧪 Очікувано: ["education", 
"questionnaire", "universe"]

📦 Підказка:

.filter(w -> "aeiou".chars()
.allMatch(c -> w.indexOf(c) >= 0))
          
---------------------------------------------------------------

✅ Завдання 10: Побудуй Map<Boolean, 
List<String>> — поділи слова, 
які починаються з великої літери

String[] words = {"Apple", "banana",
"Cherry", "date", "Eggplant"};
🧪 Очікувано:

true  = [Apple, Cherry, Eggplant]  
false = [banana, date]
📦 Підказка:

.collect(Collectors.partitioningBy(w -> Character.isUpperCase(w.charAt(0))))

---------------------------------------------------------------

✅ Завдання 11: Побудуй Map<String, Long>
— підрахуй, скільки разів зустрічається
кожне слово (регістр не враховуємо)

String[] words = {"Java", "java", 
"Kotlin", "kotlin", "kotlin", "Scala"};
🧪 Очікувано:

{
java=2,
kotlin=3,
scala=1
}
📦 Підказка:

.map(String::toLowerCase)
.collect(Collectors.groupingBy(Function
.identity(), Collectors.counting()))

---------------------------------------------------------------

✅ Завдання 12: Порахуй кількість усіх символів у 
словах довжиною від 4 до 6, та виведи summaryStatistics

String[] words = {"cat", "apple", "grape", "banana", "fig", "cherry"};
🧪 Враховуються: apple, grape, banana, cherry
→ Статистика довжин: min=5, max=6, sum=23, average=5.75

📦 Підказка:

.filter(w -> w.length() >= 4 && w.length() <= 6)
.mapToInt(String::length)
.summaryStatistics()

---------------------------------------------------------------

✅ Завдання 13: Знайди перше слово, у якому є принаймні дві однакові голосні

String[] words = {"apple", "tree", "orange", "banana", "loop"};
🧪 Очікувано: "tree" (дві "e")

📦 Підказка:

.filter(w -> "aeiou".chars().anyMatch(c -> w.chars()
.filter(ch -> ch == c).count() >= 2))
.findFirst()
.orElse("not found")

✅ Завдання 14: 🧠 Бонусний виклик
String[] words = {"apple", "tree", "orange", "banana", "loop"};
🔹 Згенеруй List<List<Integer>> — і зроби задачу з flatMap
🔹 Створи утиліту normalize(String) → яка чистить 
слова і приводить до нижнього регістру
🔹 Зроби Map<Char, Double> — кількість кожного символу