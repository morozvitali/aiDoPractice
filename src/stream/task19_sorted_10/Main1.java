package stream.task19_sorted_10;

import java.util.Comparator;
import java.util.List;

public class Main1 {
    public void practice0 () {
        List<String> words = List.of("sun", "banana", "kiwi",
                "cherry", "apple", "tea", "pear");
        words.stream().filter(val -> val.length() > 3)
                .sorted(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()).thenComparing(Comparator.reverseOrder())).toList();
    }

    public void practice1 () {
        List<String> words = List.of("tea", "lemon", "fig", "grape", "banana");
        words.stream().filter(w->w.length() >3).sorted(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()));
    }





}
