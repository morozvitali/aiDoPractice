package stream1.task19_sorted_10;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main25 {
    public List<String> task1 () {
        return Stream.of("tea", "lemon",
                "fig", "grape", "banana").sorted(Comparator.comparing(String::length)).toList();
    }




}
