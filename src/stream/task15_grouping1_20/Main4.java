package stream.task15_grouping1_20;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main4 {

    public Map<Integer, List<String>> myGroupingExample1() {
        String[] words = {"apple", "dog", "banana", "cat", "kiwi", "plum", "watermelon"};
        return Arrays.stream(words).collect(Collectors.groupingBy(String::length));
    }

    public Map <Character, List<String>> myGroupingExample2() {
        List<String> words = List.of("Apple", "apricot", "Banana", "blue", "Cherry", "cranberry");

        return words.stream().map(a->a.toLowerCase())
                .collect(Collectors.groupingBy(a->a.charAt(0)));
    }

    public Map<Character, Long> myGroupingExample3() {
        String[] words = {"apple", "dog", "banana", "cat", "kiwi", "plum", "watermelon"};
        return Arrays.stream(words)
                .map(a -> a.toLowerCase())
                .collect(Collectors.groupingBy(a -> a.charAt(0), Collectors.counting()));
    }

    public Map<String, Boolean> myGroupingExample4() {
        String[] words = {"sky", "apple", "dry", "orange", "sun"};

        return Arrays.stream(words).map(String::toLowerCase)
                .collect(Collectors.toMap(a->a, a->containLetter(a)));
    }

    public boolean containLetter(String s) {
        return s.chars().anyMatch(a->"aeiou".charAt(a) >= 0);
    }
}
