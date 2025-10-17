package stream1.task15_grouping_20;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main35 {
    public void practice1 () {
        String[] words = {"sky", "apple",
                "dry", "orange", "sun"};
        Map<String, Boolean> map = Arrays.stream(words).collect(Collectors.toMap(Function.identity(), w->getCount(w)>0));
    }

    public static long getCount(String s) {
        return s.chars().filter(c->"aeiou".indexOf(c)>=0).count();
    }

    public long practice2 (String s) {
        return s.chars().mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(e->e.getValue() > 1).count();
    }

    public String practice3 (String s) {
        return Arrays.stream(s.split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("-1");
    }

    public Map <Integer, Integer> practice4 () {
        return Stream.of(12, 23, 34, 45, 16, 7).collect(Collectors.groupingBy(n->n%10, Collectors.summingInt(n->n)));
    }

    public Integer practice5 () {
        return  Stream.of(1,2,2,3,3,3,4,4).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(-1);
    }

    public Map <Integer, Long> practice6 (String s) {
        return s.chars().filter(Character::isDigit).mapToObj(Character::getNumericValue).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public boolean practice7 () {
        return Stream.of(1, 2, 3, 2).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().anyMatch(entry -> entry.getValue() >1);
    }

    public Map <String, List<Integer>> practice8 () {
        return Stream.of(1, 2, 3, 2).collect(Collectors.groupingBy(n->n%2==0 ? "even" : "odd"));
    }

    public Map <Integer, Double> practice9 () {
        return Stream.of(3, 6, 7, 8, 9, 10, 12).collect(Collectors.groupingBy(a->a%3, Collectors.averagingInt(n->n)));
    }

    public Character practice10 () {
        String[] words = {"apple", "banana", "avocado",
                "blueberry", "bleuberry", "apricot"};
        return Arrays.stream(words).collect(Collectors.groupingBy(w->w.charAt(0), Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse('0');
    }



}
