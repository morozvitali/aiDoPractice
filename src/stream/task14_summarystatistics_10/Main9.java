package stream.task14_summarystatistics_10;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main9 {
    public void practice1() {
        int[] numbers = {2, 4, 2, 6, 8, 4, 10, 10, 12};
        IntSummaryStatistics stats = Arrays.stream(numbers)
                .filter(a -> a % 2 == 0)
                .distinct()
                .summaryStatistics();

        System.out.println(stats.getAverage());
        System.out.println(stats.getMax());
        System.out.println(stats.getCount());
        System.out.println(stats.getSum());
    }

    public int practice2() {
        List<String> words = List.of("APPLE",
                "Banana", "CHERRY", "kiwi", "PLUM");
        return words.stream().map(w -> w.toLowerCase()).filter(a -> a.length() % 2 == 0)
                .mapToInt(a -> a.length()).sum();
    }

    public Map<String, Long> practice3() {
        String[] words = {"sky", "apple",
                "moon", "dry", "banana"};

        return Arrays.stream(words)
                .filter(w -> w.length() > 3 &&
                        w.chars()
                                .mapToObj(c -> (char) c)
                                .filter(c -> "aeiou".indexOf(Character.toLowerCase(c)) >= 0)
                                .count() > 1)
                .collect(Collectors
                        .toMap(w -> w,
                                w -> w.chars()
                                        .mapToObj(c -> (char) c)
                                        .filter(c -> "aeiou"
                                                .indexOf(Character.toLowerCase(c)) >= 0)
                                        .count()));
    }

    public double practice4() {
        String[] words = {"sky", "apple", "moon",
                "dry", "sun"};
        return  Arrays.stream(words)
                .map(w -> w.toLowerCase())
                .filter(w -> w.matches(".*[aeiou].*"))
                .mapToInt(w -> w.length())
                .summaryStatistics().getAverage();
    }

    public String practice5 () {
        String[] words = {"apple", "orange", "banana",
                "ice", "umbrella", "echo"};
        return Arrays.stream(words).filter(w -> w.matches("(?i)^[aeiou].*")).min(Comparator.comparing(w->w.length())).orElse("empty");
    }

    public Map<Character, Double> practice6 () {
        String[] words = {"apple", "ant",
                "banana", "blue", "berry", "dolphin"};
        return Arrays.stream(words).collect(Collectors.groupingBy(w->w.charAt(0), Collectors.averagingInt(String::length)));
    }

    public Map <Character, Long> practice7 () {
        String[] words = {"apple", "orange",
                "banana", "umbrella"};
        return Arrays.stream(words)
                .flatMap(w->w.toLowerCase().chars()
                        .mapToObj(c->(char)c))
                .filter(c->"aeiou".indexOf(c)>=0)
                .collect(Collectors
                        .groupingBy(Function.identity(),
                                Collectors.counting()));
    }



}
