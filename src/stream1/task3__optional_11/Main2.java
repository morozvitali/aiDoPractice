package stream1.task3__optional_11;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class Main2 {

    public int practice1 () {
        List<Integer> numbers = List.of(3, 8, 10, 15, 4);
        return numbers.stream().filter(a->a%5==0).findFirst().orElse(-1);
    }

    public int practice2 () {
        Optional<Integer> value = Optional.of(7);
        return value.map(a->a*a).orElse(-1);
    }

    public String practice3 () {
        Optional<String> word = Optional.of("HelloWorld");
        return word.filter(a->a.length()>5).orElse("short");
    }

    public void practice4 () {
        Optional<String> name = Optional.of("Vitali");
        name.map(n->"Hello " + n + "!").orElse("Hello, guest");
    }

    public void practice5 () {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        Optional <Integer> max = nums.stream().max((a,b)-> a.compareTo(b));
        max.ifPresentOrElse(
                value -> System.out.println("Maximum " + value), () -> System.out.println("Empty no values")
        );
    }

    public String practice6 () {
        Optional<String> email = Optional.of("ADMIN@SITE.COM");
        return email.map(a->a.toLowerCase()).filter(a->a.contains(".com"))
                .orElseThrow(() -> new IllegalArgumentException("Invalid email"));
    }

    public void practice7 () {
        List<Integer> nums = List.of(5, 2, 9);
        nums.stream().min(
                Comparator.naturalOrder()
                //(a,b) -> Integer.compare(a,b)
        ).ifPresentOrElse(
                value -> System.out.println("Мінімум " + value),
                () -> System.out.println("Порожній список")
        );
    }

    public void practice8 () {
        List<String> words = List.of("Java", "Spring");
        words.stream().findFirst().map(a->a.length()).ifPresentOrElse(
                value -> System.out.println("Довжина " + value),
                () -> System.out.println("Список слів порожній")
        );
    }

    public void practice9 () {
        Optional <String> name = Optional.of("Nmae");
        name.map(a->a.toUpperCase())
                .orElseThrow(() -> new NoSuchElementException(" no such element exception"));
    }

    public void practice10 () {
        Optional <String> login = Optional.of("adminlaskf");
        login.map(a->a.startsWith("admin") ? "Admin access" : "User access").orElse("No login");
    }

    public void practice11 () {
        Optional <Integer> value = Optional.of(7);
        value.filter(a->a%2==0).map(a->a*2).ifPresentOrElse(
                val -> System.out.println(val),
                () -> System.out.println("empty or not odd")
        );
    }
}