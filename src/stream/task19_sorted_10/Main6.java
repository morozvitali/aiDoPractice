package stream.task19_sorted_10;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main6 {
    public void practice1 () {
        List<String> words = List.of("sun", "banana", "kiwi",
                "cherry", "apple", "tea", "pear");
        words.stream().filter(v->v.length() > 3)
                .sorted(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()))
                .collect(Collectors.toList());
    }



}
