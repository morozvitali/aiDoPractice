package stream.task15_grouping_20;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main13 {
    public Map<String, Boolean> practice1 () {
        String[] words = {"sky", "apple",
                "dry", "orange", "sun"};
        return Arrays.stream(words).collect(Collectors.toMap(Function.identity(), this::isHaveVovels));
    }
    public boolean isHaveVovels (String s) {
        return s.chars().anyMatch(a->"aeiou".indexOf(a) >=0);
    }
}
