package stream.task16_grouping2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main1 {
    public Map<Integer, List<String>> practice1 () {
        String[] words = {"apple", "banana",
                "dog", "kiwi", "plum"};
        return Arrays.stream(words)
                .map(a -> a.toUpperCase())
                .collect(Collectors.groupingBy(String::length));
    }

    public Map <Integer, Long> practice2 () {
        String[] words = {"apple", "banana", "dog", "kiwi", "plum"};
        return Arrays.stream(words)
                .filter(b-> b
                        .chars()
                        .map(c -> (char) c)
                        .filter(ch -> "aeiou"
                                .indexOf(ch) >= 0).findAny().isPresent())
                .collect(Collectors
                        .groupingBy(a->a.length(), Collectors.counting()));
    }

    public Map <Boolean, List <String>> practice3 () {
        String[] words = {"apple", "sky", "banana", "dry", "orange"};
        return Arrays.stream(words).collect(Collectors.partitioningBy(w -> w.chars().filter(ch->"aoeiu".indexOf(ch)>=0).count() > 0));
    }



















}
