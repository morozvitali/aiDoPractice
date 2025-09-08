package stream.task15_grouping_20;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main22 {
    public Map<String, Boolean> practice0() {
        return Stream.of("sky", "apple",
                        "dry", "orange", "sun")
                .collect(Collectors.toMap(Function.identity(), w -> w.chars().anyMatch(c -> "aeiou".indexOf(c) >= 0)));
    }

    public long practice1(String s) {
        return s.chars().mapToObj(c -> (char) c).collect(Collectors
                .groupingBy(c -> c, Collectors.counting())).entrySet().stream().filter(e -> e.getValue() > 1).count();
    }

    public String practice2 (String s) {
        return Arrays.stream(s.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
                .max(Map.Entry.comparingByValue()).get().getKey();
    }

    public Map<Integer, Integer> practice3 (String s) {
        return Stream.of(12, 23, 34, 45, 16, 7)
                .collect(Collectors.groupingBy(w->w%10, Collectors.summingInt(n->n)));
    }

    public int practice6 () {
        return Stream.of(1,2,2,3,3,3,4,4)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(-1);
    }

}
