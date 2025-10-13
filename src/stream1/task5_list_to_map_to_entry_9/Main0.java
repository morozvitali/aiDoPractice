package stream1.task5_list_to_map_to_entry_9;

import java.util.List;
import java.util.Map;

public class Main0 {
    public String practice1() {
        List<String> words = List.of("stream1", "code",
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

    public String practice2 () {
        List<String> list = List.of("Java", "C",
                "Python", "Go", "Kotlin");
        return list.stream()
                .map(w->Map.entry(w,w.length()))
                .reduce((a,b)-> a.getValue() < b.getValue() ? a:b).map(Map.Entry::getKey).orElse("немає");
    }

    public String practice4 () {
        List<String> list = List.of("apple", "pear",
                "banana", "kiwi");
        return list.stream().map(w->Map.entry(w, w.chars().distinct().count()))
                .reduce((a,b) -> a.getValue() > b.getValue() ? a:b)
                .map(Map.Entry::getKey).orElse("empty");
    }

    public String practice5 () {
        List<String> list = List.of("cat", "tiger", "elephant", "dog");
        return list.stream()
                .filter (w->w.length() > 5)
                .map(w->Map.entry(w,w.length()))
                .findFirst().map(Map.Entry::getKey).orElse("немає");
    }

    public void practice6 () {
        List<String> list = List.of("apple", "committee",
                "banana", "success");
        list.stream()
                .map(w->Map
                        .entry(w, w
                                .chars()
                                .distinct()
                                .count()))
                .reduce((a,b)->a.getValue() > b.getValue() ? a : b)
                .map(Map.Entry::getKey);
    }

    public String practice7 () {
        List <String> list = List.of("abc", "aaa", "zzz");
                return list.stream()
                        .map(w->Map.entry(w,w.chars().sum()))
                        .reduce((a,b)-> a.getValue() > b.getValue() ? a : b).map(Map.Entry::getKey).orElse("empty");
    }

    public String practice8 () {
        List<String> list = List.of("zebra",
                "apple", "mango", "banana");
        return list.stream().map(w->Map.entry(w, w.chars().filter(c->c=='a').count()))
                .reduce((a,b)->a.getValue() > b.getValue() ? a : b)
                .map(Map.Entry::getKey)
                .orElse("empty");
    }

    public String practice9 () {
        return List.of("apple", "Tree", "Java", "stream1", "Engineer")
                .stream().filter(w->Character.isUpperCase(w.charAt(0)))
                .map(w->Map.entry(w,w.length()))
                .reduce((a,b)-> a.getValue() > b.getValue() ? a : b)
                .map(Map.Entry::getKey).orElse("empty");
    }
}
