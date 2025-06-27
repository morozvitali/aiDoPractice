package stream.task13__Instream_range_limit;

import java.util.stream.IntStream;

public class Main6 {

    public static void practice2() {
        IntStream.iterate(2, i -> i + 2).limit(10).forEach(System.out::println);
    }

    public static void main(String[] args) {
        Main6.practice2();
    }

    public void practice3() {
        IntStream.iterate(1, i -> i+2).limit(10)
                .forEach(System.out::println);
    }

    public void practice4 () {
        IntStream.iterate(50, i->i-5).limit(10)
                .forEach(System.out::println);
    }

    public void practice5 () {
        IntStream.iterate(1,i-> i+1).limit(10)
                .forEach(System.out::println);
    }

    public void practice6 () {
        IntStream.iterate(17, i->i+10).limit(9)
                .forEach(System.out::println);
    }

    public void practice7 () {
        IntStream.iterate(1, i->i * 2).limit(10)
                .forEach(System.out::println);
    }

    public void practice8 () {
        IntStream.iterate(1, i ->i+3).filter(a -> a%2 == 0)
                .limit(10).forEach(System.out::println);
    }

    public void practice9 () {
        IntStream.iterate(1, i->i+1).
                map(a->a*a)
                .filter(a->a%5 != 0)
                .limit(10)
                .forEach(System.out::println);
    }



}
