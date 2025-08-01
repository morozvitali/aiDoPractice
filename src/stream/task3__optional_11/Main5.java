package stream.task3__optional_11;

import java.util.List;

public class Main5 {
    public void practice1 () {
        List<Integer> numbers = List.of(3, 8, 10, 15, 4);
        numbers.stream().filter(a->a%5 ==0).findFirst().orElse(-1);
    }


}
