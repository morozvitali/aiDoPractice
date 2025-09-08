package stream.task15_grouping_20;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main22 {
    public Map<String, Boolean> practice0 () {
        return Stream.of("sky", "apple",
                "dry", "orange", "sun")
                .collect(Collectors.toMap(Function.identity(), w->w.chars().anyMatch(c->"aeiou".indexOf(c)>=0)));
    }



}
