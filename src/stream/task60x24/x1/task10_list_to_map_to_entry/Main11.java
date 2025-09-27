package stream.task60x24.x1.task10_list_to_map_to_entry;

import java.util.List;
import java.util.Map;

public class Main11 {
    public String practice1() {
        List<String> words = List.of("stream", "code",
                "developer", "Engineer");
        return words
                .stream()
                .map(w -> Map.entry(w, w.length()))
                .reduce((a, b) -> a.getValue() > b.getValue() ? a : b)
                .map(Map.Entry::getKey)
                .orElse("");
    }

    public String practice2() {
        List<String> list = List.of("Java", "C",
                "Python", "Go", "Kotlin");
        return list.stream()
                .map(w -> Map.entry(w, w.length()))
                .reduce((a, b) -> a.getValue() < b.getValue() ? a : b)
                .map(Map.Entry::getKey)
                .orElse("");
    }

    public String practice3() {
        List<String> list = List.of("apple", "banana",
                "orange", "blueberry");
        return list.stream()
                .map(w -> Map.entry(w, getCount(w)))
                .reduce((a, b) -> a.getValue() > b.getValue() ? a : b)
                .map(Map.Entry::getKey)
                .orElse("");

    }

    public static long getCount(String s) {
        return s.chars()
                .filter(c -> "aeiuo".indexOf(c) >= 0)
                .count();
    }

    public String practice4() {
        List<String> list = List.of("apple", "pear",
                "banana", "kiwi");
        return list.stream().map(w -> Map.entry(w, w.chars().distinct().count()))
                .reduce((a, b) -> a.getValue() > b.getValue() ? a : b)
                .map(Map.Entry::getKey)
                .orElse("");
    }

    public String practice5() {
        List<String> list = List.of("apple",
                "committee", "banana", "success");
        return list.stream().map(w -> Map.entry(w, w.length() - w.chars().distinct().count()))
                .reduce((a, b) -> a.getValue() > b.getValue() ? a : b)
                .map(Map.Entry::getKey)
                .orElse("");
    }

    public String practice6() {
        List<String> list = List.of("abc", "aaa", "zzz");
        return list.stream().map(w -> Map.entry(w, w.chars().sum()))
                .reduce((a, b) -> a.getValue() > b.getValue() ? a : b)
                .map(Map.Entry::getKey)
                .orElse("");
    }

    public String practice7 () {
        return List.of("alpha", "arena",
                "java", "banana", "lava").stream().map(w->Map.entry(w, w.chars().filter(c->c=='a').count()))
                .reduce((a, b) -> a.getValue() > b.getValue() ? a : b)
                .map(Map.Entry::getKey)
                .orElse("");
    }


}
