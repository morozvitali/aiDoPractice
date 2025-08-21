package stream.task15_grouping_20;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main13 {
    public Map<String, Boolean> practice0() {
        String[] words = {"sky", "apple",
                "dry", "orange", "sun"};
        return Arrays.stream(words).collect(Collectors.toMap(Function.identity(), this::isHaveVovels));
    }

    public boolean isHaveVovels(String s) {
        return s.chars().anyMatch(a -> "aeiou".indexOf(a) >= 0);
    }

    public Long practice1(String s) {
        Map<Character, Long> map = s.toLowerCase().chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return map.entrySet().stream().filter(e -> e.getValue() > 1).count();
    }

    public String practice2() {
        Map<String, Long> map = Arrays.stream("java is fun and java is powerful".split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return map.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
    }

    public Map <Integer, Integer> practice3 () {
        return Stream.of(2, 23, 34, 45, 16, 7).collect(Collectors.groupingBy(value->value%10, Collectors.summingInt(n->n)));
    }

    public Integer practice6 () {
        Map <Integer, Long> map =  Stream.of(1,2,2,3,3,3,4,4)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return map.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getKey();
    }

}
