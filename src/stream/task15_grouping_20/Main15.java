package stream.task15_grouping_20;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main15 {
    public Map<String, Boolean> practice0() {
        return Stream.of("sky", "apple",
                        "dry", "orange", "sun")
                .collect(Collectors.toMap(w -> w, w -> w.chars().filter(c -> "aeiou".indexOf(c) >= 0).findAny().isPresent()));
    }
}
