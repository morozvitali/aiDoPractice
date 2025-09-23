🔹 Завдання 1. Сортування студентів за віком
import java.util.*;

class Student implements Comparable<Student> {
private String name;
private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    TODO: compareTo()

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}

public class Task1 {
public static void main(String[] args) {
List<Student> students = Arrays.asList(
new Student("Anna", 22),
new Student("Oleh", 19),
new Student("Ira", 22)
);

        Collections.sort(students);
        System.out.println(students);
    }
}

🔹 Завдання 2. Сортування книг за назвою
import java.util.*;

class Book implements Comparable<Book> {
private String title;
private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    TODO: compareTo()

    @Override
    public String toString() {
        return "\"" + title + "\" by " + author;
    }
}

public class Task2 {
public static void main(String[] args) {
List<Book> books = Arrays.asList(
new Book("Java Basics", "Smith"),
new Book("Algorithms", "Knuth"),
new Book("Clean Code", "Martin")
);

        Collections.sort(books);
        System.out.println(books);
    }
}

🔹 Завдання 3. Багаторівневе сортування (age → name)
import java.util.*;

class Student2 implements Comparable<Student2> {
private String name;
private int age;

    public Student2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    TODO: compareTo()

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}

public class Task3 {
public static void main(String[] args) {
List<Student2> students = Arrays.asList(
new Student2("Anna", 20),
new Student2("Oleh", 20),
new Student2("Ira", 19)
);

        Collections.sort(students);
        System.out.println(students);
    }
}

🔹 Завдання 4. Банківські рахунки
import java.util.*;

class BankAccount implements Comparable<BankAccount> {
private String accountNumber;
private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    TODO: compareTo()

    @Override
    public String toString() {
        return accountNumber + " : $" + balance;
    }
}

public class Task4 {
public static void main(String[] args) {
List<BankAccount> accounts = Arrays.asList(
new BankAccount("ACC003", 500.0),
new BankAccount("ACC001", 1000.0),
new BankAccount("ACC002", 1000.0)
);

        Collections.sort(accounts);
        System.out.println(accounts);
    }
}

🔹 Завдання 5. Дата народження
import java.util.*;
import java.time.*;

class Person implements Comparable<Person> {
private String name;
private LocalDate birthday;

    public Person(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    TODO: compareTo()

    @Override
    public String toString() {
        return name + " (" + birthday + ")";
    }
}

public class Task5 {
public static void main(String[] args) {
List<Person> people = Arrays.asList(
new Person("Anna", LocalDate.of(1995, 5, 10)),
new Person("Oleh", LocalDate.of(1988, 3, 20)),
new Person("Ira", LocalDate.of(2000, 1, 1))
);

        Collections.sort(people);
        System.out.println(people);
    }
}

🔹 Завдання 6. Топ гравців
import java.util.*;

class Player implements Comparable<Player> {
private String nickname;
private int score;

    public Player(String nickname, int score) {
        this.nickname = nickname;
        this.score = score;
    }

    TODO: compareTo()

    @Override
    public String toString() {
        return nickname + " (" + score + ")";
    }
}

public class Task6 {
public static void main(String[] args) {
List<Player> players = Arrays.asList(
new Player("DarkSoul", 1200),
new Player("Knight", 1500),
new Player("Mage", 900)
);

        Collections.sort(players);
        System.out.println(players);
    }
}

🔹 Завдання 7. Довжина рядка
import java.util.*;

class Word implements Comparable<Word> {
private String text;

    public Word(String text) {
        this.text = text;
    }

    TODO: compareTo()

    @Override
    public String toString() {
        return text;
    }
}

public class Task7 {
public static void main(String[] args) {
List<Word> words = Arrays.asList(
new Word("Java"),
new Word("Spring"),
new Word("AI"),
new Word("Stream")
);

        Collections.sort(words);
        System.out.println(words);
    }
}

---------------------------------------
-

1             @Override
public int compareTo(Student other) {
return Integer.compare(this.age, other.age);
}

2    @Override
public int compareTo(Book other) {
return this.title.compareTo(other.title);
}

3     @Override
public int compareTo(Student2 other) {
int cmp = Integer.compare(this.age, other.age);
if (cmp == 0) {
return this.name.compareTo(other.name);
}
return cmp;
}

4    @Override
public int compareTo(BankAccount other) {
int cmp = Double.compare(this.balance, other.balance);
if (cmp == 0) {
return this.accountNumber.compareTo(other.accountNumber);
}
return cmp;
}

5
@Override
public int compareTo(Person other) {
// старші люди йдуть першими
return this.birthday.compareTo(other.birthday);
}

6    @Override
public int compareTo(Player other) {
// сортування за зменшенням score
return Integer.compare(other.score, this.score);
}

7    @Override
public int compareTo(Word other) {
int cmp = Integer.compare(this.text.length(), other.text.length());
if (cmp == 0) {
return this.text.compareTo(other.text);
}
return cmp;
}



