package stream1.task16_comparator_8;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Main17 {
    public List<String> task1 () {
        List<String> words = List.of("sky", "banana",
                "apple", "grape", "orange", "plum");
        return words.stream().sorted(Comparator.comparing(w->countWovels(w))).sorted(Comparator.naturalOrder()).toList();
    }

    public long countWovels (String s) {
        return s.chars().filter(c->"aeiuo".indexOf(c)>=0).count();
    }

    public String task2 () {
        return List.of("alpha", "arena", "java", "banana", "lava").stream()
                .map(w-> Map.entry(w, countLetter(w)))
                .max(Comparator.comparingLong(Map.Entry::getValue)).map(Map.Entry::getKey).orElse("");
    }

    public static long countLetter (String s) {
        return s.chars().filter(c->c=='a').count();
    }

}
