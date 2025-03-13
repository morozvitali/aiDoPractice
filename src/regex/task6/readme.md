🔹 Завдання: Перетворити рядок у "Leet Speak"
Створи метод toLeetSpeak(String str), який перетворює
звичайний англійський текст у "Leet Speak", замінюючи
певні літери на спеціальні символи.

📌 Правила заміни (Leet Code таблиця):
Буква	Заміна
A → 4
B → 8
C → (
E → 3
G → 6
H → #
I → 1
L → 1
O → 0
S → $
T → 7
Z → 2

📌 Приклади роботи:
toLeetSpeak("Hello World")  // 🔥 `#3110 W0r1d`
toLeetSpeak("Java is cool") // 🔥 `J4v4 15 (001`
toLeetSpeak("This is a test") // 🔥 `7#15 15 4 73$7`
toLeetSpeak("Leet Speak") // 🔥 `1337 $p34k`

📌 Вимоги до методу:
✔ Має працювати з великими і малими літерами
✔ Інші символи залишаються без змін (пробіли, знаки пунктуації тощо)
✔ Використай replaceAll() або replace()

💡 Підказка:
Використай replaceAll() або replace() кілька разів.
Можеш зробити Map<Character, String> і замінювати символи через StringBuilder.
🔥 Це цікаве завдання, яке допоможе закріпити роботу з replaceAll() і Map!