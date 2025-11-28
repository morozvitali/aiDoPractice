package stream1.task14_summarystatistics_10;

import java.util.*;
import java.util.stream.Collectors;

public class Main38 {
    public IntSummaryStatistics practice1 () {
        int[] numbers = {2, 4, 2, 6, 8, 4, 10, 10, 12};
            return Arrays.stream(numbers).distinct().summaryStatistics();
    }

    public long practice2 () {
        List<String> words = List.of("APPLE",
                "Banana", "CHERRY", "kiwi", "PLUM");
            return words.stream().filter(w->w.length() %2 == 0)
                    .map(w->w.toLowerCase())
                    .mapToInt(String::length)
                    .sum();
    }

    public Map <String, Integer> practice3 () {
        String[] words = {"sky", "apple",
                "moon", "dry", "banana"};
        return Arrays.stream(words).filter(w->w.length() > 3)
                .filter(w->counter(w) > 1)
                .collect(Collectors
                        .toMap(w->w, w-> Math.toIntExact(w.chars().filter(c -> "aeiou".indexOf(c) >= 0).count())));
    }

    public static long counter (String s) {
        return s.chars().filter(c->"aeiou".indexOf(c) >=0).count();
    }

    public void practice4 () {
        String[] words = {"sky", "apple", "moon",
                "dry", "sun"};
        Arrays.stream(words).filter(w->counter(w) >0).mapToInt(String::length)
                .summaryStatistics().getAverage();
    }

    public void practice5 () {
        String[] words = {"apple", "orange", "banana",
                "ice", "umbrella", "echo"};
        Arrays.stream(words).filter(w->"aeiou".indexOf(w.charAt(0)) >=0)
                .min(Comparator.comparing(String::length)).orElse("");
    }

    public Map <Character, Double> practice6 () {
        String[] words = {"apple", "ant",
                "banana", "blue", "berry", "dolphin"};
        return Arrays.stream(words).collect(Collectors.groupingBy(w->w.charAt(0), Collectors.averagingInt(String::length)));
    }
}


