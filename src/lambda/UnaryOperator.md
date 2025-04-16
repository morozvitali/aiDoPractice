Ми з тобою наближаємось до джерела магії перетворень —
вітаю тебе на ЕТАПІ 1.5: UnaryOperator<T> — справжній трансфігурації функцій 💫

🔹 Що таке UnaryOperator<T>
Це спеціалізована версія Function<T, R>, у якій вхідний і вихідний тип однакові.

@FunctionalInterface
public interface UnaryOperator<T> extends Function<T, T> {
T apply(T t);
}
🧙 Схоже на чарівне правило:
🔄 “бере щось і повертає це саме, але змінене”

🧠 Коли це корисно?
🔧 Модифікувати значення: s -> s.toUpperCase()
🧹 Очищення / обробка тексту
🔁 Генерація нових чисел з існуючих: n -> n * n
🔄 Заміна циклів типу for (item : list) { item = modify(item); }

✅ Приклади:

UnaryOperator<String> toUpper = String::toUpperCase;
System.out.println(toUpper.apply("vitalii")); // "VITALII"

UnaryOperator<Integer> square = x -> x * x;
System.out.println(square.apply(5)); // 25
📦 Використання в Java API:
✅ 1. List.replaceAll(UnaryOperator<T>)

List<String> names = new ArrayList<>(List.of("vitalii", "marichka"));
names.replaceAll(String::toUpperCase);
System.out.println(names); // [VITALII, MARICHKA]
✅ ЗАДАЧА 1: Замінити всі слова у списку на їх версії без пробілів
📌 Умова:
Напиши метод cleanList, який:

приймає List<String>
застосовує UnaryOperator<String> до кожного елемента (replaceAll)
повертає оновлений список

📥 Приклад:

List<String> dirty = new ArrayList<>(List.of("He llo", "Vi talii", "Code  Man"));

cleanList(dirty, s -> s.replaceAll(" ", ""));

// ["Hello", "Vitalii", "CodeMan"]
✅ ЗАДАЧА 2: Підняти всі числа до квадрату

List<Integer> nums = new ArrayList<>(List.of(2, 3, 4, 5));

nums.replaceAll(x -> x * x);
// [4, 9, 16, 25]
🛠 Трюки:
Можна комбінувати з andThen, як і Function

Зручно використовувати в List.replaceAll(...)

🧩 Хочеш — даю ще 2 задачі на UnaryOperator з числами і текстом (наприклад: 
“додай до кожного рядка префікс/суфікс” або “обнулити непарні числа”).

🛡️ Ти на серйозному функціональному рівні, і ми з кожним кроком ближче до того, 
щоб використовувати всі інтерфейси разом у великих фільтрах, маперах і пайплайнах.
Готовий чаклувати? 🔮








