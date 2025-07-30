package stream.task16_grouping2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main7 {


    public Map<Integer, List<String>> practice1 () {
        String[] words = {"apple", "banana",
                "dog", "kiwi", "plum"};
        return Arrays.stream(words).map(a->a.toUpperCase())
                .collect(Collectors.groupingBy(a->a.length()));
    }

    public Map <Integer, Long> practice2 () {
        String[] words = {"apple", "banana",
                "dog", "kiwi", "plum"};
        return Arrays.stream(words).filter(w->w.chars()
                .anyMatch(c->"aeiou".indexOf(c) >=0))
                .collect(Collectors.groupingBy(w->w.length(),
                        Collectors.counting()));
    }



}
