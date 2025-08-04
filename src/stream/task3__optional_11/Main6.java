package stream.task3__optional_11;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main6 {
    public void practice1 () {
        List<Integer> numbers = List.of(3, 8, 10, 15, 4);
        numbers.stream().filter(a->a%5==0).findFirst().orElse(-1);
    }

    public void practice2 () {
        Optional<Integer> value = Optional.of(7);
        value.map(a->a*a).orElse(-1);
    }

    public void practice3 () {
        Optional <String> sentence = Optional.of ("string");
        sentence.filter(len -> len.length() > 5).orElse("short");
    }

    public void practice4 (String name) {
        Optional <String> opt = Optional.of(name);
        opt.map(a->"hello, " + a).orElse("hello, guest");
    }

    public void practice5 (String name) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        nums.stream().max(Comparator.naturalOrder()).ifPresentOrElse(value -> System.out.println(value), ()-> System.out.println("empty"));
    }

    public void practice6 () {
        Optional <String> optional = Optional.of("Admin@Site.Com");
    optional.map(v-> v.toLowerCase()).filter(v->v.contains(".com")).orElseThrow(()->new IllegalArgumentException("Invalid email"));
    }

    public void practice7 () {
        List<Integer> nums = List.of(5, 2, 9);
        nums.stream().min(Comparator.naturalOrder()).ifPresentOrElse(val -> System.out.println("min " + val), () -> System.out.println("empty"));
    }

}
