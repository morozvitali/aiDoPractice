package stream2.task9_;

import java.util.List;
import java.util.stream.IntStream;

public class Main1 {
    public void practice1 () {
        List.of(1,2,3,4,5)
                .stream()
                .forEach(System.out::println);
    }

    public void practice2 () {
        List.of(1,2,3,4,5)
                .parallelStream()
                .forEach(System.out::println);
    }

    public void practice3 () {
        List.of(1,2,3,4,5)
                .parallelStream()
                .forEachOrdered(System.out::println);
    }

    public void practice4 () {
        List.of("A", "B", "C","D")
                .parallelStream()
                .forEach(s-> System.out.println(Thread.currentThread().getName() + "->" + s));
    }

    public void practice5 () {
        List <Integer> nums = IntStream.range(0,1_000_000).boxed().toList();
        long t1 = System.currentTimeMillis();
        nums.stream().map(Math::sqrt).toList();
        long t2 = System.currentTimeMillis();

        nums.parallelStream().map(Math::sqrt).toList();
        long t3 = System.currentTimeMillis();

        System.out.println("Normal " + (t2 -t1) + "ms");
        System.out.println("Normal " + (t3 -t2) + "ms");
    }

}
