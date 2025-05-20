package stream.task15_grouping1;

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


}
