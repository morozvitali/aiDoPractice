package stream.task15_grouping_20;

import java.util.Arrays;
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



}
