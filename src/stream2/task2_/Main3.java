package stream2.task2_;

import java.util.stream.IntStream;

public class Main3 {
    public void practice1 () {
        IntStream.range(1,5).forEach(System.out::println);
        IntStream.rangeClosed(1,5).forEach(System.out::println);
    }




}
