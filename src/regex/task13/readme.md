🔹 Завдання 2: Видалити всі непотрібні символи з рядка
📌 Умова: Напиши метод cleanText(String text),
який видаляє всі символи, крім літер, цифр та пробілів.

Приклади роботи:
cleanText("Hello, World! 123")  // 🔥 "Hello World 123"
cleanText("Java_Regex@#$")      // 🔥 "JavaRegex"
cleanText("Special!@#Chars")    // 🔥 "SpecialChars"

💡 Підказка:
Використай replaceAll().
Видали все, що НЕ [a-zA-Z0-9 ] ([^a-zA-Z0-9 ]).
