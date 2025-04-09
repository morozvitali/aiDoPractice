package stream.task13;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public Long myCounter (String [] array) {
        return Arrays.stream(array)
                .filter(word -> word.length()>3)
                .collect(Collectors.counting());
    }

    public String myFilter (String [] array) {
        return Arrays.stream(array)
                .filter(word -> word.startsWith("s"))
                .reduce((a, b) -> a.length() <= b.length() ? a : b)
                .orElse("немає результату");
        }

    public int mySqrt (int [] array) {
        return Arrays.stream(array).map(a-> a*a).reduce(0, (a,b) -> a+b);
    }


    public String [] myUper (String [] array){
        return Arrays.stream(array)
                .filter(word -> word.length() == 4)
                .map(word -> word.toUpperCase())
                .toArray(String[]::new);
    }

    public Map<String, Long> myMaper(String[] array) {
        return Arrays.stream(array)
                .collect(Collectors.toMap(
                        word -> word,
                        word -> word.chars()
                                .filter(c -> "aeiou".indexOf(c) >= 0)
                                .count()
                ));
    }
}
