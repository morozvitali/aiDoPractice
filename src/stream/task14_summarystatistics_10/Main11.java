package stream.task14_summarystatistics_10;

import java.util.Arrays;
import java.util.stream.Stream;

public class Main11 {
    public Double practice1 () {
        int[] numbers = {2, 4, 2, 6, 8, 4, 10, 10, 12};
        return Arrays.stream(numbers)
                .distinct()
                .filter(a->a%2 == 0)
                .summaryStatistics().getAverage();
    }


}
