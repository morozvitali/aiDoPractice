package stream.task15_grouping_20;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main19 {

    public Map<String, Boolean> practice0() {
        String[] words = {"sky", "apple",
                "dry", "orange", "sun"};
        return Arrays.stream(words).collect(Collectors.toMap(Function.identity(), w->isHaveVovels(w)));
    }

    public boolean isHaveVovels (String s) {
        return s.chars().anyMatch(a->"aeiou".indexOf(a) >=0);
    }

    public long practice1 (String s) {
        return s.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().filter(e->e.getValue() > 1).count();
    }

}