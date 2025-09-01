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

    public List <Integer> practice5 () {
        List<Integer> nums = List.of(3, 2, 5, 6, 1, 4);

        return nums.stream().sorted(Comparator.comparing(n->(int)n%2).thenComparingInt(n->(int)n)).toList();
    }

    public List <String> practice6 () {
        List<String> words = List.of("kiwi", "apple",
                "banana", "grape", "plum");
        return words.stream().sorted(Comparator.comparing(w->w.charAt(w.length()-1))).toList();
    }

    public List <String> practice7 () {
        List<String> words = List.of("apple",
                "banana", "cherry", "kiwi", "grape");
        return words.stream().sorted(Comparator.comparing((String w)->w.chars().filter(c->"aeiou".indexOf(c)>=0).count()).thenComparing(Comparator.naturalOrder())).toList();
    }

    public List <String> practice8 () {
        List<String> words = List.of("tea", "watermelon",
                "apple", "pear", "banana");
        return words.stream().sorted(Comparator.comparing(String::length).reversed())
                .toList();
    }

}

