package stream.task15_grouping_20;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main11 {
    public Map<String, Boolean> practice0 () {
        String[] words = {"sky", "apple",
                "dry", "orange", "sun"};
        return Arrays.stream(words)
                .collect(Collectors.toMap(Function.identity(), w->isHave(w)));
    }
    public boolean isHave(String s) {
        return s.chars().filter(c->"aeiou".indexOf(c)>=0).count() > 0;
    }

    public Long practice1 (String s) {
        return s.toLowerCase().chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().filter(e->e.getValue() >1).count();
    }


}
