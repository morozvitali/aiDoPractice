package stream2.task3_;

import java.util.stream.Stream;

public class Main3 {

    public void practice1 () {
        Stream.of(1,2,3,4,6,2,1)
                .takeWhile(n-> n<5)
                .forEach(System.out::println);
    }

    public void practice2 () {
        Stream.of(1,2,3,4,6,2,1)
                .dropWhile(n->n<5)
                .forEach(System.out::println);
    }

    public void practice3 () {
        Stream.of(1,2,3,6,2,1)
                .filter(n->n<5)
                .forEach(System.out::println);
    }




}

















