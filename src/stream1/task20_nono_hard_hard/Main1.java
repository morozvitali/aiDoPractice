package stream1.task20_nono_hard_hard;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main1 {
    public String practice1 ()  {
        List<String> words = List.of("banana", "alphabet", "committee", "coffee", "rhythm");
        Map<String, Long> map = words.stream().collect(Collectors.toMap(Function.identity(), w->getCount(w)));
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static long getCount (String s) {
        return s.toLowerCase().chars().distinct().count();
    }

    public Character practice2 () {
        List<String> words = List.of("apple", "banana", "grape", "pear");
        return words.stream().flatMap(w->w.chars().mapToObj(c->(char)c))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse('?');
    }

    public List <String> practice3 () {
        List<String> words = List.of("moon", "sky", "cloud", "aeroplane", "tree");
        return words.stream().sorted(Comparator.comparing(w->w.chars().filter(c->"aeiou".indexOf(c)>=0).count())).toList();
    }

    public Double practice4 () {
        List<String> words = List.of("sun", "moon", "sun", "sky", "star");
        return words.stream().distinct().mapToInt(String::length).average().orElse(-1);
    }

    public String practice5 () {
        List<String> words = List.of("apple", "grape", "sky", "cloud", "orange");
        return words.stream().filter(w->"aeiou".indexOf(w.charAt(0))>=0).min(Comparator.comparing(String::length)).orElse("");
    }

    public List <Character> practice6 () {
        String text = "banana";
        return text.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().filter(e->e.getValue() == 2).map(Map.Entry::getKey).toList();
    }

    public List <String> practice7 () {
        List<String> phrases = List.of("I love Java", "Java is great", "I love streams");
        return phrases.stream().flatMap(s-> Arrays.stream(s.split(" "))).map(String::toLowerCase).distinct().toList();
    }

    public Map <Integer, List <String>> prctice8 () {
        List<String> words = List.of("sun", "sky", "blue", "cloud", "rain");
        return words.stream().collect(Collectors.groupingBy(String::length));
    }

    public Long practice9 (String s) {
        List<String> words = List.of("apple", "banana", "grape", "pear", "plum");
        return words.stream().filter(w->w.contains(s)).count();
    }

    public Double practice10 () {
        String text = "Java makes coding elegant and expressive";
        return Arrays.stream(text.split(" ")).mapToInt(String::length).average().orElse(0);
    }


}
