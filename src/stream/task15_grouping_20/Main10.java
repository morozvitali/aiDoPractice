package stream.task15_grouping_20;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main10 {
    public Map<String, Boolean> practice0 () {
        return Stream.of("sky", "apple",
                "dry", "orange", "sun").collect(Collectors.toMap(Function.identity(), w->w.chars().anyMatch(ch->"aeiou".indexOf(ch) >= 0)));
    }

    public void practice1 (String s) {
        Map <Character, Long> map = s.toLowerCase().chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c, Collectors.counting()));
    }

    public String practice2 (String sentence) {
        Map <String, Long> map = Arrays.stream(sentence.split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return Collections.max(map.entrySet(), Comparator.comparingLong(entry ->entry.getValue())).getKey();
    }

    public Map <Integer, Integer> practice3 () {
        return Stream.of(12, 23, 34, 45, 16, 7).collect(Collectors.groupingBy(w-> w%10, Collectors.summingInt(w->w)));
    }

    public int practice6 () {
        Map <Integer, Long> map = Stream.of(1,2,2,3,3,3,4,4).collect(Collectors.groupingBy(w->w, Collectors.counting()));
        return map.entrySet().stream().max(Comparator.comparingLong(Map.Entry::getValue)).get().getKey();
    }

    public void practice7 () {
        "ab123cc44a77".chars().filter(Character::isDigit).mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public Boolean practice8 () {
        Map <Integer, Long> map = Stream.of(1, 2, 3, 2).collect(Collectors.groupingBy(v->v, Collectors.counting()));
        return map.entrySet().stream().anyMatch(v->v.getValue() >1);
    }

    public Map <Boolean, List<Integer>> practice9 () {
        return Stream.of(1, 2, 3, 4, 5).collect(Collectors.partitioningBy(v->v%2==0));
    }

    public Map <Integer, Double> practice10 () {
        return Stream.of(3, 6, 7, 8, 9, 10, 12).collect(Collectors.groupingBy(w->w%3, Collectors.averagingInt(n->n)));
    }

    public Character practice11 () {
        Map <Character, Long> map = Stream.of("apple", "banana", "avocado",
                "blueberry", "bleuberry", "apricot").map(w->w.charAt(0)).collect(Collectors.groupingBy(w->w, Collectors.counting()));
        return map.entrySet().stream().max(Comparator.comparingLong(n->n.getValue()))
                .map(Map.Entry::getKey)
                .orElse(null);

    }

}
