package stream.task14_summarystatistics_10;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main27 {
    public Long practice1 () {
        int[] numbers = {2, 4, 2, 6, 8, 4, 10, 10, 12};
        return Arrays.stream(numbers).distinct().filter(a->a%2==0).summaryStatistics().getCount();
    }

    public Long practice2 () {
        List<String> words = List.of("APPLE",
                "Banana", "CHERRY", "kiwi", "PLUM");
        return words.stream().filter(w->w.length()%2==0).map(String::toLowerCase).mapToInt(String::length).summaryStatistics().getCount();
    }

    public Map <String, Long> practice3 () {
        String[] words = {"sky", "apple",
                "moon", "dry", "banana"};
        return Arrays.stream(words).filter(w->getCount(w)>1 && w.length() >3).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static long getCount(String s) {
        return s.chars().filter(c->"aeiou".indexOf(c)>=0).count();
    }

    public Double practice4 () {
        String[] words = {"sky", "apple", "moon",
                "dry", "sun"};
        return Arrays.stream(words).filter(w->w.matches(".*[aeiou].*")).mapToInt(String::length).summaryStatistics().getAverage();
    }

    public String practice5 () {
        String[] words = {"apple", "orange", "banana",
                "ice", "umbrella", "echo"};
        return Arrays.stream(words).filter(w->"aeiou".indexOf(w.charAt(0))>=0).min(Comparator.comparingInt(String::length)).orElse("");
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
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }


 }
