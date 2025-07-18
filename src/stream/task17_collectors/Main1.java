package stream.task17_collectors;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
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




}
