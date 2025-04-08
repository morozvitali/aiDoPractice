package stream.Task16;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main3 {
    public Map<Integer, List<String>> myGrouping1() {

        return Arrays.stream(new String[]{"apple", "banana", "dog", "kiwi", "plum"})
                .map(a -> a.toUpperCase())
                .collect(Collectors.groupingBy(a -> a.length()));
    /* але краще так:
    .collect(Collectors.groupingBy(
    String::length,
    Collectors.mapping(String::toUpperCase, Collectors.toList())
    ))
     */
    }

    public Map<Integer, Long> myGrouping2() {
        return Arrays.stream(new String [] {"apple", "sky", "banana", "dry", "orange"})
                .filter(a->a.chars().anyMatch(c->"aeiou".indexOf(c)>=0))
                .collect(Collectors.groupingBy(a-> a.length(), Collectors.counting()));
    }

    public Map <Boolean, List <String>> myGrouping3 () {
        return Arrays.stream(new String [] {"apple", "sky", "banana", "dry", "orange"})
                .collect(Collectors.partitioningBy(a->isContains(a)));
    }

    public boolean isContains (String s) {
        return s.toLowerCase().chars().anyMatch(c->"aeiou".indexOf(c)>=0);
    }

    public Map <Integer, Long> myGrouping4 () {
        return Arrays.stream(new String [] {"apple", "banana", "orange", "umbrella",
                "ant", "dog", "egg"})
                .filter(a->a.chars().anyMatch(c->"aeiou".indexOf(c) >= 0))
                .collect(Collectors.groupingBy(a->a.length(), Collectors.counting()));
    }
}