package stream1.task2__foreach_ordered_6;

import java.util.List;
import java.util.stream.IntStream;

public class Main1 {
    public void practice1 () {
        List<String> list = List.of("A", "B", "C", "D");
        list.stream().forEach(System.out::print);
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
        list.parallelStream().peek(a-> System.out.println("logging " + a))
                .map(value -> value * value)
                .forEachOrdered(a-> System.out.println("logging " + a));
    }

    public void practice5 () {
        IntStream.rangeClosed(1,5).parallel()
                .forEachOrdered(i-> {
                    try{
                        Thread.sleep(100);
                    } catch (InterruptedException e) {}
                    System.out.println(i + " ");
                });
    }

    public void practice6 () {
        List<String> list = List.of("A", "B", "C", "D");
        StringBuilder sb = new StringBuilder();

        list.parallelStream().forEachOrdered(sb::append);
        System.out.println(sb);
    }


}
