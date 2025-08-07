package stream.task15_grouping1_20;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public Map<Integer, List<String>> groupingArray1 (String [] array) {
        return Arrays.stream(array).collect(Collectors.groupingBy(word -> word.length()));
    }


    public Map<Character, List<String>> groupingArray2 (String [] array) {
        return Arrays.stream(array)
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(word -> word.charAt(0)));
    }

    public Map<Character, Long> groupingArray3 (String [] array) {
        return Arrays.stream(array)
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(word -> word.charAt(0), Collectors.counting()));
    }

    public Map<String, Boolean> groupingArray4 (String [] array) {
        return Arrays.stream(array)
                .collect(Collectors.toMap(
                        word -> word,
                        word -> word.chars()
                                .anyMatch(c->"aouei".indexOf(c)>=0)));
    }
}
