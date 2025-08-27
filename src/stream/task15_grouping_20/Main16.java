package stream.task15_grouping_20;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main16 {
    public long practice1 (String s) {
        return s.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().filter(entry->entry.getValue() > 1).count();
    }

public String practice2 (String s) {
        return Arrays.stream(s.split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getKey();
}

public Map <Integer, Integer> practice3 () {
        return Stream.of(12, 23, 34, 45, 16, 7).collect(Collectors.groupingBy(v->v%10, Collectors.summingInt(n->n)));
}

public Integer practice6 () {
        return Stream.of(1,2,2,3,3,3,4,4)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().max(Comparator.comparing(e->e.getValue())).get().getKey();
}

public Map <Integer, Long> practice7 () {
        return "ab123cc44a77".chars().filter(Character::isDigit).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
}

public Boolean practice8 () {
        return Stream.of(1, 2, 3, 2).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().anyMatch(e->e.getValue() > 1);
}

public Map <String, List<Integer>> practice9 () {
        return Stream.of(1, 2, 3, 4, 5).collect(Collectors.groupingBy(a->a%2 == 0 ? "even": "odd"));
}


}
