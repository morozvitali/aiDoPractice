package stream.task60x24.x1.task19_sorted_10;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main1 {
    public void practice0 () {
        List<String> words = List.of("sun", "banana", "kiwi",
                "cherry", "apple", "tea", "pear");
        words.stream().filter(val -> val.length() > 3)
                .sorted(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()).thenComparing(Comparator.reverseOrder())).toList();
    }

    public void practice1 () {
        List<String> words = List.of("tea", "lemon", "fig", "grape", "banana");
        words.stream().filter(w->w.length() >3).sorted(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()));
    }

    public List <String> practice2 () {
        List<String> words = List.of("Zebra", "apple", "Lemon", "banana");
        return words.stream().map(a->a.toLowerCase()).sorted(Comparator.naturalOrder()).collect(Collectors.toList());
    }

    public List <Integer> practice3 () {
        List<Integer> numbers = List.of(3, 7, 1, 9, 2);
        return numbers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public List <Integer> practice5 () {
        List<Integer> nums = List.of(3, 2, 5, 6, 1, 4);
        return nums.stream().sorted(Comparator.comparingInt(n->(int)n%2).thenComparing(n->(int)n)).collect(Collectors.toList());
    }

    public List <String> practice6 () {
        List<String> words = List.of("kiwi", "apple", "banana", "grape", "plum");
        return words.stream().filter(s->s.length() >4).sorted(Comparator.comparing(value -> value.charAt(value.length()-1))).toList();
    }

    public List <String> practice7 () {
        List<String> words = List.of("apple", "banana", "cherry", "kiwi", "grape");
        return words.stream().sorted(Comparator.comparingInt((String s)->countVowels(s)).thenComparing(Comparator.naturalOrder())).toList();
    }

    public int countVowels (String s) {
        return (int) s.chars().filter(c->"aeiou".indexOf(c)>=0).count();
    }

    public List <String> practice8 () {
        List<String> words = List.of("tea", "watermelon", "apple", "pear", "banana");
        return words.stream().sorted(Comparator.comparing(String::length).reversed()).collect(Collectors.toList());
    }

    public List <Integer> practice9 () {
        List<Integer> numbers = List.of(3, 2, 5, 6, 4, 1);
        return numbers.stream().sorted(Comparator.comparing((Integer val) -> val%2).thenComparing(Comparator.reverseOrder())).collect(Collectors.toList());
    }
}
