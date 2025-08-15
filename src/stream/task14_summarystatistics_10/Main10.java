package stream.task14_summarystatistics_10;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main10 {
    public long practice1() {
        int[] numbers = {2, 4, 2, 6, 8, 4, 10, 10, 12};
        IntSummaryStatistics stats = Arrays.stream(numbers).filter(a -> a % 2 == 0).distinct().summaryStatistics();
        return stats.getCount();
    }

    public int practice2() {
        List<String> words = List.of("APPLE",
                "Banana", "CHERRY", "kiwi", "PLUM");
        return words.stream().filter(s -> s.length() % 2 == 0).map(String::toLowerCase).mapToInt(String::length).sum();
    }

    public Map<String, Long> practice3() {
        String[] words = {"sky", "apple",
                "moon", "dry", "banana"};
        return Arrays.stream(words).filter(s -> s.length() > 3).filter(s -> s.chars().anyMatch(a -> "aeiou".indexOf(a) >= 0)).collect(Collectors.toMap(w -> w, w -> w.chars().filter(c -> "aeiou".indexOf(c) >= 0).count()));
    }

    public Double practice4() {
        String[] words = {"sky", "apple", "moon",
                "dry", "sun"};
        return Arrays.stream(words).map(String::toLowerCase).filter(a -> a.matches(".*[aeiou].*"))
                .mapToInt(w -> w.length())
                .summaryStatistics().getAverage();
    }

    public void practice5() {
        String[] words = {"apple", "orange", "banana",
                "ice", "umbrella", "echo"};
        Arrays.stream(words).filter(w->"aeiou".indexOf(w.charAt(0)) >=0).min(Comparator.comparing(String::length)).orElse("");
    }

    public void practice6() {
        String[] words = {"apple", "ant",
                "banana", "blue", "berry", "dolphin"};
        Arrays.stream(words).collect(Collectors.groupingBy(w->w.charAt(0), Collectors.averagingInt(String::length)));
    }

    public void practice7 () {
        String[] words = {"apple", "orange",
                "banana", "umbrella"};
        Arrays.stream(words).flatMap(w->w.chars().mapToObj(c->(char)c))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public IntSummaryStatistics practice8() {
        String[] words = {"apple", "moon",
                "sky", "banana", "loop"};
        return Arrays.stream(words).filter(w->w.chars().distinct().count() < w.length()).mapToInt(String::length).summaryStatistics();
    }

    public List <String> practice9 () {
        String[] words = {"education", "questionnaire",
                "house", "audio", "universe"};
        return Arrays.stream(words).filter(w->"aeiou".chars().allMatch(c->w.indexOf(c) >=0)).collect(Collectors.toList());
    }

    public Map<Boolean, List <String>> practice10 () {
        String[] words = {"Apple", "banana",
                "Cherry", "date", "Eggplant"};
        return Arrays.stream(words).collect(Collectors.partitioningBy(w->Character.isUpperCase(w.charAt(0))));
    }
}