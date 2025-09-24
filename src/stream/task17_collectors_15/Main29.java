package stream.task17_collectors_15;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main29 {
    public Map<Character, List<String>> practice1() {
        return Stream.of("apple",
                "ant", "banana", "bat", "car").collect(Collectors.groupingBy(w -> w.charAt(0), Collectors.mapping(w -> w.toUpperCase(), Collectors.toList())));
    }

    public Map<Character, List<Integer>> practice2() {
        List<String> words = List.of("apple", "ant",
                "banana", "bat", "car");
        return words.stream().collect(Collectors.groupingBy(w -> w.charAt(0), Collectors.mapping(String::length, Collectors.toList())));
    }

    public Map<Boolean, Long> practice3() {
        List<String> words = List.of("apple", "ant",
                "banana", "bat", "car");
        return words.stream().collect(Collectors.partitioningBy(a -> a.length() % 2 == 0, Collectors.counting()));
    }

    public Map<Integer, Set<String>> practice4() {
        List<String> words = List.of("hi", "hi",
                "book", "sun", "day", "Java", "sky");
        return words.stream().collect(Collectors.groupingBy(String::length, Collectors.toSet()));
    }

    public String practice5() {
        List<Integer> numbers = List.of(4, 8,
                15, 16, 23, 42);
        return numbers.stream().collect(Collectors.collectingAndThen(Collectors.counting(), count -> "counter" + count));
    }

    public Map<Character, String> practice6() {
        List<String> words = List.of("apple",
                "ant", "banana", "bat", "car");
        return words.stream().collect(Collectors.groupingBy(w -> w.charAt(0), Collectors.collectingAndThen(Collectors.toList(), list -> String.join(" ", list))));
    }

    public Map<Integer, Integer> practice7() {
        List<Integer> numbers = List.of(1, 2, 3, 4,
                5, 6, 7, 8, 9);
        return numbers.stream().collect(Collectors.groupingBy(n -> n % 3, Collectors.summingInt(n -> n)));
    }



}