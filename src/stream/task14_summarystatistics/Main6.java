package stream.task14_summarystatistics;

import java.util.*;
import java.util.stream.Collectors;

public class Main6 {
    public Optional<Map.Entry<String, Integer>> practice1() {
        String[] words = {"java", "stream", "code", "developer", "Engineer"};
        return Arrays.stream(words).filter(w -> w.toLowerCase().contains("e"))
                .map(w -> Map.entry(w, w.length()))
                .reduce((a, b) -> a.getValue() >= b.getValue() ? a : b);
    }

    public IntSummaryStatistics practice2() {
        int[] numbers = {2, 4, 2, 6, 8, 4, 10, 10, 12};
        IntSummaryStatistics stats = Arrays.stream(numbers).distinct().summaryStatistics();
        int count = Math.toIntExact(stats.getCount());
        return stats;
    }

    public void practice3() {
        List<String> words = List.of("APPLE", "Banana", "CHERRY", "kiwi", "PLUM");
        words.stream()
                .filter(a->a.length()%2==0)
                .map(a->a.toLowerCase())
                .mapToInt(a->a.length()).sum();

    }
}