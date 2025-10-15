package stream2.task5_;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class Main1 {
    public void practice1 () {
        Stream<String> a = Stream.of("A", "B", "C");
        Stream<String> b = Stream.of("D", "E");
        Stream.concat(a,b).forEach(System.out::println);
    }

    public void practice2 () {
        List<String> one = List.of("apple", "banana", "cherry");
        List<String> two = List.of("banana", "date", "apple");
        List<String> merged = Stream.concat(one.stream(), two.stream())
                .distinct()
                .toList();
        System.out.println(merged);
    }

    public void practice3 () {
        List<List<String>> lists = List.of(
                List.of("A", "B"),
                List.of("C", "D", "E")
        );
        List <String> list = lists.stream().flatMap(Collection::stream).toList();
    }

    public void practice4 () {

        Stream<String> s1 = Stream.of("a");
        Stream<String> s2 = Stream.of("b");
        Stream<String> s3 = Stream.of("c");
        Stream <String> merged = Stream.of(s1, s2, s3).reduce(Stream::concat).orElse(Stream.empty());
        merged.forEach(System.out::println);
    }

}
