🔹 Завдання 1: Перевірити, чи рядок містить тільки літери та пробіли
📌 Умова: Напиши метод isOnlyLettersAndSpaces(String str),
який перевіряє, чи містить рядок тільки літери (a-z, A-Z) та пробіли,
але не цифри чи інші символи.

Приклади роботи:
isOnlyLettersAndSpaces("Hello World")   // ✅ true
isOnlyLettersAndSpaces("Java Regex")    // ✅ true
isOnlyLettersAndSpaces("Regex 101")     // ❌ false (є цифра)
isOnlyLettersAndSpaces("Hello! World")  // ❌ false (є `!`)
isOnlyLettersAndSpaces(" Spaces  ")     // ✅ true
💡 Підказка:
Використай matches().
Використай ^[a-zA-Z ]+$.