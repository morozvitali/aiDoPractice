🧠 Серія: Групування та робота з Map — Частина 1
✅ Завдання 1: Групування слів за кількістю літер

String[] words = {"apple", "dog", "banana", "cat", "kiwi", "plum", "watermelon"};

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



✅ Завдання 2: Групування за першою літерою, але всі слова в нижньому регістрі
List<String> words = List.of("Apple", "apricot", "Banana", "blue", "Cherry", "cranberry");

Очікуваний результат:
{
a=[apple, apricot],
b=[banana, blue],
c=[cherry, cranberry]
}

Тип: Map<Character, List<String>>
Підказка: .map(String::toLowerCase) перед groupingBy



✅ Завдання 3: Порахуй, скільки слів починається на кожну літеру
String[] words = {"apple", "banana", "apricot", "blue", "berry", "cherry"};

Очікуваний результат:
{
a=2,
b=3,
c=1
}
Тип: Map<Character, Long>
Підказка: groupingBy(..., counting())



✅ Завдання 4: Побудуй Map<String, Boolean> — слово ➜ чи містить воно голосні
String[] words = {"sky", "apple", "dry", "orange", "sun"};

Очікуваний результат:
{
sky=false,
apple=true,
dry=false,
orange=true,
sun=true
}

Тип: Map<String, Boolean>
Підказка: використовуй .toMap(...) і chars().anyMatch(...)