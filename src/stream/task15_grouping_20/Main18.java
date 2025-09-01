package stream.task15_grouping_20;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main18 {
    public Map<String, Boolean> practice0 () {
        String[] words = {"sky", "apple",
                "dry", "orange", "sun"};
        return Arrays.stream(words).collect(Collectors.toMap(Function.identity(), w->w.chars().anyMatch(c->"aeiou".indexOf(c) >= 0)));
    }

public Long practice1 (String s) {
        return s.toLowerCase().chars().mapToObj(i->(char)i)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().filter(e->e.getValue() > 1).count();
}



}
