package stream.task17_collectors;

import java.util.*;
import java.util.stream.Collectors;

public class Main1 {
    public String practice1 () {
        List<String> names = List.of("Alice", "Bob", "Charlie");
    return names.stream().collect(Collectors.joining(", "));
    }

    public void practice2 () {
        List<Integer> numbers = List.of(4, 8, 15, 16, 23, 42);
        IntSummaryStatistics stats = numbers.stream()
                .collect(Collectors
                        .summarizingInt(value -> value));

        System.out.println(stats.getAverage());
        System.out.println(stats.getSum());
        System.out.println(stats.getMin());
        System.out.println(stats.getMax());
    }

    public Map<Integer, List<String>> practice3 () {
        List<String> words = List.of("hi", "book",
                "sun", "day", "Java", "sky");
        return words.stream().collect(Collectors.groupingBy(a->a.length()));
    }

    public Map <Integer, Long> practice4 () {
        List<String> words = List.of("hi", "book",
                "sun", "day", "Java", "sky");
        return words.stream().collect(Collectors.groupingBy(a->a.length(), Collectors.counting()));
    }

    public Map<Boolean, List<Integer>> practice5 () {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        return numbers.stream().collect(Collectors.partitioningBy(a->a%2 == 0));
    }

    public Map <Character, List <String>> practice6 () {
        List<String> words = List.of("apple",
                "ant", "banana", "bat", "car");
        return words.stream().map(a-> a.toUpperCase())
                .collect(Collectors
                        .groupingBy(a->a
                                .charAt(0)));
    }

    public Map<Character, List<Integer>> practice7 () {
        List<String> words = List.of("apple", "ant",
                "banana", "bat", "car");
        return words.stream().collect(Collectors.groupingBy(word->word.charAt(0),
                Collectors.mapping(word->word.length(), Collectors.toList())));
    }

    public Map <Boolean, Long> practice8 () {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        return numbers.stream().collect(Collectors.partitioningBy(a->a%2==0, Collectors.counting()));
    }

    public Map <Integer, Set<String>> practice9 () {
        List<String> words = List.of("hi", "hi",
                "book", "sun", "day", "Java", "sky");
        return words.stream().collect(Collectors.groupingBy(a->a.length(), Collectors.toSet()));
    }

    public String practice10 () {
        List<Integer> numbers = List.of(4, 8,
                15, 16, 23, 42);
        return numbers.stream().collect(Collectors.collectingAndThen(Collectors.counting(), count -> "Count " + count));
    }

    public Map<Character, String> practice11 () {
        List<String> words = List.of("apple",
                "ant", "banana", "bat", "car");
        return words.stream()
                .collect(Collectors
                        .groupingBy(a->a.charAt(0),
                                Collectors.joining(", ")));
    }

    public Map <Integer, Integer> practice12 () {
        List<Integer> numbers = List.of(1, 2, 3, 4,
                5, 6, 7, 8, 9);
        return numbers.stream().collect(Collectors.groupingBy(n -> n % 3, Collectors.reducing(0, Integer::sum)));
    }

    public String practice13 () {
        List<String> words = List.of("hi", "book",
                "sun", "day", "Java", "sky");
        return words.stream()
                .collect(Collectors.reducing("", (a,b) -> a.length() >=b.length() ? a : b));
    }

    public Map <Character, List<String>> practice14 () {
        List<String> words = List.of("apple", "ant",
                "alphabet", "axe", "banana", "bat");
        return words.stream().collect(Collectors.groupingBy(a->a.charAt(0), Collectors.collectingAndThen(Collectors.toList(), list -> list.stream().sorted(Comparator.comparingInt(String::length)).toList())));
    }

}
