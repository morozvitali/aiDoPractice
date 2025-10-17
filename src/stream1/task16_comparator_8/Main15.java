package stream1.task16_comparator_8;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Main15 {
    public List <String> practice1 () {
        List<String> words = List.of("sky", "banana",
                "apple", "grape", "orange", "plum");
        return words.stream().sorted(Comparator.comparing(w->getCount(w))).toList();
    }

    public static long getCount(String s) {
        return s.chars().filter(c->"aeiou".indexOf(c)>=0).count();
    }

    public String practice2 () {
        return Stream.of("alpha", "arena", "java", "banana", "lava")
                .max(Comparator.comparing(w->w.chars().filter(c->c=='a').count()))
                .orElse("");
    }

    public Integer practice3 () {
        return Stream.of(111, 123, 444, 1212).map(n -> Map.entry(n,
                        (int) String.valueOf(n)
                                .chars()
                                .distinct()
                                .count()))
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).orElse(-1);
    }

    public String practice4 (List <String> list) {
        return list.stream().map(w->Map.entry(w, w.chars().sum())).max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("");
    }

}
