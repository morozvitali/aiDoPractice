package stream1.task14_summarystatistics_10;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main15 {
    public long practice1 () {
        int[] numbers = {2, 4, 2, 6, 8, 4, 10, 10, 12};
        return Arrays.stream(numbers)
                .filter(a->a%2==0)
                .distinct()
                .summaryStatistics()
                .getCount();
    }

    public int practice2 () {
        List<String> words = List.of("APPLE",
                "Banana", "CHERRY", "kiwi", "PLUM");
        return words.stream().filter(a->a.length() %2==0)
                .map(String::toLowerCase)
                .mapToInt(String::length)
                .sum();
    }

    public Map<String, Long> practice3 () {
        String[] words = {"sky", "apple",
                "moon", "dry", "banana"};

        return Arrays.stream(words).filter(w->w.length()>3 && countVowels(w)>1)
                .collect(Collectors.toMap(a->a, Main15::countVowels));
    }

    public static long countVowels (String s) {
        return s.chars().filter(c->"aeiou".indexOf(c)>=0).count();
    }

    public Double practice4 () {
        String[] words = {"sky", "apple", "moon",
                "dry", "sun"};
        return Arrays.stream(words).filter(w->countVowels(w) >0)
                .mapToInt(String::length)
                .average()
                .orElse(-1);
    }

    public String practice5 () {
        String[] words = {"apple", "orange", "banana",
                "ice", "umbrella", "echo"};
        return Arrays.stream(words).filter(word->"aeiou".indexOf(word.charAt(0))>=0)
                .min(Comparator.comparing(String::length))
                .orElse("empty");
    }

    public Map <Character, Double> practice6 () {
        String[] words = {"apple", "ant",
                "banana", "blue", "berry", "dolphin"};
        return Arrays.stream(words).collect(Collectors.groupingBy(w->w.charAt(0), Collectors.averagingInt(String::length)));
    }

    public Map <Character, Long> practice7 () {
        String[] words = {"apple", "orange",
                "banana", "umbrella"};
        return Arrays.stream(words).flatMap(w->w.chars().mapToObj(c->(char)c))
                .filter(c->"aeiou".indexOf(c) >=0)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public IntSummaryStatistics practice8 () {
        String[] words = {"apple", "moon",
                "sky", "banana", "loop"};

        return Arrays.stream(words)
        .filter(w->w.length() - w.chars().distinct().count() >=2)
                .mapToInt(String::length)
                .summaryStatistics();
    }

    public void practice10 () {
        String[] words = {"Apple", "banana",
                "Cherry", "date", "Eggplant"};
        Arrays.stream(words).collect(Collectors.groupingBy(w->"aeiou".indexOf(w.charAt(0)) >=0));
    }
}
