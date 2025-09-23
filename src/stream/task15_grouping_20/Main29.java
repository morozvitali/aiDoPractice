package stream.task15_grouping_20;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main29 {
    public Map<String, Boolean> practice1 () {
        String[] words = {"sky", "apple",
                "dry", "orange", "sun"};
        return Arrays.stream(words).collect(Collectors.toMap(Function.identity(), w->count(w)>0));
    }
    public static long count (String s) {
        return s.chars().filter(c->"aeiou".indexOf(c)>=0).count();
    }



}
