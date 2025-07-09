package stream.task15_grouping1;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main7 {
    public long practice1 () {
        int[] numbers = {2, 4, 2, 6, 8, 4, 10, 10, 12};
        IntSummaryStatistics stats = Arrays.stream(numbers).filter(a->a%2==0).distinct().summaryStatistics();
        return stats.getCount();
    }

public int practice2 () {
    List<String> words = List.of("APPLE",
            "Banana", "CHERRY", "kiwi", "PLUM");

    return words.stream()
            .map(a->a.toLowerCase())
            .filter(a->a.length()%2==0)
            .mapToInt(a->a.length())
            .sum();
}

    public void practice3 () {
        String[] words = {"sky", "apple",
                "moon", "dry", "banana"};
        Arrays.stream(words).filter(a->a.length()>3)
                .filter(a->a.chars().map(c->(char)c)
                .filter(ch->"aeiou".indexOf(ch)>=0).count() > 0);
    }

    public double practice4 () {
        String[] words = {"sky", "apple", "moon",
                "dry", "sun"};

        IntSummaryStatistics stats = Arrays.stream(words)
                .filter(w->w.matches(".*[aeiou].*"))
                .mapToInt(a->a.length())
                .summaryStatistics();
        return stats.getAverage();
    }

    public void practice5 () {
        String[] words = {"apple", "orange", "banana",
                "ice", "umbrella", "echo"};
        Arrays.stream(words)
                .filter(a->"aeiou".indexOf(a.charAt(0)) >=0)
                .min(Comparator.comparingInt(String::length))
                .orElse("empty");
    }

    public void practice6 () {
        String[] words = {"apple", "ant",
                "banana", "blue", "berry", "dolphin"};

        Map<Character, Double> map = Arrays
                .stream(words)
                .collect(Collectors.groupingBy(w->w.charAt(0), Collectors.averagingInt(String::length)));
    }

    public Map <Character, Long> practice7 () {
        String[] words = {"apple", "orange",
                "banana", "umbrella"};

        return Arrays.stream(words).flatMap(a->a.chars().mapToObj(c->(char)c))
                .filter(ch->"aeiou".indexOf(ch)>=0)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public IntSummaryStatistics practice8 () {
        String[] words = {"apple", "moon",
                "sky", "banana", "loop"};

        return  Arrays.stream(words)
                .filter(a->a.chars()
                        .distinct()
                        .count() == a.length())
                .mapToInt(a->a.length())
                .summaryStatistics();
    }

    public List <String> practice9 () {
        String[] words = {"education", "questionnaire",
                "house", "audio", "universe"};
        return Arrays.stream(words).filter(w-> "aeiou".chars().allMatch(c->w.indexOf(c) >= 0)).collect(Collectors.toList());
    }

    public Map <Boolean, List <String>> practice10 () {

        String[] words = {"Apple", "banana",
                "Cherry", "date", "Eggplant"};
        return Arrays.stream(words)
                .collect(Collectors
                        .partitioningBy(w->Character
                                .isUpperCase(w.charAt(0))));
    }











}
