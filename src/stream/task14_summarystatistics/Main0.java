package stream.task14_summarystatistics;

import java.util.*;

public class Main0 {
    public void pracrice1 () {
        String[] words = {"java", "stream", "code", "developer", "Engineer"};
        Arrays.stream(words).filter(w->w.toLowerCase().contains("e"))
                .map(w-> Map.entry(w, w.length()))
                .reduce((a,b) ->
                        a.getValue() >= b.getValue() ? a : b);
    }

    public void practice2 () {
        int[] numbers = {2, 4, 2, 6, 8, 4, 10, 10, 12};
        IntSummaryStatistics stats = Arrays
                .stream(numbers)
                .distinct()
                .summaryStatistics();
        System.out.println(stats.getSum());
        System.out.println(stats.getMin());
        System.out.println(stats.getMax());
        System.out.println(stats.getAverage());
        System.out.println(stats.getCount());
    }

    public int practice3 () {
        List<String> words = List.of("APPLE",
                "Banana", "CHERRY", "kiwi", "PLUM");
        return words.stream()
                .filter(a-> a.length() % 2 == 0)
                .map(a->a.toLowerCase())
                .mapToInt(String::length).sum();
    }


}