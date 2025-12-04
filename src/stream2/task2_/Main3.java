package stream2.task2_;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

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

    public void practice5 () {
        long factirial = LongStream.rangeClosed(1,5)
                .reduce((a,b)-> a * b).orElse(-1);
        System.out.println(factirial);
    }

    public void practice6 () {
        OptionalDouble avg = IntStream.of(10, 20, 30, 40).average();
        System.out.println(avg.getAsDouble());
    }

    public void practice7 () {
        List<String> list = IntStream.rangeClosed(1,3)
                .mapToObj(i-> "Num " + i)
                .toList();
        System.out.println(list);
    }




}



















