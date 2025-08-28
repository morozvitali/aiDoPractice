package stream.task14_summarystatistics_10;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main18 {
    public long practice1() {
        int[] numbers = {2, 4, 2, 6, 8, 4, 10, 10, 12};
        return Arrays.stream(numbers).distinct().summaryStatistics().getCount();
    }

    public long practice2() {
        List<String> words = List.of("APPLE",
                "Banana", "CHERRY", "kiwi", "PLUM");
        return words.stream().filter(w -> w.length() % 2 == 0)
                .mapToInt(String::length)
                .summaryStatistics()
                .getSum();
    }

    public Map<String, Long> practice3() {
        String[] words = {"sky", "apple",
                "moon", "dry", "banana"};
        return Arrays.stream(words).filter(w -> w.length() > 3 && w.chars().filter(c -> "aeiou".indexOf(c) >= 0).count() > 1)
                .collect(Collectors.toMap(Function.identity(), w -> w.chars().filter(c -> "aeiou".indexOf(c) >= 0).count()));
    }

    public Double practice4() {
        String[] words = {"sky", "apple", "moon",
                "dry", "sun"};
        return Arrays.stream(words).filter(w -> w.chars().filter(c -> "aeiou".indexOf(c) >= 0).count() > 0)
                .mapToInt(String::length)
                .summaryStatistics().getAverage();
    }

    public String practice5() {
        String[] words = {"apple", "orange", "banana",
                "ice", "umbrella", "echo"};

        return Arrays.stream(words)
                .filter(w -> "aeiou"
                        .indexOf(w.charAt(0)) >= 0)
                .min(Comparator.comparingInt(String::length))
                .orElse("empty");
    }

    public Map <Character, Double> practice6 () {
        String[] words = {"apple", "ant",
                "banana", "blue", "berry", "dolphin"};
        return Arrays.stream(words).collect(Collectors.groupingBy(w->w.charAt(0),
                Collectors.averagingInt(String::length)));
    }



}
