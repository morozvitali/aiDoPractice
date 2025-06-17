package stream.task17_collectors;

import java.util.*;
import java.util.stream.Collectors;

public class Main6 {
    public String practice1 () {
        List<String> names = List.of("Alice", "Bob", "Charlie");
        return names.stream().collect(Collectors.joining(", "));
    }

    public void practice2 () {
        List<Integer> numbers = List.of(4, 8, 15, 16, 23, 42);
        IntSummaryStatistics stats = numbers.stream().collect(Collectors.summarizingInt(value -> value));
        Integer count = Math.toIntExact(stats.getCount());
        Integer sum = Math.toIntExact(stats.getSum());
        Integer min = Math.toIntExact(stats.getMin());
        Integer max = Math.toIntExact(stats.getMax());
        Integer average = Math.toIntExact((long) stats.getAverage());
    }

    public Map<Integer, List <String>> practice3 () {
        List<String> words = List.of("hi", "book", "sun", "day", "Java", "sky");
        return words.stream().collect(Collectors.groupingBy(a->a.length()));
    }

    public Map <Integer, Long> practice4 () {
        List<String> words = List.of("hi", "book", "sun", "day", "Java", "sky");
        return words.stream().collect(Collectors.groupingBy(a->a.length(), Collectors.counting()));
    }

    public Map <Boolean, List<Integer>> practice5 () {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        return numbers.stream().collect(Collectors.groupingBy(a->a%2==0));
    }

    public Map <Character, List<String>> practice6 () {
        List<String> words = List.of("apple", "ant", "banana", "bat", "car");
        return words.stream().map(a->a.toUpperCase()).collect(Collectors.groupingBy(a->a.charAt(0)));
    }

    public Map <Character, List<Integer>> practice7 () {
        List<String> words = List.of("apple", "ant", "banana", "bat", "car");
        return words.stream().collect(Collectors
                .groupingBy(word->word.charAt(0), Collectors
                        .mapping(a->a.length(), Collectors.toList())));
    }

    public Map <Boolean, Long> practice8 () {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        return numbers.stream().collect(Collectors.partitioningBy((n-> n%2 == 0), Collectors.counting()));
    }

    public Map <Integer, Set<String>> practice9 () {
        List<String> words = List.of("hi", "hi", "book", "sun", "day", "Java", "sky");
        return words.stream().collect(Collectors.groupingBy(a->a.length(), Collectors.toSet()));
    }

    public String practice10 () {
        List<Integer> numbers = List.of(4, 8, 15, 16, 23, 42);
        return numbers.stream().collect(Collectors.collectingAndThen(Collectors.counting(), count -> "Count " + count));
    }

    public Map <Character, String> practice11 () {
        List<String> words = List.of("apple", "ant", "banana", "bat", "car");
        return words.stream()
                .collect(Collectors.groupingBy(a->a.charAt(0),
                        Collectors.joining(", ")));
    }

    public Map <Integer, Integer> practice12 () {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
     return numbers.stream()
             .collect(Collectors.groupingBy(a->a%3,
                     Collectors.reducing(0, Integer::sum)));
    }

    public Map <Integer, List <String>> practice13 () {
        List<String> words = List.of("hi", "book", "sun", "day", "Java", "sky");
        return words.stream().collect(Collectors.groupingBy(a->a.length(), TreeMap::new, Collectors.toList()));
    }



}





















