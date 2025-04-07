package stream.Task16;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main3 {
    public Map<Integer, List<String>> myGrouping() {

        return Arrays.stream(new String[]{"apple", "banana", "dog", "kiwi", "plum"})
                .map(a -> a.toUpperCase())
                .collect(Collectors.groupingBy(a -> a.length()));

    }
}