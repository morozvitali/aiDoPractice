✅ Завдання 1. Перевірка номера телефону
Умова: Перевір, чи є рядок номером українського мобільного телефону у форматі:
+380 і 9 цифр після цього, наприклад:

+380501234567
👉 Метод:

public boolean isValidUkrPhone(String phone)



✅ Завдання 2. Видалити всі непотрібні символи з тексту
Умова: Є довільний рядок. Залиш тільки букви, цифри та пробіли.

👉 Метод:

public String cleanText(String input)
Приклад:

"Hi! My name is @Java_Dev99." → "Hi My name is JavaDev99"


✅ Завдання 3. Перевірка email-адреси
Умова: Перевір, чи рядок є email-адресою у форматі:

літери + @ + літери + . + 2-6 літер
👉 Метод:

public boolean isValidEmail(String email)

✅ Завдання 4. Перевірка паліндрома
Умова: Перевір, чи рядок читається однаково зліва
направо і справа наліво (без урахування пробілів,
розділових знаків і регістру).

👉 Метод:

public boolean isPalindrome(String input)

✅ Завдання 5. Порахувати кількість цифр у рядку
Умова: Поверни кількість цифр у переданому рядку.

👉 Метод:

public int countDigits(String input)
Приклад:
"Java123 is cool45" → 5