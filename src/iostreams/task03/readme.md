🧪 ЗАДАЧА 3: Перетворити всі рядки у ВЕЛИКІ ЛІТЕРИ та записати у новий файл
📄 Умова:
Зчитати усі рядки з input.txt.

Перетворити кожен рядок на великі літери (toUpperCase()).

Записати у новий файл — output.txt.

🧾 Приклад input.txt:
vbnet
Копіювати
Редагувати
hello world
this is java
let's practice io
👉 Очікуваний output.txt:

vbnet
Копіювати
Редагувати
HELLO WORLD
THIS IS JAVA
LET'S PRACTICE IO
🔧 Реалізація:
java
Копіювати
Редагувати
import java.io.*;

public class UpperCaseWriter {
public static void main(String[] args) {
try (
BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))
) {
String line;
while ((line = reader.readLine()) != null) {
writer.write(line.toUpperCase());
writer.newLine();
}
System.out.println("Успішно перетворено і записано у output.txt");
} catch (IOException e) {
e.printStackTrace();
}
}
}
🛠 Важливо:
BufferedWriter має метод newLine() — завжди додавай після кожного рядка.

FileWriter("output.txt") перезапише файл. Якщо хочеш дописувати, додай true:

java
Копіювати
Редагувати
new FileWriter("output.txt", true)
✅ Хочеш ще «хардкор»?
Challenge+ варіант:
🧩 Перетворити рядки на великі, але лише ті, які мають більше ніж 10 символів.

