package stream.task14_summarystatistics_10;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class Main9 {
    public void practice1 () {
        int[] numbers = {2, 4, 2, 6, 8, 4, 10, 10, 12};
        IntSummaryStatistics stats = Arrays.stream(numbers)
                .filter(a->a%2==0)
                .distinct()
                .summaryStatistics();

        System.out.println(stats.getAverage());
        System.out.println(stats.getMax());
        System.out.println(stats.getCount());
        System.out.println(stats.getSum());
    }

    public int practice2 () {
        List<String> words = List.of("APPLE",
                "Banana", "CHERRY", "kiwi", "PLUM");
        return words.stream().map(w->w.toLowerCase()).filter(a->a.length()%2==0)
                .mapToInt(a->a.length()).sum();
    }



}
