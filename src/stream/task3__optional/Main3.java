package stream.task3__optional;

import java.util.List;
import java.util.Optional;

public class Main3 {
    public int practice1() {
        List<Integer> numbers = List.of(3, 8, 10, 15, 4);
        return numbers.stream().filter(a->a%5==0).findFirst().orElse(-1);
    }

    public void practice2 () {
        Optional<Integer> value = Optional.of(7);
        value.map(a->a*2).orElse(-1);
    }

    public void practice3 () {
        Optional<String> word = Optional.of("HelloWorld");
        word.filter(w->w.length()>5).orElse("short");
    }

    public void practice4 () {
        Optional<String> name = Optional.of("Vitali");
        name.map(n-> "hello " + n + "!").orElse("hello, guest");
    }

    public void practice5 () {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        Optional<Integer> max = nums.stream().max((a,b)-> a >b ? a :b);
        max.ifPresentOrElse(value -> System.out.println("Max = " + value),
                () -> System.out.println("empty"));
    }



}
