package stream.task17_collectors_15;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main30 {
    public Map<Character, List<String>> practice1 () {
        List<String> words = List.of("apple",
                "ant", "banana", "bat", "car");
        return words.stream().collect(Collectors.groupingBy(w->w.charAt(0), Collectors.mapping(w->w.toUpperCase(), Collectors.toList())));
    }

    public Map<Character, Integer> practice2 () {
        List<String> words = List.of("apple", "ant",
                "banana", "bat", "car");
        return words.stream().collect(Collectors
                .toMap(a->a.charAt(0),
                        String::length));
    }

    public Map<Boolean, Long> practice3 () {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        return numbers.stream().collect(Collectors.groupingBy(a->a%2==0, Collectors.counting()));
    }

    public Map <Integer, Set<String>> practice4 () {
        List<String> words = List.of("hi", "hi",
                "book", "sun", "day", "Java", "sky");
        return words.stream().collect(Collectors.groupingBy(String::length, Collectors.toSet()));
    }

}
