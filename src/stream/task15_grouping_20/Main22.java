package stream.task15_grouping_20;

import java.util.Arrays;
import java.util.List;
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

    public Map <Integer, Long> practicce7 () {
        return "ab123cc44a77".chars().filter(Character::isDigit).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public boolean practice8 () {
        return Stream.of(1, 2, 3, 2).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().anyMatch(e->e.getValue() > 1);
    }

    public Map <String, List<Integer>> practice9 () {
        return Stream.of(1, 2, 3, 4, 5).collect(Collectors.groupingBy(v->v%2 == 0? "even" : "odd"));
    }

    public Map <Integer, Double> practice10 () {
        return Stream.of(3, 6, 7, 8, 9, 10, 12).collect(Collectors.groupingBy(n->n%3, Collectors.averagingInt(n->n)));
    }

    public Character practice11 () {
        return Stream.of("apple", "banana", "avocado",
                "blueberry", "bleuberry", "apricot")
                .collect(Collectors.groupingBy(w->w.charAt(0), Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
    }
}
