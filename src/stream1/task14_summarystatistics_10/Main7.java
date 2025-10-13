package stream1.task14_summarystatistics_10;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main7 {
    public void practice1() {
        int[] numbers = {2, 4, 2, 6, 8, 4, 10, 10, 12};
        IntSummaryStatistics stats = Arrays.stream(numbers).distinct().summaryStatistics();
        System.out.println(stats.getCount());
        System.out.println(stats.getMax());
    }

    public int practice2() {
        List<String> words = List.of("APPLE", "Banana", "CHERRY", "kiwi", "PLUM");
        return words.stream().filter(a -> a.length() % 2 == 0).filter(a -> a.chars().allMatch(c -> Character.isLowerCase(c))).mapToInt(a -> a.length()).sum();
    }

    public Map<String, Long> practice3() {
        String[] words = {"sky", "apple", "moon", "dry", "banana"};
        return Arrays.stream(words).filter(a -> a.length() > 3).filter(a -> a.chars().filter(c -> "aeiou".indexOf(c) >= 0).count() == a.length()).collect(Collectors.groupingBy(a -> a, (Collectors.counting())));
    }

    public int practice4() {
        String[] words = {"sky", "apple", "moon", "dry", "sun"};
        return Arrays.stream(words).filter(a -> a.chars().filter(c -> "aeiou".indexOf(c) >= 0).count() != a.length()).mapToInt(a -> a.length()).sum();
    }

    public String practice5() {
        String[] words = {"apple", "orange", "banana", "ice", "umbrella", "echo"};
        return Arrays.stream(words).filter(a -> "aeiou".indexOf(a.charAt(0)) >= 0).sorted(Comparator.naturalOrder()).findFirst().orElse("empty");
    }

    public Map<Character, Double> practice6() {
        String[] words = {"apple", "ant", "banana", "blue", "berry", "dolphin"};
        return Arrays.stream(words).collect(Collectors.groupingBy(w -> w.charAt(0), Collectors.averagingInt(w -> w.length())));
    }

    public void practice7() {
        String[] words = {"apple", "orange", "banana", "umbrella"};
        Arrays.stream(words).flatMap(w -> w.chars().mapToObj(c -> (char) c)).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public List<String> practice9() {
        String[] words = {"education", "questionnaire", "house", "audio", "universe"};
        return Arrays.stream(words).filter(a -> a.chars().filter(ch -> "aeiou".indexOf(ch) >= 0).count() < a.length()).collect(Collectors.toList());
    }

    public Map<Boolean, List<String>> practice10() {
        String[] words = {"Apple", "banana", "Cherry", "date", "Eggplant"};
        return Arrays.stream(words).collect(Collectors.partitioningBy(a -> Character.isUpperCase(a.charAt(0))));
    }

    public void practice11 () {
        String[] words = {"Java", "java",
                "Kotlin", "kotlin", "kotlin", "Scala"};
        Arrays.stream(words).map(a->a.toLowerCase()).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public void practice12 () {
        String[] words = {"cat", "apple",
                "grape", "banana", "fig", "cherry"};

        Arrays.stream(words)
        .filter(a-> a.length() > 4 && a.length() <6).mapToInt(String::length).summaryStatistics();
    }

    public void practice13 () {
        String[] words = {"apple", "tree",
                "orange", "banana", "loop"};
        Arrays.stream(words)
                .filter(w->"aeiou".chars()
                        .anyMatch(c-> w.chars()
                                .filter(ch->ch == c).count() >=2))
                .findFirst()
                .orElse("empty");
    }
}
