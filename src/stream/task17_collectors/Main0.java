package stream.task17_collectors;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main0 {
    public void practice1 () {
        List<String> names = List.of("Alice", "Bob", "Charlie");
        names.stream().collect(Collectors.joining(", "));
    }


    public void practice2 () {
        List<Integer> numbers = List.of(4, 8, 15, 16, 23, 42);
        IntSummaryStatistics stats = numbers
                .stream()
                .collect(Collectors
                        .summarizingInt(value->value));

        Integer max = stats.getMax();
        Integer sum = Math.toIntExact(stats.getSum());
        Integer min = stats.getMin();
        Integer count = Math.toIntExact(stats.getCount());
        Double average = stats.getAverage();
    }

    public Map<Integer, List <String>> practice3 () {
        List<String> words = List.of("hi", "book",
                "sun", "day", "Java", "sky");
        return words.stream().collect(Collectors.groupingBy(String::length));
    }

    public Map <Integer, Long> practice4 () {
        List<String> words = List.of("hi", "book",
                "sun", "day", "Java", "sky");
        return words.stream()
                .collect(Collectors
                        .groupingBy (a->a.length(),
                                Collectors.counting()));
    }



}
