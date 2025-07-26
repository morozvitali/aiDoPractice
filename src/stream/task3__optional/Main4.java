package stream.task3__optional;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class Main4 {
    public void practice1 () {
        List<Integer> numbers = List.of(3, 8, 10, 15, 4);
        int response = numbers.stream().filter(value-> value %5 == 0).findFirst().orElse(-1);
    }

    public void practice2 () {
     Optional<Integer> value = Optional.of(7);
     int response = value.map(i -> i*i).orElse(-1);
    }

    public void practice3 () {
        Optional <String> name = Optional.of("Vitali");
        name.map(w->"hello, " + name)
                .orElse("hello, guest");
    }

    public void practice4 () {
        Optional <String> str = Optional.of("shrt")
                String response = str
                .filter(s -> s.length() > 5)
                .orElse("short");
    }

    public void practice5 () {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        nums.stream().max((a,b)->a.compareTo(b)).ifPresent(System.out::println);
    }

    public void practice6 () {
        Optional<String> email = Optional.of("ADMIN@SITE.COM");
        email.map(s->s.toLowerCase()).filter(e->e.contains(".com"))
                .orElseThrow(()->new IllegalArgumentException("Invalid email"));
    }



}
