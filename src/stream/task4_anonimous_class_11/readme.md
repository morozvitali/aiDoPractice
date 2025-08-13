
✅ Задача 01: Виведи перші кілька чисел, поки їхня сума менша за 50
-

📦 Очікуваний результат:

1  
2  
3  
4  
5  
6  
7  
8  
9  
(бо після цього 1+2+…+9 = 45, а 45+10=55 → вже не підходить)

🧠 Підказка (тільки Java 9+):

IntStream.iterate(1, i -> i + 1)
.takeWhile(new IntPredicate() {
int sum = 0;
public boolean test(int i) {
sum += i;
return sum < 50;
}
})

✅ Завдання 02: Виведи лише ті числа, які кратні 3
-
📋 Виведи числа від 1 до 20, але лише ті, що кратні 3, 
використовуючи IntPredicate через анонімний клас.

📦 Очікуваний результат:

3  
6  
9  
12  
15  
18

🧠 Підказка:

IntPredicate predicate = new IntPredicate() {
public boolean test(int value) {
return value % 3 == 0;
}
};
IntStream.rangeClosed(1, 20)
.filter(predicate)
.forEach(System.out::println);


✅ Завдання 03: Відсортуй рядки за довжиною
-
📋 Є список слів, відсортуй їх за довжиною 
за допомогою анонімного Comparator.

📥 Вхід:
["pear", "banana", "kiwi", "plum"]

📤 Вихід:
["kiwi", "pear", "plum", "banana"]

🧠 Підказка:

List<String> list = new ArrayList<>(List.of("pear", 
"banana", "kiwi", "plum"));
list.sort(new Comparator<String>() {
public int compare(String a, String b) {
return Integer.compare(a.length(), b.length());
}
});
System.out.println(list);



✅ Завдання 04: Створи таймер через Runnable
-
📋 Виведи "Тік..." 5 разів з паузою 1 секунда між виводами. Використай Runnable як анонімний клас.

📦 Очікуваний результат:

Тік...
Тік...
Тік...
Тік...
Тік...
🧠 Підказка:

Runnable task = new Runnable() {
public void run() {
for (int i = 0; i < 5; i++) {
System.out.println("Тік...");
try { Thread.sleep(1000); } catch (InterruptedException e) {}
}
}
};
new Thread(task).start();

✅ Завдання 05: Використай анонімний клас для ActionListener
-

📋 При натисканні кнопки має виводитись повідомлення "Натиснуто!".

🧠 Підказка:

JButton button = new JButton("Натисни мене");
button.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
System.out.println("Натиснуто!");
}
});

🪟 (Це для тих, хто вже трохи пробував Swing, 
але навіть якщо ні — залишимо на потім як приклад GUI.)

✅ Завдання 06: Створи власний фільтр чисел
-

📋 Напиши свій IntPredicate (анонімно), 
який пропускає тільки парні або ті, що > 10.

📥 Вхід:
IntStream.rangeClosed(1, 15)

📤 Вихід:
2 4 6 8 10 11 12 13 14 15

🧠 Підказка:

IntPredicate filter = new IntPredicate() {
public boolean test(int i) {
return i % 2 == 0 || i > 10;
}
};
IntStream.rangeClosed(1, 15)
.filter(filter)
.forEach(System.out::print);




Ось наступний блок завдань для практики 
анонімних класів, з акцентом на Comparator,
Runnable, Callable, і трохи ускладнення 
для практичного мислення. Все — з підказками.

✅ Завдання 07: Відсортуй числа в зворотному порядку
-
(анонімний Comparator)

📋 Є список цілих чисел. Відсортуй його у спадному 
порядку, використовуючи анонімний клас Comparator.

📥 Вхід:
[4, 2, 7, 1, 9]
📤 Вихід:
[9, 7, 4, 2, 1]

🧠 Підказка:

List<Integer> list = new ArrayList<>(List.of(4, 2, 7, 1, 9));
list.sort(new Comparator<Integer>() {
public int compare(Integer a, Integer b) {
return b - a;
}
});
System.out.println(list);

✅ Завдання 08: Створи кілька потоків через Runnable
-
📋 Створи 3 потоки, які виводять "Потік N: працює...", 
де N — номер потоку. Використай Runnable через анонімні класи.

📦 Очікуваний результат (порядок може бути різним):

Потік 1: працює...
Потік 2: працює...
Потік 3: працює...

🧠 Підказка:

for (int i = 1; i <= 3; i++) {
final int id = i;
Runnable task = new Runnable() {
public void run() {
System.out.println("Потік " + id + ": працює...");
}
};
new Thread(task).start();
}

✅ Завдання 09: Використай Callable з анонімним класом
-

📋 Створи Callable<String>, який повертає 
рядок: "Завдання виконано!"
Запусти його через ExecutorService і виведи результат.

📤 Вихід:

Завдання виконано!
🧠 Підказка:

ExecutorService executor = Executors.newSingleThreadExecutor();
Callable<String> task = new Callable<String>() {
public String call() {
return "Завдання виконано!";
}
};
Future<String> result = executor.submit(task);
System.out.println(result.get());
executor.shutdown();

✅ Завдання 10: Створи власний сортувальник рядків
-

📋 Відсортуй список слів за останньою буквою, 
використовуючи Comparator через анонімний клас.

📥 Вхід: ["cat", "dog", "apple", "banana"]
📤 Вихід: ["banana", "apple", "dog", "cat"]
(бо: "a", "e", "g", "t")

🧠 Підказка:

List<String> list = new ArrayList<>(List.of("cat", 
"dog", "apple", "banana"));
list.sort(new Comparator<String>() {
public int compare(String a, String b) {
return Character.compare(
a.charAt(a.length() - 1),
b.charAt(b.length() - 1)
);
}
});
System.out.println(list);

✅ Завдання 11: Анонімний фільтр через інтерфейс
-
📋 Створи свій інтерфейс WordFilter, який має метод boolean
accept(String word). Потім створи анонімний клас, 
що відфільтровує лише слова довжиною > 4.

📥 Вхід: ["java", "python", "go", "kotlin", "js"]
📤 Вихід: ["python", "kotlin"]

🧠 Підказка:

interface WordFilter {
boolean accept(String word);
}

WordFilter filter = new WordFilter() {
public boolean accept(String word) {
return word.length() > 4;
}
};

List<String> words = List.of("java", 
"python", "go", "kotlin", "js");
List<String> result = words.stream()
.filter(w -> filter.accept(w))
.collect(Collectors.toList());
System.out.println(result);



🧠 Ідеї для продовження:

Comparator з кількома умовами сортування 
(довжина, алфавіт, остання буква…)
Анонімний Callable, який читає файл 
і повертає кількість рядків
Runnable у таймері або анімації 
(типу лічильника, що змінюється)
Реалізація власного інтерфейсу з параметрами
🔔 Скажи, якщо хочеш — я можу 
переробити ці завдання так, 
щоб потім їх було зручно трансформувати 
в лямбда-вирази для порівняння.
Або зробити тестовий блок 
(вибери правильне або помилка).