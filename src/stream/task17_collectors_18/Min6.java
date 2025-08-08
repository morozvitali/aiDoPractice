package stream.task17_collectors_18;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Min6 {
    public String practice1 () {
        List<String> names = List.of("Alice", "Bob", "Charlie");
        return names.stream().collect(Collectors.joining(", "));
    }

    public IntSummaryStatistics practice2 () {
        List<Integer> numbers = List.of(4, 8, 15, 16, 23, 42);
        return numbers.stream().collect(Collectors.summarizingInt(value->value));
    }

    public void practice3 () {
        List<String> words = List.of("hi", "book",
                "sun", "day", "Java", "sky");


    }


}
