package stream.task19_sorted;

import java.util.Comparator;
import java.util.List;

public class Main0 {
    public void practice1 () {
        List<String> words = List.of("sun", "banana", "kiwi",
                "cherry", "apple", "tea", "pear");
        words.stream().filter(a->a.length() >3)
                .sorted(Comparator.comparing(String::length)
                .thenComparing(Comparator.naturalOrder()));
    }



}
