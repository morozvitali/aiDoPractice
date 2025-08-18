package stream.task14_summarystatistics_10;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main11 {
    public Double practice1 () {
        int[] numbers = {2, 4, 2, 6, 8, 4, 10, 10, 12};
        return Arrays.stream(numbers)
                .distinct()
                .filter(a->a%2 == 0)
                .summaryStatistics().getAverage();
    }

    public Long practice2 () {
        List<String> words = List.of("APPLE",
                "Banana", "CHERRY", "kiwi", "PLUM");
        return words.stream().map(a->a.toLowerCase()).mapToInt(String::length).summaryStatistics().getCount();
    }

    public Map <String, Long> practice3 () {
        String[] words = {"sky", "apple",
                "moon", "dry", "banana"};
        return Arrays.stream(words).filter(a->a.length() > 3 && countVowels(a) >1).collect(Collectors.toMap(Function.identity(), w->countVowels(w)));
    }
    public long countVowels (String s) {
        return s.chars().filter(c->"aeiou".indexOf(c) >=0).count();
    }


}
