package stream.task2__foreach_ordered_6;

import java.util.List;
import java.util.stream.IntStream;

public class Main0 {
    public void practice1 () {
        List<String> list = List.of("A", "B", "C", "D");
        list.stream().forEach(System.out::println);
    }

    public void practice2 () {
        List<String> list = List.of("A", "B", "C", "D");
        list.parallelStream().forEach(System.out::println);
    }

    public void practice3 () {
        List<String> list = List.of("A", "B", "C", "D");
        list.parallelStream().forEachOrdered(System.out::println);
    }

    public void practice4 () {
        List<Integer> list = List.of(1, 2, 3, 4);
        list.parallelStream().peek(System.out::println).map(a->a*a).toList();
    }

    public void practice5 () {
        IntStream.rangeClosed(1, 5).parallel().forEachOrdered(i -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            System.out.println(i + " ");
        });
    }




}
