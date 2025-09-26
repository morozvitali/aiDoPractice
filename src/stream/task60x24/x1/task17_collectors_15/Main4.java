package stream.task60x24.x1.task17_collectors_15;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main4 {

    public String myCollectors () {
        List<String> names = List.of("Alice", "Bob", "Charlie");

        return names.stream()
                .collect(Collectors.joining(", "));
    }

    public void mySummarizing2 () {
        List<Integer> numbers = List.of(4, 8, 15, 16, 23, 42);
        IntSummaryStatistics stats = numbers.stream()
                .collect(Collectors.summarizingInt(value -> value));
        System.out.println(stats.getCount());
        System.out.println(stats.getSum());
        System.out.println(stats.getMax());
        System.out.println(stats.getAverage());
        System.out.println(stats.getMin());
    }

    public Map<Integer, List<String>> myCollectors3 () {
        List<String> words = List.of("hi", "book", "sun", "day", "Java", "sky");
        return words.stream().collect(Collectors.groupingBy(a->a.length()));
    }

    public Map <Integer, Long> myCollectors4 () {
        List<String> words = List.of("hi", "book", "sun", "day", "Java", "sky");
        return words.stream().collect(Collectors.groupingBy(a->a.length(), Collectors.counting()));
    }

    public Map<Boolean, List<Integer>> myCollectors5 () {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
                return numbers.stream().collect(Collectors.partitioningBy((a -> a%2 == 0)));
    }

    public Map<Character, List<String>> myCollectors6 () {
        List<String> words = List.of("apple", "ant", "banana", "bat", "car");
        return words.stream()
                .map(a->a.toUpperCase())
                .collect(Collectors.groupingBy(a->a.charAt(0)));
    }

    public static void main(String[] args) {
        Main4 main4 = new Main4();
        System.out.println(main4.myCollectors());
    }

}
