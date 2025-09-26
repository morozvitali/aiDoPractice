package stream.task60x24.x1.task17_collectors_15;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main25 {
    public Map<Character, List<String>> practice1() {
        List<String> words = List.of("apple",
                "ant", "banana", "bat", "car");
        return words.stream().collect(Collectors.groupingBy(w -> w.charAt(0), Collectors.mapping(String::toUpperCase, Collectors.toList())));
    }

    public Map<Character, List<Integer>> practice2() {
        List<String> words = List.of("apple", "ant",
                "banana", "bat", "car");
        return words.stream().collect(Collectors.groupingBy(w -> w.charAt(0), Collectors.mapping(String::length, Collectors.toList())));
    }

    public Map<Boolean, Long> practice3() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        return numbers.stream().collect(Collectors.partitioningBy(a -> a % 2 == 0, Collectors.counting()));
    }

    public Map<Integer, Set<String>> practice4() {
        List<String> words = List.of("hi", "hi",
                "book", "sun", "day", "Java", "sky");
        return words.stream().collect(Collectors.groupingBy(String::length, Collectors.toSet()));
    }

    public String practice5() {
        return Stream.of(4, 8, 15, 16, 23, 42).collect(Collectors.collectingAndThen(Collectors.counting(), count -> "counter " + count));
    }

    public Map<Character, String> practice6() {
        return Stream.of("apple",
                        "ant", "banana", "bat", "car")
                .collect(Collectors.groupingBy(w -> w.charAt(0), Collectors.joining(", ")));
    }

    public Map <Integer, Integer> practice7 () {
        List<Integer> numbers = List.of(1, 2, 3, 4,
                5, 6, 7, 8, 9);
        return numbers.stream().collect(Collectors.groupingBy(w->w%3, Collectors.summingInt(n->n)));
    }

    public String practice8 () {
        List<String> words = List.of("hi", "book",
                "sun", "day", "Java", "sky");
        return words.stream().collect(Collectors.reducing("", (a,b)->a.length() > b.length() ? a : b));
    }

    public List<String> practice9 () {
        List<String> words = List.of("apple", "ant",
                "alphabet", "axe", "banana", "bat");
        return words.stream().collect(Collectors.collectingAndThen(Collectors.toList(), (List <String> list) -> list.stream().sorted(Comparator.comparingInt(String::length)).toList()));
    }

    public TreeMap<Integer, List<String>> practice10 () {
        List<String> words = List.of("hi", "book",
                "sun", "day", "Java", "sky");
        return words.stream().collect(Collectors.groupingBy(
                String::length,
                TreeMap::new,
                Collectors.toList()
        ));
    }
}
