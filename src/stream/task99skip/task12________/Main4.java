package stream.task99skip.task12________;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Main4 {
    public Map<Character, Long> countWordsByFirstLetter1 (String[] array) {
        return Arrays.stream(array).collect(Collectors.groupingBy(a->a.charAt(0), Collectors.counting()));
    }
    public Map<Character, String> countWordsByFirstLetter2 (String[] array) {
        return Arrays.stream(array).collect(Collectors.toMap(a->a.charAt(0), a->a.toUpperCase()));
        }
}
