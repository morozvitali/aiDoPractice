package stream.task15_grouping_20;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main19 {

    public Map<String, Boolean> practice0() {
        String[] words = {"sky", "apple",
                "dry", "orange", "sun"};
        return Arrays.stream(words).collect(Collectors.toMap(Function.identity(), w -> isHaveVovels(w)));
    }

    public boolean isHaveVovels(String s) {
        return s.chars().anyMatch(a -> "aeiou".indexOf(a) >= 0);
    }

    public long practice1(String s) {
        return s.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().filter(e -> e.getValue() > 1).count();
    }

    public String practice2(String s) {
        return Arrays.stream(s.split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().max(Comparator.comparing(e -> e.getValue())).get().getKey();
    }

    public Map<Integer, Integer> practice3() {
        return Stream.of(12, 23, 34, 45, 16, 7)
                .collect(Collectors.groupingBy(a -> a % 10, Collectors.summingInt(n -> n)));
    }
}