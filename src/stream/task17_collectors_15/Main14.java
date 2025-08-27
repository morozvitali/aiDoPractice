package stream.task17_collectors_15;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main14 {

    public Map<Character, List <String>> practice1 () {
        List<String> words = List.of("apple",
                "ant", "banana", "bat", "car");
        return words.stream().collect(Collectors.groupingBy(w->w.charAt(0), Collectors.mapping(w->w.toUpperCase(), Collectors.toList())));
    }

    public Map <Character, List <Integer>> practice2 () {
        List<String> words = List.of("apple", "ant",
                "banana", "bat", "car");
        return words.stream().collect(Collectors.groupingBy(w->w.charAt(0), Collectors.mapping((String::length), Collectors.toList())));
    }

    public Map <Boolean, Long> practice3 () {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        return numbers.stream().collect(Collectors.partitioningBy(a->a%2==0, Collectors.counting()));
    }

    public Map <Integer, Set<String>> practice4 () {
        List<String> words = List.of("hi", "hi",
                "book", "sun", "day", "Java", "sky");
        return words.stream().collect(Collectors.groupingBy(String::length, Collectors.toSet()));
    }

    public String practice5 () {
        List<Integer> numbers = List.of(4, 8,
                15, 16, 23, 42);
        return numbers.stream().collect(Collectors.collectingAndThen(Collectors.counting(), count -> "Count " + count));
    }

    public void practice6 () {

    }

}
