package stream.task3__optional_11;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main5 {
    public void practice1 () {
        List<Integer> numbers = List.of(3, 8, 10, 15, 4);
        numbers.stream().filter(a->a%5 ==0).findFirst().orElse(-1);
    }

    public void practice2 () {
        Optional<Integer> value = Optional.of(7);
        value.map(x->x*2).orElse(-1);
    }

    public void practice3 () {
        Optional <String> word = Optional.of("hello");
        String s = word.filter(a->a.length() > 5).orElse("short");
    }

    public void practice4 () {
        Optional <String> name = Optional.of("Vitali");
        String s = name.map(n->"Hello" + n + "!").orElse("Hello guest!");
    }

    public void practice5 () {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        nums.stream().max(Comparator.naturalOrder()).ifPresentOrElse(value -> System.out.println("max " + value), () -> System.out.println("empty"));
    }


}
