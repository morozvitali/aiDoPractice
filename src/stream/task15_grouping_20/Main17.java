package stream.task15_grouping_20;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main17 {
    public Map<String, Boolean> practice1 () {
        String[] words = {"sky", "apple",
                "dry", "orange", "sun"};
        return Arrays.stream(words)
                .collect(Collectors.toMap(Function.identity(),
                        Main17::isHasVovels));

    }

    public static boolean isHasVovels(String s) {
        return s.chars().anyMatch(c->"aeiou".indexOf(c) >=0);
    }


}
