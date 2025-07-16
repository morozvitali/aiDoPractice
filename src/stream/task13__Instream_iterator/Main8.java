package stream.task13__Instream_iterator;

import java.util.stream.IntStream;

public class Main8 {
    public void practice1 () {
        IntStream.iterate(10, i ->i -1).limit(10).forEach(System.out::println);
    }

    public void practice2 () {
        IntStream.iterate(2, i->i+2).limit(10).forEach(System.out::println);
    }

    public void practice3 () {
        IntStream.iterate(1, i->i+2).limit(10).forEach(System.out::println);
    }

    public void practice4 () {
        IntStream.iterate(50, i->i-5).limit(10).forEach(System.out::println);
    }




}
