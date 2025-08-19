package stream.task14_summarystatistics_10;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main12 {
    public IntSummaryStatistics practice1() {
        int[] numbers = {2, 4, 2, 6, 8, 4, 10, 10, 12};
        return Arrays.stream(numbers).filter(a -> a % 2 == 0)
                .distinct().summaryStatistics();
    }

    public int practice2() {
        List<String> words = List.of("APPLE",
                "Banana", "CHERRY", "kiwi", "PLUM");
        return words.stream().filter(w -> w.length() % 2 == 0)
                .map(String::toLowerCase)
                .mapToInt(String::length)
                .sum();
    }

    public void practice3 () {
        String[] words = {"sky", "apple",
                "moon", "dry", "banana"};
        Arrays.stream(words).filter(w->w.length()>3 && countVowels(w) > 1).collect(Collectors.toMap(Function.identity(), w->countVowels(w)));
    }
    public long countVowels (String s) {
        return s.chars().filter(c->"aeiou".indexOf(c) >= 0).count();
    }

    public void practice4 () {

    }

}
