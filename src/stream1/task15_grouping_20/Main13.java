package stream1.task15_grouping_20;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main13 {
    public Map<String, Boolean> practice0() {
        String[] words = {"sky", "apple",
                "dry", "orange", "sun"};
        return Arrays.stream(words).collect(Collectors.toMap(Function.identity(), this::isHaveVovels));
    }

    public boolean isHaveVovels(String s) {
        return s.chars().anyMatch(a -> "aeiou".indexOf(a) >= 0);
    }

    public Long practice1(String s) {
        Map<Character, Long> map = s.toLowerCase().chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return map.entrySet().stream().filter(e -> e.getValue() > 1).count();
    }

    public String practice2() {
        Map<String, Long> map = Arrays.stream("java is fun and java is powerful".split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return map.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
    }

    public Map<Integer, Integer> practice3() {
        return Stream.of(2, 23, 34, 45, 16, 7).collect(Collectors.groupingBy(value -> value % 10, Collectors.summingInt(n -> n)));
    }

    public Integer practice6() {
        Map<Integer, Long> map = Stream.of(1, 2, 2, 3, 3, 3, 4, 4)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return map.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getKey();
    }

    public Map<Integer, Long> practice7() {
        return "ab123cc44a77".chars()
                .filter(Character::isDigit)
                .mapToObj(i -> i)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public Boolean practice8() {
        return Stream.of(1, 2, 3, 2).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().anyMatch(entry -> entry.getValue() > 1);
    }

    public Map<String, List<Integer>> practice9() {
        return Stream.of(1, 2, 3, 4, 5).collect(Collectors.groupingBy(a -> a % 2 == 0 ? "even" : "odd"));
    }

    public Map<Integer, Double> practice10() {
        int[] numbers = {3, 6, 7, 8, 9, 10, 12};
        return Arrays.stream(numbers).boxed().collect(Collectors.groupingBy(a -> a % 3, Collectors.averagingInt(n -> n)));
    }

    public Character practice11() {
        String[] words = {"apple", "banana", "avocado",
                "blueberry", "bleuberry", "apricot"};
        return Arrays.stream(words)
                .collect(Collectors.groupingBy(w -> w.charAt(0)))
                .entrySet().stream()
                .max(Comparator.comparingLong(n -> n.getValue().size()))                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public Map<Character, Long> practice12() {
        Map<Character, Long> map = new HashMap<>();
        map.put('a', 2L);
        map.put('b', 5L);
        map.put('c', 1L);
        return map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toMap(w -> w.getKey(), w -> w.getValue()
        ));
    }
}
