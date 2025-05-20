package stream.task17_collectors;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main5 {
    public String joining () {
        List<String> names = List.of("Alice", "Bob", "Charlie");
        return names.stream().reduce((a,b) -> a + ", " + b).orElse("");
    }

    public void summarising () {
        List<Integer> numbers = List.of(4, 8, 15, 16, 23, 42);
        IntSummaryStatistics stats = numbers.stream().collect(Collectors.summarizingInt(value->value));
        System.out.println("count " + stats.getCount());
        System.out.println("sum " + stats.getSum());
        System.out.println("max " + stats.getMax());
        System.out.println("average " + stats.getAverage());
        System.out.println("minimum " + stats.getMin());
    }

    public Map<Integer, List <String>> grouping () {
        List<String> words = List.of("hi", "book", "sun", "day", "Java", "sky");
        return words.stream().collect(Collectors.groupingBy(a->a.length()));
    }

    public Map <Integer, Long> grouping2 () {
        List<String> words = List.of("hi", "book", "sun", "day", "Java", "sky");
        return words.stream().collect(Collectors.groupingBy(a->a.length(), Collectors.counting()));
    }


}
