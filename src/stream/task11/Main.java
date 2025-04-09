package stream.task11;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

    }


    public List<String> collector (String [] array) {
        return Arrays.stream(array)
                .filter(a->a.startsWith("A"))
                .collect(Collectors.toList());
    }

    public Long counter (int [] array) {
            return Arrays.stream(array)
                .filter(a->a%2==0)
                .count();
    }

    public List <String> grouper (String [] array) {
            return (List<String>) Arrays.stream(array)
                    .sorted()
                    .collect(Collectors.groupingBy(word -> word.charAt(0)));
    }

    public Map <String, Integer> myMaper (String [] array) {
        return Arrays.stream(array)
                .collect(Collectors.toMap(word -> word, word -> word.length()));
    }
}
 