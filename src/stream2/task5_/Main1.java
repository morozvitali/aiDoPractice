package stream2.task5_;

import java.util.stream.Stream;

public class Main1 {
    public void practice1 () {
        Stream<String> a = Stream.of("A", "B", "C");
        Stream<String> b = Stream.of("D", "E");
        Stream.concat(a,b).forEach(System.out::println);
    }


}
