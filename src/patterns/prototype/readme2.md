🧬 Патерн Prototype
🔹 Ідея:
Замість створення нового об'єкта через new, ми копіюємо вже існуючий об'єкт-прототип.

Це особливо корисно, коли:
створення об’єкта дороге (ресурси, БД, складна логіка),
об’єкт має багато параметрів і складну конфігурацію,
потрібні копії зі схожими властивостями, але окремі.

🔧 Java-реалізація через clone()

🔸 Інтерфейс:
public interface Prototype extends Cloneable {
Prototype clone(); // типова сигнатура
} 

🔸 Клас-прототип:
public class Document implements Prototype {
private String text;
private List<String> tags = new ArrayList<>();

public Document(String text) {
        this.text = text;
    }

public void addTag(String tag) {
        tags.add(tag);
    }

@Override
    public Document clone() {
        try {
            Document copy = (Document) super.clone(); // shallow copy
            copy.tags = new ArrayList<>(tags); // глибоке копіювання списку
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

@Override
    public String toString() {
        return "Text: " + text + ", Tags: " + tags;
    }
}

🔸 Використання:
Document original = new Document("Hello world");
original.addTag("welcome");
original.addTag("text");

Document copy = original.clone();
copy.addTag("copy");

System.out.println(original); // не містить "copy"
System.out.println(copy);     // містить "copy"

❌ Типові помилки і проблеми при використанні Prototype

🔻 1. Поверхневе копіювання (shallow copy)
copy.tags = original.tags; // 🙅‍♂️

🔸 Проблема: зміни в одному об’єкті впливають на інший.
🔧 Рішення: вручну копіювати вкладені об’єкти (deep copy).

🔻 2. Cloneable + clone() = поламаний контракт
В Java інтерфейс Cloneable не має методу, а Object.clone() — protected.

🔸 Проблема: клас повинен сам викликати super.clone(), інакше виняток.
🔧 Рішення: реалізовувати clone() обережно, або краще не використовувати взагалі Cloneable, а писати свій метод копіювання:

public Document copy() {
Document copy = new Document(this.text);
copy.tags = new ArrayList<>(this.tags);
return copy;
}

🔻 3. Mutable поля без копіювання
class UserProfile {
private Settings settings; // mutable class

@Override
    public UserProfile clone() {
        UserProfile copy = (UserProfile) super.clone();
        copy.settings = this.settings; // ❌ один і той самий об’єкт
        return copy;
    }
}
🔧 Рішення: якщо поле змінне — клонувати його теж:

copy.settings = settings.clone(); // або вручну копіювати всі поля

🔻 4. Використання в багатопоточному середовищі
Якщо ти зберігаєш прототипи в одному реєстрі (Map<String, Product>), і кілька потоків одночасно його читають і клонують — можеш отримати гонки станів.

🔧 Рішення: синхронізувати доступ або використовувати ConcurrentHashMap, якщо потрібно.

🔻 5. Заміна new без реального виграшу
Якщо об’єкт простий (примітиви + 2 геттера), використовувати Prototype — це перебільшення.

🔧 Порада: Не створюй Prototype лише заради патерну. Використовуй там, де:

об’єкти складні;

часто потрібна копія;

потрібна висока продуктивність.

📦 Коли використовувати Prototype:
Ситуація	                        Prototype — підходить?
Створення об’єкта дороге	        ✅
Об’єкт має багато конфігурації	    ✅
Об'єкти мають вкладені структури	⚠️ тільки з deep copy
Об’єкти прості, примітивні	        ❌ перебільшення

🔁 Приклад із реального життя:
У тебе є документ-шаблон, наприклад договір. Кожного разу ти копіюєш його, вставляєш нові імена/дати. Це і є Prototype!