package stream1.task10_list_to_map_to_entry;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Main3 {
    public String practice1() {
        List<String> words = List.of("stream1", "code",
                "developer", "Engineer");
        return words.stream().map(w -> Map.entry(w, w.length()))
                .reduce((a, b) -> a.getValue() > b.getValue() ? a : b)
                .map(Map.Entry::getKey).orElse("");
    }


    public String practice2() {
        List<String> words = List.of("stream1", "code",
                "developer", "Engineer");
        return words.stream().map(w -> Map.entry(w, w.length()))
                .reduce((a, b) -> a.getValue() < b.getValue() ? a : b)
                .map(Map.Entry::getKey).orElse("empty");
    }

    public String practice3() {
        List<String> list = List.of("Java", "C",
                "Python", "Go", "Kotlin");
        return list.stream().map(w -> Map.entry(w, countVowels(w)))
                .reduce((a, b) -> a.getValue() < b.getValue() ? a : b)
                .map(Map.Entry::getKey).orElse("empty");
    }

    public long countVowels(String s) {
        return s.chars().map(c -> (char) c).filter(c -> "aeiou".indexOf(c) >= 0).count();
    }

    public String practice4() {
        List<String> list = List.of("apple", "pear",
                "banana", "kiwi");
        return list.stream().map(w -> Map.entry(w, w.chars().distinct().count()))
                .reduce((a, b) -> a.getValue() > b.getValue() ? a : b)
                .map(Map.Entry::getKey).orElse("empty");
    }

    public String practice5() {
        List<String> list = List.of("apple",
                "committee", "banana", "success");
        return list.stream().map(w -> Map.entry(w, w.length() - w.chars().distinct().count()))
                .reduce((a, b) -> a.getValue() > b.getValue() ? a : b)
                .map(Map.Entry::getKey).orElse("");
    }

    public void practice6() {
        Stream.of("abc", "aaa", "zzz").map(w -> Map.entry(w, w.chars().sum()))
                .reduce((a, b) -> a.getValue() > b.getValue() ? a : b)
                .map(Map.Entry::getKey).orElse("");
    }

    public String practice7 () {
        return Stream.of("alpha", "arena",
                "java", "banana", "lava").map(w->Map.entry(w, w.chars().filter(c->c=='a').count()))
                .reduce((a,b) -> a.getValue() > b.getValue() ? a : b)
                .map(Map.Entry::getKey).orElse("");
    }

    public String practice8 () {
        return Stream.of("apple", "Tree",
                "Java", "stream1", "Engineer").filter(w->Character.isUpperCase(w.charAt(0))).map(w->Map.entry(w,w.length()))
                .reduce((a,b) -> a.getValue() > b.getValue() ? a:b)
                .map(Map.Entry::getKey).orElse("");
    }

}
