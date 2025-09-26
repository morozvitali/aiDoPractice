package stream.task60x24.x1.task17_collectors_15;

import java.util.*;
import java.util.stream.Collectors;

public class Main19 {
    public void practice1() {
        List<String> words = List.of("apple",
                "ant", "banana", "bat", "car");
        words.stream().collect(Collectors.groupingBy(w -> w.charAt(0), Collectors.mapping(w -> w.toUpperCase(), Collectors.toList())));
    }

    public Map<Character, Integer> practice2() {
        List<String> words = List.of("apple", "ant",
                "banana", "bat", "car");
        return words.stream().collect(Collectors.toMap(w -> w.charAt(0), String::length));
    }

    public void practice3() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        numbers.stream().collect(Collectors.partitioningBy(a -> a % 2 == 0, Collectors.counting()));
    }

    public Map<Integer, Set<String>> practice4() {
        List<String> words = List.of("hi", "hi",
                "book", "sun", "day", "Java", "sky");
        return words.stream().collect(Collectors.groupingBy(String::length, Collectors.toSet()));
    }

    public String practice5() {
        List<Integer> numbers = List.of(4, 8,
                15, 16, 23, 42);
        return numbers.stream().collect(Collectors.collectingAndThen(Collectors.counting(), count -> "counter =" + count));
    }

    public Map<Character, String> practice6() {
        List<String> words = List.of("apple",
                "ant", "banana", "bat", "car");
        return words.stream().collect(Collectors.groupingBy(w -> w.charAt(0), Collectors.joining(", ")));
    }

    public Map<Integer, Integer> practice7() {
        List<Integer> numbers = List.of(1, 2, 3, 4,
                5, 6, 7, 8, 9);
        return numbers.stream().collect(Collectors.groupingBy(a -> a % 3, Collectors.summingInt(n -> n)));
    }

    public String practice8() {
        List<String> words = List.of("hi", "book",
                "sun", "day", "Java", "sky");
        return words.stream().collect(Collectors.reducing((a, b) -> a.length() > b.length() ? a : b)).orElse("");
    }

    public Map<Character, List<String>> practice9() {
        List<String> words = List.of("apple", "ant",
                "alphabet", "axe", "banana", "bat");
        return words.stream().collect(Collectors.groupingBy(w -> w.charAt(0), Collectors.collectingAndThen(Collectors.toList(), list -> list.stream().sorted(Comparator.comparingInt(String::length)).toList())));
    }

    public Map<Integer, List<String>> practice10() {
        List<String> words = List.of("hi", "book",
                "sun", "day", "Java", "sky");
        return words.stream().collect(Collectors.groupingBy(
                String::length,
                TreeMap::new,
                Collectors.toList()
        ));
    }

    public Map <Integer, List <String>> practice11 () {
        Map <Integer, List<String>> input = Map.of(
                2, List.of("hi"),
                3, List.of("sun", "day", "sky"),
                4, List.of("book", "Java")
        );
        return input.entrySet().stream()
                .sorted(Comparator.comparingInt(e->e.getValue().size()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a,b) -> b, LinkedHashMap::new));
    }
}