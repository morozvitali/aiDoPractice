package stream.task15_grouping_20;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main5 {
    public Map<Integer, List<String>> mapping1 () {
        String[] words = {"apple", "dog", "banana", "cat", "kiwi", "plum", "watermelon"};
        return Arrays.stream(words).collect(Collectors.groupingBy(a -> a.length()));
    }

    public Map <Character, List<String>> mapping2 () {
        List<String> words = List.of("Apple", "apricot", "Banana", "blue", "Cherry", "cranberry");
        return words.stream().map(a->a.toLowerCase()).collect(Collectors.groupingBy(a->a.charAt(0)));
    }

    public Map<Character, Long> mappibg () {
        String[] words = {"apple", "banana", "apricot", "blue", "berry", "cherry"};
        return Arrays.stream(words).map(a->a.toLowerCase())
                .collect(Collectors.groupingBy (a->a.charAt(0), Collectors.counting()));
    }

    public Map <String, Boolean> mapping () {
        String[] words = {"sky", "apple", "dry", "orange", "sun"};
        return Arrays.stream(words).collect(Collectors.toMap(a->a, a->isContain(a)));
    }

    public boolean isContain (String s) {
        return s.chars().boxed().filter(a->"aeiou".indexOf(a) >= 0).count() > 0 ? true : false;
    }
}
