package stream.task16_comparator_8;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main9 {
    public List<String> practice1 () {
        List<String> words = List.of("sky", "banana",
                "apple", "grape", "orange", "plum");
        return words.stream().sorted(Comparator.comparing(w->getCount(w))).toList();
    }

    public static long getCount (String s) {
        return s.chars().filter(c->"aeiou".indexOf(c)>=0).count();
    }

    public String practice2 () {
        return List.of("alpha", "arena", "java", "banana", "lava").stream().max(Comparator.comparing(w->getCounterA(w))).orElse("");
    }
    public static long getCounterA (String s) {
        return s.chars().filter(c->c=='a').count();
    }

    public void practice3 () {
        return List.of(111, 123, 444, 1212).stream().map(String::valueOf).max(Comparator.comparing(w->getUniqCounter(w))).orElse(-1);
    }

    public static long getUniqCounter (String s) {
        return s.chars().distinct().count();
    }

    public Integer practice4 () {
        return List.of("abc", "aaa", "zzz").stream().mapToInt(w->w.chars().sum()).max().orElse(-1);
    }

    public String practice5 () {
        List<String> words = List.of("sun", "star", "supernova", "apple");
        return words.stream().filter(w->w.startsWith("s")).max((Comparator.comparing(String::length))).orElse("");
    }

    public List <String> practice6 () {
        return Stream.of("sun", "star", "supernova", "apple").sorted(Comparator.comparing(w->w.charAt(w.length()-1))).toList();
    }

    public String practice7 () {
        return Stream.of("java", "hello", "me", "zebra").filter(w->w.contains("e"))
                .min(Comparator.comparing(String::length)).orElse("");
    }

    public List<Integer> practice8 () {
        return List.of(100, 1010, 5, 2000, 10).stream().sorted(Comparator.comparing(a->String.valueOf(a).chars().filter(c->c=='0').count())).toList();
    }

}
