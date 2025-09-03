package stream.task14_summarystatistics_10;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main21 {
    public long practice1 () {
        int[] numbers = {2, 4, 2, 6, 8, 4, 10, 10, 12};
        return Arrays.stream(numbers).distinct().summaryStatistics().getCount();
    }

    public int practice2 () {
        List<String> words = List.of("APPLE",
                "Banana", "CHERRY", "kiwi", "PLUM");
        return words.stream().filter(a->a.length()%2==0)
                .map(a->a.toLowerCase())
                .mapToInt(String::length)
                .sum();
    }

    public Map<String, Long> practice3 () {
        String[] words = {"sky", "apple",
                "moon", "dry", "banana"};
        return Arrays.stream(words).filter(w->w.length() > 3)
                .filter(w->w.chars().filter(c->"aeiou".indexOf(c)>=0).count()>1)
                .collect(Collectors.toMap(Function.identity(), w->w.chars().filter(c->"aeiou".indexOf(c)>=0).count()));
    }

    public Double practice4 () {
        String[] words = {"sky", "apple", "moon",
                "dry", "sun"};
        return Arrays.stream(words).filter(w->coountVowels(w) > 0).mapToInt(String::length).summaryStatistics().getAverage();
    }

    public long coountVowels (String s) {
        return s.chars().filter(c->"aeiou".indexOf(c) >=0).count();
    }

    public String practice5 () {
        String[] words = {"apple", "orange", "banana",
                "ice", "umbrella", "echo"};
        return Arrays.stream(words).filter(w->"aeiou".indexOf(w.charAt(0))>=0)
                .min(Comparator.comparing(String::length))
                .orElse("");
    }



}
