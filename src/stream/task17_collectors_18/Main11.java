package stream.task17_collectors_18;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Main11 {
    public IntSummaryStatistics practice1 () {
        List<Integer> numbers = List.of(4, 8, 15, 16, 23, 42);
        return numbers.stream().collect(Collectors.summarizingInt(i->i));
    }



}
