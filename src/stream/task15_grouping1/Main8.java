package stream.task15_grouping1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main8 {

    public Map<String, Boolean> practice0 () {
        String[] words = {"sky", "apple",
                "dry", "orange", "sun"};
        return Arrays.stream(words)
                .collect(Collectors
                        .toMap(Function.identity(),
                                word -> word
                                        .chars()
                                        .anyMatch(ch -> "aeiou"
                                                .indexOf(ch) >= 0)
                ));
    }

    public int practice1 (String s) {
        Map <Character, Long> map = s.toLowerCase().chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return (int) map.entrySet().stream().filter(e->e.getValue() > 1).count();
    }

    public String practice2 () {
        Map <String, Long> map = Arrays.stream("java is fun and java is powerful".split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return Collections.max(map.entrySet(), Comparator.comparingLong(entry ->entry.getValue())).getKey();
    }


    public Map<Integer, Integer> practice3 () {
        Integer[] array = new Integer[] {12, 23, 34, 45, 16, 7};
        return Arrays.stream(array).collect(Collectors.groupingBy(n->n%10, Collectors.summingInt(n->n)));
    }



}
