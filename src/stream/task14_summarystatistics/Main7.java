package stream.task14_summarystatistics;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

public class Main7 {
    public void practice1 () {
        int[] numbers = {2, 4, 2, 6, 8, 4, 10, 10, 12};
        IntSummaryStatistics stats = Arrays.stream(numbers).distinct().summaryStatistics();
        System.out.println(stats.getCount());
        System.out.println(stats.getMax());
    }



}
