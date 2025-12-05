package stream2.task5_;

import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main3 {
    public void practice1() {
        Stream<String> a = Stream.of("A", "B", "C");
        Stream<String> b = Stream.of("D", "F");
        Stream.concat(a, b).forEach(System.out::println);
    }

    public void practice2() {
        List<String> one = List.of("apple", "banana", "cherry");
        List<String> two = List.of("banana", "date", "apple");
        List<String> list = Stream.concat(one.stream(), two.stream())
                .distinct()
                .toList();
        System.out.println(list);
    }

    public void practice3() {
        List<List<String>> lists = List.of(
                List.of("A", "B"),
                List.of("C", "D", "E")
        );

        List<String> result = lists.stream()
                .flatMap(Collection::stream)
                .toList();

        System.out.println(result);
    }

    public void practice4() {
        Stream<String> s1 = Stream.of("a");
        Stream<String> s2 = Stream.of("b");
        Stream<String> s3 = Stream.of("c");

        Stream<String> merged = Stream.of(s1, s2, s3)
                .reduce(Stream::concat)
                .orElse(Stream.empty());
        merged.forEach(System.out::println);
    }

    public void practice5() {
        List<String> java = List.of("Spring", "Hibernate");
        List<String> js = List.of("React, Vue");
        Stream.concat(
                        java.stream().map(j -> "[JAVA] " + j),
                        js.stream().map(j -> "[JS ]" + j))
                .forEach(System.out::println);
    }

    public void practice6() {
        IntStream evens = IntStream.of(2, 4, 6);
        IntStream odds = IntStream.of(1, 3, 5);
        IntStream.concat(odds, evens).sorted().forEach(System.out::println);
    }


}

