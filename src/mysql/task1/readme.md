📘 Теорія: Що таке таблиця і SQL?
Уяви таблицю Excel — рядки та стовпці.
У базі даних це називається:

Таблиця — зберігає дані (наприклад, "users", "orders").
Стовпці (columns) — назви типів даних (наприклад, name, age, email).
Рядки (rows) — самі дані: одна людина, одне замовлення тощо.

🔧 Що таке SQL?
SQL (Structured Query Language) — мова, якою ми звертаємось до бази, щоб:

🧠 Читати (SELECT)
➕ Додавати (INSERT)
✏️ Оновлювати (UPDATE)
❌ Видаляти (DELETE)

--------------------------------------------

🧪 Задача 1: Прочитати всі рядки з таблиці
Умова:
Є таблиця students з такими стовпцями:

id (int)
name (varchar)
age (int)

📋 Таблиця виглядає так:

id	name	age
1	Olya	19
2	Maksym	21
3	Taras	20

👉 Сформуй SQL-запит, щоб отримати ВСІ дані.

📥 Підказка:
Це буде простий SELECT *.

✅ Відповідь:

SELECT * FROM students;

--------------------------------------------

🧪 Задача 2: Прочитати лише імена
Умова:
З таблиці students потрібно прочитати лише стовпець name.

📥 Підказка:
Замінюємо зірочку * на конкретну назву стовпця.

✅ Відповідь:

SELECT name FROM students;

--------------------------------------------

🧪 Задача 3: Знайти всіх, кому більше ніж 20 років
Умова:
З таблиці students обери лише тих, у кого age > 20.

📥 Підказка:
Після WHERE вказуємо умову.

✅ Відповідь:

SELECT * FROM students
WHERE age > 20;

--------------------------------------------

🧪 Задача 4: Додати нового студента
Умова:
Додай до таблиці students нового учня:

name = "Ira"
age = 18

📥 Підказка:
Використай команду INSERT INTO.

✅ Відповідь:

INSERT INTO students (name, age)
VALUES ('Ira', 18);

--------------------------------------------

🧪 Задача 5: Порахувати кількість студентів
Умова:
Скільки всього студентів у таблиці?

📥 Підказка:
COUNT(*) повертає кількість рядків.

✅ Відповідь:

SELECT COUNT(*) FROM students;
🧪 Задача 6: Середній вік студентів
Умова:
Знайди середній вік (average) усіх студентів.

📥 Підказка:
Використай AVG(age).

✅ Відповідь:

SELECT AVG(age) FROM students;

--------------------------------------------

🧪 Задача 7: Відсортувати студентів за віком
Умова:
Показати студентів у порядку зростання віку.

📥 Підказка:
ORDER BY — команда для сортування.

✅ Відповідь:

SELECT * FROM students
ORDER BY age ASC;

--------------------------------------------

📚 Хочеш більше таких завдань?
Можу створити 50 практичних завдань по SQL зі зростаючою складністю:
JOIN, GROUP BY, HAVING, LIMIT, LIKE, IS NULL, підзапити, foreign keys, індекси тощо.

Тільки скажи: "Полетіли далі" ✈️ — і я зберу тобі школу SQL від А до Я!
https://chatgpt.com/c/68512c67-3f04-8009-8716-a95323a80e83