package stream.task60x24.x1.task15_grouping_20;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main21 {
    public long practice1(String s) {
        return s.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() > 1).count();
    }

    public String practice2(String s) {
        return Arrays.stream(s.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
    }

    public Map<Integer, Integer> practice3() {
        return Stream.of(12, 23, 34, 45, 16, 7)
                .collect(Collectors.groupingBy(a -> a % 10, Collectors.summingInt(n -> n)));
    }

    public Integer practice6() {
        return Stream.of(1, 2, 2, 3, 3, 3, 4, 4)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(Comparator.comparingLong(Map.Entry::getValue)).get().getKey();
    }

    public Map<Integer, Long> practice7(String s) {
        return s.chars().filter(Character::isDigit)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public boolean practice8() {
        return Stream.of(1, 2, 3, 2)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().anyMatch(e -> e.getValue() > 1);
    }

    public Map<String, List<Integer>> practice9() {
        return Stream.of(1, 2, 3, 4, 5).collect(Collectors.groupingBy(a -> (int) a % 2 == 0 ? "even" : "odd"));
    }

    public Map<Integer, Double> practice10() {
        return Stream.of(3, 6, 7, 8, 9, 10, 12)
                .collect(Collectors.groupingBy(a -> a % 3, Collectors.averagingInt(n -> n)));
    }

    public Character practice11() {
        return Stream.of("apple", "banana", "avocado",
                        "blueberry", "bleuberry", "apricot")
                .collect(Collectors.groupingBy(w -> w.charAt(0), Collectors.counting()))
                .entrySet().stream().max(Comparator.comparing(e -> e.getValue()))
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public Map<Character, Long> practice12() {
        Map<Character, Long> map = new HashMap<>();
        map.put('a', 2L);
        map.put('b', 5L);
        map.put('c', 1L);
        return map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));
    }
}
