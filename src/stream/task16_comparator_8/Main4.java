package stream.task16_comparator_8;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main4 {
    public void practice1 () {
        List<String> words = List.of("sky", "banana",
                "apple", "grape", "orange", "plum");
        words.stream().sorted(Comparator.comparing(Main4::getCount)).toList();
    }
    public static long getCount (String s) {
        return s.chars()
                .filter(c->"aeiou".indexOf(c)>=0)
                .count();
    }

    public String practce2 () {
        return Stream.of("alpha", "arena", "java", "banana", "lava").filter(w->getCharCount(w) >0).max(Comparator.comparingLong(Main4::getCharCount)).orElse("");
    }

    public static long getCharCount (String s) {
        return s.chars().filter(c->c=='a').count();
    }
}
