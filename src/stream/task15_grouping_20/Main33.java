package stream.task15_grouping_20;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main33 {
    public Map<String, Boolean> practice1 () {
        String[] words = {"sky", "apple",
                "dry", "orange", "sun"};
        return Arrays.stream(words).collect(Collectors.toMap(Function.identity(), w->getCount(w)>0));
    }

    public static Long getCount (String s) {
        return  s.chars().filter(c->"aeiou".indexOf(c)>=0).count();
    }

    public Long practice2 (String s) {
        return s.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(e->e.getValue() >1).count();
    }

    public String practice3 () {
        Map<String, Long> map = Arrays.stream("java is fun and java is powerful".split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public Map <Integer, Integer> practice4 () {
        return Stream.of(12, 23, 34, 45, 16, 7).collect(Collectors.groupingBy(a->a%10, Collectors.summingInt(n->n)));
    }

    public Integer practice5 () {
        Map <Integer, Long>map = Stream.of(1,2,2,3,3,3,4,4).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public Map <Integer, Long> practice6 () {
        return "ab123cc44a77".chars().filter(Character::isDigit).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public boolean practice7 () {
        return Stream.of(1, 2, 3, 2).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().anyMatch(e->e.getValue() >1);
    }

    public Map <String, List<Integer>> practice8 () {
        return Stream.of(1, 2, 3, 4, 5).collect(Collectors.groupingBy(n->n%2==0 ? "even" : "odd"));
    }
}
