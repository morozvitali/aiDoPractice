package stream.task3__optional_11;

import java.util.List;
import java.util.Optional;

public class Main7 {
    public void practice1 () {
        List<Integer> numbers = List.of(3, 8, 10, 15, 4);
        numbers.stream().filter(value ->value%5 ==0).findFirst().orElse(-1);
    }

    public int practice2 () {
        Optional<Integer> value = Optional.of(7);
        return value.map(n->n*n).orElse(-1);
    }
}
