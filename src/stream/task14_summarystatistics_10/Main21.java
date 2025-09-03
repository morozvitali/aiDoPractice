package stream.task14_summarystatistics_10;

import java.util.Arrays;
import java.util.List;

public class Main21 {
    public long practice1 () {
        int[] numbers = {2, 4, 2, 6, 8, 4, 10, 10, 12};
        return Arrays.stream(numbers).distinct().summaryStatistics().getCount();
    }

    public int practice2 () {
        List<String> words = List.of("APPLE",
                "Banana", "CHERRY", "kiwi", "PLUM");
        return words.stream().filter(a->a.length()%2==0)
                .map(a->a.toLowerCase())
                .mapToInt(String::length)
                .sum();
    }
}
