package stream.task13__Instream_iterator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main9 {
    public List<Integer> practice1() {
        return IntStream.iterate(10, i -> i - 1).boxed().toList();
    }


}
