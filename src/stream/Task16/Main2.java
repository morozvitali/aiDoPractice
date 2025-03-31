package stream.Task16;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main2 {
    public void myGrouPing() {
        String[] words = {"apple", "banana", "dog", "kiwi", "plum"};
        Arrays.stream(words).map(a -> a.toUpperCase())
                .collect(Collectors.groupingBy(a -> a.length()));
    }

    public void myGrouPing2() {
        String[] words = {"apple", "sky", "banana", "dry", "orange"};
        Arrays.stream(words).filter(a -> a.chars()
                        .filter(c -> "aeiou".indexOf(c) >= 0)
                        .count() > 0)
                .collect(Collectors.groupingBy(a -> a.length()));
    }

    public Map <Boolean, List<String>> myGrouPing3 () {
        String[] words = {"apple", "sky", "banana", "dry", "orange"};
        return Arrays.stream(words).collect(Collectors.partitioningBy(word->word.chars().anyMatch(c->"aeiou".indexOf(c) >=0)));
    }

    public Map <Integer, Long> myGrouPing4 () {
        String[] words = {"apple", "banana", "orange", "umbrella", "ant", "dog", "egg"};
        return Arrays.stream(words)
                .filter(word -> "aeoui".indexOf(word.charAt(0)) >= 0)
                .collect(Collectors.groupingBy(
                        word -> word.length(),
                        Collectors.counting()
                ));
    }
}



