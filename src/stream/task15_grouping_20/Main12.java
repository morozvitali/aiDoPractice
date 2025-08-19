package stream.task15_grouping_20;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main12 {
    public void practice0 () {
        String[] words = {"sky", "apple",
                "dry", "orange", "sun"};
        Arrays.stream(words).collect(Collectors.toMap(Function.identity(), w->w.chars().anyMatch(c->"aeiou".indexOf(c)>=0)));
    }

    public String practice1 () {
        Map<String, Long> map =  Arrays.stream("java is fun and java is powerful".split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return Collections.max(map.entrySet(), Comparator.comparingLong(entry -> entry.getValue())).getKey();
    }
}
