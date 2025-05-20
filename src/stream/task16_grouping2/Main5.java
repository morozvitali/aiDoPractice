package stream.task16_grouping2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main5 {

    public Map<Integer, List<String>> mapping1() {
        String[] words = {"apple", "banana", "dog", "kiwi", "plum"};
        return Arrays.stream(words).map(a->a.toUpperCase()).collect(Collectors.groupingBy(w->w.length()));
    }

    public Map <Integer, Long> mapping2 () {
        String[] words = {"apple", "banana", "dg", "kiwi", "plm"};
        return Arrays.stream(words).filter(a->a.chars().anyMatch(c -> "aeiou".indexOf(c)>=0))
                .collect(Collectors.groupingBy(a->a.length(), Collectors.counting()));
    }

    public Map <Boolean, List <String>> mapping3 () {
        String[] words = {"apple", "sky", "banana", "dry", "orange"};
        return Arrays.stream(words).collect(Collectors.groupingBy(s->s.chars().anyMatch(a->"aeiou".indexOf(a)>=0)));
    }

    public Map <Integer, Long> mapping4 () {
        String[] words = {"apple", "banana", "orange", "umbrella",
                "ant", "dog", "egg"};
        return Arrays.stream(words).filter(a->"aeiou".indexOf(a.charAt(0)) >=0)
                .collect(Collectors.groupingBy(a->a.length(), Collectors.counting()));
    }
}
