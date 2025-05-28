package stream.task0_optional;

import java.util.List;
import java.util.Optional;

public class Main {

    public Integer myOptional () {
        List<Integer> numbers = List.of(3, 8, 10, 15, 4);
        return numbers.stream().filter(a->a%5 ==0).findFirst().orElse(-1);
    }

    public Integer myOptional1 (Optional<Integer> value) {
        return value.map(a->a*2).orElse(-1);
    }



}
