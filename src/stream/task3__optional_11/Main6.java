package stream.task3__optional_11;

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

}
