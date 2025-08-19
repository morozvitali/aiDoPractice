package stream.task14_summarystatistics_10;

import java.util.*;
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

    public Double practice4 () {
        String[] words = {"sky", "apple", "moon",
                "dry", "sun"};
        return Arrays.stream(words).map(String::toLowerCase).filter(w->countVowels(w)>1).mapToInt(Integer::parseInt).summaryStatistics().getAverage();
    }

    public void practice5 () {
        String[] words = {"apple", "orange", "banana",
                "ice", "umbrella", "echo"};
        Arrays.stream(words).filter(w->"aeiuo".indexOf(w.charAt(0))>=0).min(Comparator.comparing(String::length)).orElse("");
    }

    public Map <Character, Double> practice6 () {
        String[] words = {"apple", "ant",
                "banana", "blue", "berry", "dolphin"};
        return Arrays.stream(words).collect(Collectors.groupingBy(w->w.charAt(0), Collectors.averagingInt(String::length)));
    }


}
