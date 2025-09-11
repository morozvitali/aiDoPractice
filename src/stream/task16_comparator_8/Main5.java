package stream.task16_comparator_8;

import java.util.Comparator;
import java.util.List;

public class Main5 {
    public List <String> practice1 () {
        List<String> words = List.of("sky", "banana",
                "apple", "grape", "orange", "plum");
        return words.stream().sorted(Comparator.comparing(w->w.chars().filter(c->"aeiou".indexOf(c)>=0).count())).toList();
    }



}
