package stream2.task10_;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class Main3 {
    public void practice1 () {
        IntSummaryStatistics stats = IntStream.of(5,109,15,20).summaryStatistics()
        System.out.println(stats);
    }

}
