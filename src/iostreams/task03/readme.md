🧪 ЗАДАЧА 3: Перетворити всі рядки у ВЕЛИКІ ЛІТЕРИ та записати у новий файл
📄 Умова:
Зчитати усі рядки з input.txt.
Перетворити кожен рядок на великі літери (toUpperCase()).
Записати у новий файл — output.txt.
🧾 Приклад input.txt:
hello world
this is java
let's practice io
👉 Очікуваний output.txt:
HELLO WORLD
THIS IS JAVA
LET'S PRACTICE IO
🔧 Реалізація:

import java.io.*;
public class UpperCaseWriter {
public static void main(String[] args) {
try (
BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
String line;
while ((line = reader.readLine()) != null) {
writer.write(line.toUpperCase());
writer.newLine();
}
System.out.println("Успішно перетворено і записано у output.txt");
} catch (IOException e) {
e.printStackTrace();
}}}
🛠 Важливо:
BufferedWriter має метод newLine() — завжди додавай після кожного рядка.
FileWriter("output.txt") перезапише файл. Якщо хочеш дописувати, додай true:
new FileWriter("output.txt", true)
✅ Хочеш ще «хардкор»?
Challenge+ варіант:
🧩 Перетворити рядки на великі, але лише ті, які мають більше ніж 10 символів.

-----------------------------------EXCEPTION--------------------------------------

1. Чому ми «пропустили» FileNotFoundException?
   ➤ Відповідь:
   Ми не пропустили її, а обробили в catch-блоці через загальний IOException:

catch (IOException e) {
e.printStackTrace();
}
Але…

FileNotFoundException — це підклас IOException
Тобто ловиться ось цим catch'ом, але не явно.

🔹 Якщо хочеш більш гнучкий контроль, можна спочатку ловити FileNotFoundException, а потім IOException, наприклад:

try {
...
} catch (FileNotFoundException e) {
System.out.println("Файл не знайдено: " + e.getMessage());
} catch (IOException e) {
System.out.println("Інша помилка введення/виведення: " + e.getMessage());
}
✌️ 2. Різниця між e.printStackTrace() та throw new RuntimeException(e)?
Метод	Що робить	Коли використовувати
e.printStackTrace()	Друкує трасування стека помилки (де сталася, який клас, метод, рядок) — але не припиняє виконання.	Коли хочеш побачити помилку, але не зупиняти програму.
throw new RuntimeException(e)	Генерує нову виняткову ситуацію на базі e — програма зазвичай припиняє роботу.	Коли помилка критична, і ти не хочеш продовжувати роботу програми.

🔍 Приклад:
catch (IOException e) {
e.printStackTrace(); // Просто лог
// або
throw new RuntimeException("Помилка при читанні файлу", e); // зупиняє
}
🧠 Порада:
На ранніх етапах (e.printStackTrace()) — зручно для налагодження.
Коли створюєш реальний застосунок — краще логувати помилку і кидати власний виняток 
або обробляти її правильно.

Якщо хочеш, можу показати приклад з кастомним Exception класом або ж можемо йти далі по задачах!
Чудово, Віталію! 🔥 Покажу тобі приклад використання кастомного (власного) 
Exception класу в контексті потоків (читання файлів). Це корисно, коли ти 
хочеш чітко позначити помилкову ситуацію, яка має особливий сенс у твоєму проєкті.

💡 Навіщо кастомні Exception-и?
Роблять код чіткішим і самодокументованим.

Дають змогу відрізнити одну помилку від іншої, навіть якщо вони всі IOException.

📦 1. Створи свій виняток

package iostreams.exceptions;

public class FileProcessingException extends Exception {
public FileProcessingException(String message) {
super(message);
}

    public FileProcessingException(String message, Throwable cause) {
        super(message, cause);
    }
}
Це виняток, що успадковується від Exception, тому його потрібно оголошувати (throws або try-catch).

🛠 2. Використай його в коді:

import java.io.*;
import iostreams.exceptions.FileProcessingException;

public class StringToUpperCase {

    public void myToUpperCase(String path1, String path2) throws FileProcessingException {
        try (BufferedReader br = new BufferedReader(new FileReader(path1));
             BufferedWriter bw = new BufferedWriter(new FileWriter(path2))) {
            
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line.toUpperCase());
                bw.newLine();
            }

        } catch (FileNotFoundException e) {
            throw new FileProcessingException("Файл не знайдено: " + path1, e);
        } catch (IOException e) {
            throw new FileProcessingException("Помилка обробки файлу", e);
        }
    }

    public static void main(String[] args) {
        StringToUpperCase su = new StringToUpperCase();
        try {
            su.myToUpperCase("iotask03.txt", "iotask03-03.txt");
            System.out.println("Успішно виконано!");
        } catch (FileProcessingException e) {
            System.err.println("⚠ Помилка: " + e.getMessage());
        }
    }
}
✅ Що це дає:
Без кастомного	З кастомним
IOException — занадто загально	FileProcessingException — точна причина
Можна сплутати з іншими помилками	Чітка обробка у логіці
Менш гнучко в архітектурі	Більше контролю, краще логування

Якщо хочеш, можемо спробувати зробити власний Exception для фільтрації рядків, 
або іншу прикладну ситуацію. Хочеш такий варіант?

✅ Так, фільтрацію краще винести в окремий клас або метод
Бо:

