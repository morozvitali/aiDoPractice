package stream.task3__optional;

import java.util.List;
import java.util.Optional;

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


}
