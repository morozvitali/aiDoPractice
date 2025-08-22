package stream.task15_grouping_20;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main14 {
    public Map<String, Boolean> practice0 () {
        String[] words = {"sky", "apple",
                "dry", "orange", "sun"};
    return Arrays.stream(words).collect(Collectors.toMap(Function.identity(), Main14::isHaveVOvel));
    }
    public static Boolean isHaveVOvel (String s) {
        return s.chars().anyMatch(c->"aeiou".indexOf(c) >=0);
    }

    public Map<Character, Long> practice1 (String s) {
        return s.toLowerCase().chars().mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public String practice2 () {
        return Arrays.stream("java is fun and java is powerful".split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(Comparator.comparing( entry->entry.getValue())).get().getKey();
    }

    public Map <Integer, Integer> practice3 () {
        return Stream.of(12, 23, 34, 45, 16, 7).collect(Collectors.groupingBy(v->v%10, Collectors.summingInt(n->n)));
    }

    public int practice6 () {
        return Stream.of(1,2,2,3,3,3,4,4)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(Comparator.comparing(v->v.getValue())).get().getKey();
    }
}
