package stream.task15_grouping_20;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main14 {
    public Map<String, Boolean> practice0 () {
        String[] words = {"sky", "apple",
                "dry", "orange", "sun"};
    return Arrays.stream(words).collect(Collectors.toMap(Function.identity(), Main14::isHaveVOvel));
    }
    public static Boolean isHaveVOvel (String s) {
        return s.chars().anyMatch(c->"aeiou".indexOf(c) >=0);
    }

    public Map<Character, Long> practice1 (String s) {
        return s.toLowerCase().chars().mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }



}
