🔥 Завдання 1: Витягни букви з коду
📋 Умова:

Є список кодів символів (наприклад, 97 = 'a', 98 = 'b' тощо).
Потрібно перетворити список чисел у відповідні літери.

List<Integer> codes = List.of(97, 98, 99, 100, 101);
🔧 Очікуваний результат:

["a", "b", "c", "d", "e"]
🧠 Підказка:

codes.stream()
.map(c -> String.valueOf((char)(int)c))
.collect(Collectors.toList());

🔎 Теорія:

(char)(int)c — перетворення числа в символ. а далі → String.
String.valueOf(char) — робить зі char → String.

-----------------------------------------------------

⚡ Завдання 2: Знайди всі цифри в рядку
📋 Умова:
Є рядок, потрібно витягти лише цифри (0–9), 
перетворити їх у числа (int),
відсортувати й скласти список.

String mixed = "a1b2c3x9z7";
🔧 Очікуваний результат:

[1, 2, 3, 7, 9]
🧠 Підказка:

mixed.chars()
.filter(Character::isDigit)
.mapToObj(c -> Character.getNumericValue(c))
.sorted()
.collect(Collectors.toList());
🧠 Теорія:

.chars() — створює IntStream.
Character.getNumericValue(char) — повертає число, 
яке представляє символ-цифру.

-----------------------------------------------------

🎯 Завдання 3: Унікальні символи як рядки
📋 Умова:
Дано рядок. Потрібно:

залишити лише унікальні символи
перетворити кожен символ у String

зібрати у список

String s = "abracadabra";
🔧 Очікуваний результат:

["a", "b", "r", "c", "d"]
🧠 Підказка:

s.chars()
.distinct()
.mapToObj(c -> String.valueOf((char) c))
.collect(Collectors.toList());

🔹 Пояснення. Тут головне:
c — це все ще int, не char і не String!
mapToObj(...) перетворює кожен int у об'єкт 
(String), через каст до char, а потім String.valueOf(...)

💡 Інакше кажучи:
mapToInt — коли хочеш отримати числа
mapToObj — коли хочеш об’єкти (наприклад, рядки, 
обгортки, власні класи)
-----------------------------------------------------

🧪 Завдання 4: Виведи всі символи як їх коди
📋 Умова:
Є рядок. Виведи список ASCII-кодів кожного символу.

String text = "Code";
🔧 Очікуваний результат:

[67, 111, 100, 101]
🧠 Підказка:

text.chars()
.boxed()
.collect(Collectors.toList());

-----------------------------------------------------

💥 Завдання 5: Витягни великі літери
📋 Умова:
Є рядок. Виведи всі великі літери
в рядку як String (наприклад, "ABC").

String input = "hEllO WoRLd";
🔧 Очікуваний результат:

["E", "O", "W", "R", "L"]
🧠 Підказка:

input.chars()
.filter(Character::isUpperCase)
.mapToObj(c -> String.valueOf((char) c))
.collect(Collectors.toList());

🔍 Теорія про String.valueOf(...) та перетворення:

Мета	                        Приклад	                            Пояснення
char → String	                String.valueOf('a') → "a"	        Створює строкове представлення
int → String	                String.valueOf(123) → "123"	        Перетворює число в текст
char → int (код)	            int c = 'a'; → 97	                Код символу (ASCII/Unicode)
int → char	                    (char) 97 → 'a'	                    Зворотне перетворення
Character.isDigit(c)	        Перевірка, чи символ — цифра
Character.getNumericValue(c)	'9' → 9, 'a' → 10	                Значення символу у числовому вигляді

-----------------------------------------------------

🔥 Завдання 6: Перетвори символи на місця
в алфавіті
📋 Умова:
Дано рядок з малих літер (a–z).
Для кожної букви виведи її порядковий 
номер в алфавіті:
'a' → 1, 'b' → 2, ..., 'z' → 26.

String s = "abcxyz";
🔧 Очікуваний результат:

[1, 2, 3, 24, 25, 26]
🧠 Підказка:

s.chars()
.map(c -> c - 'a' + 1)
.boxed()
.collect(Collectors.toList());

-----------------------------------------------------

✨ Завдання 7: Рядок → список букв 
у верхньому регістрі
📋 Умова:
Дано рядок. Перетвори кожен 
символ у відповідну велику літеру.

String s = "java";
🔧 Очікуваний результат:

["J", "A", "V", "A"]
🧠 Підказка:

s.chars()
.map(Character::toUpperCase)
.mapToObj(c -> String.valueOf((char) c))
.collect(Collectors.toList());

