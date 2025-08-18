package stream.task17_collectors_18;

import java.util.List;

public class Main8 {
    public Double practice1 () {
        List<Integer> numbers = List.of(4, 8, 15, 16, 23, 42);
        return numbers.stream().mapToInt(a->(int)a)
                .summaryStatistics().getAverage();
    }


}
