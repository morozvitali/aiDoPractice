package stream.task15_grouping_20;

import java.util.Arrays;
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

    public void practce2 () {

    }
}
