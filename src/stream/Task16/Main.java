package stream.Task16;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public Map<Integer, List<String>> mapGrouping(String[] array) {
        return Arrays.stream(array)
                .map(String::toUpperCase)
                .collect(Collectors.groupingBy(word -> word.length()));
    }

    public Map<Integer, Long> mapGrouping2(String[] array) {
        return Arrays.stream(array)
                .filter(word -> word.chars()
                        .filter(c -> "aeoui".indexOf(c) >= 0)
                        .count() > 0)
                .collect(Collectors.groupingBy(
                        word -> word.length(),
                        Collectors.counting()
                ));
    }

    public Map <Boolean, List<String>> mapGrouping3(String[] array) {
        return Arrays.stream(array)
                .collect(Collectors.partitioningBy(
                        word -> word.chars().anyMatch(c -> "aeoui".indexOf(c) >= 0)
                ));
    }

    public Map <Integer, Long> mapGrouping4(String[] array) {
        return Arrays.stream(array)
                .filter(word -> "aeoui".indexOf(word.charAt(0)) >= 0)
                .collect(Collectors.groupingBy(
                        word -> word.length(),
                        Collectors.counting()
                ));
    }
}
