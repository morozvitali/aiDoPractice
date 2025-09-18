package stream.task16_comparator_8;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main8 {

    public List <String> practice1 () {

        List<String> words = List.of("sky", "banana",
                "apple", "grape", "orange", "plum");
        return words.stream().sorted(Comparator.comparing(Main8::countVowels).thenComparing(Comparator.naturalOrder())).toList();
    }

    public static long countVowels (String s) {
        return s.chars().filter(c-> "aeiou".indexOf(c)>=0).count();
    }

    public String practice2 () {
        return Stream.of("alpha", "arena", "java", "banana", "lava").collect(Collectors.toMap(Function.identity(), w->countLetter(w))).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("");
    }

    public long countLetter (String s) {
        return s.chars().filter(a->a=='a').count();
    }

    public int practice3 () {
        return Stream.of(111, 123, 444, 1212).collect(Collectors.toMap(Function.identity(), Main8::getMaxCountc)).entrySet().stream()
                .max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(-1);
    }

    public static long getMaxCountc (int n) {
        return String.valueOf(Math.abs(n)).chars().distinct().count();
    }

    public String practice4 () {
        return Stream.of("abc", "aaa", "zzz").collect(Collectors.toMap(Function.identity(), w->w.chars().sum())).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("");
    }

    public String practice5 () {
        return Stream.of("sun", "star", "supernova", "apple").filter(w->w.startsWith("s")).collect(Collectors.toMap(Function.identity(), String::length)).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("");
    }

    public String practice6 () {
        return Stream.of("java", "hello", "me", "zebra").filter(w->w.contains("e")).min(Comparator.comparing(String::length)).orElse("");
    }
}
