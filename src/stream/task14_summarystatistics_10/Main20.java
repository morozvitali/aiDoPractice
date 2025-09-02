package stream.task14_summarystatistics_10;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main20 {
    public Long practice1() {
        int[] numbers = {2, 4, 2, 6, 8, 4, 10, 10, 12};
        return Arrays.stream(numbers).filter(a -> a % 2 == 0)
                .distinct()
                .summaryStatistics().getCount();
    }

    public int practice2() {
        List<String> words = List.of("APPLE",
                "Banana", "CHERRY", "kiwi", "PLUM");
        return words.stream().filter(w -> w.length() % 2 == 0)
                .map(String::toLowerCase)
                .mapToInt(String::length)
                .sum();
    }

    public Map<String, Long> practice3() {
        String[] words = {"sky", "apple",
                "moon", "dry", "banana"};
        return Arrays.stream(words).filter(w -> countVowels(w) > 1 && w.length() > 3).collect(Collectors.toMap(w->w, w->countVowels(w)));
    }

    public static long countVowels(String s) {
        return s.chars().filter(c -> "aeiou".indexOf(c) >= 0).count();
    }


    public Double practice4 () {
        String[] words = {"sky", "apple", "moon",
                "dry", "sun"};
        return Arrays.stream(words).filter(w->countVowels(w) > 0).mapToInt(String::length).summaryStatistics().getAverage();
    }


}
