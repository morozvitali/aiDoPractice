package stream1.task15_grouping_20;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main31 {

    public Map<String, Boolean> practice1() {
        String[] words = {"sky", "apple",
                "dry", "orange", "sun"};
        return Arrays.stream(words)
                .collect(Collectors.toMap(Function.identity(), w -> w.chars()
                        .anyMatch(c -> "aeiou".indexOf(c) >= 0)));
    }

    public Map<Character, Long> practice2(String s) {
        return s.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public String practice3() {
        return Arrays.stream("java is fun and java is powerful".split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("");
    }

    public Map<Integer, Integer> practice4() {
        return Stream.of(12, 23, 34, 45, 16, 7).collect(Collectors.groupingBy(n -> n % 10, Collectors.summingInt(n -> n)));
    }

    public int practice5() {
        return Stream.of(12, 23, 34, 45, 16, 7).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(-1);
    }

    public Map<Character, Long> practice6() {
        return "ab123cc44a77".chars().mapToObj(c -> (char) c).filter(Character::isDigit).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public Boolean practice7() {
        return Stream.of(1, 2, 3, 2).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().anyMatch(v -> v.getValue() > 1);
    }

    public Map<String, List<Integer>> practice8() {
        return Stream.of(1, 2, 3, 4, 5).collect(Collectors.groupingBy(n -> n % 2 == 0 ? "even" : "odd"));
    }

    public Map<Integer, Double> practice9() {
        return Stream.of(3, 6, 7, 8, 9, 10, 12).collect(Collectors.groupingBy(n -> n % 3, Collectors.averagingInt(n -> n)));
    }

    public Character practice10 () {
        String[] words = {"apple", "banana", "avocado",
                "blueberry", "bleuberry", "apricot"};
        Map <Character, Long> map = Arrays.stream(words)
                .collect(Collectors
                        .groupingBy(w->w.charAt(0), Collectors.counting()));
        for(var e : map.entrySet()) {
            e.getValue();
            e.getKey();
            e.setValue(11L);
        }
        return map.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
    }


}