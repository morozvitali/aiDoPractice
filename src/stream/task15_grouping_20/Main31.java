package stream.task15_grouping_20;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main31 {

    public Map<String, Boolean> practice1 () {
        String[] words = {"sky", "apple",
                "dry", "orange", "sun"};
        return Arrays.stream(words)
                .collect(Collectors.toMap(Function.identity(), w->w.chars()
                        .anyMatch(c->"aeiou".indexOf(c)>=0)));
    }

    public Map <Character, Long> practice2 (String s) {
        return s.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }



}
