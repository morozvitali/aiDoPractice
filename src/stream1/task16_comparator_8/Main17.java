package stream1.task16_comparator_8;

import java.util.Comparator;
import java.util.List;

public class Main17 {
    public List<String> task1 () {
        List<String> words = List.of("sky", "banana",
                "apple", "grape", "orange", "plum");
        return words.stream().sorted(Comparator.comparing(w->countWovels(w))).toList();
    }

    public long countWovels (String s) {
        return s.chars().filter(c->"aeiuo".indexOf(c)>=0).count();
    }



}
