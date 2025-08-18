package stream.task17_collectors_18;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main8 {
    public Double practice1 () {
        List<Integer> numbers = List.of(4, 8, 15, 16, 23, 42);
        return numbers.stream().mapToInt(a->(int)a)
                .summaryStatistics().getAverage();
    }

    public Long practice2 () {
        List<Integer> numbers = List.of(4, 8, 15, 16, 23, 42);
        return numbers.stream().mapToInt(a->a).summaryStatistics().getCount();
    }

    public Map<Integer, List <String>> practice3 () {
        List<String> words = List.of("hi", "book",
                "sun", "day", "Java", "sky");
        return words.stream().collect(Collectors.groupingBy(String::length));
    }

    public Map <Integer, Long> practice4 () {
        List<String> words = List.of("hi", "book",
                "sun", "day", "Java", "sky");
        return words.stream().collect(Collectors.groupingBy(String::length, Collectors.counting()));
    }

    public Map <Boolean, List <Integer>> practice5 () {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        return numbers.stream().collect(Collectors.partitioningBy(v->v%2==0));
    }

    public Map <Character, List<String>> practice6 () {
        List<String> words = List.of("apple",
                "ant", "banana", "bat", "car");
        return words.stream().collect(Collectors.groupingBy(value-> value.charAt(0), Collectors.mapping(w->w.toUpperCase(), Collectors.toList())));
    }

public Map <Character, List <Integer>> practice7 () {
    List<String> words = List.of("apple", "ant",
            "banana", "bat", "car");
    return words.stream().collect(Collectors.groupingBy(w->w.charAt(0), Collectors.mapping(String::length, Collectors.toList())));
}


}
