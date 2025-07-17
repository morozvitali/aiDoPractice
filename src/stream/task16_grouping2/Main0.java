package stream.task16_grouping2;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main0 {
    public void practice1 () {
        String[] words = {"apple", "banana",
                "dog", "kiwi", "plum"};
        Arrays.stream(words).map(a->a.toUpperCase())
                .collect(Collectors.groupingBy(w->w.length()));
    }




}
