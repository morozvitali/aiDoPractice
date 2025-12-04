package stream2.task3_;

import java.util.stream.Stream;

public class Main3 {

    public void practice1 () {
        Stream.of(1,2,3,4,6,2,1)
                .takeWhile(n-> n<5)
                .forEach(System.out::println);
    }








}
