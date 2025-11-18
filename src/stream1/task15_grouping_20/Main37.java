package stream1.task15_grouping_20;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main37 {
    public void task1() {
        String[] words = {"sky", "apple",
                "dry", "orange", "sun"};
        Arrays.stream(words).collect(Collectors.toMap(Function.identity(), w -> countWovels(w) > 0));
    }

    public static long countWovels(String s) {
        return s.chars().filter(c -> "aeiou".indexOf(c) >= 0).count();
    }

    public long task2(String s) {
        return s.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(a -> a.getValue() > 1)
                .count();
    }

    public String task3(String s) {
        return Arrays.stream(s.split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("");
    }

    public Map<Integer, Integer> task4() {
        return Stream.of(2, 23, 34, 45, 16, 7).collect(Collectors.groupingBy(n -> n % 10, Collectors.summingInt(n -> n)));
    }

    public int task5() {
        return Stream.of(1, 2, 2, 3, 3, 3, 4, 4).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(Comparator.comparingLong(Map.Entry::getValue)).map(Map.Entry::getKey).orElse(-1);
    }

    public Map<Integer, Long> task6(String s) {
        return s.chars().filter(Character::isDigit).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public boolean task7() {
        return Stream.of(1, 2, 3, 2).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().anyMatch(a -> a.getValue() > 1);
    }

    public Map<String, List<Integer>> task8() {
        return Stream.of(1, 2, 3, 4, 5).collect(Collectors.groupingBy(a -> a % 2 == 0 ? "even" : "odd"));
    }

    public Map<Integer, Double> task9() {
        return Stream.of(3, 6, 7, 8, 9, 10, 12).collect(Collectors.groupingBy(a->a%3, Collectors.averagingInt(n->n)));
    }

}
