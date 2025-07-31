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

    public Map <Integer, Long> practice4 () {
        String[] words = {"apple", "banana",
                "orange", "umbrella",
                "ant", "dog", "egg"};
        return Arrays.stream(words)
                .filter(w->"aeiou".indexOf(w.charAt(0))>=0)
                .collect(Collectors.groupingBy(a->a.length(), Collectors.counting()));
    }
/*
    public int practice5 () {
        int[] ints = {2, 4, 6, 8, 10, 3};
        Map <Boolean, List <Integer>> map = Arrays.stream(ints).boxed().collect(Collectors.partitioningBy(value -> value % 2 == 0));
        return map.get(true).size() == 1 ? map.get(true).getFirst() : map.get(false).getFirst();
    }

 */
}
