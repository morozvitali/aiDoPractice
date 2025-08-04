package stream.task2__foreach_ordered_6;

import java.util.List;

public class Main0 {
    public void practice1 () {
        List<String> list = List.of("A", "B", "C", "D");
        list.stream().forEach(System.out::println);
    }

    public void practice2 () {
        List<String> list = List.of("A", "B", "C", "D");
        list.parallelStream().forEach(System.out::println);
    }



}
