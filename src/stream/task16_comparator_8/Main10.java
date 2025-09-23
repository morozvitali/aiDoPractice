package stream.task16_comparator_8;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main10 {
    public List <String> practice1 () {
        List<String> words = List.of("sky", "banana",
                "apple", "grape", "orange", "plum");
        return words.stream().sorted(Comparator.comparing(Main10::count).thenComparing(Comparator.naturalOrder())).toList();
    }

    public static long count (String s) {
        return s.chars().filter(c->"aeiou".indexOf(c)>=0).count();
    }

    public String practice2 () {
        return Stream.of("alpha", "arena", "java", "banana", "lava").map(w-> Map.entry(w, countA(w))).max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("");
    }

    public static long countA (String s) {
    return s.chars().filter(c->c=='a').count();
    }

    public Integer practice3 () {
        return Stream.of(111, 123, 444, 1212).map(n->Map.entry(n, (int)String.valueOf(n).chars()
                .distinct().count())).max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(-1);
    }

}
