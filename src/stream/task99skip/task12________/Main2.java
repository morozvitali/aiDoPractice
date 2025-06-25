package stream.task99skip.task12________;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Main2 {

    public Map<Character, Long> countWordsByFirstLetter1 (String[] array) {
        return Arrays.stream(array).collect(Collectors.groupingBy(word -> word.charAt(0), Collectors.counting()));
    }

    public Map<String, String> countWordsByFirstLetter2 (String[] array) {
        return Arrays.stream(array).collect(Collectors.toMap(word -> word, word -> word.toUpperCase()));
    }
}
