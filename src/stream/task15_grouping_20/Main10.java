package stream.task15_grouping_20;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main10 {
    public Map<String, Boolean> practice0 () {
        return Stream.of("sky", "apple",
                "dry", "orange", "sun").collect(Collectors.toMap(Function.identity(), w->w.chars().anyMatch(ch->"aeiou".indexOf(ch) >= 0)));
    }

    public void practice1 (String s) {
        Map <Character, Long> map = s.toLowerCase().chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c, Collectors.counting()));
    }


}
