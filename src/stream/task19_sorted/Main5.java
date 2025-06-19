package stream.task19_sorted;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main5 {
    public List <String> practice1 () {

        List<String> words = List.of("sun", "banana", "kiwi",
                "cherry", "apple", "tea", "pear");

        return words.stream().filter(w->w.length() > 3).sorted(Comparator.comparing(String::length)
                .thenComparing(Comparator.naturalOrder())).collect(Collectors.toList());
    }
}
