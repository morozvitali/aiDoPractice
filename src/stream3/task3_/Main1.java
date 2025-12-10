package stream3.task3_;

import java.util.Arrays;
import java.util.List;
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

    public Map <Boolean, List<String>> practice2 () {
        String [] array = new String [] {"Aa", "Bba", "Cec"};
        return Arrays.stream(array)
                .collect(Collectors.partitioningBy(w->w.chars()
                        .anyMatch(c->"aeiou".indexOf(c)>=0)));
    }

    public void practice3 () {
        String [] array = new String [] {"Aa", "Bba", "Cec"};
        return Arrays.stream(array).
                filter(w->w.chars().anyMatch(c->"aeiou".indexOf(c)>=0))
                .collect(Collectors.groupingBy(String::length, Collectors.counting()))
    }



}
