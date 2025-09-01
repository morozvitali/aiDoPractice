package stream.task19_sorted_10;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main12 {
    public List<String> practice1() {
        return Stream.of("tea", "lemon",
                        "fig", "grape", "banana")
                .filter(s -> s.length() > 3)
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public List<Integer> practice3() {
        return Stream.of(3, 7, 1, 9, 2).sorted(Comparator.reverseOrder()).toList();
    }



}

