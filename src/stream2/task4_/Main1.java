package stream2.task4_;

import java.util.stream.Stream;

public class Main1 {
    public void practice1 () {
        Stream.iterate(0, n->n+2)
                .limit(5)
                .forEach(System.out::println);
    }

}
