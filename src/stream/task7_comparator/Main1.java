package stream.task7_comparator;

import java.util.Comparator;
import java.util.List;

public class Main1 {
    public void practice1 () {
        List<String> words = List.of("sky", "banana",
                "apple", "grape", "orange", "plum");
        words.stream().sorted(Comparator.comparing((String s) -> s.chars().filter(ch-> "aeiou".indexOf(ch) >= 0).count()).thenComparing(Comparator.naturalOrder())).forEach(System.out::println);
    }



}
