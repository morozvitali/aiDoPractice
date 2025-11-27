package stream1.task14_summarystatistics_10;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

public class Main38 {
    public IntSummaryStatistics practice1 () {
        int[] numbers = {2, 4, 2, 6, 8, 4, 10, 10, 12};
            return Arrays.stream(numbers).distinct().summaryStatistics();
    }




}
