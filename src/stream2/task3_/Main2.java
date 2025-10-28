package stream2.task3_;

import java.util.stream.Stream;

public class Main2 {
    public void practice1() {
        Stream.of(1, 2, 3, 4, 5, 6, 7, 4, 3)
                .takeWhile(n->n<5)
                .forEach(System.out::println);
    }

    public void practice2 () {
        Stream.of(1,2,3,4,6,5)
                .dropWhile(n->n<5)
                .forEach(System.out::println);
    }


}
