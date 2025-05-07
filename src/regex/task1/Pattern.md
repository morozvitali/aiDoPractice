🔹 Клас Pattern (java.util.regex.Pattern)
Це репрезентація компільованого регулярного виразу.

Pattern pattern = Pattern.compile("a*b");  // Створює патерн 
для рядків з нуля або більше 'a', що завершуються на 'b'
Основні методи:
Метод	Пояснення
Pattern.compile(String)	Компілює регулярний вираз
matcher(String input)	Повертає Matcher, який буде шукати 
збіги в заданому тексті

🔹 Клас Matcher (java.util.regex.Matcher)
Це двигун, який працює з текстом, використовуючи Pattern.

Matcher matcher = pattern.matcher("aaab");
Основні методи:
Метод	Пояснення
matches()	Перевіряє, чи весь рядок відповідає патерну
find()	Шукає перше/наступне входження
group()	Повертає останній знайдений збіг
start() / end()	Індекс початку і кінця останнього збігу
replaceAll(String)	Замінює всі збіги на інший рядок
replaceFirst(String)	Замінює перший збіг

🔹 Простий приклад:

import java.util.regex.*;

public class RegexExample {
public static void main(String[] args) {
String input = "Email: test@example.com";

        Pattern pattern = Pattern.compile("\\w+@\\w+\\.\\w+");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            System.out.println("Знайдено: " + matcher.group());
        }
    }
}
🟩 Виведе:

Знайдено: test@example.com
📌 Корисні позначки в регулярках:
Символ	Значення
.	будь-який символ
*	0 або більше повторень
+	1 або більше
     ?	0 або 1
     \\d	цифра
     \\w	буква або цифра (word char)
     \\s	пробіл
     ^	початок рядка
     $	кінець рядка
     [abc]	будь-який з a, b, c
     [^abc]	все крім a, b, c

Хочеш далі – наприклад, зробити кілька завдань на тренування,
або перевірку мейлів / телефонів / чисел?