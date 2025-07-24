package stream.task1_comparator;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Main0 {

    public void practice1 () {
        List<String> words = List.of("sky", "banana",
                "apple", "grape", "orange", "plum");

        words.stream()
                .sorted(Comparator.comparing((String word) -> word.chars()
                        .filter(ch -> "aeiou".indexOf(ch) >=0).count())
                        .thenComparing(Comparator.naturalOrder()))
                .forEach(System.out::println);
    }

    public void practice2 () {
        List.of("alpha", "arena", "java", "banana", "lava").stream().map(w-> Map.entry(w, w.chars().filter(c-> c=='a').count()))
                .max(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse("Empty");
    }

    public void practice3 () {
        List.of(111, 123, 444, 1212).stream().map(n -> Map.entry(n, (int) String.valueOf(n).chars().distinct().count()))
                .max(Map.Entry.comparingByValue())
                .get().getKey();
    }



}
