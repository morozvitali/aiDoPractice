package stream.task0_optional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {

    public Integer myOptional() {
        List<Integer> numbers = List.of(3, 8, 10, 15, 4);
        return numbers.stream().filter(a -> a % 5 == 0).findFirst().orElse(-1);
    }

    public Integer myOptional1(Optional<Integer> value) {
        return value.map(a -> a * 2).orElse(-1);
    }

    public String myOptional2(Optional<String> value) {
        return value.filter(s -> s.length() > 5).orElse("short");
    }

    public String myOptional3(Optional<String> value) {
        return value.map(a -> "Hello, " + a + "!").orElse("Hello, guest!");
    }

    public void myOptional4() {

        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        nums.stream()
                .max(Integer::compareTo)
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Немає значень")
                );
    }

    public String myOptional5() {
        Optional<String> email = Optional.of("ADMIN@SITE.COM");
        return email.map(String::toLowerCase).filter(a -> a.contains(".com")).orElseThrow(() -> new IllegalArgumentException("Invalid email"));
    }
}
