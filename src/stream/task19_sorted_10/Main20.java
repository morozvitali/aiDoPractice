package stream.task19_sorted_10;

import java.util.Comparator;
import java.util.List;

public class Main20 {
    public List <String> practice1 () {
        List<String> words = List.of("tea", "lemon",
                "fig", "grape", "banana");
        return words.stream().sorted(Comparator.comparing(String::length)).toList();
    }

}
