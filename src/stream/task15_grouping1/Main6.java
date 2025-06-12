package stream.task15_grouping1;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main6 {
    public Map<Integer, List<String>> practice1() {
        String[] words = {"apple", "dog", "banana", "cat", "kiwi", "plum", "watermelon"};
        return Arrays.stream(words).collect(Collectors.groupingBy(a -> a.length()));
    }

    public Map<Character, List<String>> practice2() {
        List<String> words = List.of("Apple", "apricot", "Banana", "blue", "Cherry", "cranberry");
        return words.stream().map(a -> a.toLowerCase()).collect(Collectors.groupingBy(a -> a.charAt(0)));
    }

    public Map<Character, Long> practice3() {
        String[] words = {"apple", "banana", "apricot", "blue", "berry", "cherry"};
        return Arrays.stream(words).map(a->a.toLowerCase()).collect(Collectors.groupingBy(a->a.charAt(0), Collectors.counting()));
    }

    public Map<String, Boolean> practice4 () {
        String[] words = {"sky", "apple", "dry", "orange", "sun"};
        return Arrays.stream(words).collect(Collectors.toMap(a->a, a->isContain(a)));
    }

    public Map<String, Boolean> practice5 () {
        String[] words = {"sky", "apple", "dry", "orange", "sun"};
        return Arrays.stream(words).collect(Collectors.toMap(a->a, a-> a.chars().anyMatch(c->"aeiou".indexOf(c) >= 0)));
    }

    public boolean isContain(String s) {
        return s.chars().filter(a->"aeiou".indexOf(a) >= 0).count() > 0 ? true : false;
    }
}