-----------------------------------------------------

🎲 Завдання 8: Підрахунок кількості літер
📋 Умова:
Є рядок. Порахуйте, скільки разів 
кожна літера зустрічається.
(тільки латинські літери, 
без цифр і пробілів).

String s = "banana";
🔧 Очікуваний результат:

{b=1, a=3, n=2}
🧠 Підказка:

s.chars()
.filter(Character::isLetter)
.mapToObj(c -> (char) c)
.collect(Collectors.groupingBy(c -> c, Collectors.counting()));

    public void practice8 () {
        String s = "banana";
        s.chars().filter(c->Character.isLetter(c)).mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(c->c, Collectors.counting()));
    }

-----------------------------------------------------

🧊 Завдання 9: Залишити тільки символи, 
що не є цифрами
📋 Умова:
Є рядок, в якому можуть бути і букви, 
і цифри. 
Залиш лише нецифрові символи 
(виведи як String).

String s = "a1b2c3d4";
🔧 Очікуваний результат:

"abcd"
🧠 Підказка:

String result = s.chars()
.filter(c -> !Character.isDigit(c))
.mapToObj(c -> String.valueOf((char) c))
.collect(Collectors.joining());

-----------------------------------------------------

🧨 Завдання 10: Сума всіх цифр у рядку
📋 Умова:
Знайди суму всіх цифр у рядку.

String s = "abc1d2e3f9";
🔧 Очікуваний результат:

15

🧠 Підказка:

int sum = s.chars()
.filter(Character::isDigit)
.map(Character::getNumericValue)
.sum();

🥁 Що далі?

-----------------------------------------------------

⚔️ Завдання 11: Витягни лише малі
літери й склади з них слово
📋 Умова:
З рядка витягни всі малі латинські
літери (a-z) 
і з'єднай в один рядок.

String input = "ABCdefGHIjkl123";
🧪 Очікуване:

"defjkl"

.filter(a-> Character.isLetter(a))
.filter(ch->Character.isLowerCase(ch))
.mapToObj(a->String.valueOf((char)a))
.collect(Collectors.joining());
-----------------------------------------------------

🧨 Завдання 12: Коди символів + 1
📋 Умова:
Є рядок. Замість кожної літери 
виведи її ASCII-код + 1.

String input = "abc";
🧪 Очікуване:

[98, 99, 100]

return input.chars()  // перетворює String у IntStream кодів символів
.map(c -> c + 1)  // додаємо 1 до кожного коду
.boxed()         // перетворюємо int на Integer (обгортка)
.collect(Collectors.toList()); // збираємо у список
}
-----------------------------------------------------

🎯 Завдання 13: Цифри → символи

📋 Умова:
Є список цифр від 0 до 9. 
Виведи відповідні символи,
тобто '0', '1', ..., '9'.

List<Integer> digits = 
List.of(1, 2, 3, 9);
🧪 Очікуване:

['1', '2', '3', '9']
🎁 Підказка: '0' + digit

.map(d -> (char) ('0' + d)) 
// додаємо до символу '0'
.collect(Collectors.toList());
'0' — це символ з ASCII-кодом 48
Якщо додати до нього 1, отримаємо '1' (49), і т.д.
(char) ('0' + d) — класичний 
трюк для перетворення числа на символ

-----------------------------------------------------

🔬 Завдання 14: Витягни букви 
та відсортуй у зворотному порядку
📋 Умова:
Є рядок з мішаниною символів.
Залиш лише літери, 
сортуй у зворотному порядку,
поверни як список символів.

String input = "a1C!bZ2";
🧪 Очікуване:

['Z', 'C', 'b', 'a']

return input.chars()
.filter(Character::isAlphabetic) 
// залишаємо лише букви
.mapToObj(c -> (char) c)         
// перетворюємо int у Character
.sorted(Comparator.reverseOrder()) 
// сортуємо у зворотному порядку
.collect(Collectors.toList());   
// збираємо в список
-----------------------------------------------------

🎸 Завдання 15: Перевір, 
чи всі символи — цифри
📋 Умова:
Дано рядок. Перевір, 
чи всі символи — це цифри.

String input1 = "123456";
String input2 = "12a3";
🧪 Очікуване:

true  
false


better-->>) return input.chars()
.allMatch(Character::isDigit);

longer-->>) return input
.length() == input
.chars()
.filter(c->Character.isDigit(c)).count();

🔔 Якщо готовий — можу ще 5 завдань дати або влаштувати
легеньку міні-контрольну. Або змішати з flatMap, sorted,
groupingBy. Комбо якраз підвищить левел ⚔️