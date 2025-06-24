package stream.task14_summarystatistics;

import java.util.*;

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

    public int practice3 () {
        List<String> words = List.of("APPLE",
                "Banana", "CHERRY", "kiwi", "PLUM");
        return words.stream().mapToInt(a->a.length()).sum();
    }

}
