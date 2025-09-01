package stream.task15_grouping_20;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main18 {
    public Map<String, Boolean> practice0() {
        String[] words = {"sky", "apple",
                "dry", "orange", "sun"};
        return Arrays.stream(words).collect(Collectors.toMap(Function.identity(), w -> w.chars().anyMatch(c -> "aeiou".indexOf(c) >= 0)));
    }

    public Long practice1(String s) {
        return s.toLowerCase().chars().mapToObj(i -> (char) i)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().filter(e -> e.getValue() > 1).count();
    }

    public String practice2(String s) {
        return Arrays.stream(s.toLowerCase().split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().max(Comparator.comparingLong(entry -> entry.getValue())).get().getKey();
    }

    public Map<Integer, Integer> practice3() {
        return Stream.of(12, 23, 34, 45, 16, 7)
                .collect(Collectors.groupingBy(v -> v % 10, Collectors.summingInt(n -> n)));
    }

    public int practice6() {
        return Stream.of(1, 2, 2, 3, 3, 3, 4, 4).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().max(Comparator.comparing(entry -> entry.getValue())).get().getKey();
    }

    public Map<Integer, Long> practice7() {
        return "ab123cc44a77".chars().filter(Character::isDigit)
                .mapToObj(a -> (int) a)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public Boolean practice8() {
        return Stream.of(1, 2, 3, 2)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().anyMatch(entry -> entry.getValue() > 1);
    }

    public Map<String, List<Integer>> practice9() {
        return Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.groupingBy(a -> a % 2 == 0 ? "even" : "odd"));
    }

    public Map<Integer, Double> practice10() {
        return Stream.of(3, 6, 7, 8, 9, 10, 12).collect(Collectors.groupingBy(v -> v % 3, Collectors.averagingInt(n -> n)));
    }

    public Character practice11() {
        String[] words = {"apple", "banana", "avocado",
                "blueberry", "bleuberry", "apricot"};
        return Arrays.stream(words).collect(Collectors.groupingBy(w -> w.charAt(0), Collectors.counting())).entrySet().stream().max(Comparator.comparing(v -> v.getValue())).get().getKey();
    }

    public Map<Character, Long> practice12() {
        Map<Character, Long> map = new HashMap<>();
        map.put('a', 2L);
        map.put('b', 5L);
        map.put('c', 1L);
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, // вирішення колізій (на всяк випадок)
                        LinkedHashMap::new // ось тут ми зберігаємо порядок
                ));
    }
}
