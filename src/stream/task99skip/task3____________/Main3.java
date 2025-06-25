package stream.task99skip.task3____________;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main3 {

    public List<String> filter1 (String sentence) {
        return Arrays.stream(sentence.split(" "))
                .filter(a -> "aeiou".indexOf(a.charAt(0)) >= 0)
                .collect(Collectors.toList());
    }

    public List<String> filter2 (String sentence) {
        return Arrays.stream(sentence.split(" "))
                .filter(a-> counter(a)>2)
                .collect(Collectors.toList());
    }

    public long counter (String word) {
        return word.chars().filter(c -> "aeiou".indexOf(c) >= 0).count();
    }

    public List<String> filter3 (String sentence) {
        return Arrays.stream(sentence.split(" "))
                .filter(a->a.length()>=3 && a.length()<=5)
                .map(a->a.toUpperCase())
                .collect(Collectors.toList());
    }
}
