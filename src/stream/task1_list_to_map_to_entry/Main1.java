package stream.task1_list_to_map_to_entry;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main1 {

    public void practice1 () {
        List<String> words = List.of("stream", "code",
                "developer", "Engineer");

        String s = words.stream()
                .map(a-> Map.entry(a, a.length()))
                .reduce((a,b)->a.getValue() >= b.getValue() ? a : b)
                .map(Map.Entry::getKey).orElse("");
    }

    public void practice2 () {
        List<String> list = List.of("Java", "C",
                "Python", "Go", "Kotlin");
        String s = list.stream()
                .map(a-> Map.entry(a, a.length()))
                .reduce((a,b)->a.getValue() <= b.getValue() ? a : b)
                .map(Map.Entry::getKey).orElse("");
    }

    public void practice3 () {
        List<String> list = List.of("apple", "banana",
                "orange", "blueberry");
        String s = String.valueOf(list.stream().map(a-> Map.entry(a, a.chars().filter(ch->"aeiou".indexOf(ch) >=0).count()))
                .reduce((a,b)->a.getValue() >= b.getValue() ? a : b));
    }

    public void practice4 () {
        List<String> list = List.of("apple", "pear",
                "banana", "kiwi");
        String output = String.valueOf(list.stream()
                .map(a-> Map.entry(a, a
                        .chars()
                        .distinct()
                        .count()))
                .reduce((a,b)-> a
                        .getValue() > b.getValue() ? a :b));
    }

    public void practice5 () {
        List<String> list = List.of("cat", "tiger",
                "elephant", "dog");
        String s = String.valueOf(list.stream().filter(a->a.length() > 5).findFirst());
    }

    public void practice6 () {
        List<String> list = List.of("apple",
                "committee", "banana", "success");
                list.stream().map(word-> Map.entry(word, word.chars().mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(c->c, Collectors.counting()))
                .values().stream()
                .max(Long::compareTo)
                .orElse(0L)))
                        .max(Comparator.comparing(Map.Entry::getValue))
                        .map(Map.Entry::getKey)
                        .orElse("empty");
    }

    public String practice7 () {
        List<String> list = List.of("abc", "aaa", "zzz");

        return list.stream().map(word -> Map.entry(word, word.chars().sum()))
                .max(Comparator.comparingInt(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse("");
    }

    public String practice8 () {
        List <String> list = List.of ("alpha", "arena",
                "java", "banana", "lava");
        return list.stream()
                .map(word -> Map.entry(word, word
                        .chars()
                        .filter(c-> c == 'a')
                        .count()))
                .reduce((a,b)->a.getValue() >= b.getValue() ? a : b)
                .map(a->a.getKey()).orElse("");
    }

    public String practice9 () {
        List <String> list = List.of ("alpha", "arena",
                "java", "banana", "lava");
        return list.stream().filter(a->Character.isUpperCase(a.charAt(0))).map(word -> Map.entry(word, word.length())).reduce((a,b)-> a.getValue() >= b.getValue() ? a : b).map(entry->entry.getKey()).orElse("");
    }
}

