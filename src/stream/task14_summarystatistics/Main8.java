package stream.task14_summarystatistics;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main8 {
    public void practice1 () {
        int[] numbers = {2, 4, 2, 6, 8, 4, 10, 10, 12};
        IntSummaryStatistics stats = Arrays.stream(numbers)
                .filter(a->a%2==0)
                .summaryStatistics();
        System.out.println(stats.getAverage());
        System.out.println(stats.getCount());
    }

    public void practice2 () {
        List<String> words = List.of("APPLE",
                "Banana", "CHERRY", "kiwi", "PLUM");
    words.stream().filter(w->w.length() % 2 == 0).map(w->w.toLowerCase()).mapToInt(a->a.length()).sum();
    }

    public Map<String, Long> practice3 () {
        String[] words = {"sky", "apple",
                "moon", "dry", "banana"};
        return Arrays.stream(words).filter(a->a.length() > 3 && a.chars().anyMatch(c->"AEIOU".indexOf(c) >= 0)).collect(Collectors.toMap(Function.identity(), w->w.chars().filter(ch-> "aeiou".indexOf(ch) >=0).count()));
    }

    public void practice4 () {
        String[] words = {"sky", "apple", "moon",
                "dry", "sun"};
        IntSummaryStatistics stats = Arrays.stream(words).filter(w->w.chars().anyMatch(ch->"aeiou".indexOf(ch) >= 0)).mapToInt(w->w.length()).summaryStatistics();
        System.out.println(stats.getAverage());
    }

    public void practice5 () {
        String[] words = {"apple", "orange", "banana",
                "ice", "umbrella", "echo"};
        Arrays.stream(words).filter(w->"aeiou".indexOf(w.charAt(0))>=0).min(Comparator.comparingInt(String::length)).orElse("empty");
    }

    public void practice6 () {
        String[] words = {"apple", "ant",
                "banana", "blue", "berry", "dolphin"};
        Arrays.stream(words)
                .collect(Collectors.groupingBy(w->w.charAt(0), Collectors.averagingInt(String::length)));
    }

    public void practice7 () {
        String[] words = {"apple", "orange",
                "banana", "umbrella"};
        Arrays.stream(words)
                .flatMap(w->w.chars()
                        .mapToObj(c-> (char)c))
                .collect(Collectors
                        .groupingBy(Function.identity(),
                                Collectors.counting()));
    }

    public void practice8 () {

    }
}
