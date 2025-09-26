package stream.task60x24.x1.task15_grouping_20;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main2 {
    public Map<Integer, List<String>> myGroupping1 () {
        String[] words = {"apple", "dog", "banana", "cat", "kiwi", "plum", "watermelon"};
        return Arrays.stream(words).collect(Collectors.groupingBy(a->a.length()));
    }

    public void myGrouping2 () {
        List <String> words = List.of ("Apple", "apricot", "Banana", "blue", "Cherry", "cranberry");
        words.stream().map(a->a.toLowerCase())
                .collect(Collectors.groupingBy(a->a.charAt(0)));
    }

    public void myGrouping3 () {
        String[] words = {"apple", "banana", "apricot", "blue", "berry", "cherry"};
        Arrays.stream(words).collect(Collectors.groupingBy(c->c.charAt(0), Collectors.counting()));
    }

    public Map<String, Boolean> myGrouping4 () {
        String[] words = {"sky", "apple", "dry", "orange", "sun"};
        return Arrays.stream(words)
                .collect(Collectors.toMap(
                        a->a,
                        a->a.chars().anyMatch(c->"aeiou".indexOf(c)>=0)));
    }
}
