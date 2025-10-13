package stream1.task15_grouping_20;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main12 {
    public void practice1 () {
        String[] words = {"sky", "apple",
                "dry", "orange", "sun"};
        Arrays.stream(words).collect(Collectors.toMap(Function.identity(), w->w.chars().anyMatch(c->"aeiou".indexOf(c)>=0)));
    }

    public String practice2 () {
        Map<String, Long> map =  Arrays.stream("java is fun and java is powerful".split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return Collections.max(map.entrySet(), Comparator.comparingLong(entry -> entry.getValue())).getKey();
    }

    public Map <Integer, Integer> practice3 () {
        return Stream.of(12, 23, 34, 45, 16, 7).collect(Collectors.groupingBy(w -> w % 10, Collectors.summingInt(w -> w)));
    }

    public Integer practice6 () {
        Map <Integer, Long> map = Stream.of(1,2,2,3,3,3,4,4).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return map.entrySet().stream().max(Comparator.comparingLong(Map.Entry::getValue)).get().getKey();
    }

    public Map <Integer, Long> practice7 () {
    return "ab123cc44a77".chars().filter(Character::isDigit).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public Boolean practice8 () {
        Map <Integer, Long> map = Stream.of(1, 2, 3, 2).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return map.entrySet().stream().anyMatch(entry -> entry.getValue() > 1);
    }

    public Map <String, List<Integer>> practice9 () {
        return Stream.of(1, 2, 3, 4, 5).collect(Collectors.groupingBy(n->n%2 ==0 ? "even": "odd"));
    }

    public Map <Integer, Double> practice10 () {
        return Stream.of(3, 6, 7, 8, 9, 10, 12).collect(Collectors.groupingBy(n->n%3, Collectors.averagingInt(n->n)));
    }

    public Character practice11 () {
        String[] words = {"apple", "banana", "avocado",
                "blueberry", "bleuberry", "apricot"};
        Map <Character, Long>  map = Arrays.stream(words).collect(Collectors.groupingBy(w->w.charAt(0), Collectors.counting()));
        return map.entrySet().stream().max(Comparator.comparingLong(val->val.getValue()))
                .map(Map.Entry::getKey).orElse(null);
    }

    public void practice12 () {
        Map <Character, Long> map = new HashMap<>();
        map.put('a', 2L);
        map.put('b', 5L);
        map.put('c', 1L);

        map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()));
    }
}
