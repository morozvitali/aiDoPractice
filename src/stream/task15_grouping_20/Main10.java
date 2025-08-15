package stream.task15_grouping_20;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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

    public String practice2 (String sentence) {
        Map <String, Long> map = Arrays.stream(sentence.split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return Collections.max(map.entrySet(), Comparator.comparingLong(entry ->entry.getValue())).getKey();
    }

    public Map <Integer, Integer> practice3 () {
        return Stream.of(12, 23, 34, 45, 16, 7).collect(Collectors.groupingBy(w-> w%10, Collectors.summingInt(w->w)));
    }


}
