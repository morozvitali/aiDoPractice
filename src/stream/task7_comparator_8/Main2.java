package stream.task7_comparator_8;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main2 {
    public List<String> practice1 () {
        return Stream.of("sky", "banana",
                "apple", "grape", "orange", "plum").sorted(Comparator.comparing(w->countVowels(w))).collect(Collectors.toList());
    }
    public long countVowels (String s) {
        return s.chars().filter(c->"aeiou".indexOf(c) >= 0).count();
    }

}
