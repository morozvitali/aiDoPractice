package stream1.task19_sorted_10;

import java.util.Comparator;
import java.util.List;

public class Main19 {
    public List<String> practice1() {
        List<String> words = List.of("tea", "lemon",
                "fig", "grape", "banana");
        return words.stream().filter(w -> w.length() % 3 == 0)
                .sorted(Comparator.comparing(String::length)).toList();
    }

    public List<String> practice2() {
        List<String> words = List.of("tea", "lemon",
                "fig", "grape", "banana");
        return words.stream().map(String::toLowerCase).sorted(Comparator.naturalOrder()).toList();
    }

    public List<Integer> practice3() {
        List<Integer> numbers = List.of(3, 7, 1, 9, 2);
        return numbers.stream().sorted(Comparator.reverseOrder()).toList();
    }

    public List<Integer> practice4() {
        List<Integer> nums = List.of(3, 2, 5, 6, 1, 4);
        return nums.stream().sorted(Comparator.comparing(n -> (int) n % 2).thenComparingInt(n -> (int) n)).toList();
    }

    public List<String> practice5() {
        List<String> words = List.of("kiwi", "apple",
                "banana", "grape", "plum");
        return words.stream().sorted(Comparator.comparing(w -> w.charAt(w.length() - 1))).toList();
    }

    public List<String> practice6() {
        List<String> words = List.of("apple",
                "banana", "cherry", "kiwi", "grape");
        return words.stream().sorted(Comparator.comparing(w -> myCounter(w))).toList();
    }

    public static long myCounter(String w) {
        return w.chars().filter(c -> "aeiou".indexOf(c) >= 0).count();
    }

    public List <String> practice7 () {
        List<String> words = List.of("tea", "watermelon",
                "apple", "pear", "banana");
        return words.stream().sorted(Comparator.comparing(String::length).reversed()).toList();
    }

    public List <Integer> practice8 () {
        List<Integer> numbers = List.of(3, 2, 5, 6, 4, 1);
        return numbers.stream().sorted(Comparator.comparing((Integer n)->n%2).thenComparing(Comparator.reverseOrder())).toList();
    }

    public List <Integer> practice9 () {
        List<Integer> numbers = List.of(3, 2, 5, 6, 4, 1);
        return numbers.stream().sorted(Comparator.comparing((Integer n)-> n%2)
                .thenComparing(Comparator.reverseOrder()))
                .toList();
    }

}