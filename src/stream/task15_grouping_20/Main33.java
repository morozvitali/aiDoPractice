package stream.task15_grouping_20;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main33 {
    public Map<String, Boolean> practice1 () {
        String[] words = {"sky", "apple",
                "dry", "orange", "sun"};
        return Arrays.stream(words).collect(Collectors.toMap(Function.identity(), w->getCount(w)>0));
    }

    public static Long getCount (String s) {
        return  s.chars().filter(c->"aeiou".indexOf(c)>=0).count();
    }

    public Long practice2 (String s) {
        return s.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(e->e.getValue() >1).count();
    }

    public String practice3 () {
        Map<String, Long> map = Arrays.stream("java is fun and java is powerful".split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
