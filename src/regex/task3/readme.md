🔹 Завдання 3: Перевірити, чи рядок є валідною електронною поштою
Напиши метод isValidEmail(String email), який перевіряє,
чи рядок є валідною електронною адресою.

📌 Умови:
Має бути формат username@domain.com.
username може містити: літери (a-z, A-Z), цифри (0-9), підкреслення (_),
крапки (.) і дефіси (-), але не може починатися або закінчуватися крапкою чи дефісом.
domain має складатися з літер і цифр (a-z, A-Z, 0-9), може мати крапки (.),
але не може починатися або закінчуватися крапкою.
TLD (зона, наприклад, .com, .net, .org) має складатися тільки з літер (a-z, A-Z)
і бути довжиною від 2 до 6 символів.


Приклади роботи:
isValidEmail("user@example.com")       -> true
isValidEmail("john.doe-123@gmail.com") -> true
isValidEmail("jane@sub.domain.org")    -> true
isValidEmail("invalid@com")            -> false  // Немає крапки в домені
isValidEmail("user.@example.com")      -> false  // username не може закінчуватися "."
isValidEmail("@example.com")           -> false  // Немає username
isValidEmail("user@.com")              -> false  // domain не може починатися з "."
isValidEmail("user@domain.c")          -> false  // TLD занадто коротке

💡 Підказка:
Використай регулярний вираз із методом matches().