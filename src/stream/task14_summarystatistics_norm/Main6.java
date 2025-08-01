package stream.task14_summarystatistics_norm;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main6 {
    public Optional<Map.Entry<String, Integer>> practice1() {
        String[] words = {"java", "stream", "code", "developer", "Engineer"};
        return Arrays.stream(words).filter(w -> w.toLowerCase().contains("e"))
                .map(w -> Map.entry(w, w.length()))
                .reduce((a, b) -> a.getValue() >= b.getValue() ? a : b);
    }

    public IntSummaryStatistics practice2() {
        int[] numbers = {2, 4, 2, 6, 8, 4, 10, 10, 12};
        IntSummaryStatistics stats = Arrays.stream(numbers).distinct().summaryStatistics();
        int count = Math.toIntExact(stats.getCount());
        return stats;
    }

    public void practice3() {
        List<String> words = List.of("APPLE", "Banana", "CHERRY", "kiwi", "PLUM");
        words.stream()
                .filter(a->a.length()%2==0)
                .map(a->a.toLowerCase())
                .mapToInt(a->a.length()).sum();
    }

    public Map<Character, IntSummaryStatistics> practice4() {
        String[] words = {"apple", "ant", "banana", "blue", "berry", "dog", "dolphin"};
        return Arrays.stream(words)
                .filter(w->w.length() > 4)
                .collect(Collectors.groupingBy(w-> (char) w.length(), Collectors.summarizingInt(a->a.length())));
    }

    public Map <String, Integer> practice5 () {
        String[] words = {"sky", "apple", "moon", "dry", "banana"};
        return Arrays.stream(words).filter(a->a.length() > 3)
                .filter(a->a.chars()
                        .filter(c->"aeiou".indexOf(c) >= 0).count() > 1)
                .collect(Collectors.toMap(a->a, a-> Math.toIntExact(a.chars()
                        .filter(c -> "aeiou".indexOf(c) >= 0).count())));
    }

    public int practice6 () {
        String[] words = {"sky", "apple", "moon", "dry", "sun"};
        return (int) Arrays.stream(words).filter(w-> w.matches(".*[aeiou].*"))
                .mapToInt(a->a.length()).summaryStatistics().getAverage();

    }

    public void practice7 () {
        String[] words = {"apple", "orange", "banana", "ice", "umbrella", "echo"};
        Arrays.stream(words).filter(w-> w.matches("^[aeiou].*"));
    }

    public Map <Character, Double> practice8 () {
        String[] words = {"apple", "ant", "banana", "blue", "berry", "dolphin"};
        return Arrays.stream(words).collect(Collectors.groupingBy(w->w.charAt(0),
                Collectors.averagingInt(a->a.length())));
    }

    public Map<Character, Long> practice9 () {
        String[] words = {"apple", "moon", "sky", "banana", "loop"};
        return Arrays.stream(words).flatMap(w->w.toLowerCase().chars().mapToObj(c->(char) c))
                .filter(ch -> "aeiou".indexOf(ch) >= 0)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public void practice10 () {
        String[] words = {"apple", "moon", "sky", "banana", "loop"};
        IntSummaryStatistics stats = Arrays.stream(words).filter(a-> hasRepeatingLetters(a))
                .mapToInt(a->a.length())
                .summaryStatistics();

        System.out.println(stats.getCount());
        System.out.println(stats.getAverage());
        System.out.println(stats.getMax());
        System.out.println(stats.getMin());
        System.out.println(stats.getSum());
    }

    public boolean hasRepeatingLetters (String s) {
        Set <Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!set.add(c)) {
                return true;
            }
        }
        return false;
    }







}



















