package stream1.task15_grouping_20;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main37 {
    public void task1() {
        String[] words = {"sky", "apple",
                "dry", "orange", "sun"};
        Arrays.stream(words).collect(Collectors.toMap(Function.identity(), w->countWovels(w)>0));
    }

    public static long countWovels(String s) {
        return s.chars().filter(c->"aeiou".indexOf(c)>=0).count();
    }

    public long task2 (String s) {
        return s.chars().mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(a->a.getValue() > 1)
                .count();
    }

    public String task3 (String s) {
        return Arrays.stream(s.split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("");
    }

}
