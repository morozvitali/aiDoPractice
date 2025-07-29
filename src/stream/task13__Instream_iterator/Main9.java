package stream.task13__Instream_iterator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main9 {
    public void practice1() {
        IntStream.iterate(10, i -> i - 1).forEach(System.out::println);
    }
public void practice2 () {
        IntStream.iterate(2, i -> i+2).limit(10).forEach(System.out::println);
}

}
