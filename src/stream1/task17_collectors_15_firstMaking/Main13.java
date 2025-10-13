package stream1.task17_collectors_15_firstMaking;

import java.util.*;
import java.util.stream.Collectors;

public class Main13 {
    public Map<Character, List<String>> practice1() {
        List<String> words = List.of("apple",
                "ant", "banana", "bat", "car");
        return words.stream().collect(Collectors.groupingBy(word -> word.charAt(0),
                Collectors.mapping(String::toUpperCase, Collectors.toList())));
    }

    public Map<Character, Integer> practice2() {
        List<String> words = List.of("apple", "ant",
                "banana", "bat", "car");
        return words.stream().collect(Collectors.toMap(w -> w.charAt(0), String::length));
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

    public void practice5() {
        List<Integer> numbers = List.of(4, 8, 15, 16, 23, 42);
        numbers.stream().collect(Collectors.collectingAndThen(Collectors.counting(), count -> "Count " + count));
    }

    public void practice6 () {
        List<String> words = List.of("apple",
                "ant", "banana", "bat", "car");
        words.stream().collect(Collectors.groupingBy(w->w.charAt(0), Collectors.joining(", ")));
    }

    public void practice7 () {
        List<Integer> numbers = List.of(1, 2, 3, 4,
                5, 6, 7, 8, 9);
        numbers.stream().collect(Collectors.groupingBy(a->a%3, Collectors.reducing(0, Integer::sum)));
    }

    public String practice8 () {
        List<String> words = List.of("hi", "book",
                "sun", "day", "Java", "sky");
        return words.stream().collect(Collectors.reducing("", (a,b) -> a.length() >= b.length() ? a : b));
    }

    public Map <Character, List<String>> practice9 () {
        List<String> words = List.of("apple", "ant",
                "alphabet", "axe", "banana", "bat");
        return words.stream().collect(Collectors.groupingBy(w->w.charAt(0), Collectors.collectingAndThen(Collectors.toList(), list -> list.stream().sorted(Comparator.comparingInt(String::length)).toList())));
    }

    public Map <Integer, List <String>> practice10 () {
        List<String> words = List.of("hi", "book",
                "sun", "day", "Java", "sky");
        return words.stream().collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toList()));
    }
}
