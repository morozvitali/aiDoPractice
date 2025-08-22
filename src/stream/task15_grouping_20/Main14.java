package stream.task15_grouping_20;

import java.util.*;
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
                .entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getKey();
    }

    public Map <Integer, Integer> practice3 () {
        return Stream.of(12, 23, 34, 45, 16, 7).collect(Collectors.groupingBy(v->v%10, Collectors.summingInt(n->n)));
    }

    public int practice6 () {
        return Stream.of(1,2,2,3,3,3,4,4)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getKey();
    }

    public Long practice7 () {
        return "ab123cc44a77".chars().filter(Character::isDigit).count();
    }

    public Boolean practice8 () {
        return Stream.of(1, 2, 3, 2).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().anyMatch(entry->entry.getValue()>1);
    }

    public Map <String, List<Integer>> practice9 () {
        return Stream.of(1, 2, 3, 4, 5).collect(Collectors.groupingBy(v->v%2 == 0 ? "even" : "odd"));
    }

    public Map <Integer, Double> practice10 () {
        return Stream.of(3, 6, 7, 8, 9, 10, 12).collect(Collectors.groupingBy(Function.identity(), Collectors.averagingInt(n->n)));
    }

    public Character practice11 () {
        String[] words = {"apple", "banana", "avocado",
                "blueberry", "bleuberry", "apricot"};
        return Arrays.stream(words).collect(Collectors.groupingBy(w->w.charAt(0), Collectors.counting())).entrySet().stream().max(Comparator.comparing(entry -> entry.getValue())).get().getKey();
    }

    public void practice12 () {
        Map <Character, Long> map = new HashMap<>();
        map.put('a', 2L);
        map.put('b', 5L);
        map.put('c', 1L);
        map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()));
    }
}
