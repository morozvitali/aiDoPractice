🚀 Серія: Несамовиті завдання по Stream API 💥
✅ Завдання 1: Знайди найдовше слово, яке містить літеру "e"

String[] words = {"java", "stream", "code", "developer", "sun"};
Очікуваний результат: "developer"

Підказка: .filter(w -> w.contains("e")) + .reduce(...)

✅ Завдання 2: Порахуй, скільки у масиві унікальних парних чисел

int[] numbers = {2, 4, 2, 6, 8, 4, 10, 10, 12};
Очікуваний результат: 5

Підказка: .filter(...), .distinct(), .count()

✅ Завдання 3: Збери всі слова у список, які мають парну довжину,
та приведи їх до нижнього регістру

List<String> words = List.of("APPLE", "Banana", "CHERRY", "kiwi", "PLUM");
Очікуваний результат: [banana, cherry, plum]

✅ Завдання 4: Побудуй Map<Character, List<String>>, 
де ключ — перша літера слова, але тільки для слів довжиною > 4

String[] words = {"apple", "ant", "banana", "blue", "berry", "dog", "dolphin"};
Очікуваний результат:

{
a=[apple],
b=[banana, berry],
d=[dolphin]
}

✅ Завдання 5: Створи Map<String, Integer>, де ключ — слово,
значення — кількість голосних у слові, але тільки якщо голосних більше 1

String[] words = {"sky", "apple", "moon", "dry", "banana"};
Очікуваний результат:

{
apple=2,
moon=2,
banana=3
}
