package stream.task17_collectors_18;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main10 {
    public IntSummaryStatistics practice2() {
        List<Integer> numbers = List.of(4, 8, 15, 16, 23, 42);
        return numbers.stream().mapToInt(i -> (int) i)
                .summaryStatistics();
    }

public Map<Integer, Long> practice3 () {
        return Stream.of("hi", "book",
                "sun", "day", "Java", "sky")
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));
}


}
