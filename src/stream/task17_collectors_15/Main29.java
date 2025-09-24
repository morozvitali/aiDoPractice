package stream.task17_collectors_15;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main29 {
    public Map<Character, List<String>> practice1 () {
        return Stream.of("apple",
                "ant", "banana", "bat", "car").collect(Collectors.groupingBy(w->w.charAt(0), Collectors.mapping(w->w.toUpperCase(), Collectors.toList())));
    }

    public Map<Character, List<Integer>> practice2 () {
        List<String> words = List.of("apple", "ant",
                "banana", "bat", "car");
        return words.stream().collect(Collectors.groupingBy(w->w.charAt(0), Collectors.mapping(String::length, Collectors.toList())));
    }

}
