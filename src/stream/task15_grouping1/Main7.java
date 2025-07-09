package stream.task15_grouping1;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

public class Main7 {
    public long practice1 () {
        int[] numbers = {2, 4, 2, 6, 8, 4, 10, 10, 12};
        IntSummaryStatistics stats = Arrays.stream(numbers).filter(a->a%2==0).distinct().summaryStatistics();
        return stats.getCount();
    }



}
