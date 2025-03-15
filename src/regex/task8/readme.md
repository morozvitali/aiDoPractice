🔹 Завдання: Перевірити, чи рядок є "правильним реченням"
Напиши метод isValidSentence(String sentence), який перевіряє, чи речення відповідає наступним правилам:

📌 Правила перевірки:
✔ Починається з великої літери (A-Z)
✔ Закінчується крапкою (.), знаком питання (?) або знаком оклику (!)
✔ Не містить подвійних пробілів ( )
✔ Не містить цифр (речення — це тільки текст)
✔ Не містить зайвих пробілів на початку чи в кінці

📌 Приклади роботи
java
Копіювати
Редагувати
isValidSentence("Hello world.")   // ✅ true
isValidSentence("Hi! How are you?")   // ✅ true
isValidSentence("this is wrong.")  // ❌ false (не починається з великої літери)
isValidSentence("Hello world")     // ❌ false (немає знаку пунктуації в кінці)
isValidSentence("Hello  world.")   // ❌ false (подвійний пробіл)
isValidSentence("Hello world123.") // ❌ false (є цифри)
isValidSentence(" Hello world.")   // ❌ false (пробіл на початку)
isValidSentence("Hello world. ")   // ❌ false (пробіл в кінці)
💡 Підказка:
Використай регулярні вирази (matches()) для перевірки.
Використай trim(), щоб видалити зайві пробіли з початку і кінця.
Використай replaceAll("\\s+", " "), щоб прибрати подвійні пробіли.
