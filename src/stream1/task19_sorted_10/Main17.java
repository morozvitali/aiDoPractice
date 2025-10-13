package stream1.task19_sorted_10;

import java.util.Comparator;
import java.util.List;

public class Main17 {

    public List<String> practice1 () {
        List<String> words = List.of("tea", "lemon",
                "fig", "grape", "banana");
        return words.stream().filter(w->w.length() > 3).sorted(Comparator.comparingInt(String::length)).toList();
    }

    public List <Integer> practice2 () {
        List<Integer> numbers = List.of(3, 7, 1, 9, 2);
        return numbers.stream().sorted(Comparator.reverseOrder()).toList();
    }

    public List<Integer> practice3 () {
        List<Integer> nums = List.of(3, 2, 5, 6, 1, 4);
        return nums.stream().sorted(Comparator.comparingInt(a->(int)a%2).thenComparingInt(n->(int)n)).toList();
    }

    public List<String> practice4 () {
        List<String> words = List.of("kiwi", "apple",
                "banana", "grape", "plum");
        return words.stream().filter(w->w.length() > 4).sorted(Comparator.comparing(w->w.charAt(w.length()-1))).toList();
    }

    public List <String> practice5 () {
        List<String> words = List.of("apple",
                "banana", "cherry", "kiwi", "grape");
        return words.stream().sorted(Comparator.comparing(w->w.chars().filter(c->"aeiou".indexOf(c) >=0).count())).toList();
    }

    public List <String> practice6 () {
        List<String> words = List.of("tea", "watermelon",
                "apple", "pear", "banana");
        return words.stream().sorted().sorted(Comparator.comparingInt(String::length).reversed()).toList();
    }


    public List<Integer> practice7 () {
        List<Integer> numbers = List.of(3, 2, 5, 6, 4, 1);
        return numbers.stream().sorted(Comparator.comparingInt(n->(int)n%2).reversed()).toList();
    }



}
