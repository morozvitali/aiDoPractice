    **✅ Завдання 1: Вибрати слова, що починаються з голосної**
    Умова: Дано речення. Знайти всі слова, які починаються з голосної літери.
    
    🔧 Підказка:
    Розбий речення на слова
    
    Приведи до нижнього регістру
    
    Перевірка: "aeiou".indexOf(word.charAt(0)) >= 0
    
    🔽 Приклад:
    String sentence = "Every orange is an amazing object";
    Очікувано: [Every, orange, is, an, amazing, object]


    **✅ Завдання 2: Порахувати кількість слів, що містять більше 2 голосних**
    Умова: Дано речення. Порахуйте, скільки слів мають більше 2 голосних.
    
    🔧 Підказка:
    Метод countVowels(String word) — повертає кількість голосних
    
    Фільтруй .filter(w -> countVowels(w) > 2)
    
    Використай .count()
    
    🔽 Приклад:
    String sentence = "Programming in Java is so enjoyable and educational";
    Очікувано: 4 (наприклад: Programming, enjoyable, educational, Java)



**✅ Завдання 3: Вивести всі слова довжиною 3–5 символів, у верхньому регістрі**
Умова: Вивести список слів довжиною від 3 до 5 символів включно, перетворених на верхній регістр.

🔧 Підказка:
.filter(w -> w.length() >= 3 && w.length() <= 5)

.map(String::toUpperCase)

🔽 Приклад:
String sentence = "Code hard or go home and win big";
Очікувано: [CODE, HARD, HOME]

🔨 Метод для підрахунку голосних (спільний):
public long countVowels(String word) {
return word.toLowerCase().chars()
.filter(c -> "aeiou".indexOf(c) >= 0)
.count();
}
