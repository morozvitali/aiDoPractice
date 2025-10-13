package stream1.task19_sorted_10;

import java.util.Comparator;
import java.util.List;

public class Main13 {
    public List<String> practice1() {
        List<String> words = List.of("tea", "lemon",
                "fig", "grape", "banana");
        return words.stream().filter(w -> w.length() > 3).sorted(Comparator.comparing(String::length)).toList();
    }

    public List<Integer> practice2() {
        List<Integer> numbers = List.of(3, 7, 1, 9, 2);
        return numbers.stream().sorted(Comparator.reverseOrder()).toList();
    }

    public List<Integer> practice5 () {
        List<Integer> nums = List.of(3, 2, 5, 6, 1, 4);
        return nums.stream().sorted(Comparator.comparing(v->(int)v%2).thenComparing(n->(int)n)).toList();
    }

    public List<String> practice6 () {
        List<String> words = List.of("kiwi", "apple",
                "banana", "grape", "plum");
        return words.stream().sorted(Comparator.comparing(w->w.charAt(w.length()-1))).toList();
    }
}
