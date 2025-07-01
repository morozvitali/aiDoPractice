package stream.task3__optional;

import java.util.List;
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


}
