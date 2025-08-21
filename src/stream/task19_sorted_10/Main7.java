package stream.task19_sorted_10;

import java.util.Comparator;
import java.util.List;

public class Main7 {

    public static void main(String[] args) {
        Main7 m = new Main7();
        m.practice1();
    }

    public List<String> practice1() {
        List<String> words = List.of("sun", "banana", "kiwi",
                "cherry", "apple", "tea", "pear");

        return words.stream().filter(w -> w.length() > 3)
                .sorted(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder())).toList();
    }

    public List<String> practice2 () {
        List<String> words = List.of("Zebra", "apple",
                "Lemon", "banana");
        return words.stream().map(String::toLowerCase)
                .sorted(Comparator.naturalOrder()).toList();
    }

    public List <Integer> practice3 () {
        List<Integer> numbers = List.of(3, 7, 1, 9, 2);
        return numbers.stream().sorted(Comparator.reverseOrder()).toList();
    }

    public List <Integer> practice5 () {
        List<Integer> nums = List.of(3, 2, 5, 6, 1, 4);
        return nums.stream().sorted(Comparator.comparing(value->value % 2 == 1)).toList();
    }

    public List <String> practice6 () {
        List<String> words = List.of("kiwi", "apple",
                "banana", "grape", "plum");
        return words.stream().sorted(Comparator.comparing(w -> w.charAt(w.length() - 1))).toList();
    }

    public List <String> practice7 () {
        List<String> words = List.of("apple",
                "banana", "cherry", "kiwi", "grape");
        return words.stream().sorted(Comparator.comparing(Main7::countVowels)).toList();
    }

    public static long countVowels(String s) {
        return s.chars().filter(c->"aeiou".indexOf(c)>=0).count();
    }


    public void practice8 () {
        List<String> words = List.of("tea", "watermelon",
                "apple", "pear", "banana");
        words.stream().sorted(Comparator.comparing(String::length).thenComparing(Comparator.reverseOrder()));
    }


}
