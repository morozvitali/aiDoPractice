🔍 Що таке equals() в Java?
Метод equals() — це метод класу Object, який використовується для порівняння об'єктів за значенням, а не за посиланням.

public boolean equals(Object obj)
За замовчуванням (Object.equals()):
Порівнює посилання:

Object obj1 = new Object();
Object obj2 = new Object();

System.out.println(obj1.equals(obj2)); // false
System.out.println(obj1 == obj2);      // false



✅ Правила перевизначення equals():
Згідно з контрактом equals(), метод повинен бути:

Рефлексивним — x.equals(x) → true
Симетричним — x.equals(y) ⇔ y.equals(x)
Транзитивним — якщо x.equals(y) і y.equals(z), тоді x.equals(z)
Консистентним — багаторазові виклики дають той самий результат, якщо об’єкти не змінюються
Сумісним з null — x.equals(null) → false (не має кидати виняток)

🛠️ Коли перевизначають equals()?
Коли ти створюєш власні класи, наприклад, User, і хочеш порівнювати об'єкти за їхніми полями, а не за посиланням:

User u1 = new User("Vitalii", 25);
User u2 = new User("Vitalii", 25);

u1.equals(u2); // true, якщо перевизначено правильно


🧑‍💻 Як реалізувати equals()?
✅ Приклад класу:
import java.util.Objects;

public class User {
private String name;
private int age;

public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

@Override
    public boolean equals(Object o) {
        if (this == o) return true; // перевірка посилання
        if (o == null || getClass() != o.getClass()) return false; // перевірка типу

User user = (User) o; // кастинг

// порівняння полів
        return age == user.age && Objects.equals(name, user.name);
    }

@Override
    public int hashCode() {
        return Objects.hash(name, age); // якщо перевизначаєш equals — обов'язково перевизнач hashCode()
    //завдання = зроби власну реалызацыю методу hashCode()    
}
}

⚠️ Що буде, якщо не перевизначити hashCode()?
Це призведе до неправильної роботи з HashMap, HashSet, HashTable, 
бо вони покладаються на hashCode() для збереження об'єктів.

🧪 Перевірка:

User u1 = new User("Vitalii", 25);
User u2 = new User("Vitalii", 25);

System.out.println(u1.equals(u2)); // true
System.out.println(u1 == u2);      // false
✍️ Порада:
Для кращого контролю і простоти, можеш скористатись генерацією в IDE:

IntelliJ IDEA → правий клік → Generate → equals() and hashCode()



----------------------------HASHCODE-----------------------------
Зараз покажу, як зробити кастомну реалізацію hashCode(), використовуючи множення на прості числа (наприклад 7, 11, 5, 3) — це дуже класична техніка для створення хороших хешів. Поїхали!

🔧 Загальна ідея:
Хешкод створюється з полів об'єкта так, щоб:

рівні об'єкти мали однаковий хешкод

різні об'єкти — по можливості різний

Множення на прості числа (наприклад 7, 11, 31) — це хитрість для розсіювання значень і зменшення колізій.

🧱 Структура кастомного hashCode()

@Override
public int hashCode() {
int result = 7; // початкове просте число
result = 11 * result + Integer.hashCode(id);
result = 5 * result + name.hashCode();
result = 3 * result + (email != null ? email.hashCode() : 0);
return result;
}
🧪 Повний приклад:
public class User {
private int id;
private String name;
private String email;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
               name.equals(user.name) &&
               (email != null ? email.equals(user.email) : user.email == null);
    }

    @Override
    public int hashCode() {
        int result = 7;
        result = 11 * result + Integer.hashCode(id); // просте число
        result = 5 * result + name.hashCode();        // інше просте число
        result = 3 * result + (email != null ? email.hashCode() : 0); // ще одне
        return result;
    }
}
🧠 Пояснення:
7 — стартове значення

11, 5, 3 — прості множники для змішування значень полів

Integer.hashCode(id) — обчислює хеш для числа
(або просто id, бо це int)

name.hashCode() — стандартний hashCode() для String

email.hashCode() — з перевіркою null, бо null.hashCode() →
викине NullPointerException

❗ Навіщо множити на прості числа?
Щоб кожне поле "вносило свій вклад" у хеш, і щоб мінімізувати
хеш-колізії (різні об'єкти з однаковим хешем).

Це простий і ефективний спосіб зробити "якісний" хешкод.

⚠️ І ще:
Завжди дотримуйся контракту:

Якщо a.equals(b) → обов’язково a.hashCode() == b.hashCode()

Можемо зробити версію з Objects.hash(...) або record
— якщо хочеш ще коротший варіант.
Ну шо, подивимось як це працює в HashSet чи HashMap,
чи підкинути тестів? 😏
