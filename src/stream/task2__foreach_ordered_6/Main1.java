package stream.task2__foreach_ordered_6;

import java.util.List;

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

}
