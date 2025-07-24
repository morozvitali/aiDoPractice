package stream.task1_comparator;

import java.util.Comparator;
import java.util.List;

public class Main0 {

    public void practice1 () {
        List<String> words = List.of("sky", "banana",
                "apple", "grape", "orange", "plum");

        words.stream()
                .sorted(Comparator.comparing((String word) -> word.chars()
                        .filter(ch -> "aeiou".indexOf(ch) >=0).count())
                        .thenComparing(Comparator.naturalOrder()))
                .forEach(System.out::println);
    }


}
