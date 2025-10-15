package stream2.task4_;

import java.util.stream.Stream;

public class Main1 {
    public void practice1() {
        Stream.iterate(0, n -> n + 2)
                .limit(5)
                .forEach(System.out::println);
    }

    public void practice2() {
        Stream.generate(() -> (int) (Math.random() * 10))
                .limit(5)
                .forEach(System.out::println);
    }

    public void practice3 () {
        Stream.iterate(1, n->n+1)
                .map(n->n*n)
                .limit(5)
                .forEach(System.out::println);
    }


}
