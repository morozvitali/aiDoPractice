package stream.task14_summarystatistics_10;

import java.util.Arrays;
import java.util.List;

public class Main13 {
    public Long practice1 () {
        int[] numbers = {2, 4, 2, 6, 8, 4, 10, 10, 12};
        return Arrays.stream(numbers).distinct().summaryStatistics().getCount();
    }

    public long practice2 () {
        List<String> words = List.of("APPLE",
                "Banana", "CHERRY", "kiwi", "PLUM");
        return words.stream()
                .filter(w->w.length() %2 ==0)
                .map(w->w.toLowerCase())
                .mapToInt(String::length)
                .summaryStatistics().getSum();
    }



}
