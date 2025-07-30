package stream.task15_grouping1;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main8 {
    public Map<String, Boolean> practice1 () {
        String[] words = {"sky", "apple",
                "dry", "orange", "sun"};
        return Arrays.stream(words)
                .collect(Collectors
                        .toMap(Function.identity(),
                                word -> word
                                        .chars()
                                        .anyMatch(ch -> "aeiou"
                                                .indexOf(ch) >= 0)
                ));
    }


}
