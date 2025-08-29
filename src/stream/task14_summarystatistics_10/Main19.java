package stream.task14_summarystatistics_10;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main19 {
    public long practice1 () {
        int[] numbers = {2, 4, 2, 6, 8, 4, 10, 10, 12};
        return Arrays.stream(numbers).distinct().summaryStatistics().getCount();
    }

    public Long practice2 () {
        List<String> words = List.of("APPLE",
                "Banana", "CHERRY", "kiwi", "PLUM");
        return words.stream().map(String::toLowerCase)
                .mapToInt(String::length)
                .summaryStatistics().getSum();
    }

    public Map<String, Long> practice3 () {
        String[] words = {"sky", "apple",
                "moon", "dry", "banana"};
        return Arrays.stream(words)
        .filter(w->w.length()>3 && countVowels(w) > 1)
                .collect(Collectors.toMap(Function.identity(), Main19::countVowels);
    }

    public static long countVowels (String w) {
        return w.chars().filter(c->"aeiou".indexOf(c)>=0).count();
    }

    public Double practice4 () {
        String[] words = {"sky", "apple", "moon",
                "dry", "sun"};
        return Arrays.stream(words).filter(w->countVowels(w) >0).mapToInt(String::length)
                .summaryStatistics().getAverage();
    }


}
