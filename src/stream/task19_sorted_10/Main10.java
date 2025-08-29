package stream.task19_sorted_10;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main10 {
    public List <String> practice0 () {
        List<String> words = List.of("sun", "banana", "kiwi",
                "cherry", "apple", "tea", "pear");
        return words.stream().sorted(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder())).toList();
    }

    public List <String> practice1 () {
        return Stream.of("pear", "apple", "banana").filter(w->w.length() >3).sorted(Comparator.comparing(String::length)).toList();
    }

    public List<String> practice2 () {
        List<String> words = List.of("Zebra", "apple",
                "Lemon", "banana");
        return words.stream().sorted().map(String::toLowerCase).toList();
    }

    public List <Integer> practice3 () {
        List<Integer> numbers = List.of(3, 7, 1, 9, 2);
        return numbers.stream().sorted(Comparator.reverseOrder()).toList();
    }

    public List<Integer> practice5 () {
        List<Integer> nums = List.of(3, 2, 5, 6, 1, 4);
        return nums.stream().sorted(Comparator.comparingInt(a->(int)a%2).thenComparingInt(n->(int)n)).toList();
    }


}
