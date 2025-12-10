package stream3.task3_;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main1 {
    public Map<String, Boolean> practice1 () {
        String [] words = new String[] {"Aa", "Bba", "Cec"};
        return Arrays.stream(words)
                        .collect(Collectors.toMap(Function.identity(),
                                w->w.chars().anyMatch(c->"aeiou".indexOf(c)>=0)));
    }




}
