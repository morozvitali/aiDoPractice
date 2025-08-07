package stream.task99skip.task16_grouping2_5;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main6 {
    public Map<Integer, List<String>> practice1 () {
        String[] words = {"apple", "banana", "dog", "kiwi", "plum"};
        return Arrays.stream(words).map(a->a.toUpperCase()).collect(Collectors.groupingBy(a->a.length()));
    }

    public Map <Integer, Long> practice2 () {
        String[] words = {"apple", "banana", "dog", "kiwi", "plum"};
        return Arrays.stream(words)
                .filter(a->a.chars()
                        .anyMatch(c->"aeiou".indexOf(c) >=0))
                .collect(Collectors
                    .groupingBy(a->a.length(), Collectors.counting()));
    }

    public Map <Boolean, List <String>> practice3 () {
        String[] words = {"apple", "sky", "banana", "dry", "orange"};
        return Arrays.stream(words).collect(Collectors.groupingBy(a->isHasVowel(a)));
    }

    public boolean isHasVowel (String s) {
        return s.chars().anyMatch(a->"aeiou".indexOf(a) >= 0 ? true : false);
    }

    public Map <Integer, Long> practice4 () {
        String[] words = {"apple", "banana", "orange", "umbrella",
                "ant", "dog", "egg"};
        return Arrays.stream(words)
                .filter(a->"aeiou".indexOf(a.charAt(0)) >=0)
                .collect(Collectors.groupingBy(b->b.length(), Collectors.counting()));
    }
}
