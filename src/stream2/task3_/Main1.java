package stream2.task3_;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Main1 {
    public void practice1 () {
        Stream.of(1, 2, 3, 6, 2, 1)
                .takeWhile(n->n<5)
                .forEach(System.out::print);
    }

    public void practice2 () {
        Stream.of(1, 2, 3, 6, 2, 1)
                .dropWhile(n->n<5)
                .forEach(System.out::println);
    }

    public void practice3 () {
        Stream.of(1, 2, 3, 6, 2, 1)
                .filter(n->n <5)
                .forEach(System.out::println);
    }

    public void practice4 () {
        List<Integer> nums = List.of(1, 2, 3, 5, 2, 6, 7);
        //nums.stream().takeWhile(new int[] {Integer.MIN_VALUE}::equals)
        AtomicInteger prev = new AtomicInteger(0);
        List <Integer> result = nums.stream().takeWhile(n-> {
            boolean ok = n > prev.get();
            prev.set(n);
            return ok;
        }).toList();
        System.out.println(result);
    }

    public void practice5 () {

    }
}
