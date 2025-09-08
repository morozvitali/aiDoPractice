package stream.task17_collectors_15;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main19 {
    public void practice1 () {
        List<String> words = List.of("apple",
                "ant", "banana", "bat", "car");
        words.stream().collect(Collectors.groupingBy(w->w.charAt(0), Collectors.mapping(w->w.toUpperCase(), Collectors.toList())));
    }

    public Map<Character, Integer> practice2 () {
        List<String> words = List.of("apple", "ant",
                "banana", "bat", "car");
        return words.stream().collect(Collectors.toMap(w->w.charAt(0), String::length));
    }

    public void practice3 () {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        numbers.stream().collect(Collectors.partitioningBy(a->a%2==0, Collectors.counting()));
    }



}
