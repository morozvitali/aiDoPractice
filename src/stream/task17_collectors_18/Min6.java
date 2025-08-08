package stream.task17_collectors_18;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
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

    public Map<Integer, List <String>> practice3 () {
        List<String> words = List.of("hi", "book",
                "sun", "day", "Java", "sky");
        return words.stream().collect(Collectors.groupingBy(String::length));
    }


    public Map <Integer, Long> practice4 () {
        List<String> words = List.of("hi", "book",
                "sun", "day", "Java", "sky");
        return words.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));
    }

    public Map <Boolean, List <Integer>> practice5 () {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        return numbers.stream().collect(Collectors.partitioningBy(value->value%2==0));
    }

    public Map <Character, List<String>> practice6 () {
        List<String> words = List.of("apple",
                "ant", "banana", "bat", "car");
        return words.stream().collect(Collectors.groupingBy(word->word.charAt(0), Collectors.mapping(word->word.toUpperCase(), Collectors.toList())));
    }

    public void practice7 () {

    }









}
