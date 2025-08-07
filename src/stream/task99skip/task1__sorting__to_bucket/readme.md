    🔥 Завдання 1: Фільтрація та перетворення списку
    Завдання: Є список цілих чисел. Необхідно:
    
    Вибрати лише парні числа.
    Піднести їх до квадрату.
    Відсортувати у спадному порядку.
    Вивести у вигляді списку.
    List<Integer> numbers = List.of(3, 6, 1, 9, 4, 8, 2);
    Очікуваний результат:
    [64, 36, 16, 4]

    🔹 Використай: filter(), map(), sorted(), collect()

    🔥 Завдання 2: Сума квадратів непарних чисел
    Завдання:
    Є список чисел. Залишити лише непарні, 
    піднести до квадрату і порахувати суму.

    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);
    Очікуваний результат:
    1² + 3² + 5² + 7² = 1 + 9 + 25 + 49 = 84
    
    Методи: filter(), map(), reduce() або mapToInt().sum()


    🔥 Завдання 3: Обробка імен
    Завдання:
    Є список імен. Залишити лише ті, які довші за 4 символи, 
    перетворити їх на верхній регістр,
    відсортувати за спаданням.
    
    List<String> names = List.of("Ola", "Vitalii", "Sasha", "Alina", "Max");
    Очікуваний результат:
    [VITALII, SASHA, ALINA]
    
    Методи: filter(), map(), sorted(), collect()


    🔥 Завдання 4: Унікальні парні числа
    Завдання:
    Є список з дублікатами. Залишити лише унікальні парні числа, 
    відсортувати їх за зростанням.
    
    List<Integer> numbers = List.of(4, 6, 2, 6, 4, 8, 10, 2);
    Очікуваний результат:
    [2, 4, 6, 8, 10]
    
    Методи: filter(), distinct(), sorted(), collect()


    🔥 Завдання 5: Довжини слів
    Завдання:
    Є список слів. Залишити лише ті, що починаються з голосної літери, 
    і перетворити їх у список довжин.
    
    List<String> words = List.of("Apple", "orange",
    "Banana", "Umbrella", "Elephant", "Cat");
    
    Очікуваний результат:
    Apple, Umbrella, Elephant  → [5, 8, 8]

    Методи: filter(), map(), collect()

    
    🔥 Бонус-завдання: Індекси квадратів
    Завдання:
    Є список чисел. Залишити ті, що діляться на 3,
    піднести до квадрату і повернути їх індекси в новому списку.
    
    List<Integer> numbers = List.of(3, 5, 9, 12, 8, 15);
    Результат:
    Наприклад: квадрати → [9, 81, 144, 225], а індекси в новому списку → [0, 1, 2, 3]
    
    Складніше: використовуй IntStream.range(0, size) 
    для індексів або створюй пару (індекс, значення).


grouping by

🧠 Серія: Групування та робота з Map — Частина 1
✅ Завдання 1: Групування слів за кількістю літер

String[] words = {"apple", "dog", "banana",
"cat", "kiwi", "plum", "watermelon"};

Очікуваний результат:
{
3=[dog, cat],
4=[kiwi, plum],
5=[apple],
6=[banana],
10=[watermelon]
}

Тип: Map<Integer, List<String>>
Підказка: .groupingBy(word -> word.length())


✅ Завдання 2: Групування за першою літерою,
але всі слова в нижньому регістрі
List<String> words = List.of("Apple", "apricot",
"Banana", "blue", "Cherry", "cranberry");

Очікуваний результат:
{
a=[apple, apricot],
b=[banana, blue],
c=[cherry, cranberry]
}

Тип: Map<Character, List<String>>
Підказка: .map(String::toLowerCase) перед groupingBy



✅ Завдання 3: Порахуй, скільки слів
починається на кожну літеру
String[] words = {"apple", "banana", "apricot",
"blue", "berry", "cherry"};

Очікуваний результат:
{
a=2,
b=3,
c=1
}
Тип: Map<Character, Long>
Підказка: groupingBy(..., counting())



----------------------------------


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

----------------------------------------------

✅ Завдання 12: Порахуй кількість усіх
символів у словах довжиною від 4 до 6,
та виведи summaryStatistics

String[] words = {"cat", "apple",
"grape", "banana", "fig", "cherry"};
🧪 Враховуються:
apple, grape, banana, cherry
→ Статистика довжин: min=5, max=6,
sum=23, average=5.75

📦 Підказка:

.filter(w -> w.length() >= 4 &&
w.length() <= 6)
.mapToInt(String::length)
.summaryStatistics()

--------------------------------------------------

✅ Завдання 13: Знайди перше слово,
у якому є принаймні дві однакові голосні

String[] words = {"apple", "tree",
"orange", "banana", "loop"};
🧪 Очікувано: "tree" (дві "e")

📦 Підказка:

.filter(w -> "aeiou".chars()
.anyMatch(c -> w.chars()
.filter(ch -> ch == c).count() >= 2))
.findFirst()
.orElse("not found")

-----------------------------------------------

✅ Завдання 14: 🧠 Бонусний виклик
String[] words = {"apple", "tree",
"orange", "banana", "loop"};
🔹 Згенеруй Map<Char, Long>
— і зроби задачу з flatMap
🔹 Створи утиліту normalize(String) →
яка чистить слова і приводить до
нижнього регістру
🔹 Зроби Map<Char, Long> —
кількість кожного символу

    public Map <Character, Long>  practice () {
        String[] words = {"apple", "tree",
                "orange", "banana", "loop"};
        
    return Arrays.stream(words)
                .map(w->normalize(w))
                .flatMap(a -> a
                        .chars()
                        .mapToObj(ch->(char)ch))
                .collect(Collectors
    .groupingBy(m->m, Collectors.counting()));
    }
    
    public String normalize (String s) {
        return s.chars()
                .map(c->(char)c)
                .filter(Character::isLetter)
                .map(Character::toLowerCase)
                .toString();
    }

