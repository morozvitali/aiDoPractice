package stream.task17_collectors_15_firstMaking;

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

         public Map <Integer, Long> myGroupCounting() {
            List<String> words = List.of("hi", "book", "sun", "day", "Java", "sky");
            return words.stream().collect(Collectors.groupingBy(a->a.length(),
                    Collectors.counting()));
         }

         public Map <Boolean, List <Integer>> myGrouping5 () {
             List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
             return numbers.stream().collect(Collectors.partitioningBy((a-> a%2 == 0)));
         }

        public Map <Character, List <String>> myGrouping6 () {
            List<String> words = List.of("apple", "ant", "banana", "bat", "car");
            return words.stream().collect(Collectors.groupingBy(
                    a->a.charAt(0),
                    Collectors.mapping(a->a.toUpperCase(), Collectors.toList())
            ));
        }
}
