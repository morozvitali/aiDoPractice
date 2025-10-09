package stream.task15_grouping_20;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main34 {
    public void practice1 () {
        String[] words = {"sky", "apple", "dry", "orange", "sun"};
        Arrays.stream(words).collect(Collectors.toMap(Function.identity(), v->getCount(v) >0));
    }
    public static long getCount (String s) {
        return s.chars().filter(c->"aeiou".indexOf(c)>=0).count();
    }

    public Long practice2 (String s) {
        Map <Character, Long> map = s.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return map.entrySet().stream().filter(e->e.getValue() > 1).count();
    }

    public String practice3 (String s) {
        Map <String, Long> map = Arrays.stream(s.split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public Map <Integer, Integer> practice4 () {
        return Stream.of(12, 23, 34, 45, 16, 7).collect(Collectors.groupingBy(a->a%10, Collectors.summingInt(n->n)));
    }

    public Integer practice5 () {
        Map <Integer, Long> map = Stream.of(1,2,2,3,3,3,4,4).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return map.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(-1);
    }

    public Map <Integer, Long> practice6 (String s) {
        return s.chars().filter(Character::isDigit).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public Boolean practice7 () {
        return Stream.of(1, 2, 3, 2).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().anyMatch(e->e.getValue() >1);
    }

    public Map <String, List<Integer>> practice8 () {
        return Stream.of(1, 2, 3, 4, 5).collect(Collectors.groupingBy(v->v%2==0 ? "even" : "odd"));
    }

    public Map <Integer, Double> practice9 () {
        return Stream.of(3, 6, 7, 8, 9, 10, 12).collect(Collectors.groupingBy(n->n%3, Collectors.averagingInt(n->(int)n)));
    }

    public Character practice10 () {
        String[] words = {"apple", "banana", "avocado",
                "blueberry", "bleuberry", "apricot"};
        Map <Character, Long> map = Arrays.stream(words).collect(Collectors.groupingBy(w->w.charAt(0), Collectors.counting()));
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public LinkedHashMap <Character, Long> practice11 () {
        Map <Character, Long> map = new HashMap<>();
        map.put('a', 2L);
        map.put('b', 5L);
        map.put('c', 1L);
        return map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (old, newValue) ->old, LinkedHashMap::new));
    }



}
