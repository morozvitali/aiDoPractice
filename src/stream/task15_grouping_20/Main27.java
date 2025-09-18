package stream.task15_grouping_20;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main27 {
    public long practice1 (String s) {
        return s.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(e->e.getValue() > 1).count(); //
    }

    public String practice2 () {
        return Arrays.stream("java is fun and java is powerful".split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("");
    }

    public Map <Integer, Integer> practice3 () {
        return Stream.of(12, 23, 34, 45, 16, 7).collect(Collectors.groupingBy(a->a%3, Collectors.summingInt(n->n)));
    }

    public Integer practice4 () {
        int[] numbers = {1, 2, 2, 3, 3, 3, 4, 4};
        return Arrays.stream(numbers).mapToObj(Character::getNumericValue).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(-1);
    }

    public Map <Integer, Long> practice5 () {
        return "ab123cc44a77".chars().filter(Character::isDigit).mapToObj(Character::getNumericValue).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public Boolean practice6 () {
        return Stream.of(1, 2, 3, 2).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().anyMatch(e->e.getValue() >1);
    }

    public Map <String, List<Integer>> practice7 () {
        return Stream.of(1, 2, 3, 4, 5).collect(Collectors.groupingBy(a->a%2==0 ? "even" : "odd"));
    }

    public Map<Integer, Double> practice8 () {
        return Stream.of(3, 6, 7, 8, 9, 10, 12).collect(Collectors.groupingBy(a->a%3, Collectors.averagingInt(n->n)));
    }

    public Character practice9 () {
        String[] words = {"apple", "banana", "avocado",
                "blueberry", "bleuberry", "apricot"};
        return Arrays.stream(words).collect(Collectors.groupingBy(w->w.charAt(0), Collectors.counting())).entrySet().stream()
                .max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
    }



}
