package stream.task16;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main4 {

    public Map<Integer, List<String>> myGrouping1() {
        String[] words = {"apple", "banana", "dog", "kiwi", "plum"};

        return Arrays.stream(words).map(a -> a.toUpperCase())
                .collect(Collectors.groupingBy(a -> a.length()));
    }

    public Map<Integer, Long> myGrouping2() {
        String[] words = {"apple", "banana", "dog", "kiwi", "plum"};
        return Arrays.stream(words)
                .filter(a -> "aeiou".indexOf(a) >= 0)
                .collect(Collectors.groupingBy(a -> a.length(), Collectors.counting()));
    }

    public Map<Boolean, List<String>> myGrouping3() {
        String[] words = {"apple", "sky", "banana", "dry", "orange"};
        return Arrays.stream(words)
                .collect(Collectors.groupingBy(a -> "aeiou".indexOf(a) >= 0));
    }

    public Map<Integer, Long> myGrouping4() {
        String[] words = {"apple", "banana", "orange", "umbrella", "ant", "dog", "egg"};
        return Arrays.stream(words)
                .filter(a -> "aeiou".indexOf(a.charAt(0)) >= 0)
                .collect(Collectors.groupingBy(a -> a.length(), Collectors.counting()));
    }
}
