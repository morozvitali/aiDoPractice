package stream.task17_collectors_15;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main15 {
    public Map<Character, List <String>> practice() {
        List<String> words = List.of("apple",
                "ant", "banana", "bat", "car");
        return words.stream().collect(Collectors.groupingBy(w->w.charAt(0), Collectors.mapping(String::toUpperCase, Collectors.toList())));
    }

    public Map <Character, List <Integer>> practice2 () {
        List<String> words = List.of("apple", "ant",
                "banana", "bat", "car");
        return words.stream().collect(Collectors.groupingBy(w->w.charAt(0), Collectors.mapping(String::length, Collectors.toList())));
    }

    public void practice3 () {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        numbers.stream().collect(Collectors.groupingBy(n->n%2==0, Collectors.counting()));
    }


}
