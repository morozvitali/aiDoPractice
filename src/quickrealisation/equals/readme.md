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
java
Копіювати
Редагувати
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
    }
}
⚠️ Що буде, якщо не перевизначити hashCode()?
Це призведе до неправильної роботи з HashMap, HashSet, HashTable, бо вони покладаються на hashCode() для збереження об'єктів.

🧪 Перевірка:
java
Копіювати
Редагувати
User u1 = new User("Vitalii", 25);
User u2 = new User("Vitalii", 25);

System.out.println(u1.equals(u2)); // true
System.out.println(u1 == u2);      // false
✍️ Порада:
Для кращого контролю і простоти, можеш скористатись генерацією в IDE:

IntelliJ IDEA → правий клік → Generate → equals() and hashCode()