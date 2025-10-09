package stream.task17_collectors_15_firstMaking;

import java.util.*;
import java.util.stream.Collectors;

public class Main21 {
    public String practice1() {
        List<String> names = List.of("Alice", "Bob", "Charlie");
        return names.stream().collect(Collectors.joining(", "));
    }

    public IntSummaryStatistics practice2() {
        List<Integer> numbers = List.of(4, 8, 15, 16, 23, 42);
        return numbers.stream().collect(Collectors.summarizingInt(value -> value));
    }

    public Map<Integer, List<String>> practice3() {
        List<String> words = List.of("hi", "book",
                "sun", "day", "Java", "sky");
        return words.stream().collect(Collectors.groupingBy(String::length));
    }


    public Map<Integer, Long> practice4() {
        List<String> words = List.of("hi", "book",
                "sun", "day", "Java", "sky");
        return words.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));
    }

    public Map<Boolean, List<Integer>> practice5() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        return numbers.stream().collect(Collectors.partitioningBy(value -> value % 2 == 0));
    }

    public Map<Character, List<String>> practice6() {
        List<String> words = List.of("apple",
                "ant", "banana", "bat", "car");
        return words.stream().collect(Collectors.groupingBy(word -> word.charAt(0), Collectors.mapping(word -> word.toUpperCase(), Collectors.toList())));
    }

    public Map<Character, List<Integer>> practice7() {
        List<String> words = List.of("apple", "ant",
                "banana", "bat", "car");
        return words.stream().collect(Collectors.groupingBy(word -> word.charAt(0), Collectors.mapping(value -> value.length(), Collectors.toList())));
    }

    public Map<Boolean, Long> practice8() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        return numbers.stream().collect(Collectors.partitioningBy(value -> value % 2 == 0, Collectors.counting()));
    }

    public Map<Integer, Set<String>> practice9() {
        List<String> words = List.of("hi", "hi",
                "book", "sun", "day", "Java", "sky");
        return words.stream().collect(Collectors.groupingBy(String::length, Collectors.toSet()));
    }

    public String practice10(List<Integer> list) {
        return list.stream().collect(Collectors.collectingAndThen(Collectors.counting(), count -> "Count " + count));
    }

    public Map<Character, String> practice11(List<String> list) {
        return list.stream().collect(Collectors.groupingBy(w -> w.charAt(0), Collectors.joining(", ")));
    }

    public Map<Integer, Integer> practice12(List<Integer> list) {
        return list.stream().collect(Collectors.groupingBy(value -> value % 3, Collectors.reducing(0, Integer::sum)));
    }

    public String practice13() {
        List<String> words = List.of("hi", "book",
                "sun", "day", "Java", "sky");
        return words.stream().collect(Collectors.reducing("", (a, b) -> a.length() >= b.length() ? a : b));
    }

    public Map<Character, List<String>> practice14() {
        List<String> words = List.of("apple", "ant",
                "alphabet", "axe", "banana", "bat");
        return words.stream().collect(Collectors.groupingBy(a -> a.charAt(0), Collectors.collectingAndThen(Collectors.toList(), list -> list.stream().sorted(Comparator.comparingInt(String::length)).toList())));
    }

    public Map<Integer, List<String>> practice15() {
        List<String> words = List.of("hi", "book",
                "sun", "day", "Java", "sky");
        return words.stream().collect(Collectors.groupingBy(
                String::length,
                TreeMap::new,
                Collectors.toList()
        ));
    }

    public void practice16(Map<Integer, List<String>> map) {
        map.entrySet().stream().sorted(Comparator.comparingInt(e -> e.getValue().size()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> b, LinkedHashMap::new
                ));
    }

    public Map<Character, Set<String>> practice18() {
        List<String> words = List.of("apple",
                "ant", "alpha", "banana", "bat", "car", "cat");
        return words.stream().collect(Collectors.groupingBy(word -> word.charAt(0), Collectors.toCollection(TreeSet::new)
        ));
    }
}
