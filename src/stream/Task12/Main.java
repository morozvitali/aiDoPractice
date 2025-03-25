package stream.Task12;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

    }

    public Map<Character, Long> myCounter(String[] array) {
        return Arrays.stream(array).collect(Collectors.groupingBy(word -> word.charAt(0), Collectors.counting()));
    }

    public Map<String, String> myUpper(String[] array) {
        return Arrays.stream(array)
                .collect(Collectors.toMap(word -> word, word -> word.toUpperCase()));
    }
}
