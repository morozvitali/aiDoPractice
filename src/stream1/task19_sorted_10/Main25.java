package stream1.task19_sorted_10;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main25 {
    public List<String> task1 () {
        return Stream.of("tea", "lemon",
                "fig", "grape", "banana").sorted(Comparator.comparing(String::length)).toList();
    }

    public List <Integer> task2 () {
        return Stream.of(3, 7, 1, 9, 2).sorted(Comparator.reverseOrder()).toList();
    }

    public List <Integer> task3 () {
        return List.of(3, 2, 5, 6, 1, 4).stream().sorted(Comparator.comparing((Integer a)->a%2).thenComparing(n->n)).collect(Collectors.toList());
    }

    public List <String> task4 () {
        List<String> words = List.of("kiwi", "apple",
                "banana", "grape", "plum");
        return words.stream().sorted(Comparator.comparing(w->w.charAt(w.length()-1))).toList();
    }


}
