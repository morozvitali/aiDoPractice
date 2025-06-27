package stream.task13__Instream_range_limit;

import java.util.stream.IntStream;

public class Main6 {

    public static void practice2 () {
        IntStream.iterate(2, i -> i+2).limit(10).forEach(System.out::println);
    }

    public static void main(String[] args) {
        Main6.practice2();
    }




}
