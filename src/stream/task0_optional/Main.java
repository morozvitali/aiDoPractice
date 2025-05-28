package stream.task0_optional;

import java.util.List;

public class Main {

    public Integer myOptional () {
        List<Integer> numbers = List.of(3, 8, 10, 15, 4);
        return numbers.stream().filter(a->a%5 ==0).findFirst().orElse(-1);
    }



}
