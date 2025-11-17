package stream1.task14_summarystatistics_10;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main37 {
    public IntSummaryStatistics task1 () {
        int[] numbers = {2, 4, 2, 6, 8, 4, 10, 10, 12};
        return Arrays.stream(numbers).filter(a->a%2==0).summaryStatistics();
    }

    public int task2 () {
        List<String> words = List.of("APPLE",
                "Banana", "CHERRY", "kiwi", "PLUM");
        return words.stream().filter(w->w.length()%2==0)
                .map(w->w.toLowerCase())
                .mapToInt(String::length)
                .sum();
    }

    public Map<String, Long> task3 () {
        String[] words = {"sky", "apple",
                "moon", "dry", "banana"};
        return Arrays.stream(words).filter(w->count(w)>1)
                .collect(Collectors.toMap(w->w, w->count(w)));
    }

    public long count (String s) {
        return s.chars().filter(c->"aeiou".indexOf(c)>=0).count();
    }

    public double task4 () {
        String[] words = {"sky", "apple", "moon",
                "dry", "sun"};
        return Arrays.stream(words).filter(w->count(w)>0).mapToInt(String::length).summaryStatistics().getAverage();
    }

    public String task5 () {
        String[] words = {"apple", "orange", "banana",
                "ice", "umbrella", "echo"};
        return Arrays.stream(words).min(Comparator.comparing(String::length)).orElse("empty");
    }

    public
}
