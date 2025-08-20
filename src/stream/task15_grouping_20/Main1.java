package stream.task15_grouping_20;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main1 {
    public Map<String, Boolean> practice1 () {
        String[] words = {"sky", "apple",
                "dry", "orange", "sun"};
        return Arrays.stream(words).collect(Collectors.toMap(Function.identity(), this::isHaveVowels));
    }

    public boolean isHaveVowels (String s) {
        return s.chars().filter(c -> "aeiou".indexOf(c) >= 0).findAny().isPresent();
    }

    public String practice2 () {
        return Arrays.stream("java is fun and java is powerful".split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet()
                .stream().max(Comparator.comparing(Map.Entry::getValue)).get().getKey();
    }

    public Map <Integer, Integer> practice3 () {
        return Stream.of(12, 23, 34, 45, 16, 7)
                .collect(Collectors.groupingBy(value->value%10, Collectors.summingInt(n->n)));
    }

    public Integer practice6 () {
        return Stream.of(1,2,2,3,3,3,4,4)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().max(Comparator.comparingLong(value-> value.getValue())).get().getKey();
    }



}
