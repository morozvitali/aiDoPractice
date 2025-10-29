package stream1.task16_comparator_8;

import java.util.Comparator;
import java.util.List;

public class Main16 {
    public List <String> practice1 () {
        List<String> words = List.of("sky", "banana",
                "apple", "grape", "orange", "plum");
        return words.stream().sorted(Comparator.comparing(w->getCount(w))).toList();
    }

    public static long getCount (String s) {
        return s.chars().filter(c->"aeiou".indexOf(c)>=0).count();
    }

    public List<String> practice2 () {
        return List.of("alpha", "arena", "java", "banana", "lava").stream().sorted(Comparator.comparing(w->aCounter(w))).toList();
    }

    public static long aCounter (String s) {
        return s.chars().filter(c->c=='a').count();
    }



}
