package stream.task17_collectors;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main3 {
        public String myJoining () {
            List<String> names = List.of("Alice", "Bob", "Charlie");
            return names.stream().collect(Collectors.joining(", "));
        }

        public void mySummarizing () {
            List<Integer> numbers = List.of(4, 8, 15, 16, 23, 42);

            IntSummaryStatistics stats = numbers.stream()
                    .collect(Collectors.summarizingInt(value -> value));

            System.out.println("count = " + stats.getCount());
            System.out.println("sum = " + stats.getSum());
            System.out.println("min = " + stats.getMin());
            System.out.println("max = " + stats.getMax());
            System.out.println("average = " + stats.getAverage());
        }

        public Map<Integer, List<String>> myGrouping () {
            List<String> words = List.of("hi", "book", "sun", "day", "Java", "sky");
            return words.stream().collect(Collectors.groupingBy(a->a.length()));
        }

        // public Map <Integer, Integer> myGroupCounting() {
        // }
}
