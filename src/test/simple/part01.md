🧪 Java Enthuware-Style Test #1 (Basic Level)
Тема: Основи Java — змінні, оператори, ключові слова, прості методи
Кількість питань: 5
Рівень: Початковий
Формат: Multiple Choice (одна або кілька правильних відповідей)
Мета: Закріпити синтаксис та базову логіку

📘 Питання 1
Що виведе наступний код?

java
Copy
Edit
int a = 5;
int b = 2;
System.out.println(a / b);
A) 2
B) 2.5
C) 3
D) Помилка компіляції

✅ Правильна відповідь: A
📝 Пояснення: Ділення двох int завжди дає int, тобто дробова частина відкидається.

📘 Питання 2
Який з наступних ідентифікаторів не є допустимим в Java?

A) _myVar
B) $value
C) 2ndValue
D) boolean

✅ Правильна відповідь: C, D
📝 Пояснення: 2ndValue починається з цифри — заборонено. boolean — зарезервоване ключове слово.

📘 Питання 3
Що буде результатом виконання наступного коду?

java
Copy
Edit
int x = 10;
int y = ++x * 2;
System.out.println(y);
A) 20
B) 21
C) 22
D) 10

✅ Правильна відповідь: C
📝 Пояснення: ++x збільшує x до 11 перед множенням, тобто 11 * 2 = 22.

📘 Питання 4
Який з наведених методів є допустимим методом main у Java?

A) public void main(String[] args)
B) public static void main(String args[])
C) void main(String[] args)
D) public static int main(String[] args)

✅ Правильна відповідь: B
📝 Пояснення: Метод main має бути public static void, а параметри можуть бути String[] args або String args[].

📘 Питання 5
Що буде результатом виконання?

java
Copy
Edit
boolean flag = true;
if (flag = false) {
System.out.println("Yes");
} else {
System.out.println("No");
}
A) Yes
B) No
C) Compilation error
D) Runtime error

✅ Правильна відповідь: B
📝 Пояснення: flag = false — це присвоєння, а не перевірка. Отже, if виконується з false.

