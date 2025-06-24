package stream.task14_summarystatistics;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.Optional;

public class Main1 {
    public Optional<Map.Entry<String, Integer>> practice1 () {
        String[] words = {"java", "stream", "code", "developer", "Engineer"};

        return Arrays.stream(words).map(a->a.toLowerCase()).filter(w->w.contains("e"))
                .map(w-> Map.entry(w, w.length()))
                .reduce((a,b) -> a.getValue() >= b.getValue() ? a : b);
    }
    
    public Long practice2 () {
        int[] numbers = {2, 4, 2, 6, 8, 4, 10, 10, 12};
        IntSummaryStatistics stats = Arrays.stream(numbers).distinct().filter(a->a%2==0)
                .summaryStatistics();
        return stats.getCount();
    }
}
