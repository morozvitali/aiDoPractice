package stream.task3__optional_11;

import java.util.List;
import java.util.Optional;

public class Main8 {
    public int practice1() {
        List<Integer> numbers = List.of(3, 8, 10, 15, 4);
        return numbers.stream().filter(a -> a % 5 == 0).findFirst().orElse(-1);
    }

    public int practice2 () {
        Optional <Integer> value = Optional.of(7);
        return value.map(v->v*2).orElse(-1);
        }


    public String practice3 () {
        Optional <String> value = Optional.of("Helloworld");
        return value.filter(w->w.length() >5).orElse("Short");
    }

    public String practice4 () {
        Optional <String> value = Optional.of("Vitali");
        return value.map(name->"Hello " + name + "!").orElse("Hello, Guest!");
    }


}
