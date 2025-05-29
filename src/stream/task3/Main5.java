package stream.task3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main5 {
    public List<String> myFiltering () {
        String sentence = "Every orange is an amazing object";
        String [] array = sentence.split(" ");
        return Arrays.stream(array).map(a->a.toLowerCase())
                .filter(s->"aeiou".indexOf(s.charAt(0))>=0)
                .toList();
    }
}
