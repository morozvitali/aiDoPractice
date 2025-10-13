package stream1.task3__optional_11;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class Main3 {
    public int practice1() {
        List<Integer> numbers = List.of(3, 8, 10, 15, 4);
        return numbers.stream().filter(a -> a % 5 == 0).findFirst().orElse(-1);
    }

    public void practice2() {
        Optional<Integer> value = Optional.of(7);
        value.map(a -> a * 2).orElse(-1);
    }

    public void practice3() {
        Optional<String> word = Optional.of("HelloWorld");
        word.filter(w -> w.length() > 5).orElse("short");
    }

    public void practice4() {
        Optional<String> name = Optional.of("Vitali");
        name.map(n -> "hello " + n + "!").orElse("hello, guest");
    }

    public void practice5() {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        Optional<Integer> max = nums.stream().max((a, b) -> a > b ? a : b);
        max.ifPresentOrElse(value -> System.out.println("Max = " + value),
                () -> System.out.println("empty"));
    }

    public static String practice6() {
        Optional<String> email = Optional.of("ADMIN@SITE.COM");
        return email
                .map(String::toLowerCase)
                .filter(e -> e.contains(".com"))
                .orElseThrow(() -> new IllegalArgumentException("Invalid email"));
    }

    public void practice7() {
        List<Integer> nums = List.of(); // або List.of(5, 2, 9);
        nums.stream().min(Integer::compareTo)
                .ifPresentOrElse(
                        val -> System.out.println("min " + val),
                        () -> System.out.println("empty")
                );
    }

    public void practice8() {
        List<String> words = List.of("Java", "Spring");
        words.stream().findFirst().map(a -> a.length()).ifPresentOrElse(len -> System.out.println("length" + len), () -> System.out.println("empty"));
    }

    public String practice9(String user) {
        Optional<String> name = Optional.of(user);
        return name.map(String::toUpperCase)
                .orElseThrow(() -> new NoSuchElementException("Nmae not found"));
    }

    public String practice10(String login) {
        Optional<String> user = Optional.of(login);
        return user.map(a -> a.startsWith("admin") ? "Admin access" : "User access")
                .orElse("no login");
    }

    public void practice11(Optional<Integer> number) {
         number.filter(n -> n % 2 == 0)
                .map(n -> n * 2)
                .ifPresentOrElse(val -> System.out.println("double " + val),
                () -> System.out.println("val is empty"));
    }
}
