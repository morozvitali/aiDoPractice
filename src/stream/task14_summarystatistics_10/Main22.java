package stream.task14_summarystatistics_10;

import java.util.Arrays;
import java.util.List;

public class Main22 {
    public Double practice1 () {
        int[] numbers = {2, 4, 2, 6, 8, 4, 10, 10, 12};
        return Arrays.stream(numbers).distinct().summaryStatistics().getAverage();
    }

    public Long practice2 () {
        List<String> words = List.of("APPLE",
                "Banana", "CHERRY", "kiwi", "PLUM");
        return words.stream().map(String::toUpperCase).mapToInt(String::length).filter(a->a%2==0)
                .summaryStatistics().getCount();
    }


}
