package stream.task3__optional;

import java.util.List;
import java.util.Optional;

public class Main1 {
    public int practice1 () {
        List<Integer> numbers = List.of(3, 8, 10, 15, 4);
        return numbers.stream().filter(a->a%5 == 0).findFirst().orElse(-1);
    }

    public int practice2 () {
        Optional<Integer> value = Optional.of(7);
        return value.map(x->2*x).orElse(-1);
    }

    public String practice3 () {
        Optional<String> word = Optional.of("HelloWorld");
        return word.stream().filter(a->a.length() > 5).findFirst().orElse("short");
    }

    public String practice4 () {
        Optional<String> name = Optional.of("Vitali");
        return name.map(n-> "Hello " + n + "!").orElse("Hello, Guest");
    }

    public void practice5 () {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        Optional<Integer> max = nums.stream().max(( a,b) -> a.compareTo(b));

        max.ifPresentOrElse(
                value -> System.out.println("Максимум: " + value),
                () -> System.out.println("Немає значень")
        );
    }

    public String practice6 () {
        Optional<String> email = Optional.of("ADMIN@SITE.COM");
        return email.map(a -> a.toLowerCase()).filter(e -> e.contains(".com"))
                .orElseThrow(() -> new IllegalArgumentException("Invalid email"));
    }
}