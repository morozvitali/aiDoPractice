package stream.task19_sorted_10;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main2 {
    public void practice1 (){
        List<String> words = List.of("tea", "lemon", "fig", "grape", "banana");
        words.stream().filter(a->a.length() > 3)
                .sorted(Comparator.comparing(String::length));
    }

    public List <String> practice2 () {
        List<String> words = List.of("Zebra", "apple", "Lemon", "banana");
        return words.stream().map(String::toLowerCase)
                .sorted()
                .collect(Collectors.toList());
    }

    public void practice3
}
