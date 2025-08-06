package stream.task7_comparator_8;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Main1 {
    public void practice1() {
        List<String> words = List.of("sky", "banana",
                "apple", "grape", "orange", "plum");
        words.stream().sorted(Comparator.comparing((String s) -> s.chars().filter(ch -> "aeiou".indexOf(ch) >= 0).count()).thenComparing(Comparator.naturalOrder())).forEach(System.out::println);
    }

    public void practice2() {
        List.of("alpha", "arena", "java", "banana", "lava").stream()
                .map(w -> Map.entry(w, countOf(w, 'a')))
                .max(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse("empty");
    }

    public long countOf(String s, char ch) {
        return s.chars().filter(a -> "aeiou".indexOf(ch) >= 0).count();
    }

    public void practice3() {
        List.of(111, 123, 444, 1212).stream().map(n -> Map.entry(n, (int) String.valueOf(n)
                        .chars()
                        .distinct()
                        .count()))
                .max(Map.Entry.comparingByValue()).get().getKey();
    }

    public void practice4() {
        List.of("abc", "aaa", "zzz").stream()
                .map(a -> Map.entry(a, a.chars().sum()))
                .max(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse("нема");
    }


}
