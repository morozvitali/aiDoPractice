package stream.task17_collectors;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
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

}
