package stream.task14_summarystatistics_10;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main22 {
    public Double practice1 () {
        int[] numbers = {2, 4, 2, 6, 8, 4, 10, 10, 12};
        return Arrays.stream(numbers).distinct().summaryStatistics().getAverage();
    }

    public Long practice2 () {
        List<String> words = List.of("APPLE",
                "Banana", "CHERRY", "kiwi", "PLUM");
        return words.stream().map(String::toUpperCase).mapToInt(String::length).filter(a->a%2==0)
                .summaryStatistics().getCount();
    }

    public Map<String, Long> practice3 () {
        String[] words = {"sky", "apple",
                "moon", "dry", "banana"};
        return Arrays.stream(words).filter(w->w.length() > 3)
                .filter(w->countVowels(w) >1)
                .collect(Collectors.toMap(w->w, w->countVowels(w)));
    }

    public long countVowels (String s) {
        return s.chars().filter(c->"aeiuo".indexOf(c)>-0).count();
    }
}
