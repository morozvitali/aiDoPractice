package stream.task14_summarystatistics_10;

import java.util.*;
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
                .map(String::toLowerCase)
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

    public String practice5 () {
        String[] words = {"apple", "orange", "banana",
                "ice", "umbrella", "echo"};
        return Arrays.stream(words).filter(w->"aeiou".indexOf(w.charAt(0))>=0)
                .min(Comparator.comparing(String::length)).orElse("");
    }

    public Map <Character, Double> practice6 () {
        return Stream.of("apple", "ant",
                "banana", "blue", "berry", "dolphin")
                .collect(Collectors.groupingBy(w->w.charAt(0), Collectors.averagingInt(String::length)));
    }

    public Map <Character, Long> practice7 () {
        String[] words = {"apple", "orange",
                "banana", "umbrella"};
        return Arrays.stream(words).flatMap(w->w.chars().mapToObj(c->(char)c))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public IntSummaryStatistics practice8 () {
        String[] words = {"apple", "moon",
                "sky", "banana", "loop"};
        return Arrays.stream(words)
                .filter(Main13::has2repeatingLetters)
                .mapToInt(String::length).summaryStatistics();
    }

    public static boolean has2repeatingLetters(String s) {
        return s.length() - s.chars().distinct().count() > 1 ;
    }

    public List <String> practice9 () {
        String[] words = {"education", "questionnaire",
                "house", "audio", "universe"};
        return Arrays.stream(words).filter(w->"aeiou".chars().allMatch(c->w.indexOf(c) >= 0)).collect(Collectors.toList());
    }

    public Map <Boolean, List <String>> practice10 () {
        String[] words = {"Apple", "banana",
                "Cherry", "date", "Eggplant"};
        return Arrays.stream(words).collect(Collectors.partitioningBy(w->Character.isUpperCase(w.charAt(0))));
    }
}
