package stream.task60x24.x1.task19_sorted_10;

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

    public List <Integer> practice3 () {
        List<Integer> numbers = List.of(3, 7, 1, 9, 2);
        return numbers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public List <Integer> practice5 () {
        List<Integer> nums = List.of(3, 2, 5, 6, 1, 4);
        return nums.stream()
                .sorted(Comparator
                        .comparing(value->(int)value%2)
                        .thenComparingInt(n->(int)n))
                .collect(Collectors.toList());
    }

    public List <String> practice6 () {
        List<String> words = List.of("kiwi", "apple", "banana", "grape", "plum");
        return words.stream().sorted(Comparator.comparing(value-> value.charAt(value.length()-1))).collect(Collectors.toList());
    }

    public List <String> practice7 () {
        List<String> words = List.of("apple", "banana", "cherry", "kiwi", "grape");
        return words.stream().sorted(Comparator.comparing(value-> count(value))).collect(Collectors.toList());
    }

    public long count(String s) {
        return s.chars().filter(c->"aeiou".indexOf(c)>=0).count();
    }

    public List <String> practice8 () {
        List<String> words = List.of("tea", "watermelon", "apple", "pear", "banana");
        return words.stream().sorted(Comparator.comparing(String::length).reversed()).collect(Collectors.toList());
    }

    public List <String> practicve9 () {
        List<String> words = List.of("tea", "watermelon", "apple", "pear", "banana");
        return words.stream().sorted(Comparator.comparing(v->((int)v)%2).reversed()).collect(Collectors.toList());
    }
 }
