package stream.task17_collectors_18;

import java.util.IntSummaryStatistics;
import java.util.List;

public class Main9 {
    public IntSummaryStatistics practice2 () {
        List<Integer> numbers = List.of(4, 8, 15, 16, 23, 42);
        return numbers.stream().mapToInt(i->(int)i).summaryStatistics();
    }



}
