package stream.task99skip.task16_grouping2_5;

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

    public void practice3 () {
        String[] words = {"apple", "sky",
                "banana", "dry", "orange"};
        Arrays.stream(words).collect(Collectors.groupingBy(a->a.chars().anyMatch(ch-> "aeiou".indexOf(ch) >= 0)));
    }

    public Map <Integer, Long> practice4 () {
        String[] words = {"apple", "banana",
                "orange", "umbrella",
                "ant", "dog", "egg"};
        return Arrays.stream(words).filter(w->"aeiou".indexOf(w.charAt(0))>=0).collect(Collectors.groupingBy(a->a.length(), Collectors.counting()));
    }
}
