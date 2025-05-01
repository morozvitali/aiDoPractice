🧪 ЗАДАЧА 4: Фільтрація рядків, що починаються з певної літери
📄 Умова:
Прочитати файл input.txt.

Знайти всі рядки, які починаються з вказаної літери (наприклад, S або s).

Записати їх у новий файл startsWithS.txt.

🧾 Приклад input.txt:
pgsql
Копіювати
Редагувати
Start here
Somewhere over the rainbow
Nothing special
stop now
Rain is good
Sleep more
👉 Якщо шукаємо S:

sql
Копіювати
Редагувати
Start here
Somewhere over the rainbow
stop now
Sleep more
🔧 Код:
java
Копіювати
Редагувати
import java.io.*;

public class FilterLinesByLetter {
public static void main(String[] args) {
char filterChar = 's'; // або 'S', залежить від задачі

        try (
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("startsWithS.txt"))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty() && Character.toLowerCase(line.charAt(0)) == Character.toLowerCase(filterChar)) {
                    writer.write(line);
                    writer.newLine();
                }
            }
            System.out.println("Відібрані рядки записано у startsWithS.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
🧠 Рекомендації:
Перевіряй, що рядок не порожній, інакше отримаєш StringIndexOutOfBoundsException.

Для нечутливості до регістру використовуй Character.toLowerCase(...).

🔥 Модифікації (для експериментів):
Фільтрувати рядки, які містять слово (наприклад "java").

Записати кількість таких рядків у кінець файлу.

Додати логіку зчитування символу з консолі: Scanner scanner = new Scanner(System.in);

