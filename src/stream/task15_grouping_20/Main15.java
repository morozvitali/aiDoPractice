package stream.task15_grouping_20;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main15 {
    public Map<String, Boolean> practice0() {
        return Stream.of("sky", "apple",
                        "dry", "orange", "sun")
                .collect(Collectors.toMap(w -> w, w -> w.chars().filter(c -> "aeiou".indexOf(c) >= 0).findAny().isPresent()));
    }

    public long practice1 (String s) {
        return s.toLowerCase().chars().mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().filter(e->e.getValue() >1).count();
    }

    public String practice2 () {
        return Arrays.stream("java is fun and java is powerful".split(" "))
                .collect(Collectors.groupingBy(w->w, Collectors.counting())).entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getKey();
    }

    public Map<Integer, Integer> practice3 () {
        return Stream.of(12, 23, 34, 45, 16, 7)
                .collect(Collectors.groupingBy(v->v%3, Collectors.summingInt(n->n)));
    }

    public Integer practice6 () {
        return Stream.of(1,2,2,3,3,3,4,4).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().max(Comparator.comparing(entry->entry.getValue())).get().getKey();
    }


    public Map <Integer, Long> practice7 () {
        return "ab123cc44a77".chars().filter(Character::isDigit).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }


}
