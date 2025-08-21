package stream.task15_grouping_20;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main13 {
    public Map<String, Boolean> practice0 () {
        String[] words = {"sky", "apple",
                "dry", "orange", "sun"};
        return Arrays.stream(words).collect(Collectors.toMap(Function.identity(), this::isHaveVovels));
    }
    public boolean isHaveVovels (String s) {
        return s.chars().anyMatch(a->"aeiou".indexOf(a) >=0);
    }

    public Long practice1 (String s) {
        Map <Character, Long> map =  s.toLowerCase().chars().mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return map.entrySet().stream().filter(e->e.getValue() >1).count();
    }



}
