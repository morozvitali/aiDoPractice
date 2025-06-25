package stream.task99skip.task12________;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Main5 {
    public Map<Character, Long> countWordsByFirstLetter(String[] array) {
        return Arrays.stream(array).collect(Collectors.groupingBy(a -> a.charAt(0), Collectors.counting()));
    }

    public Map<String, String> upperMap(String[] array) {
        return Arrays.stream(array).collect(Collectors.toMap(a -> a, a -> a.toUpperCase()));
    }
}