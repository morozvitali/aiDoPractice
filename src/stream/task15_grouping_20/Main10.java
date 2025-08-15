package stream.task15_grouping_20;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main10 {
    public Map<String, Boolean> practice1 () {
        return Stream.of("sky", "apple",
                "dry", "orange", "sun").collect(Collectors.toMap(Function.identity(), w->w.chars().anyMatch(ch->"aeiou".indexOf(ch) >= 0)));
    }



}
