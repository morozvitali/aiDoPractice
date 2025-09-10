package stream.task14_summarystatistics_10;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main25 {
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
        return Arrays.stream(words).filter(w -> w.length() > 3 && getCount(w) > 1).collect(Collectors.toMap(Function.identity(), w -> getCount(w)));
    }

    public static long getCount(String s) {
        return s.chars().filter(c -> "aeiou".indexOf(c) >= 0).count();
    }

    public Double practice4() {
        String[] words = {"sky", "apple", "moon",
                "dry", "sun"};
        return Arrays.stream(words).filter(w -> getCount(w) > 1).mapToInt(String::length).summaryStatistics().getAverage();
    }

    public String practice5() {
        String[] words = {"apple", "orange", "banana",
                "ice", "umbrella", "echo"};
        return Arrays.stream(words).filter(w -> "aeiou".indexOf(w.charAt(0)) >= 0)
                .min(Comparator.comparing(String::length)).orElse("");
    }

    public Map<Character, Double> practice6() {
        String[] words = {"apple", "ant",
                "banana", "blue", "berry", "dolphin"};
        return Arrays.stream(words).collect(Collectors.groupingBy(w -> w.charAt(0), Collectors.averagingInt(String::length)));
    }

    public Long practice7() {
        String[] words = {"apple", "orange",
                "banana", "umbrella"};
        return Arrays.stream(words).mapToLong(w -> getClear(w)).summaryStatistics().getSum();
    }

    public static long getClear(String s) {
        return s.chars()
                .filter(c -> "aeoiu".indexOf(c) >= 0)
                .count();
    }

    public IntSummaryStatistics practice8() {
        String[] words = {"apple", "moon",
                "sky", "banana", "loop"};
        return Arrays.stream(words)
                .filter(w -> w.length() - w.chars()
                        .distinct().count() > 2)
                .mapToInt(String::length)
                .summaryStatistics();
    }

    public List <String> practice9 () {
        String[] words = {"education", "questionnaire",
                "house", "audio", "universe"};
        return Arrays.stream(words).filter(w->"aeiou".chars().allMatch(c->w.indexOf(c) >=0)).toList();
    }




}
