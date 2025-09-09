package stream.task16_comparator_8;

import java.util.Comparator;
import java.util.List;

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



}
