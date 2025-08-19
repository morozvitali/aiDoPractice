package stream.task19_sorted_10;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main6 {
    public void practice1 () {
        List<String> words = List.of("sun", "banana", "kiwi",
                "cherry", "apple", "tea", "pear");
        words.stream().filter(v->v.length() > 3)
                .sorted(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()))
                .collect(Collectors.toList());
    }

    public void practice2 () {
        Stream.of("apple", "banana", "lemon", "zebra")
                .map(String::toLowerCase)
                .sorted()
                .collect(Collectors.toList());
    }

    public List <Integer> practice3 () {
        List<Integer> numbers = List.of(3, 7, 1, 9, 2);
        return numbers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public List <Integer> practice5 () {
        List<Integer> numbers = List.of(3, 2, 5, 6, 4, 1);
        return numbers.stream().sorted(Comparator.comparingInt((Integer n) -> n%2).thenComparing(Comparator.reverseOrder())).collect(Collectors.toList());
    }

    public List <String> practice6 () {
        List<String> words = List.of("kiwi", "apple", "banana", "grape", "plum");
        return words.stream().filter(w->w.length() > 4).sorted(Comparator.comparing(w->w.charAt(w.length()-1))).collect(Collectors.toList());
    }

}