Причина	Пояснення
Принцип SRP (Single Responsibility Principle)	Метод myToUpperCase зараз робить читання, фільтрацію, перетворення, запис і логування. Це забагато.
Гнучкість	Ти зможеш легко змінити правила фільтрації (довжина, наявність ключових слів, RegEx, тощо), просто передаючи іншу реалізацію.
Можливість тестування	Окрема фільтрація — легше покрити юніт-тестами.
Розширення	Можна створити декілька фільтрів: LengthFilter, KeywordFilter, RegexFilter, і навіть передавати як стратегію.

🔧 Як це зробити
1. Створимо інтерфейс LineFilter:

   @FunctionalInterface
   public interface LineFilter {
   boolean allow(String line);
   }
2. Створимо клас-фільтр, наприклад:

   public class LengthFilter implements LineFilter {
   private int minLength;

   public LengthFilter(int minLength) {
   this.minLength = minLength;
   }

   @Override
   public boolean allow(String line) {
   return line.length() >= minLength;
   }
   }
3. І перепишемо StringToUpperCase так:

   public class StringToUpperCase {

   public void myToUpperCase(String path1, String path2, LineFilter filter) throws FileProcessingException {
   try (BufferedReader br = new BufferedReader(new FileReader(path1));
   BufferedWriter bw = new BufferedWriter(new FileWriter(path2, true))) {

            String line;
            while ((line = br.readLine()) != null) {
                if (!filter.allow(line)) {
                    System.out.println("Пропущено (не пройшло фільтр): " + line);
                    continue;
                }

                System.out.println("Line to upper case is: " + line);
                bw.write(line.toUpperCase());
                bw.newLine();
                System.out.println("перетворено і записано у файл");
            }
        } catch (FileNotFoundException e) {
            throw new FileProcessingException("Файл не знайдено", e);
        } catch (IOException e) {
            throw new FileProcessingException("Помилка обробки файлу", e);
        }
   }
   }
4. І в main():

   public static void main(String[] args) {
   StringToUpperCase su = new StringToUpperCase();
   LineFilter filter = new LengthFilter(10);

   try {
   su.myToUpperCase("iotask03.txt", "iotask03-03.txt", filter);
   System.out.println("Успішно виконано");
   } catch (FileProcessingException e) {
   System.out.println("⚠ Помилка: " + e.getMessage());
   }
   }
   💡 Або ще коротше: передати фільтр як лямбда!

   su.myToUpperCase("iotask03.txt", "iotask03-03.txt", line -> line.length() >= 10);
   🧠 Висновок:
   Ти застосував принцип SRP.

Використовуєш інтерфейс для стратегії — дуже гарна практика.

Отримав гнучку, тестовану, модульну архітектуру.

Готовий винести фільтрацію у пакет filter, або створити додаткові фільтри (наприклад, за ключовим словом)?


Ви сказали:
не логічніше просто зробити Predicate і в метод передати цю умову


Програма ChatGPT сказала:
Віталію, так! 🔥
Це якраз і є найчистіше, сучасне, гнучке, Java-way рішення — 
використовувати Predicate<String> з пакету java.util.function. 
І ти просто зараз влучив у саму суть функціонального програмування в Java.

✅ Чому Predicate<String> — краще, ніж свій інтерфейс?
Predicate<String>	Свій інтерфейс (LineFilter)
✅ Вбудований в Java 8+	❌ Треба писати вручну
✅ Має готові методи: and(), or(), negate()	❌ Треба реалізовувати
✅ Працює з лямбдами напряму	❌ Не всі інструменти з ним інтегруються
✅ Сумісний зі Stream API	❌ Не сумісний напряму

🔧 Переписуємо твій метод з Predicate<String>:
✨ Метод:

public void myToUpperCase(String path1, String path2, Predicate<String> condition) throws FileProcessingException {
try (BufferedReader br = new BufferedReader(new FileReader(path1));
BufferedWriter bw = new BufferedWriter(new FileWriter(path2, true))) {

        String line;
        while ((line = br.readLine()) != null) {
            if (!condition.test(line)) {
                System.out.println("Пропущено: " + line);
                continue;
            }

            System.out.println("Обробляється: " + line);
            bw.write(line.toUpperCase());
            bw.newLine();
        }

        System.out.println("✔ Успішно записано у файл");

    } catch (FileNotFoundException e) {
        throw new FileProcessingException("Файл не знайдено", e);
    } catch (IOException e) {
        throw new FileProcessingException("Помилка обробки файлу", e);
    }
}
✨ main() із лямбдаю:

StringToUpperCase su = new StringToUpperCase();

// Умова: довжина >= 10 && починається з великої літери
Predicate<String> filter = line -> line.length() >= 10 && Character.isUpperCase(line.charAt(0));

try {
su.myToUpperCase("iotask03.txt", "iotask03-03.txt", filter);
} catch (FileProcessingException e) {
System.out.println("⚠ " + e.getMessage());
}
🧠 Бонус — комбінування:

Predicate<String> hasJava = line -> line.contains("Java");
Predicate<String> longLine = line -> line.length() > 15;
Predicate<String> complex = hasJava.and(longLine);
🔥 Підсумок:
🔹 Ти на 100% правий — Predicate<String>:

Гнучкий
Вбудований
Потужний
Комбінується

Ідеальне рішення для реального продакшн-коду!