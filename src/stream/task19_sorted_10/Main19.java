package stream.task19_sorted_10;

import java.util.Comparator;
import java.util.List;

public class Main19 {
    public List<String> practice1 () {
        List<String> words = List.of("tea", "lemon",
                "fig", "grape", "banana");
        return words.stream().filter(w->w.length()%3==0)
                .sorted(Comparator.comparing(String::length)).toList()
    }



}
