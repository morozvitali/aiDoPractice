package stream.task15_grouping_20;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main34 {
    public void practice1 () {
        String[] words = {"sky", "apple", "dry", "orange", "sun"};
        Arrays.stream(words).collect(Collectors.toMap(Function.identity(), v->getCount(v) >0));
    }
    public static long getCount (String s) {
        return s.chars().filter(c->"aeiou".indexOf(c)>=0).count();
    }

    public Long practice2 (String s) {
        Map <Character, Long> map = s.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return map.entrySet().stream().filter(e->e.getValue() > 1).count();
    }

    public String practice3 (String s) {
        Map <String, Long> map = Arrays.stream(s.split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }


}
