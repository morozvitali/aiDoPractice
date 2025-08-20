package stream.task17_collectors_18;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main10 {
    public IntSummaryStatistics practice2() {
        List<Integer> numbers = List.of(4, 8, 15, 16, 23, 42);
        return numbers.stream().mapToInt(i -> (int) i)
                .summaryStatistics();
    }

    public Map<Integer, Long> practice3() {
        return Stream.of("hi", "book",
                        "sun", "day", "Java", "sky")
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));
    }

    public Map<Boolean, List<Integer>> practice5() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        return numbers.stream().collect(Collectors.partitioningBy(a -> a % 2 == 0));
    }

    public Map<Character, List<String>> practice6() {
        List<String> words = List.of("apple",
                "ant", "banana", "bat", "car");
        return words.stream().collect(Collectors.groupingBy(word -> word.charAt(0),
                Collectors.mapping(String::toUpperCase,
                        Collectors.toList())));
    }

    public void practice7 () {
        List<String> words = List.of("apple", "ant",
                "banana", "bat", "car");
        words.stream().collect(Collectors.toMap(w->w.charAt(0), a->a.length()));
    }

    public Map <Boolean, Long> practice8 () {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        return numbers.stream().collect(Collectors.partitioningBy(a->a%2 ==0, Collectors.counting()));
    }

    public Map <Integer, Set<String>> practice9 () {
        List<String> words = List.of("hi", "hi",
                "book", "sun", "day", "Java", "sky");
        return words.stream().collect(Collectors.groupingBy(String::length, Collectors.toSet()));
    }

    public void practice10 () {
        List<Integer> numbers = List.of(4, 8, 15, 16, 23, 42);
        numbers.stream().collect(Collectors.collectingAndThen(Collectors.counting(), count -> "Count " + count));
    }

    public Map <Character, String> practice11 () {
        List<String> words = List.of("apple", "ant",
                "banana", "bat", "car");
        return words.stream().collect(Collectors.groupingBy(w->w.charAt(0), Collectors.joining()));
    }


}
