package stream.task14_summarystatistics;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main7 {
    public void practice1 () {
        int[] numbers = {2, 4, 2, 6, 8, 4, 10, 10, 12};
        IntSummaryStatistics stats = Arrays.stream(numbers).distinct().summaryStatistics();
        System.out.println(stats.getCount());
        System.out.println(stats.getMax());
    }

    public int practice2 () {
        List<String> words = List.of("APPLE",
                "Banana", "CHERRY", "kiwi", "PLUM");
        return words.stream().filter(a-> a.length()%2==0)
                .filter(a->a.chars().allMatch(c->Character.isLowerCase(c)))
                .mapToInt(a->a.length())
                .sum();
    }

    public Map <String, Long> practice3 () {
        String[] words = {"sky", "apple",
                "moon", "dry", "banana"};
        return Arrays
                .stream(words)
                .filter(a->a.length()>3)
                .filter(a-> a.chars()
                        .filter(c->"aeiou"
                                .indexOf(c) >=0)
                        .count() == a.length())
                .collect(Collectors
                        .groupingBy(a->a,(Collectors
                                .counting())));
    }

    public int practice4 () {
        String[] words = {"sky", "apple", "moon",
                "dry", "sun"};
        return Arrays.stream(words)
                .filter(a->a.chars()
                        .filter(c->"aeiou".indexOf(c) >=0)
                        .count()!=a.length())
                .mapToInt(a->a.length()).sum();
    }

    public String practice5 () {
        String[] words = {"apple", "orange", "banana",
                "ice", "umbrella", "echo"};
        return Arrays.stream(words)
                .filter(a->"aeiou"
                        .indexOf(a.charAt(0)) >=0)
                .sorted(Comparator.naturalOrder())
                .findFirst()
                .orElse("empty");
    }

    public Map <Character, Double> practice6 () {
        String[] words = {"apple", "ant",
                "banana", "blue", "berry", "dolphin"};
        return Arrays.stream(words)
                .collect(Collectors
                        .groupingBy(w->w.charAt(0), Collectors
                                .averagingInt(w->w
                                        .length())));
    }

    public void practice7 () {
        String[] words = {"apple", "orange",
                "banana", "umbrella"};
        Arrays.stream(words)
                .flatMap(w->w.chars()
                .mapToObj(c->(char)c))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

}
