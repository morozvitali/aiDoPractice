package stream.task17_collectors_18;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main9 {
    public IntSummaryStatistics practice2() {
        List<Integer> numbers = List.of(4, 8, 15, 16, 23, 42);
        return numbers.stream().mapToInt(i -> (int) i).summaryStatistics();
    }

    public Map<Integer, List<String>> practice3() {
        List<String> words = List.of("hi", "book",
                "sun", "day", "Java", "sky");
        return words.stream().collect(Collectors.groupingBy(String::length));
    }

    public void practice4 () {

    }
}
