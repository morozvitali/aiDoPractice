🔹 Завдання 1. Сортування студентів за віком
-
Створи клас Student з полями name (String) і age (int).
Реалізуй Comparable<Student> так, щоб сортування відбувалося за віком (молодший перший).
Питання для перевірки: що буде, якщо два студенти мають однаковий вік?

import java.util.*;

class Student {
private String name;
private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() { return age; }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}

class StudentAgeComparator implements Comparator<Student> {
@Override
public int compare(Student s1, Student s2) {
// TODO: реалізуй порівняння за віком
return 0;
}
}

public class Main1 {
public static void main(String[] args) {
List<Student> students = Arrays.asList(
new Student("Іван", 22),
new Student("Марія", 19),
new Student("Олег", 25)
);

        Collections.sort(students, new StudentAgeComparator());
        System.out.println(students);
    }
}

🔹 Завдання 2. Сортування книг за назвою
-
Створи клас Book з полями title і author.
Зроби так, щоб сортування йшло за title в алфавітному порядку.
Додатково: перевір, як поводиться compareTo, якщо у двох книжок однаковий title.

import java.util.*;

class Book {
private String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() { return title; }

    @Override
    public String toString() {
        return title;
    }
}

class BookTitleLengthComparator implements Comparator<Book> {
@Override
public int compare(Book b1, Book b2) {
// TODO: порівняй довжину рядків
return 0;
}
}

public class Main2 {
public static void main(String[] args) {
List<Book> books = Arrays.asList(
new Book("Java Programming"),
new Book("C"),
new Book("Algorithms and Data Structures")
);

        Collections.sort(books, new BookTitleLengthComparator());
        System.out.println(books);
    }
}

🔹 Завдання 3. Багаторівневе сортування (age → name)
-
Модифікуй клас Student із завдання 1.
Реалізуй compareTo так, щоб спочатку сортувати за віком, а якщо він однаковий — тоді за ім’ям (алфавітно).

import java.util.*;

class Product {
private String name;
private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() { return price; }

    @Override
    public String toString() {
        return name + " - " + price + " грн";
    }
}

class ProductPriceComparator implements Comparator<Product> {
@Override
public int compare(Product p1, Product p2) {
// TODO: порівняй double-значення price
return 0;
}
}

public class Main3 {
public static void main(String[] args) {
List<Product> products = Arrays.asList(
new Product("Телефон", 12000),
new Product("Навушники", 2500),
new Product("Ноутбук", 30000)
);

        Collections.sort(products, new ProductPriceComparator());
        System.out.println(products);
    }
}

🔹 Завдання 4. Банківські рахунки
-
Створи клас BankAccount із полями:
accountNumber (String),
balance (double).

Зроби сортування за балансом (більший баланс → пізніше в списку).
Додатково: що робити, якщо баланс однаковий? (можеш використати accountNumber для розв’язання “нічия”).
import java.util.*;

class Employee {
private String name;
private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public int getSalary() { return salary; }

    @Override
    public String toString() {
        return name + " - " + salary;
    }
}

class EmployeeSalaryComparator implements Comparator<Employee> {
@Override
public int compare(Employee e1, Employee e2) {
// TODO: порівняй зарплати, але в зворотному порядку
return 0;
}
}

public class Main4 {
public static void main(String[] args) {
List<Employee> employees = Arrays.asList(
new Employee("Андрій", 25000),
new Employee("Катерина", 40000),
new Employee("Петро", 30000)
);

        Collections.sort(employees, new EmployeeSalaryComparator());
        System.out.println(employees);
    }
}

🔹 Завдання 5. Дата народження
-
Створи клас Person із полем LocalDate birthday.
Зроби сортування так, щоб старші люди йшли першими.
Питання: чому краще використати birthday.compareTo(...), а не рахувати роки вручну?
import java.util.*;

class City {
private String name;
private int population;

    public City(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public int getPopulation() { return population; }

    @Override
    public String toString() {
        return name + " (" + population + ")";
    }
}

class CityPopulationComparator implements Comparator<City> {
@Override
public int compare(City c1, City c2) {
// TODO: порівняй населення
return 0;
}
}

public class Main5 {
public static void main(String[] args) {
List<City> cities = Arrays.asList(
new City("Київ", 2960000),
new City("Львів", 720000),
new City("Харків", 1440000)
);

        Collections.sort(cities, new CityPopulationComparator());
        System.out.println(cities);
    }
}

🔹 Завдання 6. Топ гравців
-
Є клас Player із полями nickname (String) і score (int).
Зроби сортування за зменшенням score.
(Підказка: можна інвертувати результат compareTo).
import java.util.*;

class Car {
private String model;
private int year;

    public Car(String model, int year) {
        this.model = model;
        this.year = year;
    }

    public int getYear() { return year; }

    @Override
    public String toString() {
        return model + " (" + year + ")";
    }
}

class CarYearComparator implements Comparator<Car> {
@Override
public int compare(Car c1, Car c2) {
// TODO: порівняй роки
return 0;
}
}

public class Main6 {
public static void main(String[] args) {
List<Car> cars = Arrays.asList(
new Car("Toyota", 2018),
new Car("BMW", 2020),
new Car("Ford", 2015)
);

        Collections.sort(cars, new CarYearComparator());
        System.out.println(cars);
    }
}

🔹 Завдання 7. Довжина рядка
-
Створи клас Word із полем text.
Сортуй об’єкти за довжиною text. Якщо довжина однакова — сортуй алфавітно.
import java.util.*;

class User {
private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    @Override
    public String toString() {
        return name;
    }
}

class UserNameComparator implements Comparator<User> {
@Override
public int compare(User u1, User u2) {
// TODO: порівняй рядки name
return 0;
}
}

public class Main7 {
public static void main(String[] args) {
List<User> users = Arrays.asList(
new User("Олександр"),
new User("Анна"),
new User("Богдан")
);

        Collections.sort(users, new UserNameComparator());
        System.out.println(users);
    }
}

-------------------------------------------------------------
-
✨ Готові рішення
Завдання 1. Студенти за віком
@Override
public int compare(Student s1, Student s2) {
return Integer.compare(s1.getAge(), s2.getAge());
}

Завдання 2. Книги за довжиною назви
@Override
public int compare(Book b1, Book b2) {
return Integer.compare(b1.getTitle().length(), b2.getTitle().length());
}

Завдання 3. Товари за ціною (від меншої до більшої)
@Override
public int compare(Product p1, Product p2) {
return Double.compare(p1.getPrice(), p2.getPrice());
}

Завдання 4. Працівники за зарплатою (спочатку вища)
@Override
public int compare(Employee e1, Employee e2) {
return Integer.compare(e2.getSalary(), e1.getSalary()); // зворотній порядок
}

Завдання 5. Міста за кількістю населення
@Override
public int compare(City c1, City c2) {
return Integer.compare(c1.getPopulation(), c2.getPopulation());
}

Завдання 6. Автомобілі за роком випуску
@Override
public int compare(Car c1, Car c2) {
return Integer.compare(c1.getYear(), c2.getYear());
}

Завдання 7. Користувачі за іменем (алфавітно)
@Override
public int compare(User u1, User u2) {
return u1.getName().compareTo(u2.getName());
}
