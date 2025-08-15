package stream.task14_summarystatistics_10;

import java.util.*;
import java.util.stream.Collectors;

public class Main10 {
    public long practice1() {
        int[] numbers = {2, 4, 2, 6, 8, 4, 10, 10, 12};
        IntSummaryStatistics stats = Arrays.stream(numbers).filter(a -> a % 2 == 0).distinct().summaryStatistics();
        return stats.getCount();
    }

    public int practice2() {
        List<String> words = List.of("APPLE",
                "Banana", "CHERRY", "kiwi", "PLUM");
        return words.stream().filter(s -> s.length() % 2 == 0).map(String::toLowerCase).mapToInt(String::length).sum();
    }

    public Map<String, Long> practice3() {
        String[] words = {"sky", "apple",
                "moon", "dry", "banana"};
        return Arrays.stream(words).filter(s -> s.length() > 3).filter(s -> s.chars().anyMatch(a -> "aeiou".indexOf(a) >= 0)).collect(Collectors.toMap(w -> w, w -> w.chars().filter(c -> "aeiou".indexOf(c) >= 0).count()));
    }

    public Double practice4() {
        String[] words = {"sky", "apple", "moon",
                "dry", "sun"};
        return Arrays.stream(words).map(String::toLowerCase).filter(a -> a.matches(".*[aeiou].*"))
                .mapToInt(w -> w.length())
                .summaryStatistics().getAverage();
    }

    public void practice5() {
        String[] words = {"apple", "orange", "banana",
                "ice", "umbrella", "echo"};
        Arrays.stream(words).filter(w->"aeiou".indexOf(w.charAt(0)) >=0).min(Comparator.comparing(String::length)).orElse("");


    }
}