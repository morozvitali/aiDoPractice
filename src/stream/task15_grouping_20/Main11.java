package stream.task15_grouping_20;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main11 {
    public Map<String, Boolean> practice0 () {
        String[] words = {"sky", "apple",
                "dry", "orange", "sun"};
        return Arrays.stream(words)
                .collect(Collectors.toMap(Function.identity(), w->isHave(w)));
    }
    public boolean isHave(String s) {
        return s.chars().filter(c->"aeiou".indexOf(c)>=0).count() > 0;
    }

    public Long practice1 (String s) {
        return s.toLowerCase().chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().filter(e->e.getValue() >1).count();
    }

    public String practice2 (String s) {
        Map <String, Long> map = Arrays.stream(s.split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return Collections.max(map.entrySet(), Comparator.comparingLong(entry ->entry.getValue())).getKey();
    }

    public Map <Integer, Integer> practice3 () {
        return Stream.of(12, 23, 34, 45, 16, 7).collect(Collectors.groupingBy(w-> w%10, Collectors.summingInt(w->w)));
    }

    public Integer practice6 () {
        Map <Integer, Long> map = Stream.of(1,2,2,3,3,3,4,4).collect(Collectors.groupingBy(val -> val, Collectors.counting()));
        return map.entrySet().stream().max(Comparator.comparingLong(Map.Entry::getValue)).get().getKey();
    }

    public Map <Integer, Long> practice7 (String s) {
        return s.chars().filter(Character::isDigit).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public boolean practice8 (int [] array) {
        Map <Integer, Long> map = Arrays.stream(array).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return map.entrySet().stream().anyMatch(value->value.getValue() > 1);
    }

public Map<String, List<Integer>> practice9 (int [] array) {
        return Arrays.stream(array).boxed().collect(Collectors.groupingBy(value -> value % 2 == 0 ? "even" : "odd"));
}

}
