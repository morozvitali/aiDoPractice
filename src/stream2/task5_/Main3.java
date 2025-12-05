package stream2.task5_;

import java.util.List;
import java.util.stream.Stream;

public class Main3 {
    public void practice1() {
        Stream<String> a = Stream.of("A", "B", "C");
        Stream<String> b = Stream.of("D", "F");
        Stream.concat(a, b).forEach(System.out::println);
    }

    public void practice2 () {
        List<String> one = List.of("apple", "banana", "cherry");
        List<String> two = List.of("banana", "date", "apple");
        List <String> list = Stream.concat(one.stream(), two.stream())
                .distinct()
                .toList();
        System.out.println(list);
    }





}

