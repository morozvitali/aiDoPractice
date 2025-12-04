package stream2.task2_;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Main3 {
    public void practice1 () {
        IntStream.range(1,5).forEach(System.out::println);
        IntStream.rangeClosed(1,5).forEach(System.out::println);
    }

    public void practice2 () {
        int sum = IntStream.rangeClosed(1,5)
                .map(n->n*n)
                .sum();
    }

    public void practice3 () {
        DoubleStream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);
    }

    public void practice4 () {
        int result =DoubleStream.of(1.2, 2.5, 3.8)
                .mapToInt(d->(int) Math.round(d))
                .sum();
    }



}
