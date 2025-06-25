package stream.task14_summarystatistics;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main1 {
    public Optional<Map.Entry<String, Integer>> practice1 () {
        String[] words = {"java", "stream", "code", "developer", "Engineer"};

        return Arrays.stream(words).map(a->a.toLowerCase()).filter(w->w.contains("e"))
                .map(w-> Map.entry(w, w.length()))
                .reduce((a,b) -> a.getValue() >= b.getValue() ? a : b);
    }
    
    public Long practice2 () {
        int[] numbers = {2, 4, 2, 6, 8, 4, 10, 10, 12};
        IntSummaryStatistics stats = Arrays.stream(numbers).distinct().filter(a->a%2==0)
                .summaryStatistics();
        return stats.getCount();
    }

    public int practice3 () {
        List<String> words = List.of("APPLE",
                "Banana", "CHERRY", "kiwi", "PLUM");
        return words.stream().mapToInt(a->a.length()).sum();
    }

    public void practice4 () {
        String[] words = {"apple", "ant", "banana",
                "blue", "berry", "dog", "dolphin"};
        Arrays.stream(words).filter(a->a.length()>4).collect(Collectors.groupingBy(w->w.charAt(0), Collectors.summarizingInt(w->w.length())));

    }

    public Map <String, Integer> practice5 () {
        String[] words = {"sky", "apple", "moon", "dry", "banana"};
        return Arrays.stream(words).filter(s->s.length() > 3)
                .filter(w->countVovels(w)>1)
                .collect(Collectors.toMap(a->a, a->a.length()));
    }

    public long countVovels (String s) {
        return s.chars().filter(c->"aeiou".indexOf(c) >=0).count();
    }

    public Long practice6 () {
        String[] words = {"sky", "apple", "moon",
                "dry", "sun"};
        return Arrays.stream(words)
                .filter(a->a.matches(".*[aeiou].*"))
                .filter(w -> countVovels(w) > 0)
                .mapToInt(w-> w.length()).count();
    }

    public void practice7 () {
        String[] words = {"apple", "orange", "banana",
                "ice", "umbrella", "echo"};
        Arrays.stream(words).map(a->a.toLowerCase()).filter(a-> a.matches("^[aeiou].*"))
                .min(Comparator.comparingInt(a->a.length()));

    }

    public Map <Character, Double> practice8 () {
        String[] words = {"apple", "ant", "banana", "blue", "berry", "dolphin"};
        return Arrays.stream(words)
                .collect(Collectors.groupingBy(w->w.charAt(0),
                        Collectors.averagingDouble(String::length)));
    }

    public Map <Character, Long> practice9 () {
        String[] words = {"apple", "orange", "banana", "umbrella"};
        return Arrays.stream(words).flatMap(w->w.chars().mapToObj(c->(char)c))
                .filter(ch -> "aeiou".indexOf(ch)>=0)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public IntSummaryStatistics practice10 () {
        String[] words = {"apple", "moon", "sky", "banana", "loop"};
        return Arrays.stream(words).filter(w->hasRepeatingLetters(w)).mapToInt(w->w.length()).summaryStatistics();
    }

    public boolean hasRepeatingLetters(String s) {
        return s.chars().distinct().count() == s.length();
    }

    public List <String> practice11 () {
        String[] words = {"education", "questionnaire", "house", "audio", "universe"};
        return Arrays.stream(words).filter(w-> "aeiou".chars().allMatch(c->w.indexOf(c) >=0)).collect(Collectors.toList());
    }

    public Map <Boolean, List <String>> practice12 () {
        String[] words = {"Apple", "banana", "Cherry", "date", "Eggplant"};
        return Arrays.stream(words).collect(Collectors.partitioningBy(w -> Character.isUpperCase(w.charAt(0))));
    }

    public Map <String, Long> practice13 () {
        String[] words = {"Java", "java", "Kotlin", "kotlin", "kotlin", "Scala"};
        return Arrays.stream(words).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }



}