
---------------------EASY-HASH-EQUALS-----------------------

📝 Трошки теорії

equals(Object o) використовується для порівняння 
вмісту об’єктів, а не посилань.

hashCode() повертає числове значення, яке допомагає
швидко знаходити об’єкт у хеш-структурах (наприклад, HashMap).

Важливе правило:

Якщо два об’єкти рівні за equals(), то в них має 
бути однаковий hashCode().

Навпаки — однаковий hashCode не гарантує, що об’єкти рівні.

🔹 Завдання 1: Користувач

Створи клас User з полями: id, name.
Перевизнач equals() і hashCode() так, щоб користувачі 
з однаковим id вважалися рівними.

Підказка:

equals() спочатку перевіряй на this == o.

Потім на instanceof.

Потім приведи до User і порівняй id.

hashCode() роби лише на основі id.

Рішення:
import java.util.Objects;

class User {
private int id;
private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

🔹 Завдання 2: Книга

Створи клас Book з полями title і author.
Вважай книги однаковими, якщо однакові title + author.

Підказка:

Використовуй Objects.equals(...) для рядків.

hashCode() рахується по двох полях.

Рішення:
import java.util.Objects;

class Book {
private String title;
private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) &&
               Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }
}

🔹 Завдання 3: Точка на площині

Створи клас Point з координатами x, y.
Дві точки вважаються рівними, якщо однакові обидві координати.

Підказка:

Це класичний приклад.

equals() порівнює x і y.

hashCode() рахується по обох.

Рішення:
import java.util.Objects;

class Point {
private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

✅ Міні-тест до практики
import java.util.HashSet;

public class Test {
public static void main(String[] args) {
HashSet<User> users = new HashSet<>();
users.add(new User(1, "Alice"));
users.add(new User(1, "Bob")); // має не додатися
System.out.println(users.size()); // очікується 1

        HashSet<Book> books = new HashSet<>();
        books.add(new Book("Java", "Author"));
        books.add(new Book("Java", "Author")); // теж не додасться
        System.out.println(books.size()); // очікується 1

        HashSet<Point> points = new HashSet<>();
        points.add(new Point(1, 2));
        points.add(new Point(1, 2)); // не додасться
        System.out.println(points.size()); // очікується 1
    }
}


🔹 Завдання 4: Машина
=

Створи клас Car з полями brand і year.
Дві машини вважаються однаковими, якщо однакові обидва поля.

Підказка:

Використай Objects.equals(brand, car.brand).

У hashCode() включи brand і year.

Рішення:
import java.util.Objects;

class Car {
private String brand;
private int year;

    public Car(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return year == car.year &&
               Objects.equals(brand, car.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, year);
    }
}

🔹 Завдання 5: Студент
=
Створи клас Student з полями firstName, lastName, age.
Два студенти однакові, якщо однакові firstName + lastName (вік не має значення).

Підказка:

У equals() ігноруй поле age.

У hashCode() теж не враховуй age.

Рішення:
import java.util.Objects;

class Student {
private String firstName;
private String lastName;
private int age;

    public Student(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(firstName, student.firstName) &&
               Objects.equals(lastName, student.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}

🔹 Завдання 6: Коло
=
Створи клас Circle з полями radius і color.
Два кола однакові, якщо однаковий радіус (колір ігнорується).

Підказка:

Порівнюй тільки radius.

У hashCode() теж бери лише radius.

Рішення:
import java.util.Objects;

class Circle {
private double radius;
private String color;

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle)) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }
}

✅ Міні-тест
import java.util.HashSet;

public class TestEquals {
public static void main(String[] args) {
HashSet<Car> cars = new HashSet<>();
cars.add(new Car("BMW", 2020));
cars.add(new Car("BMW", 2020));
System.out.println(cars.size()); // 1

        HashSet<Student> students = new HashSet<>();
        students.add(new Student("Ivan", "Petrenko", 20));
        students.add(new Student("Ivan", "Petrenko", 25));
        System.out.println(students.size()); // 1

        HashSet<Circle> circles = new HashSet<>();
        circles.add(new Circle(5.0, "Red"));
        circles.add(new Circle(5.0, "Blue"));
        System.out.println(circles.size()); // 1
    }
}

🔹 Завдання 7: Студент + Адреса
=
Створи класи Address (місто, вулиця) і Student (ім’я, прізвище, адреса).
Два студенти однакові, якщо однакові ім’я, прізвище і адреса.

Підказка:

У equals() спочатку перевіряй на посилку.

Для порівняння адреси викликай Objects.equals(address, student.address) (він сам викличе equals в Address).

Не забудь перевизначити equals/hashCode і в Address.

Рішення:
import java.util.Objects;

class Address {
private String city;
private String street;

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return Objects.equals(city, address.city) &&
               Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street);
    }
}

class Student {
private String firstName;
private String lastName;
private Address address;

    public Student(String firstName, String lastName, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(firstName, student.firstName) &&
               Objects.equals(lastName, student.lastName) &&
               Objects.equals(address, student.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, address);
    }
}

🔹 Завдання 8: Товар + Категорія
=
Створи клас Category (назва категорії) і клас Product (назва, ціна, категорія).
Два товари однакові, якщо однакові назва і категорія (ціну ігноруй).

Підказка:

В equals() у Product не використовуй price.

У hashCode() теж тільки name + category.

Рішення:
import java.util.Objects;

class Category {
private String name;

    public Category(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;
        Category category = (Category) o;
        return Objects.equals(name, category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

class Product {
private String name;
private double price;
private Category category;

    public Product(String name, double price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) &&
               Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category);
    }
}

🔹 Завдання 9: Автор + Книга
=
Створи клас Author (ім’я, прізвище) і клас Book (назва, рік, автор).
Дві книги однакові, якщо однакові назва і автор (рік ігнорується).

Підказка:

Перевизнач equals/hashCode в Author.

У Book ігноруй поле year.

Рішення:
import java.util.Objects;

class Author {
private String firstName;
private String lastName;

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;
        Author author = (Author) o;
        return Objects.equals(firstName, author.firstName) &&
               Objects.equals(lastName, author.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}

class Book {
private String title;
private int year;
private Author author;

    public Book(String title, int year, Author author) {
        this.title = title;
        this.year = year;
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) &&
               Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }
}

✅ Міні-тест
import java.util.HashSet;

public class TestMedium {
public static void main(String[] args) {
// Завдання 7
HashSet<Student> students = new HashSet<>();
students.add(new Student("Ivan", "Petrenko", new Address("Kyiv", "Main")));
students.add(new Student("Ivan", "Petrenko", new Address("Kyiv", "Main")));
System.out.println(students.size()); // 1

        // Завдання 8
        HashSet<Product> products = new HashSet<>();
        Category cat1 = new Category("Electronics");
        products.add(new Product("Phone", 1000, cat1));
        products.add(new Product("Phone", 1500, cat1));
        System.out.println(products.size()); // 1

        // Завдання 9
        HashSet<Book> books = new HashSet<>();
        Author author = new Author("Robert", "Martin");
        books.add(new Book("Clean Code", 2008, author));
        books.add(new Book("Clean Code", 2020, author));
        System.out.println(books.size()); // 1
    }
}

https://chatgpt.com/c/68a6d2e4-eb9c-8320-90d8-530abbdc434d