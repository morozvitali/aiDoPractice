package stream.task16_grouping2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main0 {
    public void practice1() {
        String[] words = {"apple", "banana",
                "dog", "kiwi", "plum"};
        Arrays.stream(words).map(a -> a.toUpperCase())
                .collect(Collectors.groupingBy(w -> w.length()));
    }

    public void practice2() {
        String[] words = {"apple", "banana",
                "dog", "kiwi", "plum"};

        Map<Integer, List<String>> map = Arrays.stream(words)
                .filter(w -> w.chars()
                        .map(c -> (char) c)
                        .filter(c -> "aeiou"
                                .indexOf(c) >= 0)
                        .count() > 0)
                .collect(Collectors
                        .groupingBy(a -> a
                                .length()));

        for (var e : map.entrySet()) {
            System.out.println(e.getKey() + "->" + e.getValue());
        }
    }

    public void practice3() {
        String[] words = {"apple", "sky",
                "banana", "dry", "orange"};

        Arrays.stream(words)
                .collect(Collectors
                        .partitioningBy(a->a
                                .chars().map(c->(char)c)
                                .filter(ch->"aeiou"
                                        .indexOf(ch)>=0)
                                .count() > 0));
    }



}
