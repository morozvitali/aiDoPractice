package stream1.task10_list_to_map_to_entry;

import java.util.List;
import java.util.Map;

public class Main12 {
    public String task1() {
        List<String> words = List.of("stream1", "code",
                "developer", "Engineer");
        return words.stream().map(w -> Map.entry(w, w.length()))
                .reduce((a, b) -> a.getValue() >= b.getValue() ? a : b)
                .map(Map.Entry::getKey).orElse("");
    }

    public String task2() {
        List<String> words = List.of("stream1", "code",
                "developer", "Engineer");
        return words.stream().map(w -> Map.entry(w, w.length()))
                .reduce((a, b) -> a.getValue() < b.getValue() ? a : b)
                .map(Map.Entry::getKey)
                .orElse("");
    }

    public String task3() {
        List<String> list = List.of("apple", "banana",
                "orange", "blueberry");
        return list.stream().map(w -> Map.entry(w, countWovels(w)))
                .reduce((a, b) -> a.getValue() > b.getValue() ? a : b)
                .map(Map.Entry::getKey).orElse("");
    }

    public long countWovels(String s) {
        return s.chars().filter(c -> "aeiou".indexOf(c) >= 0).count();
    }

    public String task4 () {
        List<String> list = List.of("apple", "pear",
                "banana", "kiwi");
        return list.stream().map(w->Map.entry(w, getCount(w)))
                .reduce((a,b)->a.getValue() > b.getValue() ? a : b)
                .map(Map.Entry::getKey).orElse("");
    }

    public long getCount(String s) {
        return s.length() - s.chars().distinct().count();
    }

}
