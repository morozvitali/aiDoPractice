package stream.task1_list_to_map_to_entry;

import java.util.List;
import java.util.Map;

public class Main0 {
    public String practice1() {
        List<String> words = List.of("stream", "code",
                "developer", "Engineer");
        return words.stream()
                .map(w -> Map.entry(w, w.length()))
                .reduce((a, b) -> a.getValue() >= b.getValue() ? a : b)
                .map(Map.Entry::getKey).orElse("немає");
    }

    public String practice3() {
        List<String> list = List.of("Java", "C",
                "Python", "Go", "Kotlin");

        return list.stream().map(w -> Map.entry(w, w.chars().filter(c -> "aeiou".indexOf(c) >= 0).count()))
                .reduce((a, b) -> a.getValue() > b.getValue() ? a : b)
                .map(Map.Entry::getKey).orElse("Немає");
    }




















}
