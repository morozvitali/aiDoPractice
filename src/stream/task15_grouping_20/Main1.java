package stream.task15_grouping_20;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

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


}
