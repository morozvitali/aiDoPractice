package stream1.task15_grouping_20;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main36 {
    public Map<String, Boolean> practice1() {
        String[] words = {"sky", "apple", "dry", "orange", "sun"};
        return Arrays.stream(words).collect(Collectors.toMap(Function.identity(), w -> getCount(w) > 0));
    }

    public static long getCount(String s) {
        return s.chars().filter(c -> "aeiou".indexOf(c) >= 0).count();
    }

    public Long practice2(String s) {
        return s.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().filter(v -> v.getValue() > 1).count();
    }

    public String practice3(String s) {
        return Arrays.stream(s.split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("-1");
    }

    public Map <Integer, Integer> practice4 () {
        return Stream.of(12, 23, 34, 45, 16, 7).collect(Collectors.groupingBy(a->a%10, Collectors.summingInt(n->n)));
    }

    public Integer practice5 () {
        return Stream.of(1,2,2,3,3,3,4,4).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(-1);
    }

    public Map <Integer, Long> practice6 (String s) {
        return s.chars().filter(Character::isDigit).map(Character::getNumericValue).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public Boolean practice7 () {
        return Stream.of(1, 2, 3, 2).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().anyMatch(v->v.getValue() >1);
    }

    public Map <String, List<Integer>> practice8 () {
        return Stream.of(1, 2, 3, 4, 5).collect(Collectors.groupingBy(a->a%2==0 ? "even" : "odd"));
    }


}