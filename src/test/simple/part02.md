🧪 Java Enthuware-Style Test #2 (Control Flow Basics)
Тема: if-else, switch, цикли
Кількість питань: 5
Рівень: Початковий

📘 Питання 1
Що буде результатом виконання наступного коду?

java
Copy
Edit
int x = 5;
if (x < 10)
System.out.println("Less than 10");
else if (x < 20)
System.out.println("Less than 20");
A) Помилка компіляції
B) Less than 20
C) Less than 10
D) Нічого не виведе

✅ Правильна відповідь: C
📝 Пояснення: Перша умова x < 10 істинна, тому виконується лише перша гілка.

📘 Питання 2
Що буде виведено?

java
Copy
Edit
int day = 3;
switch (day) {
case 1: System.out.println("Mon");
case 2: System.out.println("Tue");
case 3: System.out.println("Wed");
default: System.out.println("Another day");
}
A) Wed
B) Wed Another day
C) Wed Tue Mon
D) Wed Another day (без break, усі йдуть далі)

✅ Правильна відповідь: D
📝 Пояснення: case 3 спрацьовує, потім немає break, тому виконується і default.

📘 Питання 3
Який з наступних варіантів дозволено в циклі for?

A) for(int i = 0; i < 5; i++)
B) for(int i = 0; i < 5; ++i)
C) for(int i = 0; i++ < 5;)
D) Усі вище

✅ Правильна відповідь: D
📝 Пояснення: Усі ці варіанти є допустимими синтаксично, хоча C трохи менш поширений.

📘 Питання 4
Що буде результатом виконання?

java
Copy
Edit
int i = 0;
while (i < 3) {
System.out.print(i);
i++;
}
A) 0 1 2
B) 1 2 3
C) 012
D) Нічого

✅ Правильна відповідь: C
📝 Пояснення: while виконується, доки i < 3, друкує i без пробілу.

📘 Питання 5
Що виведе програма?

java
Copy
Edit
for (int i = 0; i < 5; i++) {
if (i == 3) break;
System.out.print(i);
}
A) 0123
B) 012
C) 123
D) 01234

✅ Правильна відповідь: B
📝 Пояснення: Цикл зупиняється при i == 3, тому виведе 0 1 2.

🔚 Кінець блоку 2