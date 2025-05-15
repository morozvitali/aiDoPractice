package stream.task14;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main4 {
    public String filtering1 () {
        String[] words = {"java", "stream", "code", "developer", "sun"};
        return Arrays.stream(words).filter(a->a.contains("e")).reduce((a,b)-> a.length() >= b.length() ? a : b).orElse("");
    }

    public long filtering2 () {
        int[] numbers = {2, 4, 2, 6, 8, 4, 10, 10, 12};
        return Arrays.stream(numbers).filter(a->a%2 == 0).distinct().count();
    }

    public List<String> filtering3 () {
        List<String> words = List.of("APPLE", "Banana", "CHERRY", "kiwi", "PLUM");
        return words.stream().filter(a->a.length()%2 == 0).map(a->a.toUpperCase()).collect(Collectors.toList());
    }

    public

}
