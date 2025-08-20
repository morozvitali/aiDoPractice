package stream.task14_summarystatistics_10;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main13 {
    public Long practice1() {
        int[] numbers = {2, 4, 2, 6, 8, 4, 10, 10, 12};
        return Arrays.stream(numbers).distinct().summaryStatistics().getCount();
    }

    public long practice2() {
        List<String> words = List.of("APPLE",
                "Banana", "CHERRY", "kiwi", "PLUM");
        return words.stream()
                .filter(w -> w.length() % 2 == 0)
                .map(w -> w.toLowerCase())
                .mapToInt(String::length)
                .summaryStatistics().getSum();
    }

    public Map<String, Long> practice3() {
        return Stream.of("sky", "apple",
                        "moon", "dry", "banana").filter(w -> w.length() > 3)
                .filter(w -> countVowels(w) > 1)
                .collect(Collectors.toMap(Function.identity(), Main13::countVowels));
    }

    public static long countVowels(String s) {
        return s.chars().filter(c -> "aeiou".indexOf(c) >= 0).count();
    }

    public Double practice4() {
        String[] words = {"sky", "apple", "moon",
                "dry", "sun"};
        return Arrays.stream(words)
                .filter(w -> countVowels(w) > 0)
                .mapToInt(String::length)
                .summaryStatistics().getAverage();
    }


}
