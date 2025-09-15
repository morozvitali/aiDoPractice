package stream.task16_comparator_8;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main6 {
    public List<String> practice1 () {
        List<String> words = List.of("sky", "banana",
                "apple", "grape", "orange", "plum");
        return words.stream().sorted(Comparator.comparingLong(w->getCount(w))).toList();
    }

    public static long getCount(String s) {
        return s.chars().filter(c->"aeiou".indexOf(c)>=0).count();
    }

    public String  practice2 () {
        return Stream.of("alpha", "arena", "java", "banana", "lava").collect(Collectors.toMap(Function.identity(), Main6::letterCounter)).entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).map(Map.Entry::getKey).orElse("");
    }

    public static long letterCounter (String s) {
        return s.chars().filter(c->c=='a').count();
    }

    public int practice3 () {
        return Stream.of(111, 123, 444, 1212)
                .collect(Collectors.toMap(Function.identity(), n->numberCounter(n)))
                .entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).map(Map.Entry::getKey).orElse(-1);
    }

    public static int numberCounter(int n) {
        return String.valueOf(Math.abs(n)).length();
    }

    public String practice4 () {
        return Stream.of("abc", "aaa", "zzz").collect(Collectors.toMap(Function.identity(), w->w.chars().sum()))
                .entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).map(Map.Entry::getKey).orElse("");
    }

    public String practice5 () {
        return Stream.of("sun", "star", "supernova", "apple")
                .filter(w->w.startsWith("s"))
                .max(Comparator.comparing(String::length))
                .orElse("");
    }

    public List <String> practice6 () {
        return Stream.of("abc", "def", "gka", "lol")
                .sorted(Comparator.comparing(s->s.charAt(s.length()-1)))
                .toList();
    }

    public String practice7 () {
        return Stream.of("java", "hello", "me", "zebra")
                .filter(w->w.contains("e"))
                .min(Comparator.comparingInt(String::length))
                .orElse("");
    }

    public List <Integer> practice8 () {
        return Stream.of(100, 1010, 5, 2000, 10)
                .sorted(Comparator.comparing(n->countOf(n, '0'))).toList();
    }

    public static long countOf(int n, char ch) {
        return String.valueOf(n).chars().filter(c->c == ch).count();
    }

    public List <String> practice9 () {
        return Stream.of("apple", "zebra", "sky", "education")
                .sorted(Comparator.comparing(a->countVovels(a)))
                .toList();
    }

    public static long countVovels (String s) {
        return s.chars().filter(c->"aeiou".indexOf(c) >= 0).count();
    }
}
