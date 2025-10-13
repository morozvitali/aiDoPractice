package stream1.task14_summarystatistics_10;

import java.util.*;
import java.util.stream.Collectors;

public class Main0 {
    public void pracrice1 () {
        String[] words = {"java", "stream1", "code", "developer", "Engineer"};
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

    public Map<String, Long> practice4 () {
        String[] words = {"sky", "apple", "moon", "dry", "banana"};
        return Arrays.stream(words).filter(a->a.length()>3)
                .filter(a->a.chars().filter(c->"aeiou".indexOf(c)>=0).count()>0)
                .collect(Collectors.toMap(a->a, a->a.chars().filter(c->"aeiou".indexOf(c)>=0).count()));
    }

    public void practice5 () {
        String[] words = {"sky", "apple", "moon",
                "dry", "sun"};
        IntSummaryStatistics stats = Arrays.stream(words)
                .filter(w->w.chars()
                        .filter(ch->"aeiou".indexOf(ch) >= 0)
                        .count() > 0).mapToInt(String::length)
                .summaryStatistics();
        System.out.println(stats.getAverage());
    }

    public String practice6 () {
        String[] words = {"apple", "orange", "banana",
                "ice", "umbrella", "echo"};

return Arrays.stream(words)
        .filter(w->"aeiou".indexOf(w.charAt(0))>=0)
        .min(Comparator.comparingInt(String::length))
        .orElse("empty");
    }

    public void practice7 () {
        String[] words = {"apple", "ant", "banana", "blue", "berry", "dolphin"};
        Arrays.stream(words).collect(Collectors.groupingBy(w->w.charAt(0), Collectors.averagingInt(String::length)));
    }
}