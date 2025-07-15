package stream.task3__optional;

import java.util.List;
import java.util.Optional;

public class Main0 {
public int practice1 () {
    List<Integer> numbers = List.of(3, 8, 10, 15, 4);
    return numbers.stream().filter(a->a%5==0).findFirst().orElse(-1);
}

public int practice2 () {
    Optional<Integer> value = Optional.of(7);

    return value.map(x->x*2).orElse(-1);
}

}
