package stream.task60x24.x1.task15_grouping_20;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main3 {
    public Map<Integer, List<String>> myGrouper1() {

        return Arrays.stream(new String[]{"apple", "dog", "banana", "cat", "kiwi", "plum", "watermelon"})
                .collect(Collectors.groupingBy(a -> a.length()));
    }

    public Map<Character, List<String>> myGrouper2() {
        List<String> words = List.of("Apple", "apricot", "Banana", "blue", "Cherry", "cranberry");
        return words.stream().map(a -> a.toLowerCase())
                .collect(Collectors.groupingBy(a -> a.charAt(0)));
    }

    public Map<Character, Long> myGrouper3() {
        return Arrays.stream(new String[]{"apple", "banana", "apricot", "blue", "berry", "cherry"})
                .collect(Collectors.groupingBy(a -> a.charAt(0), Collectors.counting()));
    }

    public Map<String, Boolean> myGrouper4() {
        return Arrays.stream(new String[]{"sky", "apple", "dry", "orange", "sun"})
                        .collect(Collectors.toMap(
                                a->a,
                                a->a.chars().anyMatch(c->"aeiou".indexOf(c)>=0)));
    }
}

