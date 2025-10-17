package stream1.task15_grouping_20;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main35 {
    public void practice1 () {
        String[] words = {"sky", "apple",
                "dry", "orange", "sun"};
        Map<String, Boolean> map = Arrays.stream(words).collect(Collectors.toMap(Function.identity(), w->getCount(w)>0));
    }

    public static long getCount(String s) {
        return s.chars().filter(c->"aeiou".indexOf(c)>=0).count();
    }


}
