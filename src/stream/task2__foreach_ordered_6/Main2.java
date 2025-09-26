package stream.task2__foreach_ordered_6;

import java.util.List;

public class Main2 {
    public void practice1 () {
        List<String> list = List.of("A", "B", "C", "D");
        list.stream().forEach(System.out::println);
    }

    public void practice2 () {
        List<String> list = List.of("A", "B", "C", "D");
        list.stream().forEach(System.out::println);
        list.parallelStream().forEach(System.out::println);
    }

    public void practice3 () {
        List<String> list = List.of("A", "B", "C", "D");
        list.parallelStream().forEachOrdered(System.out::println);
    }

    public void practice4 () {
        List.of(1, 2, 3, 4).parallelStream().peek(a-> System.out.println("Обробляю: " + a)).forEachOrdered(a-> System.out.println("Обробляю: " + a));
    }


}
