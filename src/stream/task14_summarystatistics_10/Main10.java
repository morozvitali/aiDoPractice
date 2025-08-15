package stream.task14_summarystatistics_10;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;

public class Main10 {
    public long practice1 () {
        int[] numbers = {2, 4, 2, 6, 8, 4, 10, 10, 12};
        IntSummaryStatistics stats = Arrays.stream(numbers).filter(a->a%2==0).distinct().summaryStatistics();
        return stats.getCount();
    }


}
