package stream.task16_comparator_8;

import java.util.Comparator;
import java.util.List;

public class Main8 {

    public List <String> practice1 () {

        List<String> words = List.of("sky", "banana",
                "apple", "grape", "orange", "plum");
        return words.stream().sorted(Comparator.comparing(Main8::countVowels).thenComparing(Comparator.naturalOrder())).toList();
    }

    public static long countVowels (String s) {
        s.chars().filter(c-> "aeiou".indexOf(c)>=0).count();
    }
}
